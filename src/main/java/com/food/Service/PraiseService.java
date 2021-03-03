package com.food.service;

import com.food.vo.Food;
import com.food.vo.Praise;

import java.util.List;

public interface PraiseService {

	//根据美食id和用户id查询用户是否点赞
	public Praise getPraiseByFidAndUid(int fid,int uid) throws Exception;

	//根据用户id查询该用户所有点赞的美食信息
	public List<Food> getAllFoodByUid(int uid) throws Exception;

	// 点赞
	public void savePraise(Praise praise) throws Exception;

	// 取消点赞
	public void deletePraise(Praise praise) throws Exception;

}
