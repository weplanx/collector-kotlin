package com.openpms.server.app;

import com.openpms.common.R;
import com.openpms.server.app.dto.LoginBody;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AppController {
    private final AppService appService;

    @GetMapping
    public Map<String, Object> index(HttpSession session) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", session.getAttribute("name"));
        return data;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginBody body) {
        Boolean result = appService.login(body);
        if (!result) {
            return R.WithStatus(0, "登录失败，账户密码不正确或已被禁用", 401);
        }
        return R.Ok("登录成功");
    }
}
