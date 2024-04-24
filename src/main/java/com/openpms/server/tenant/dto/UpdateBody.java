package com.openpms.server.tenant.dto;

import com.alibaba.fastjson2.annotation.JSONType;
import com.openpms.server.tenant.Tenant;

@JSONType(schema = """
    {
        "minProperties": 1
    }""")
public class UpdateBody extends Tenant {
    protected int kind = 0;
}
