package com.yudachi.comment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "unsensitive_word")
public class UnSensitiveWord implements Serializable {
    @Id
    private int id;
    private String text;
}
