package com.yudachi.comment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
@Data
public class Comment implements Serializable {
    @Id
    private String id;
    private String uid;
    private String text;
    private Date date;
    private Integer thumbnum;
    private Integer unlikenum;
    private String vid;
    private String pid;
}
