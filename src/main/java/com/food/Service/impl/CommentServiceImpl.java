package com.food.service.impl;

import com.food.dao.CommentDao;
import com.food.service.CommentService;
import com.food.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 评论模块业务层
 * @author Administrator
 *
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    /**
     * 根据美食ID查询其所有评论
     * @param fid
     * @return
     * @throws Exception
     */
    @Override
    public List<Comment> getAllCommentByFid(int fid) throws Exception {
        return commentDao.getAllCommentByFid(fid);
    }

    /**
     * 新增评论
     * @param comment
     * @throws Exception
     */
    @Override
    public void saveComment(Comment comment) throws Exception {
        comment.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        commentDao.saveComment(comment);
    }

    /**
     * 根据评论ID删除评论
     * @param fid
     * @throws Exception
     */
    @Override
    public void deleteComment(int fid) throws Exception {
        commentDao.deleteComment(fid);
    }
}
