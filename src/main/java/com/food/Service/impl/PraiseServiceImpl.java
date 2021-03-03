package com.food.service.impl;

import com.food.dao.CommentDao;
import com.food.dao.PraiseDao;
import com.food.service.CommentService;
import com.food.service.PraiseService;
import com.food.vo.Comment;
import com.food.vo.Food;
import com.food.vo.Praise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 点赞模块业务层
 * @author Administrator
 *
 */
@Service
@Transactional
public class PraiseServiceImpl implements PraiseService {
    @Autowired
    private PraiseDao praiseDao;

    /**
     * 根据美食id和用户id查询用户是否点赞
     * @param fid
     * @return
     * @throws Exception
     */
    @Override
    public Praise getPraiseByFidAndUid(int fid,int uid) throws Exception {
        return praiseDao.getPraiseByFidAndUid(fid,uid);
    }

    /**
     * 根据用户id查询所有点赞过的美食信息
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public List<Food> getAllFoodByUid(int uid) throws Exception {
        return praiseDao.getAllFoodByUid(uid);
    }

    /**
     * 点赞
     * @param praise
     * @throws Exception
     */
    @Override
    public void savePraise(Praise praise) throws Exception {
        praiseDao.savePraise(praise);
    }

    /**
     * 取消点赞
     * @param praise
     * @throws Exception
     */
    @Override
    public void deletePraise(Praise praise) throws Exception {
        praiseDao.deletePraise(praise);
    }
}
