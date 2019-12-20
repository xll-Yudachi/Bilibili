package com.yudachi.log.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Document(collection = "RateMoreRecentlyVideos")
public class RateMoreRecentlyVideos implements Serializable {
    @Field("id")
    private String id;
    private String title;
    private int play_num;
    private String yearmonth;
}
