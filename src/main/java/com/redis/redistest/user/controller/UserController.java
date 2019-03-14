package com.redis.redistest.user.controller;

import com.redis.redistest.user.entity.User;
import com.redis.redistest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findByUsername")
    @ResponseBody
    public User findByUsername(String username){

        return userService.findByUsername(username);

    }
}
