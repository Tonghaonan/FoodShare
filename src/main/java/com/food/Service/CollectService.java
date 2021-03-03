package com.food.service;

import com.food.vo.Collect;
import com.food.vo.Food;

import java.util.List;

public interface CollectService {

	//根据美食id和用户id查询用户是否点赞
	public Collect getCollectByFidAndUid(int fid,int uid) throws Exception;

	//根据用户id查询该用户所有收藏的美食信息
	public List<Food> getAllFoodByUid(int uid) throws Exception;

	// 收藏
	public void saveCollect(Collect collect) throws Exception;

	// 取消收藏
	public void deleteCollect(Collect collect) throws Exception;

}
