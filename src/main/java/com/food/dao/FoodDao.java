package com.food.dao;

import com.food.vo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 美食模块dao
 * @author tpnghaonan
 *
 */
@Component
public interface FoodDao {

	//根据分类ID和名称模糊查询分类下所有的食物
	public List<Food> getFoodByCidAndFname(@Param("cid") int cid, @Param("fname") String fname) throws Exception;

	//查询所有美食(可以模糊查询)
	public List<Food> getAllFoodByFname(@Param("fname") String fname) throws Exception;

	//根据美食ID查询美食详细信息
	public Food getFoodByFid(@Param("fid") int fid) throws Exception;

	// 添加美食
	public void saveFood(Food food) throws Exception;

	// 修改美食
	public void updateFood(Food food) throws Exception;

	// 删除美食
	public void deleteFood(@Param("fid") int fid) throws Exception;

	//根据用户id查询用户分享的所有美食
	public List<Food> getAllFoodByUid(@Param("uid") int uid) throws Exception;

	//分页查询所有美食(可以模糊查询)
	public List<Food> getAllFoodByFnameAndPage(@Param("fname") String fname,@Param("start") int start, @Param("length") int length) throws Exception;

	//查询所有美食数量(可以模糊查询)
	public int getAllFoodByFnameCount()throws Exception;
}
