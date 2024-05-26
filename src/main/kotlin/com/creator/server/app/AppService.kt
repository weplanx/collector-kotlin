package com.creator.server.app

import cn.dev33.satoken.secure.BCrypt
import cn.dev33.satoken.stp.StpUtil
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.creator.server.app.dto.*
import com.creator.server.user.User
import com.creator.server.user.UserMapper
import org.springframework.stereotype.Service

@Service
class AppService(
    private val userMapper: UserMapper
) {
    fun login(body: LoginBody): Boolean {
        val query = QueryWrapper<User>()
        query.eq("email", body.email)
            .eq("status", true)
        val user = userMapper.selectOne(query) ?: return false
        if (!BCrypt.checkpw(body.password, user.password)) {
            return false
        }
        StpUtil.login(body.email, false)
        return true
    }
}
