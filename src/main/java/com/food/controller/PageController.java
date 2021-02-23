package com.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/toRegist")
    public String toRegist(){
        return "regist";
    }


}
