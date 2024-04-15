package com.openpms.server.mappers;

import com.openpms.server.models.User;

public interface UserMapper {
    User findById(int id);
}
