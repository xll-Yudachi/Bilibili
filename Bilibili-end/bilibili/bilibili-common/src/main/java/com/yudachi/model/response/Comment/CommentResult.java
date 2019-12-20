package com.yudachi.model.response.Comment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CommentResult implements Serializable {
    private String id;
    private String username;
    private String userimg;
    private String text;
    private Date date;
    private Integer thumbnum;
    private Integer unlikenum;
    private String vid;
    private List<CommentResult> reply;
}
