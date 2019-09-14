package com.ssm.controller;

import com.ssm.entity.Medicine;
import com.ssm.service.impl.LiuServiceImpl;
import com.ssm.service.impl.SaledServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LiuController {
    @Autowired
    SaledServiceImpl sall;
    @RequestMapping("/saled")
    public String saled(Model model){
        List<Medicine> saled = sall.SellecAllSaled();
        model.addAttribute("saled",saled);
        System.out.println("======"+saled);
        return "saled";
    }



    @Autowired
    LiuServiceImpl liu;
    @RequestMapping("/inventory")

    public String liu(HttpServletRequest request){
        List<Medicine> inventory = liu.SellecAllInventory();
        request.setAttribute("inventory",inventory);
        

        
        return "inventory";
    }

//    分类管理子页面
    @RequestMapping("/classify-add")/*product-category-add*/
    public String classifyadd(){
        return "classify-add";
    }


}
