package com.openpms.server.user;

import com.openpms.common.R;
import com.openpms.server.user.dto.CreateBody;
import com.openpms.server.user.dto.GetResult;
import com.openpms.server.user.dto.UpdateBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

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
