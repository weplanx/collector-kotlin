package com.creator.server.user.dto

import com.alibaba.fastjson2.annotation.JSONField
import com.alibaba.fastjson2.annotation.JSONType

@JSONType(
    schema = """
    {
        "required": ["email", "password"]
    }
    """
)
data class CreateBody(
    @JSONField(schema = "{'format':'email'}")
    val email: String,
    @JSONField(schema = "{'minLength': '8'}")
    val password: String,
    val name: String? = null,
    val avatar: String? = null,
    val status: Boolean = true
)
