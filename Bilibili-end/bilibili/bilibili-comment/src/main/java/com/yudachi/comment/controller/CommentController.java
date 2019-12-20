package com.yudachi.comment.controller;


import com.yudachi.comment.entity.Comment;
import com.yudachi.comment.service.CommentService;
import com.yudachi.model.response.Comment.CommentResult;
import com.yudachi.model.response.CommentCode.CommentCode;
import com.yudachi.model.response.CommonCode;
import com.yudachi.model.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public ResponseResult addComment(@RequestBody Comment comment){
        Comment addComment = commentService.addComment(comment);
        if (addComment == null){
            return new ResponseResult(CommonCode.FAIL, null);
        }else{
            return new ResponseResult(CommonCode.SUCCESS, addComment);
        }
    }

    @GetMapping("/findCommentByVid")
    public ResponseResult findCommentByVid(@RequestParam("vid") String vid){
        List<CommentResult> list = commentService.findCommentsByVid(vid);
        if (list.size()<=0){
            return new ResponseResult(CommentCode.FIND_FAIL, null);
        }else{
            return new ResponseResult(CommonCode.SUCCESS, list);
        }
    }

    @GetMapping("/initThesaurus")
    public ResponseResult initThesaurus(){
        commentService.initThesaurus();
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @GetMapping("/judgeWord")
    public ResponseResult judgeWord(@RequestParam("word") String word){
        boolean res = commentService.judgeWord(word);
        return new ResponseResult(CommonCode.SUCCESS, res);
    }
}
