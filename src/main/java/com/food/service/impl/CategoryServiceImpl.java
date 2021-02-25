package com.food.service.impl;

import com.food.dao.CategoryDao;
import com.food.service.CategoryService;
import com.food.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 美食分类业务类
 * @author Administrator
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoryByCid(Integer cid) throws Exception {
        return categoryDao.getCategoryByCid(cid);
    }

    @Override
    public List<Category> getAllCategory() throws Exception {
        return categoryDao.getAllCategory();
    }

    //添加美食分类
	@Override
	public void saveCategory(Category category) throws Exception {
	}

    @Override
    public void updateCategory(Category category) throws Exception {

    }

    @Override
    public void delectCategory(Integer cid) throws Exception {

    }


}
