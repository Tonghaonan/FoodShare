package com.food.service.impl;

import com.food.dao.FoodDao;
import com.food.service.FoodService;
import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.Category;
import com.food.vo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 一级分类的的业务层
 * @author Administrator
 *
 */
@Service
@Transactional
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDao foodDao;

    @Override
    public List<Food> getFoodByCidAndFname(int cid, String fname) throws Exception {
        return foodDao.getFoodByCidAndFname(cid,fname);
    }

    @Override
    public List<Food> getAllFoodByFname(String fname) throws Exception {
        return foodDao.getAllFoodByFname(fname);
    }

    @Override
    public Food getFoodByFid(int fid) throws Exception {
        return foodDao.getFoodByFid(fid);
    }

    @Override
    public void saveFood(Food food, MultipartFile file) throws Exception {
        //保存图片
        if (file.isEmpty()) {
            throw new Exception("图片不能为空");
        }
        String rootPath = System.getProperty("user.dir");
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).toString()+".JPG";
        String filePath = rootPath + "\\src\\main\\resources\\static\\food\\";
        File dest = new File(filePath+fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new Exception("图片上传失败",e);
        }
        //获取访问地址
        food.setImage("/static/food/" + fileName);
        //保存数据库
        foodDao.saveFood(food);
    }

    @Override
    public void updateFood(Food food) throws Exception {
        foodDao.updateFood(food);
    }

    @Override
    public void delectFood(int fid) throws Exception {
        foodDao.deleteFood(fid);
    }

    @Override
    public List<Food> getAllFoodByUid(int uid) throws Exception {
        return foodDao.getAllFoodByUid(uid);
    }

    @Override
    public PageResult getAllFoodByFnameAndPage(String fname,PageUtil pageUtil) throws Exception {
        List<Food> userList = foodDao.getAllFoodByFnameAndPage(fname,pageUtil.getStart(), pageUtil.getLimit());
        int cnt = foodDao.getAllFoodByFnameCount();
        PageResult pageResult = new PageResult(userList,cnt,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }
}
