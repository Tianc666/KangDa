package com.ssm.controller;

import com.ssm.dao.mapper.SalesmessageMapper;
import com.ssm.entity.*;
import com.ssm.service.impl.MedicineServiceImpl;
import com.ssm.service.impl.SalesmessageServiceImpl;
import com.ssm.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Controller
public class SaleMessageController {


    @Autowired
    MedicineServiceImpl msi;
    @Autowired
    SalesmessageServiceImpl ssi;
    @Autowired
    UserServiceImpl usi;
    @Autowired
    SalesmessageMapper sm;

    @RequestMapping("/shijian")
    public String AddSaleMessage(HttpServletRequest request) {
        /*查询所有注册用户名以及用户id*/
        UserExample userExample = new UserExample();
        List<User> users = usi.SelectUser(userExample);

        HttpSession session = request.getSession();
        session.setAttribute("users",users);

//        for (User u : users) {
//            String uname = u.getuUsername();
//            Integer uid = u.getuId();
//            System.out.println(uid + "----" + uname);
//        }

        /*查询所有注册药品名以及药品id*/
        MedicineExample medicineExample = new MedicineExample();
        List<Medicine> medicines = msi.selectAll(medicineExample);
        session.setAttribute("medicines",medicines);
//        for (Medicine m : medicines) {
//            String nName = m.getmName();
//            Integer mid = m.getmId();
//            System.out.println(mid + "++++++" + nName);
//        }

        return "shijian";
//        return "redirect:/salemessage";
    }

    @RequestMapping("/tijiao")
    public String tijiao(HttpServletRequest request, String changeuser, String changemedicine, String count, String data){
//        String changeuser = request.getParameter("changeuser");
//        String changemedicine = request.getParameter("changemedicine");
//        System.out.println(changeuser+"++++++++++"+changemedicine);
        System.out.println("++++++++++++++++++++"+changeuser+"------------"+changemedicine);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        int count1 = Integer.parseInt("count");
//        int count1 = Integer.valueOf("count");


        Salesmessage salesmessage = new Salesmessage();
        salesmessage.setSmInventory(Integer.parseInt(count));
        salesmessage.setSmMedicineid(Integer.parseInt(changemedicine));
        salesmessage.setSmUserid(Integer.parseInt(changeuser));
        salesmessage.setSmData(parse);
        int insert = sm.insert(salesmessage);
//        ssi.insertSalesmessage(changemedicine,changeuser,parse,count);

        return "salemessage";
    }



    @RequestMapping(value = "/salemessage", method = RequestMethod.POST)
    @ResponseBody
    public String salemessage(HttpServletRequest request, @Param("cuname") String cuname) {
        HttpSession session = request.getSession();
//        //        查询销售记录用户都有哪些
//        List<Salesmessage> Saleuname = ssi.SelectUname();
//        session.setAttribute("Saleuname",Saleuname);

//        if (cuname == null || cuname.equals("all")) {
            List<Salesmessage> salesmessages = ssi.SellectAllSalesmessage();

            session.setAttribute("salesmessages", salesmessages);

            System.out.println("查询所有销售记录" + salesmessages);
            return "salemessage";
//        } else {
//
//            List<Salesmessage> salesmessages = ssi.SelectByUname(cuname);
//            session.setAttribute("salesmessages", salesmessages);
//            System.out.println("查询指定销售记录----" + salesmessages);
////            return "redirct:salemessage2";
//            return "salemessage";
//        }

//        String cuname = request.getParameter("cuname");
//        System.out.println("____________________"+cuname);

    }

    @RequestMapping(value = "/salemessage", method = RequestMethod.GET)
    public String salemsg(HttpServletRequest request, @Param("cuname") String cuname) {
        HttpSession session = request.getSession();
        //        查询销售记录用户都有哪些
        List<Salesmessage> Saleuname = ssi.SelectUname();
        session.setAttribute("Saleuname", Saleuname);
//
//
//        if (cuname == null || cuname.equals("all")) {
            List<Salesmessage> salesmessages = ssi.SellectAllSalesmessage();

            session.setAttribute("salesmessages", salesmessages);

            System.out.println("查询所有销售记录" + salesmessages);
            return "salemessage";
//        } else {
//
//            List<Salesmessage> salesmessages = ssi.SelectByUname(cuname);
//            session.setAttribute("salesmessages", salesmessages);
//            System.out.println("查询指定销售记录----" + salesmessages);
////            return "redirct:salemessage2";
//            return "salemessage";
//        }

//        return "salemessage";
    }

    @RequestMapping("/salemessage2")
    public String salemsg2(HttpServletRequest request, @Param("cuname") String cuname) {
        HttpSession session1 = request.getSession();
        List<Salesmessage> salesmessages2 = ssi.SelectByUname(cuname);
        session1.setAttribute("salesmessages2", salesmessages2);
        System.out.println("查询指定销售记录----" + salesmessages2);
//            return "redirct:salemessage2";
        return "salemessage2";
    }
}
