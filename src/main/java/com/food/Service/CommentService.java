package com.food.service;

import com.food.vo.Comment;
import com.food.vo.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommentService {
	//根据美食id查询所有其所有评论
	public List<Comment> getAllCommentByFid(int fid) throws Exception;

	// 新增评论
	public void saveComment(Comment comment) throws Exception;

	// 删除评论
	public void deleteComment(int fid) throws Exception;

}
