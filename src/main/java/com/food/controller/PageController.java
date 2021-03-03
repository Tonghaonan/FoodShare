package com.food.controller;

import com.food.service.CategoryService;
import com.food.service.FoodService;
import com.food.vo.Category;
import com.food.vo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;

    /**
     *
     * @return
     */
    @RequestMapping("/toEditUserInfo")
    public String toEditUserInfo(){

        return "edituserinfo";
    }
//    登录

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/jsp/login";
    }
//    首页
    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        try {
            List<Food> foodList = foodService.getAllFoodByFname(null);
            List<Category> categoryList = categoryService.getAllCategory();
            model.addAttribute("foodList",foodList);
            model.addAttribute("categoryList",categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/jsp/index";
    }
//    注册
    @RequestMapping("/toRegist")
    public String toRegist(){
        return "/jsp/regist";
    }

    @RequestMapping("/toContact")
    public String toContact(){
        return "/jsp/contact";
    }
    @RequestMapping("/toPortfolio")
    public String toPortfolio(){
        return "/jsp/portfolio";
    }
    @RequestMapping("/toAbout")
    public String toAbout(){
        return "/jsp/about";
    }
    @RequestMapping("/toServices")
    public String toServices(){
        return "/jsp/services";
    }
    @RequestMapping("/toSingle")
    public String toSingle(){
        return "/jsp/single";
    }
    @RequestMapping("toAddFood")
    public String toAddFood(Model model){
        try {
            List<Category> categoryList = categoryService.getAllCategory();
            model.addAttribute("categoryList",categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/jsp/addFood";
    }



}
