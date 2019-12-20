package com.yudachi.comment.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.yudachi.comment.entity.SensitiveWord;
import com.yudachi.comment.entity.UnSensitiveWord;
import com.yudachi.comment.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NaiveBayesian {

    @Autowired
    private RedisTemplate redisTemplate;

    private List<Double> p0Vec = null;
    //垃圾邮件中每个词出现的概率
    private List<Double> p1Vec = null;
    //垃圾邮件出现的概率
    private double pSpamRatio;

    /**
     * 初始化数据集
     *
     * @return
     */
    public List<Word> initDataSet() {
        List<Word> dataSet = new ArrayList<Word>();
        List<SensitiveWord> sensitiveWordList = (List<SensitiveWord>) redisTemplate.opsForValue().get("sensitive");
        System.err.println(sensitiveWordList.size());
        for (SensitiveWord string : sensitiveWordList) {
            Word hamWord = new Word();
            hamWord.setWordList(textParse(string.getText()));
            hamWord.setFlag(0);
            dataSet.add(hamWord);
        }

        List<UnSensitiveWord> unSensitiveWordList = (List<UnSensitiveWord>) redisTemplate.opsForValue().get("unsensitive");
        for (UnSensitiveWord string : unSensitiveWordList) {
            Word spamWord = new Word();
            spamWord.setWordList(textParse(string.getText()));
            spamWord.setFlag(1);
            dataSet.add(spamWord);
        }
        return dataSet;
    }

    /**
     * 分词，英文的分词相比中文的分词要简单很多，这里使用的分隔符为除单词、数字外的任意字符串
     * 如果使用中文，则可以使用中科院的一套分词系统，分词效果还算不错
     *
     * @param originalString
     * @return
     */
    private List<String> textParse(String originalString) {
        List<String> wordList = new ArrayList<String>();
        JiebaSegmenter segmenter = new JiebaSegmenter();


        List<SegToken> process = segmenter.process(originalString, JiebaSegmenter.SegMode.INDEX);
        for (SegToken segToken : process) {
            wordList.add(segToken.word);
        }

        return wordList;
    }

    /**
     * 构建单词集，此长度等于向量长度
     *
     * @return
     */
    public Set<String> createVocabList(List<Word> dataSet) {
        Set<String> set = new LinkedHashSet<String>();
        for (Word Word : dataSet) {
            for (String string : Word.getWordList()) {
                set.add(string);
            }
        }
        return set;
    }

    /**
     * 将邮件转换为向量
     */
    public List<Integer> setOfWords2Vec(Set<String> vocabSet, Word Word) {
        List<Integer> returnVec = new ArrayList<Integer>();
        for (String word : vocabSet) {
            returnVec.add(calWordFreq(word, Word));
        }
        return returnVec;
    }

    /**
     * 计算一个词在某个集合中的出现次数
     *
     * @return
     */
    private int calWordFreq(String word, Word Word) {
        int num = 0;
        for (String string : Word.getWordList()) {
            if (string.equals(word)) {
                ++num;
            }
        }
        return num;
    }


    public void trainNB(Set<String> vocabSet, List<Word> dataSet) {
        // 训练文本的数量
        int numTrainDocs = dataSet.size();
        // 训练集中垃圾邮件的概率
        pSpamRatio = (double) calSpamNum(dataSet) / numTrainDocs;

        // 记录每个类别下每个词的出现次数
        List<Integer> p0Num = new ArrayList<Integer>();
        List<Integer> p1Num = new ArrayList<Integer>();
        // 记录每个类别下一共出现了多少词,为防止分母为0，所以在此默认值为2
        double p0Denom = 2.0, p1Denom = 2.0;
        for (Word Word : dataSet) {
            List<Integer> list = setOfWords2Vec(vocabSet, Word);
            // 如果是垃圾邮件
            if (Word.getFlag() == 1) {
                p1Num = vecAddVec(p1Num, list);
                //计算该类别下出现的所有单词数目
                p1Denom += calTotalWordNum(list);
            } else {
                p0Num = vecAddVec(p0Num, list);
                p0Denom += calTotalWordNum(list);
            }
        }
        p0Vec = calWordRatio(p0Num, p0Denom);
        p1Vec = calWordRatio(p1Num, p1Denom);
    }

    /**
     * 两个向量相加
     *
     * @param vec1
     * @param vec2
     * @return
     */
    private List<Integer> vecAddVec(List<Integer> vec1,
                                    List<Integer> vec2) {
        if (vec1.size() == 0) {
            return vec2;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < vec1.size(); i++) {
            list.add(vec1.get(i) + vec2.get(i));
        }
        return list;
    }

    /**
     * 计算垃圾邮件的数量
     *
     * @param dataSet
     * @return
     */
    private int calSpamNum(List<Word> dataSet) {
        int time = 0;
        for (Word Word : dataSet) {
            time += Word.getFlag();
        }
        return time;
    }

    /**
     * 统计出现的所有单词数
     *
     * @param list
     * @return
     */
    private int calTotalWordNum(List<Integer> list) {
        int num = 0;
        for (Integer integer : list) {
            num += integer;
        }
        return num;
    }

    /**
     * 计算每个单词在该类别下的出现概率，为防止分子为0，导致朴素贝叶斯公式为0，设置分子的默认值为1
     *
     * @param list
     * @param wordNum
     * @return
     */
    private List<Double> calWordRatio(List<Integer> list, double wordNum) {
        List<Double> vec = new ArrayList<Double>();
        for (Integer i : list) {
            vec.add(Math.log((double) (i + 1) / wordNum));
        }
        return vec;
    }

    /**
     * 比较不同类别 p(w0,w1,w2...wn | ci)*p(ci) 的大小   <br>
     * p(w0,w1,w2...wn | ci) = p(w0|ci)*p(w1|ci)*p(w2|ci)... <br>
     * 由于防止下溢，对中间计算值都取了对数，因此上述公式化为log(p(w0,w1,w2...wn | ci)) + log(p(ci)),即
     * 化为多个式子相加得到结果
     *
     * @return 返回概率最大值
     */
    public int classifyNB(List<Integer> WordVec) {
        double p0 = calProbabilityByClass(p0Vec, WordVec) + Math.log(1 - pSpamRatio);
        double p1 = calProbabilityByClass(p1Vec, WordVec) + Math.log(pSpamRatio);
        if (calProbabilityByClass(p0Vec, WordVec) == 0.0) {
            return 1;
        } else {
            if (p0 > p1) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private double calProbabilityByClass(List<Double> vec, List<Integer> WordVec) {
        double sum = 0.0;
        for (int i = 0; i < vec.size(); i++) {
            sum += (vec.get(i) * WordVec.get(i));
        }
        return sum;
    }

    public boolean testingNB(String word) {

        List<Word> dataSet = new ArrayList<>();
        if ((List<Word>) redisTemplate.opsForValue().get("dataSet")==null){
            dataSet = initDataSet();
            redisTemplate.opsForValue().set("dataSet", dataSet);
        }else{
            dataSet = (List<Word>) redisTemplate.opsForValue().get("dataSet");
        }

        List<Word> testSet = new ArrayList<Word>();

        Word testWord = new Word();
        testWord.setWordList(textParse(word));
        testSet.add(testWord);
        Set<String> vocabSet = new HashSet<>();
        if ((Set<String>) redisTemplate.opsForValue().get("vocabSet") == null){
           vocabSet = createVocabList(dataSet);
           redisTemplate.opsForValue().set("vocabSet",vocabSet);
        }else{
            vocabSet = (Set<String>) redisTemplate.opsForValue().get("vocabSet");
        }

        //训练样本
        trainNB(vocabSet, dataSet);

        return classifyNB(setOfWords2Vec(vocabSet, testWord)) == 0;

    }

}
