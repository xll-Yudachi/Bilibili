package com.yudachi.log.service;

import com.alibaba.fastjson.JSON;
import com.yudachi.log.entity.*;
import com.yudachi.log.repository.LFMUserRepository;
import com.yudachi.log.repository.LFMVideoRepository;
import com.yudachi.log.repository.VideoRepository;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private LFMUserRepository lfmUserRepository;
    @Autowired
    private LFMVideoRepository lfmVideoRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private StringRedisTemplate redisTemplate;


    final Logger logger = Logger.getLogger("liveness");
    public void changeUserRecord(UserRecord userRecord) {
        String vid = userRecord.getVid();
        String uid = userRecord.getUid();
        int isCoin = userRecord.getIsCoin();
        int isCollect = userRecord.getIsCollect();
        int isLike = userRecord.getIsLike();
        int isShare = userRecord.getIsShare();
        int LFMuid = lfmUserRepository.findByUid(uid).getLfmuid();
        int LFMvid = lfmVideoRepository.findByVid(vid).getLfmvid();
        double score = 3 + 2 * isLike*0.4 + 2 * isCoin*0.3 + 2 * isCollect * 0.2 + 2 * isShare * 0.1;
        long timestamp = new Date().getTime();

        // 将当前评价加入用户评价行为的redis缓存中
        List<String> tmp = new ArrayList<>();
        List<String> range = redisTemplate.opsForList().range("uid:" + LFMuid, 0, -1);
        if (range.size() > 0){
            tmp.add(LFMvid + ":" + score);
            for (String row : range){
                if (Integer.parseInt(row.split(":")[0]) != LFMvid){
                    tmp.add(row);
                }
            }
            redisTemplate.delete("uid:" + LFMuid);
            for (String row : tmp){
                redisTemplate.boundListOps("uid:" + LFMuid).leftPush(row);
            }
        }else{
            redisTemplate.boundListOps("uid:" + LFMuid).leftPush(LFMvid + ":" + score);
        }




        //TODO 将当前用户的行为记录在UserRecord用户行为表中，以便之后对用户行为的分析
        // 查询条件，如果数据存在更新
        Query query = new Query();
        query.addCriteria(Criteria.where("uid").is(uid));
        query.addCriteria(Criteria.where("vid").is(vid));
        query.addCriteria(Criteria.where("LFMuid").is(LFMuid));
        query.addCriteria(Criteria.where("LFMvid").is(LFMvid));
        // 更新的字段
        Update update = new Update();
        update.set("isPlay", 1);
        update.set("isLike", isLike);
        update.set("isCoin", isCoin);
        update.set("isCollect", isCollect);
        update.set("isShare", isShare);
        update.set("timestamp", new Date().getTime());
        mongoTemplate.upsert(query, update, UserRecord.class);


        logger.info("VIDEO_RATING_PREFIX:" + LFMuid + "|" + LFMvid + "|" + score + "|" + timestamp);

        Configuration conf = new Configuration();

        //1.获取hdfs客户端对象
        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI("hdfs://192.168.202.102:9000"), conf, "Yudachi");

            //2.在hdfs上创建路径
            fs.mkdirs(new Path("/Bilibili/recommender"));

            fs.copyFromLocalFile(new Path("D:/IDEAWorkSpace/bilibili-log/liveness.log"), new Path("/Bilibili/recommender"));

            //3.关闭资源
            fs.close();

            System.out.println("over");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public List<Video> findByUid(String uid){

        LFMUser lfmUser = lfmUserRepository.findByUid(uid);
        if (lfmUser == null){
            return null;
        }

        int LFMuid =lfmUser.getLfmuid();

        Query query = new Query(Criteria.where("uid").is(LFMuid));

        List<StreamRecs> all = mongoTemplate.find(query, StreamRecs.class);

        List<Video> recommenderList = new ArrayList<>();

        for (StreamRecs streamRecs : all){
            for (Object rec : streamRecs.getRecs()) {
                BaseRecommender baseRecommender = JSON.parseObject(rec.toString().replaceAll("=", ":"), BaseRecommender.class);
                String id = lfmVideoRepository.findByLfmvid(baseRecommender.getVid()).getVid();
                Optional<Video> optionalVideo = videoRepository.findById(id);
                if (optionalVideo.isPresent()){
                    Video video = optionalVideo.get();
                    recommenderList.add(video);
                }
            }
        }

        return recommenderList;
    }

    public List<Video> tagsRelatedRecommend(String vid){
        List<Video> list = new ArrayList<>();
        Query query = new Query(Criteria.where("vid").is(vid));
        VideoTagsRecs videoTagsRecs = mongoTemplate.findOne(query, VideoTagsRecs.class);
        List recsList = videoTagsRecs.getRecs();
        for (Object o : recsList) {
            TagsBaseRecommender tagsBaseRecommender = JSON.parseObject(o.toString().replaceAll("=", ":"), TagsBaseRecommender.class);
            String id = tagsBaseRecommender.getVid();
            Optional<Video> videoOptional = videoRepository.findById(id);
            if (videoOptional.isPresent()){
                Video video = videoOptional.get();
                list.add(video);
            }
        }

        return list;
    }

    public List<Video> initNewUserRecommender() {
        List<Video> list = new ArrayList<>();
        Query query = new Query();
        query.skip(0).limit(8);
        List<RateMoreRecentlyVideos> rateMoreRecentlyVideosList = mongoTemplate.find(query, RateMoreRecentlyVideos.class);
        for (RateMoreRecentlyVideos recentlyVideos : rateMoreRecentlyVideosList){
            String vid = recentlyVideos.getId();
            Optional<Video> optionalVideo = videoRepository.findById(vid);
            if (optionalVideo.isPresent()){
                Video video = optionalVideo.get();
                list.add(video);
            }
        }
        return list;
    }
}
