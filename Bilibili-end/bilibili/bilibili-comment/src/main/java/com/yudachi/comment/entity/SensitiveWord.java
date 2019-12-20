package com.yudachi.comment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "sensitive_word")
public class SensitiveWord implements Serializable {
    @Id
    private int id;
    private String text;
}
