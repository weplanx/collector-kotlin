package com.openpms.server;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.openpms.server.dto.LoginParam;
import com.openpms.server.users.User;
import com.openpms.server.users.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AppService {
    private final UserMapper userMapper;

    public Boolean login(LoginParam param) {
        User user = userMapper.findByEmail(param.getEmail());
        if (user == null) {
            return false;
        }
        if (!BCrypt.checkpw(param.getPassword(), user.getPassword())) {
            return false;
        }
        StpUtil.login(param.getEmail());
        return true;
    }
}
