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

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
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
    @RequestMapping("/toSingle")
    public String toSingle(){
        return "single";
    }
    @RequestMapping("/toAddFood")
    public String toAddFood(Model model){
        try {
            List<Category> categoryList = categoryService.getAllCategory();
            model.addAttribute("categoryList",categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "addFood";
    }

}
