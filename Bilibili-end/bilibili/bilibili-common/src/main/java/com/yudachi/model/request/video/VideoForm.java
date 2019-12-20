package com.yudachi.model.request.video;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VideoForm implements Serializable {
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
    private String vid;
    private int copyright;
    private String reprinted_url;
    //自制声明
    private int hms;
    private String subtitle;
    private int fans_post_subtitle;
    //商业声明
    private int ccs;
    private String ccs_category_1;
    private String ccs_category_2;
    private String ccs_way;
    private String fans_dynamic;
    private String image_url;
}
