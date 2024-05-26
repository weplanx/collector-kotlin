package com.creator.server.user

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : ServiceImpl<UserMapper?, User?>(), UserService
