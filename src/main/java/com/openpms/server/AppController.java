package com.openpms.server;

import com.openpms.server.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AppController {
    private final UsersService usersService;

    @GetMapping
    public Map<String, Object> index() {
        Map<String, Object> data = new HashMap<>();
        data.put("msg", "ok");
        return data;
    }
}
