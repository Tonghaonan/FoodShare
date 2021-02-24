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

    @RequestMapping("/toContact")
    public String toContact(){
        return "contact";
    }
    @RequestMapping("/toPortfolio")
    public String toPortfolio(){
        return "portfolio";
    }
    @RequestMapping("/toAbout")
    public String toAbout(){
        return "about";
    }
    @RequestMapping("/toServices")
    public String toServices(){
        return "services";
    }


}
