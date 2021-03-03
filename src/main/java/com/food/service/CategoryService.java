package com.food.service;


import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.Category;

import java.util.List;

public interface CategoryService {
	//根据cid查询分类信息
	public List<Category> getCategoryByCid(int cid) throws Exception;

	//查询所有分类信息
	public List<Category> getAllCategory() throws Exception;

	// 添加分类信息
	public void saveCategory(String cname) throws Exception;

	// 修改分类信息
	public void updateCategory(Category category) throws Exception;

	// 删除分类信息
	public void deleteCategory(int cid) throws Exception;

	//分页查询所有分类信息
	public PageResult getAllCategoryByPage(PageUtil pageUtil) throws Exception;

}
