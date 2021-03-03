package com.food.service;

import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {
	//根据分类ID和名称模糊查询分类下所有的食物
	public List<Food> getFoodByCidAndFname(int cid,String fname) throws Exception;

	//查询所有美食(可以模糊查询)
	public List<Food> getAllFoodByFname(String fname) throws Exception;

	//根据美食ID查询美食详细信息
	public Food getFoodByFid(int fid) throws Exception;

	// 添加美食
	public void saveFood(Food food, MultipartFile file) throws Exception;

	// 修改美食
	public void updateFood(Food food) throws Exception;

	// 删除美食
	public void delectFood(int fid) throws Exception;

	//根据用户id查询用户分享的所有美食
	public List<Food> getAllFoodByUid(int uid) throws Exception;

	//分页查询所有美食(可以模糊查询)
	public PageResult getAllFoodByFnameAndPage(String fname,PageUtil pageUtil) throws Exception;


}
