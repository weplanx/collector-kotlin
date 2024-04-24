package com.openpms.common;

import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class R {
    private int code;
    private String msg;

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseEntity<?> Ok() {
        return ResponseEntity.ok(new R(0, "ok"));
    }

    public static ResponseEntity<?> Ok(String msg) {
        return ResponseEntity.ok(new R(0, msg));
    }

    public static ResponseEntity<?> Fail(int code, String msg) {
        return ResponseEntity.status(400).body(new R(code, msg));
    }

    public static ResponseEntity<?> WithStatus(int code, String msg, int httpCode) {
        return ResponseEntity.status(httpCode).body(new R(code, msg));
    }
}
