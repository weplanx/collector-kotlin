package com.openpms.server.app;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.openpms.server.app.dto.LoginBody;
import com.openpms.server.user.User;
import com.openpms.server.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AppService {
    private final UserMapper userMapper;

    public Boolean login(LoginBody body) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("email", body.getEmail())
            .eq("status", 1);
        User user = userMapper.selectOne(query);
        if (user == null) {
            return false;
        }
        if (!user.checkPassword(body.getPassword())) {
            return false;
        }
        StpUtil.login(body.getEmail(), false);
        return true;
    }
}
