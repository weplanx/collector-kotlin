package com.creator.server.app.dto

import com.alibaba.fastjson2.annotation.JSONField
import com.alibaba.fastjson2.annotation.JSONType

@JSONType(
    schema = """
    {
        "required": ["email", "password"]
    }
    """
)
data class LoginBody(
    @JSONField(schema = "{'format':'email'}")
    val email: String? = null,
    @JSONField(schema = "{'minLength': '8'}")
    val password: String? = null
)
