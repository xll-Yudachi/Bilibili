package com.yudachi.model.response.Media;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryResult implements Serializable {
    private String value;
    private String label;
    private List<CategoryResult> children;
}
