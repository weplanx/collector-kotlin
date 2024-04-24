package com.openpms.server.tenant.dto;

import com.alibaba.fastjson2.annotation.JSONType;
import com.openpms.server.tenant.Tenant;

@JSONType(schema = """
    {
        "required": ["kind", "code", "name", "status"]
    }""")
public class CreateBody extends Tenant {
    protected int kind = 0;
    protected int status = 1;
}
