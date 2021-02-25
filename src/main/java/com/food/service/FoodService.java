package com.food.service;

import com.food.vo.Food;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {
	//根据分类ID和名称模糊查询分类下所有的食物
	public List<Food> getFoodByCidAndFname(int cid,String fname) throws Exception;

	//查询所有美食(可以模糊查询)
	public List<Food> getAllFoodByFname(String fname) throws Exception;

	// 添加美食
	public void saveFood(Food food, MultipartFile file) throws Exception;

	// 修改美食
	public void updateFood(Food food) throws Exception;

	// 删除美食
	public void delectFood(int fid) throws Exception;

}
