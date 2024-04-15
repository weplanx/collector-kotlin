package com.openpms.server.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Instant;

@Data
public class User {
    private int id;

    @NotBlank(message = "电子邮件不能为空")
    @Email(message = "电子邮件格式不正确")
    private String email;

    @NotBlank(message = "用户密码不能为空")
    private String password;

    private String phone;
    private String avatar;
    private Boolean status;
    private Instant create_time;
    private Instant update_time;
}
