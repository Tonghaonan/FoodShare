package com.food.dao;

import com.food.vo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 评论模块dao
 * @author tpnghaonan
 *
 */
@Component
public interface CommentDao {

	//根据美食id查询所有其所有评论
	public List<Comment> getAllCommentByFid(@Param("fid") int fid) throws Exception;

	// 新增评论
	public void saveComment(Comment comment) throws Exception;

	// 删除评论
	public void deleteComment(@Param("fid") int fid) throws Exception;

}
