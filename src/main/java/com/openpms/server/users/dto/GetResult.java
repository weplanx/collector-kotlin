package com.openpms.server.users.dto;

import com.openpms.server.users.User;

import java.time.Instant;

public class GetResult {
    private final User user;

    public GetResult(User user) {
        this.user = user;
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getName() {
        return user.getName();
    }

    public String getAvatar() {
        return user.getAvatar();
    }

    public Boolean getStatus() {
        return user.getStatus();
    }

    public Instant getCreateTime() {
        return user.getCreateTime();
    }

    public Instant getUpdateTime() {
        return user.getUpdateTime();
    }
}
