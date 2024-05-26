package com.creator.server.user.dto

import com.alibaba.fastjson2.annotation.JSONField
import com.alibaba.fastjson2.annotation.JSONType

@JSONType(
    schema = """
    {
        "minProperties": 1
    }
    """
)
data class UpdateBody(
    @JSONField(schema = "{'format':'email'}")
    val email: String? = null,
    val name: String? = null,
    val avatar: String? = null,
    val status: Boolean = false
)
