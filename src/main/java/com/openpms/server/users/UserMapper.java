package com.openpms.server.users;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Long create(User user);

    User findById(Long id);

    int updateById(User user);

    int deleteById(Long id);
}