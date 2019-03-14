package com.redis.redistest.user.service.serviceimpl;

import com.redis.redistest.user.entity.User;
import com.redis.redistest.user.dao.UserMapper;
import com.redis.redistest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {

        User user = userMapper.findByUsername(username);

        return user;
    }
}
