package com.redis.redistest.menu.services.servicesimpl;

import com.redis.redistest.common.Http;
import com.redis.redistest.common.RedisUtil;
import com.redis.redistest.menu.services.IMenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuServicesImpl implements IMenuServices{

    @Autowired
    StringRedisTemplate redis;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public List<String> MenuList() {

        List<String> list = redisUtil.lRange("site-list",0,2);

        return list;
    }

    @Override
    public String Name() {

        redisUtil.set("name","HelloWorld!");

        String url ="http://stockpage.10jqka.com.cn/spService/600776/Funds/realFunds";

        String json= Http.getHttpResponse(url);

        System.out.println(json);

        redisUtil.set("600779",json);

        System.out.println(redisUtil.get("600779"));



        return json;
    }
}
