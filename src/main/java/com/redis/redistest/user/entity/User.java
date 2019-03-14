package com.redis.redistest.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {

    private Integer uid;

    private String username;

    private String password;

    private Set<Role> roles = new HashSet<>();


}
