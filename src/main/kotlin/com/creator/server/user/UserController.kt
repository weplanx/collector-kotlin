package com.creator.server.user

import cn.dev33.satoken.secure.BCrypt
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.creator.common.R
import com.creator.server.user.dto.*
import jakarta.validation.constraints.Min
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun list(
        @RequestHeader(value = "x-page", defaultValue = "1") current: @Min(1) Long,
        @RequestHeader(value = "x-pagesize", defaultValue = "10") size: @Min(1) Long,
        @RequestParam(value = "email", required = false) email: String?
    ): ResponseEntity<*> {
        val page = Page<User>(current, size)
        val query = QueryWrapper<User>()
        if (email != null) {
            query.like("email", email)
        }
        val result = userService.page(page, query)
        return ResponseEntity.ok<IPage<User>>(result)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long?): ResponseEntity<*> {
        val user = userService.getById(id) ?: return R.Fail(0, "数据不存在")
        return ResponseEntity.ok<Any>(
            GetResult(
                email = user.email,
                name = user.name,
                avatar = user.avatar,
                status = user.status,
                createTime = user.createTime,
                updateTime = user.updateTime
            )
        )
    }

    @PostMapping("create")
    fun create(@RequestBody body: CreateBody): ResponseEntity<*> {
        val user = User(
            email = body.email,
            password = BCrypt.hashpw(body.password),
            name = body.name,
            avatar = body.avatar
        )
        userService.save(user)
        return R.Ok()
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable("id") id: Long?, @RequestBody body: UpdateBody): ResponseEntity<*> {
        val user = User()
        user.id = id
        user.email = body.email
        user.name = body.name
        user.avatar = body.avatar
        user.status = body.status
        userService.updateById(user)
        return R.Ok()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long?): ResponseEntity<*> {
        userService.removeById(id)
        return R.Ok()
    }
}
