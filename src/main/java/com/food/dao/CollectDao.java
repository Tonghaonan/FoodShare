package com.food.dao;

import com.food.vo.Collect;
import com.food.vo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 收藏模块dao
 * @author tpnghaonan
 *
 */
@Component
public interface CollectDao {

	//根据美食id和用户id查询用户是否点赞
	public Collect getCollectByFidAndUid(@Param("fid") int fid,@Param("uid") int uid) throws Exception;

	//根据用户id查询该用户所有收藏的美食信息
	public List<Food> getAllFoodByUid(@Param("uid") int uid) throws Exception;

	// 收藏
	public void saveCollect(Collect collect) throws Exception;

	// 取消收藏
	public void deleteCollect(Collect collect) throws Exception;


}
