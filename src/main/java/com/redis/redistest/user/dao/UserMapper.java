package com.redis.redistest.user.dao;


import com.redis.redistest.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);

}
