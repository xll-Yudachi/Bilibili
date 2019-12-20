package com.yudachi.upload.entity;

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
    private int highest_rank;
    private int play_num;
    private int danmu_num;
    private String danmu_id;
    private int like_num;
    private int coin_num;
    private int collect_num;
    private int share_num;
    private String video_info;
    private String tag;
    private String video_url;
    private String image_url;
    private int duration;
}
