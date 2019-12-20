package com.yudachi.log.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TagsBaseRecommender implements Serializable {
    private String vid;
    private double score;
}
