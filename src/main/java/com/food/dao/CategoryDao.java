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
	public List<Category> getCategoryByCid(@Param("cid") int cid) throws Exception;

	//查询所有分类信息
	public List<Category> getAllCategory() throws Exception;

	//查询所有分类信息数量
	public int getAllCategoryCount()throws Exception;

	//添加分类信息
	public void saveCategory(@Param("cname") String cname) throws Exception;

	//修改分类信息
	public void updateCategory(Category category) throws Exception;

	//删除分类信息
	public void deleteCategory(@Param("cid") int cid) throws Exception;

	//分页查询所有分类信息
	public List<Category> getAllCategoryByPage(@Param("start") int start, @Param("length") int length) throws Exception;
}
