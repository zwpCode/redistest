package com.redis.redistest.menu.controller;

import com.redis.redistest.menu.services.IMenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuServices iMenuServices;

    @GetMapping("/listMenu")
    @ResponseBody
    public List<String> Menu(){

        return iMenuServices.MenuList();
    }
    @GetMapping("/name")
    @ResponseBody
    public String Name(){

        return iMenuServices.Name();
    }
    @RequestMapping(value = "/menuPage")
    public String index(){
        String aaa = "kkkkkkkkkkk";

        return "menu";
    }

}
