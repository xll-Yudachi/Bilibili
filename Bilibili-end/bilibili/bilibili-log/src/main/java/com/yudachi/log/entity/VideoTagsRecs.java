package com.yudachi.log.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "VideoTagsRecs")
public class VideoTagsRecs implements Serializable {
    private String vid;
    private List recs;
}
