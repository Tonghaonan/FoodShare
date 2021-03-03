package com.food.controller;

import com.food.service.CommentService;
import com.food.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评论相关控制层
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/saveComment")
    public String saveComment(Comment comment){
        try {
            commentService.saveComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/getFoodByFid?fid=" + comment.getFid();
    }

}
