package com.yudachi.media.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "commercial")
public class Commercial implements Serializable {
    @Id
    private Integer id;
    private String cname;
}
