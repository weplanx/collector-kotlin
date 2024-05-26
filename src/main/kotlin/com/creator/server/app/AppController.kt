package com.creator.server.app

import cn.dev33.satoken.stp.SaTokenInfo
import cn.dev33.satoken.stp.StpUtil
import com.creator.common.R
import com.creator.server.app.dto.LoginBody
import jakarta.servlet.http.HttpSession
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {
    private val appService: AppService? = null

    @GetMapping
    fun index(session: HttpSession): Map<String, Any> {
        val data: MutableMap<String, Any> = HashMap()
        data["name"] = session.getAttribute("name")
        return data
    }

    @PostMapping("/login")
    fun login(@RequestBody body: LoginBody): ResponseEntity<*> {
        val result = appService!!.login(body)
        if (!result) {
            return R.WithStatus(0, "登录失败，账户密码不正确或已被禁用", 401)
        }
        val tokenInfo: SaTokenInfo = StpUtil.getTokenInfo()
        return ResponseEntity.ok<SaTokenInfo>(tokenInfo)
    }

    @PostMapping("/logout")
    fun logout(): ResponseEntity<*> {
        StpUtil.logout()
        return R.Ok("登出")
    }
}
