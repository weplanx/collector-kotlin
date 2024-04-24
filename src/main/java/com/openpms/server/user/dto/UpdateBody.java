package com.openpms.server.user.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import lombok.Data;

@Data
@JSONType(schema = """
        {
            "minProperties": 1
        }""")
public class UpdateBody {
    @JSONField(schema = "{'format':'email'}")
    private String email;
    private String name;
    private String avatar;
    private int status;
}
