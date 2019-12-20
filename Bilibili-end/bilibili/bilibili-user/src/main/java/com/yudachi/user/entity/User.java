package com.yudachi.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    @Id
    private String id;
    private String phone;
    private String email;
    private Date create_time;
    private String head_img;
    private String username;
    private String password;
    private String region;
    private Integer focus_num;
    private Integer fans_num;
    private Integer gender;
    private Integer level;
    private Integer isvip;
    private String sign;
    private Integer sex;
}
