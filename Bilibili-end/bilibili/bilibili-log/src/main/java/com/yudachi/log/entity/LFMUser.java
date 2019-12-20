package com.yudachi.log.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "lfm_user_map")
public class LFMUser implements Serializable {
    private String id;
    private String uid;
    @Id
    private int lfmuid;
}
