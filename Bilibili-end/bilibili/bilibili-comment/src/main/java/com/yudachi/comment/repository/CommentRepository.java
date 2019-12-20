package com.yudachi.comment.repository;

import com.yudachi.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String> {

    public List<Comment> findByVidAndPidOrderByDateDesc(String vid, String pid);

    public List<Comment> findByPid(String pid);
}
