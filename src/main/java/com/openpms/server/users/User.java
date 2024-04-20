package com.openpms.server.users;

import java.time.Instant;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String avatar;
    private int status;
    private int del;
    private Instant createTime;
    private Instant updateTime;
}