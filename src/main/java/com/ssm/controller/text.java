package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class text {
    @RequestMapping("/text")
    public String text(){
        return "login2";
    }

//    @RequestMapping("/index")
//    public String index(HttpServletRequest request){
//        String uname = request.getParameter("name");
//        System.out.println(uname);
//        if(uname.equals("haha")){
//            System.out.println("1111111111111111111111111");
//            return "index";
//        }
//        else {
//            System.out.println("2222222222222222222222222");
//            return "login2";}
//    }
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}
