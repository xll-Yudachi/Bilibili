package com.yudachi.model.response.Search;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchResult implements Serializable {
    private String id;

    private String title;
    private String upname;
    private Date upload_time;
    private Integer play_num;
    private String image_url;
    private Integer duration;

}
