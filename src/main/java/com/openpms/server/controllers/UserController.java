package com.openpms.server.controllers;

import com.openpms.server.common.R;
import com.openpms.server.mappers.UserMapper;
import com.openpms.server.models.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserMapper userMapper;

    @GetMapping
    public User getUser() {
        return userMapper.findById(1);
    }

    @PostMapping
    public R createUser(@Valid @RequestBody User user) {
//        userRepository.save(user);
        return new R(0, "ok");
    }
}
