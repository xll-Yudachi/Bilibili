package com.yudachi.media.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "language")
public class Language implements Serializable {
    @Id
    private Integer id;
    private String lname;
}
