package com.yudachi.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "lfm_video_map")
public class LFMVideo implements Serializable {
    private String id;
    private String vid;
    @Id
    private int lfmvid;
}
