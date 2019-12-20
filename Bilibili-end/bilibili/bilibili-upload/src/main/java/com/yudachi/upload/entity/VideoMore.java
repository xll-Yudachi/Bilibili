package com.yudachi.upload.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "video_more")
@Data
public class VideoMore implements Serializable {
    @Id
    private String id;
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
}
