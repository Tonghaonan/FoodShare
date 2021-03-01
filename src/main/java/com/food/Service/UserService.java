package com.food.service;

import com.food.vo.User;

public interface UserService {
    public User updateByUser();

    public boolean login(User user) throws Exception;

    public User selectByUsername(String username) throws Exception;

    public boolean regist(User user) throws Exception;
}
