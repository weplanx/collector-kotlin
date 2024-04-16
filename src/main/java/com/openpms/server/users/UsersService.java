package com.openpms.server.users;

import com.google.common.base.Preconditions;
import com.openpms.server.users.dto.CreateParam;
import com.openpms.server.users.dto.UpdateParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.findById(id);
    }

    public Long create(CreateParam param) {
        User user = new User();
        user.setEmail(param.getEmail());
        user.setPassword(param.getPassword());
        user.setName(param.getName());
        user.setAvatar(param.getAvatar());
        return this.userMapper.create(user);
    }

    public int updateById(Long id, UpdateParam param) {
        User user = new User();
        user.setId(id);
        user.setEmail(param.getEmail());
        user.setPassword(param.getPassword());
        user.setName(param.getName());
        user.setAvatar(param.getAvatar());
        user.setStatus(param.getStatus());
        return this.userMapper.updateById(user);
    }

    public int deleteById(Long id) {
        return this.userMapper.deleteById(id);
    }
}
