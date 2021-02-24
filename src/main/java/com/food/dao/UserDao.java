package com.food.dao;

import com.food.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户模块dao
 * @author tpnghaonan
 *
 */
@Component
public interface UserDao {
	//保存用户信息
	public void saveUser(User user) throws Exception;
	//用户登录
	public List<User> getUser(User user)throws Exception;
	//根据用户名更新密码
	public void updatePwd(User user)throws Exception;
	//根据用户名查询用户是否存在
	public List<User> getUserByUsername(@Param("username") String username)throws Exception;
	//查询所有用户
	public List<User> getAllUser(@Param("start") int start, @Param("length") int length, @Param("isadmin") String isadmin, @Param("username") String username)throws Exception;
	//查询所有用户数量
	public int getAllUserCount(@Param("start") int start, @Param("length") int length, @Param("isadmin") String isadmin, @Param("username") String username)throws Exception;
}
