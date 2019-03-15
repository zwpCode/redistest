package com.redis.redistest.user.entity;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

    private Integer rid;

    private String rname;

    private Set<Permission> permissions = new HashSet<>();

    private Set<User> users = new HashSet<>();
}
