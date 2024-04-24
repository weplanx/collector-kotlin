package com.openpms.server.app.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Data;

@Data
@JSONType(schema = """
    {
        "required": ["email", "password"]
    }"""
)
public class LoginBody {
    @JSONField(schema = "{'format':'email'}")
    private String email;
    @JSONField(schema = "{'minLength': '8'}")
    private String password;
}
