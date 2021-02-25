package com.food.controller;

import com.food.service.CategoryService;
import com.food.service.FoodService;
import com.food.vo.Category;
import com.food.vo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 美食相关控制层
 */
@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/saveFood")
    public String saveFood(Food food, MultipartFile file){
        try {
            foodService.saveFood(food,file);
        } catch (Exception e) {
            //上传失败
        }
        return "redirect:/toIndex";
    }

    @RequestMapping("/getFoodByCidAndFname")
    public String getFoodByCidAndFname(Food food,Model model){
        try {
            List<Food> foodList = foodService.getFoodByCidAndFname(food.getCid(),food.getFname());
            List<Category> categoryList = categoryService.getAllCategory();
            model.addAttribute("categoryList",categoryList);
            model.addAttribute("foodList",foodList);
            model.addAttribute("cid",food.getCid());
            model.addAttribute("fname",food.getFname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/getAllFoodByFname")
    public String getAllFoodByFname(Food food,Model model){
        try {
            List<Food> foodList = foodService.getAllFoodByFname(food.getFname());
            model.addAttribute("foodList",foodList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
