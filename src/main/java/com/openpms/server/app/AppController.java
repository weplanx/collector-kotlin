package com.openpms.server.app;

import cn.dev33.satoken.util.SaResult;
import com.openpms.server.app.dto.LoginParam;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
    public SaResult login(@RequestBody LoginParam param) {
        Boolean result = appService.login(param);
        if (!result) {
            return SaResult.error("登录失败");
        }
        return SaResult.ok();
    }
}
