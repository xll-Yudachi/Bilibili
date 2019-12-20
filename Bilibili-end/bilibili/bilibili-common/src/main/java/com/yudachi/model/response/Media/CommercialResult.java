package com.yudachi.model.response.Media;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommercialResult implements Serializable {
    private String value;
    private String label;
}
