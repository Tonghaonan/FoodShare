package com.food.controller;

import com.food.service.*;
import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 美食相关控制层
 */
@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PraiseService praiseService;
    @Autowired
    private CollectService collectService;

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

    @RequestMapping("/getFoodByFid")
    public String getFoodByFid(@RequestParam("fid") int fid, Model model){
        try {
            Food foodInfo = foodService.getFoodByFid(fid);
            List<Comment> commentList = commentService.getAllCommentByFid(fid);
            //TODO
            Collect collect = collectService.getCollectByFidAndUid(fid, 0);
            Praise praise = praiseService.getPraiseByFidAndUid(fid, 0);
            model.addAttribute("foodInfo",foodInfo);
            model.addAttribute("commentList",commentList);
            model.addAttribute("collect",collect);
            model.addAttribute("praise",praise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "foodInfo";
    }

    @RequestMapping("/getAllFoodByUid")
    public String getAllFoodByUid(@RequestParam("uid") int uid,Model model){
        try {
            List<Food> foodList = foodService.getAllFoodByUid(uid);
            model.addAttribute("foodList",foodList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "myFood";
    }


    @RequestMapping("/deleteFood")
    @ResponseBody
    public Map deleteFood(@RequestParam("fid") int fid){
        Map resultMap = new HashMap<String,Object>();
        try {
            foodService.delectFood(fid);
            resultMap.put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","1");
            resultMap.put("msg",e.getMessage());

        }
        return resultMap;
    }


    @RequestMapping("/updateFood")
    @ResponseBody
    public Map updateFood(Food food){
        Map resultMap = new HashMap<String,Object>();
        try {
            foodService.updateFood(food);
            resultMap.put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","1");
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }

    @RequestMapping("/getAllFoodByFnameAndPage")
    @ResponseBody
    public PageResult getAllFoodByFnameAndPage(@RequestParam(value="fname",defaultValue="",required=false) String fname,@RequestParam("page") int page, @RequestParam("limit") int limit) throws Exception {
        //查询列表数据
        PageUtil pageUtil = new PageUtil(page,limit);
        return foodService.getAllFoodByFnameAndPage(fname,pageUtil);
    }

    @RequestMapping("/getFoodAndCategoryByFid")
    @ResponseBody
    public Map getFoodAndCategoryByFid(@RequestParam("fid") int fid){
        Map resultMap = new HashMap<String,Object>();
        try {
            Food foodInfo = foodService.getFoodByFid(fid);
            List<Category> categoryList = categoryService.getAllCategory();
            resultMap.put("foodInfo",foodInfo);
            resultMap.put("categoryList",categoryList);
            resultMap.put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","1");
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }

}
