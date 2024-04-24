package com.openpms.server.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.openpms.common.R;
import com.openpms.server.tenant.Tenant;
import com.openpms.server.user.dto.CreateBody;
import com.openpms.server.user.dto.GetResult;
import com.openpms.server.user.dto.UpdateBody;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> list(
        @RequestHeader(value = "x-page", defaultValue = "1") @Min(1) long current,
        @RequestHeader(value = "x-pagesize", defaultValue = "10") @Min(1) long size,
        @RequestParam(value = "email", required = false) String email
    ) {
        IPage<User> page = new Page<>(current, size);
        QueryWrapper<User> query = new QueryWrapper<>();
        if (email != null) {
            query.like("email", email);
        }
        IPage<User> result = userService.page(page, query);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return R.Fail(0, "数据不存在");
        }
        return ResponseEntity.ok(new GetResult(user));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateBody body) {
        User user = new User();
        user.setEmail(body.getEmail());
        user.hashPassword(body.getPassword());
        user.setName(body.getName());
        user.setAvatar(body.getAvatar());
        userService.save(user);
        return R.Ok();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UpdateBody body) {
        User user = new User();
        user.setId(id);
        user.setEmail(body.getEmail());
        user.setName(body.getName());
        user.setAvatar(body.getAvatar());
        user.setStatus(body.getStatus());
        userService.updateById(user);
        return R.Ok();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.removeById(id);
        return R.Ok();
    }
}
