package com.openpms.server.users;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Long create(User user);

    User find(Long id);

    int update(User user);

    int delete(Long id);
}