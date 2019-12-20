package com.yudachi.media.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "dans")
public class Danmu {
    private String _id;
    private String player;
    private String author;
    private Double time;
    private String text;
    private int color;
    private int type;
    private String ip;
    private String referer;
    private Double date;
    private int _v;
}
