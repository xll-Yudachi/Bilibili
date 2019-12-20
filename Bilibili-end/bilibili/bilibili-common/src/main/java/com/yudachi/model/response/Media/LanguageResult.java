package com.yudachi.model.response.Media;

import lombok.Data;

import java.io.Serializable;

@Data
public class LanguageResult implements Serializable {
    private String value;
    private String label;
}
