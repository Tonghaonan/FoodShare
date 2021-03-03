package com.food.controller;

import com.food.service.UserService;
import com.food.util.PageResult;
import com.food.util.PageUtil;
import com.food.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("getAllUser")
    @ResponseBody
    public PageResult getAllUser(@RequestParam("page") int page, @RequestParam("limit") int limit) throws Exception {
        //查询列表数据
        PageUtil pageUtil = new PageUtil(page,limit);
        return userService.getAllUser(pageUtil);
    }

    @RequestMapping("editUserInfo")
    public String editUserInfo(HttpServletRequest request, Model model){
        return "edituserinfo";
    }
    /**
     * 注册方法
     * @param user
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    public String regist(User user, Model model) throws Exception{
        boolean regist = userService.regist(user);
        if (!regist){

            return "regist";
        }
        return "login";
    }
    /**
     *登录方法，jsp访问login路径，进入到控制层的login方法。
     * 执行业务层的登录方法 查出来有对象返回true，没有返回false
     * @param user
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(User user, Model model) throws Exception {
        System.out.println(user);

        boolean login = userService.login(user);

        String success="登录成功";
        String fail="登录失败，账号或密码错误，请重试";

        if (!login){
            model.addAttribute("message",fail);
            return "login";
        }else {
            User user1 = userService.selectByUsername(user.getUsername());
            model.addAttribute("message",success);
            model.addAttribute("user1",user1);
//            HttpSession session = request.getSession();
//            session.setAttribute("user1",user1);
            return "index";
        }
    }
}
