package com.food.service.impl;

import com.food.dao.UserDao;
import com.food.service.UserService;
import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User updateByUser() {
        return null;
    }



    @Override
    public boolean login(User user) throws Exception {
        boolean flag=false;
        List<User> user1 = userDao.getUser(user);
        for (User u : user1
        ) {
            if (u == null) {
                flag=false;
            } else {
                flag=true;
            }
        }
        return flag;
    }

    /**
     * 根据用户名查询出来的用户对象
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public User selectByUsername(String username) throws Exception {
        User user =null;
        List<User> userByUsername = userDao.getUserByUsername(username);
        /**
         * 查出来的对象是一个list集合，需要先从list集合中遍历出来要找的对象，
         * 返回给控制层处理
         */
//        userByUsername.forEach(user1 ->{
//            user=user1;
//        });
        for (User u:userByUsername
             ) {
            user=u;
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean regist(User user) throws Exception {
        userDao.registry(user);
        User user1 = selectByUsername(user.getUsername());
        if (user1!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public PageResult getAllUser(PageUtil pageUtil) throws Exception {
        List<User> userList = userDao.getAllUser(pageUtil.getStart(), pageUtil.getLimit());
        int cnt = userDao.getAllUserCount();
        PageResult pageResult = new PageResult(userList,cnt,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }
}
