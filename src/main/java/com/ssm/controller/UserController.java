package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.entity.UserExample;
import com.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl usi;

    @RequestMapping("/opinionUser")
    public String OpinionUser(HttpServletResponse response, HttpServletRequest request, UserExample userExample) {


        String username = null;
        String pwd = null;
        List<User> users = usi.SelectUser(userExample);

        System.out.println("所有" + users);

        String uname = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("前台获取用户名" + uname);
        System.out.println("嵌套获取密码" + password);

        for (User u : users) {
            username = u.getuUsername();
            pwd = u.getuPassword();
            Integer limit = u.getuLimit();
            System.out.println("增强循环" + username + pwd);
            if (uname.equals(username) && password.equals(pwd)&& limit==0) {
                System.out.println("1111111111111111111111111");
                return "index";
            }else if(uname.equals(username) && password.equals(pwd) && limit!=0){
                return "redirect:/medicineList";
            }
        }
        System.out.println("2222222222222222222222222222");
        return "login2";
    }

    @RequestMapping("/registerUser")
    public String registerUser(HttpServletRequest request) {
        String rname = request.getParameter("rname");
        String rpassword = request.getParameter("rpassword");
//        String repwd = request.getParameter("Repwd");

        System.out.println("前台获取(注册)用户名" + rname);
        System.out.println("嵌套获取（注册）密码" + rpassword);


            User user = new User();
            user.setuUsername(rname);
            user.setuPassword(rpassword);
            usi.InsertUser(user);
            return "login2";




    }


}
