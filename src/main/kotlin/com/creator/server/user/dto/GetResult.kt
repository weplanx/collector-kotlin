package com.creator.server.user.dto

import com.alibaba.fastjson2.annotation.JSONField
import java.time.Instant

data class GetResult(
    var email: String? = null,
    var name: String? = null,
    var avatar: String? = null,
    var status: Boolean = false,
    @JSONField(name = "create_time")
    var createTime: Instant?,
    @JSONField(name = "update_time")
    var updateTime: Instant?
)