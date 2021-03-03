package com.food.service.impl;

import com.food.dao.CategoryDao;
import com.food.dao.FoodDao;
import com.food.service.CategoryService;
import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.Category;
import com.food.vo.Food;
import com.food.vo.User;
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
	@Autowired
    private FoodDao foodDao;

    @Override
    public List<Category> getCategoryByCid(int cid) throws Exception {
        return categoryDao.getCategoryByCid(cid);
    }

    @Override
    public List<Category> getAllCategory() throws Exception {
        return categoryDao.getAllCategory();
    }

    //添加美食分类
	@Override
	public void saveCategory(String cname) throws Exception {
        categoryDao.saveCategory(cname);
	}

    @Override
    public void updateCategory(Category category) throws Exception {
        categoryDao.updateCategory(category);
    }

    /**
     * 根据分类id删除美食分类
     * @param cid
     * @throws Exception
     */
    @Override
    public void deleteCategory(int cid) throws Exception {
        //先根据分类id查询是否有商品属于该分类，有则不能删除
        List<Food> foodList = foodDao.getFoodByCidAndFname(cid, null);
        if(foodList == null || foodList.isEmpty()){
            categoryDao.deleteCategory(cid);
        }else{
            throw new Exception("该分类下有美食信息,不能删除");
        }
    }

    @Override
    public PageResult getAllCategoryByPage(PageUtil pageUtil) throws Exception {
        List<Category> userList = categoryDao.getAllCategoryByPage(pageUtil.getStart(), pageUtil.getLimit());
        int cnt = categoryDao.getAllCategoryCount();
        PageResult pageResult = new PageResult(userList,cnt,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }


}
