package com.yudachi.processor.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "m3u8")
public class M3u8 implements Serializable {
    @Id
    private String id;
    private String videoid;
    private String m3u8_url;
}
