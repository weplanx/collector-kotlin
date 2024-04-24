package com.openpms.server.user;

import java.time.Instant;

import cn.dev33.satoken.secure.BCrypt;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`user`")
public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String avatar;
    private int status = 1;
    private Instant createTime;
    private Instant updateTime;

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password);
    }

    public Boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
}