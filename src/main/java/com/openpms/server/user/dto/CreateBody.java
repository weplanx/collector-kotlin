package com.openpms.server.user.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Data;

@Data
@JSONType(schema = """
        {
            "required": ["email", "password"]
        }""")
public class CreateBody {
    @JSONField(schema = "{'format':'email'}")
    private String email;
    @JSONField(schema = "{'minLength': '8'}")
    private String password;
    private String name;
    private String avatar;
    private Boolean status = true;
}
