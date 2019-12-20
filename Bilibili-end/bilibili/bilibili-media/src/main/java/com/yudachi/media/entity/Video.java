package com.yudachi.media.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "video")
@Data
public class Video implements Serializable {
    @Id
    private String id;

    private String title;
    private String upid;
    private String partition_1;
    private String partition_2;
    private Date upload_time;
    private Integer highest_rank;
    private Integer play_num;
    private Integer danmu_num;
    private String danmu_id;
    private Integer like_num;
    private Integer coin_num;
    private Integer collect_num;
    private Integer share_num;
    private String video_info;
    private String tag;
    private String video_url;
    private String image_url;
    private Integer duration;
}
