package com.creator.server.user

import com.baomidou.mybatisplus.annotation.TableName
import java.time.Instant

@TableName("user")
data class User(
    var id: Long? = null,
    var email: String? = null,
    var password: String? = null,
    var name: String? = null,
    var avatar: String? = null,
    var status: Boolean = true,
    var createTime: Instant? = null,
    var updateTime: Instant? = null,
)