package com.food.controller;

import com.food.service.CommentService;
import com.food.service.PraiseService;
import com.food.vo.Comment;
import com.food.vo.Praise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 点赞相关控制层
 */
@Controller
public class PraiseController {
    @Autowired
    private PraiseService praiseService;

    @RequestMapping("/savePraise")
    @ResponseBody
    public String savePraise(Praise praise){
        try {
            praiseService.savePraise(praise);
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

    @RequestMapping("/deletePraise")
    @ResponseBody
    public String deletePraise(Praise praise){
        try {
            praiseService.deletePraise(praise);
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

}
