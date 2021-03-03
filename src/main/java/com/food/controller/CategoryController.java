package com.food.controller;

import com.food.service.CategoryService;
import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 美食分类相关控制层
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/saveCategory")
    @ResponseBody
    public Map saveCategory(Category category){
        Map resultMap = new HashMap<String,Object>();
        try {
            categoryService.saveCategory(category.getCname());
            resultMap.put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","1");
            resultMap.put("msg",e.getMessage());

        }
        return resultMap;
    }

    @RequestMapping("/deleteCategory")
    @ResponseBody
    public Map deleteCategory(@RequestBody List<Integer> cid){
        Map resultMap = new HashMap<String,Object>();
        try {
            categoryService.deleteCategory(cid.get(0));
            resultMap.put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","1");
            resultMap.put("msg",e.getMessage());

        }
        return resultMap;
    }


    @RequestMapping("/updateCategory")
    @ResponseBody
    public Map updateCategory(Category category){
        Map resultMap = new HashMap<String,Object>();
        try {
            categoryService.updateCategory(category);
            resultMap.put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","1");
            resultMap.put("msg",e.getMessage());
        }
        return resultMap;
    }

    @RequestMapping("/getAllCategoryByPage")
    @ResponseBody
    public PageResult getAllCategoryByPage(@RequestParam("page") int page, @RequestParam("limit") int limit) throws Exception {
        //查询列表数据
        PageUtil pageUtil = new PageUtil(page,limit);
        return categoryService.getAllCategoryByPage(pageUtil);
    }


}
