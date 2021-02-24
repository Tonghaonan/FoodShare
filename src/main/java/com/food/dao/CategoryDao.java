package com.food.dao;

import com.food.vo.Category;
import com.food.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分类模块dao
 * @author tpnghaonan
 *
 */
@Component
public interface CategoryDao {

	//根据cid查询分类信息
	public List<Category> getCategoryByCid(Integer cid) throws Exception;

	//查询所有分类信息
	public List<Category> getAllCategory() throws Exception;

	// 添加分类信息
	public void saveCategory(Category category) throws Exception;

	// 修改分类信息
	public void updateCategory(Category category) throws Exception;

	// 删除分类信息
	public void delectCategory(Integer cid) throws Exception;
}
