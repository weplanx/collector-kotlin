package com.openpms.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> {
    private int code;
    private String message;
    private T data;

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
