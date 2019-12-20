package com.yudachi.comment.service;

import com.yudachi.comment.entity.Comment;
import com.yudachi.comment.entity.SensitiveWord;
import com.yudachi.comment.entity.UnSensitiveWord;
import com.yudachi.comment.entity.User;
import com.yudachi.comment.repository.CommentRepository;
import com.yudachi.comment.repository.SensitiveRepository;
import com.yudachi.comment.repository.UnSensitiveRepository;
import com.yudachi.comment.repository.UserRepository;
import com.yudachi.comment.utils.NaiveBayesian;
import com.yudachi.model.response.Comment.CommentResult;
import com.yudachi.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SensitiveRepository sensitiveRepository;
    @Autowired
    private UnSensitiveRepository unSensitiveRepository;
    @Autowired
    private NaiveBayesian naiveBayesian;

    public Comment addComment(Comment comment){
        comment.setId(idWorker.nextId() + "");
        comment.setDate(new Date());
        comment.setThumbnum(0);
        comment.setUnlikenum(0);
        return commentRepository.save(comment);
    }

    public List<CommentResult> findCommentsByVid(String vid){
        List<Comment> commentList = commentRepository.findByVidAndPidOrderByDateDesc(vid, "");
        List<CommentResult> list = new ArrayList<>();
        for (Comment comment : commentList){
            CommentResult commentResult = new CommentResult();
            commentResult = commentToCommentResult(comment, commentResult);
            List<Comment> replyComment = commentRepository.findByPid(comment.getId());
            List<CommentResult> reply = new ArrayList<>();
            for (Comment rep : replyComment){
                CommentResult repRes = new CommentResult();
                repRes = commentToCommentResult(rep, repRes);
                reply.add(repRes);
            }
            commentResult.setReply(reply);
            list.add(commentResult);
        }
        return list;
    }

    private CommentResult commentToCommentResult(Comment comment, CommentResult commentResult){
        BeanUtils.copyProperties(comment, commentResult);
        Optional<User> userOptional = userRepository.findById(comment.getUid());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            commentResult.setUsername(user.getUsername());
            commentResult.setUserimg(user.getHead_img());
        }
        return commentResult;
    }

    public void initThesaurus() {
        List<SensitiveWord> sensitiveWordList = sensitiveRepository.findAll();
        List<UnSensitiveWord> unSensitiveWordList = unSensitiveRepository.findAll();

        redisTemplate.opsForValue().set("sensitive", sensitiveWordList);

        redisTemplate.opsForValue().set("unsensitive", unSensitiveWordList);

    }

    public boolean judgeWord(String word){
        return naiveBayesian.testingNB(word);
    }
}
