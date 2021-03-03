package com.food.service;

import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.User;

import java.util.List;

public interface UserService {
    public User updateByUser();

    public boolean login(User user) throws Exception;

    public User selectByUsername(String username) throws Exception;

    public boolean regist(User user) throws Exception;

    public PageResult getAllUser(PageUtil pageUtil) throws Exception;
}
