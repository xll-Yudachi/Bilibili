package com.yudachi.log.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "StreamRecs")
public class StreamRecs implements Serializable {
    private int uid;
    private List recs;
}
