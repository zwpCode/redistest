package com.redis.redistest.user.service;

import com.redis.redistest.user.entity.User;

public interface UserService {

    User findByUsername(String username);
}
