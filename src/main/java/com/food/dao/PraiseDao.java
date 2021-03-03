package com.food.dao;

import com.food.vo.Food;
import com.food.vo.Praise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 点赞模块dao
 * @author tpnghaonan
 *
 */
@Component
public interface PraiseDao {

	//根据美食id和用户id查询用户是否点赞
	public Praise getPraiseByFidAndUid(@Param("fid") int fid,@Param("uid") int uid) throws Exception;

	//根据用户id查询该用户所有点赞的美食信息
	public List<Food> getAllFoodByUid(@Param("uid") int uid) throws Exception;

	// 点赞
	public void savePraise(Praise praise) throws Exception;

	// 取消点赞
	public void deletePraise(Praise praise) throws Exception;

}
