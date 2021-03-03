package com.food.service.impl;

import com.food.dao.CollectDao;
import com.food.service.CollectService;
import com.food.vo.Collect;
import com.food.vo.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 收藏模块业务层
 * @author Administrator
 *
 */
@Service
@Transactional
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;

    /**
     * 根据美食id和用户id查询用户是否点赞
     * @param fid
     * @return
     * @throws Exception
     */
    @Override
    public Collect getCollectByFidAndUid(int fid,int uid) throws Exception {
        return collectDao.getCollectByFidAndUid(fid,uid);
    }

    /**
     * 根据用户id查询所有收藏过的美食信息
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public List<Food> getAllFoodByUid(int uid) throws Exception {
        return collectDao.getAllFoodByUid(uid);
    }

    /**
     * 收藏
     * @param Collect
     * @throws Exception
     */
    @Override
    public void saveCollect(Collect Collect) throws Exception {
        collectDao.saveCollect(Collect);
    }

    /**
     * 取消收藏
     * @param Collect
     * @throws Exception
     */
    @Override
    public void deleteCollect(Collect Collect) throws Exception {
        collectDao.deleteCollect(Collect);
    }
}
