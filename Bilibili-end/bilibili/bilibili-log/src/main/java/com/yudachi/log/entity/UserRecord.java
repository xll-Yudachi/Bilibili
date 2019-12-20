package com.yudachi.log.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString
@Document(collection = "UserRecord")
public class UserRecord implements Serializable {
    private String uid;
    private String vid;
    private int LFMuid;
    private int LFMvid;
    private int isPlay;
    private int isLike;
    private int isCoin;
    private int isCollect;
    private int isShare;
    private Long timestamp;
}
