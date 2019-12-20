package com.yudachi.comment.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Word implements Serializable {
    private List<String> wordList;
    private int flag;
}
