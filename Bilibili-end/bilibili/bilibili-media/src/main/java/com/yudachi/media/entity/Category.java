package com.yudachi.media.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "category")
@Data
public class Category implements Serializable {
    @Id
    private Integer id;
    private Integer parentid;
    private String categoryname;
}
