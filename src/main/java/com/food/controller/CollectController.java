package com.food.controller;

import com.food.service.CollectService;
import com.food.vo.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收藏相关控制层
 */
@Controller
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping("/saveCollect")
    @ResponseBody
    public String saveCollect(Collect collect){
        try {
            collectService.saveCollect(collect);
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

    @RequestMapping("/deleteCollect")
    @ResponseBody
    public String deleteCollect(Collect collect){
        try {
            collectService.deleteCollect(collect);
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
        return "0";
    }

}
