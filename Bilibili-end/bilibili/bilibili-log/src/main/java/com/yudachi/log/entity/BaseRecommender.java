package com.yudachi.log.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRecommender implements Serializable {
    private int vid;
    private double score;
}
