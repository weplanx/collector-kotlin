package com.openpms.server.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserService userService;

    @Test
    void createUser() {
        User user = new User();
        user.setEmail("kainpro@foxmail.com");
        user.hashPassword("pass@VAN1234");
        userService.save(user);
    }


}
