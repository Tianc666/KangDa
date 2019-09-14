package com.ssm.controller;

import com.ssm.entity.Salesmessage;
import com.ssm.entity.SalesmessageExample;
import com.ssm.service.impl.ChartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//import java.text.SimpleDateFormat;

@Controller
public class ChartController {
    @Autowired
    ChartServiceImpl chartService;
    //*************************月销售表****************************************************************
    @RequestMapping("/MonthlyChart")
    public String MonthlyChart() {
        return "MonthlyChart";
    }

    @RequestMapping(value = "bar", method = RequestMethod.GET)
    public String GetMonthly() {
        return "MonthlyChart";
    }

    @RequestMapping(value = "bar", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<Object, Object>> GetMonthlyMessage() {

        SalesmessageExample salesmessageExample = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria = salesmessageExample.getOredCriteria();
        SalesmessageExample.Criteria or1 = salesmessageExample.or();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse1 = null;
        Date parse2 = null;

        String date = "2019-9-1 ";
        String time0 = "00:00:00";
        String time1 = "24:00:00";

        try {
            parse1 = simpleDateFormat.parse(date + time0);

            parse2 = simpleDateFormat.parse(date + time1);

            or1.andSmDataBetween(parse1, parse2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("0点时间" + parse1);
        System.out.println("24点时间" + parse2);
        oredCriteria.add(or1);
        List<Salesmessage> status1 = chartService.SellectAllSalesmessage(salesmessageExample);
//        获取销售额
        Integer smInventory1 = 0;
        /*--*/
        Integer sum1 = 0;
        for (Salesmessage s : status1) {
            smInventory1 = s.getSmInventory();
            // sum1=smInventory1;
            /*--*/
            sum1 = sum1 + smInventory1;
            System.out.println("我最想想要的值：" + sum1);
        }
//        Integer count1 = sum1;

        List<Map<Object, Object>> ls = new ArrayList<>();
        HashMap<Object, Object> map1 = new HashMap<>();

        map1.put("name", date + "销售额");
        /*--*/
        map1.put("value", sum1);
        System.out.println("我去去去去去去去去:::" + sum1);
        ls.add(map1);

        System.out.println("1号销售量json数据：" + ls);

/**********
 *2019-9-2*
 **********/
        SalesmessageExample salesmessageExample2 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria2 = salesmessageExample2.getOredCriteria();
        SalesmessageExample.Criteria or2 = salesmessageExample2.or();
        Date parse21 = null;
        Date parse22 = null;
        String date2 = "2019-9-2 ";
        try {
            parse21 = simpleDateFormat.parse(date2 + time0);

            parse22 = simpleDateFormat.parse(date2 + time1);
            System.out.println("0点时间" + parse21);
            System.out.println("24点时间" + parse22);

            or2.andSmDataBetween(parse21, parse22);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria2.add(or2);
        List<Salesmessage> status2 = chartService.SellectAllSalesmessage(salesmessageExample2);

        //获取销售额
        Integer smInventory2 = 0;
        Integer sum2 = 0;
        for (Salesmessage s : status2) {
            smInventory2 = s.getSmInventory();
            sum2 = sum2 + smInventory2;
            System.out.println("菠萝菠萝菠萝菠萝菠萝：" + smInventory2);
        }
        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put("name", date2 + "销售额");
        map2.put("value", sum2);
        System.out.println("HAHAHAHAHAHAHAHAH:::" + status2);
        ls.add(map2);

/**********
 *3019-9-3*
 **********/
        SalesmessageExample salesmessageExample3 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria3 = salesmessageExample3.getOredCriteria();
        SalesmessageExample.Criteria or3 = salesmessageExample3.or();
        Date parse31 = null;
        Date parse32 = null;
        String date3 = "2019-9-3 ";
        try {
            parse31 = simpleDateFormat.parse(date3 + time0);

            parse32 = simpleDateFormat.parse(date3 + time1);
            System.out.println("0点时间" + parse31);
            System.out.println("24点时间" + parse32);

            or3.andSmDataBetween(parse31, parse32);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria3.add(or3);
        List<Salesmessage> status3 = chartService.SellectAllSalesmessage(salesmessageExample3);

        Integer smInventory3 = 0;
        Integer sum3 = 0;
        for (Salesmessage s : status3) {
            smInventory3 = s.getSmInventory();
            sum3 = sum3 + smInventory3;
        }

        HashMap<Object, Object> map3 = new HashMap<>();
        map3.put("name", date3 + "销售额");
        map3.put("value", sum3);
        ls.add(map3);
/**********
 *2019-9-4*
 **********/
        SalesmessageExample salesmessageExample4 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria4 = salesmessageExample4.getOredCriteria();
        SalesmessageExample.Criteria or4 = salesmessageExample4.or();
        Date parse41 = null;
        Date parse42 = null;
        String date4 = "2019-9-4 ";
        try {
            parse41 = simpleDateFormat.parse(date4 + time0);

            parse42 = simpleDateFormat.parse(date4 + time1);
            System.out.println("0点时间" + parse41);
            System.out.println("24点时间" + parse42);

            or4.andSmDataBetween(parse41, parse42);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria4.add(or4);
        List<Salesmessage> status4 = chartService.SellectAllSalesmessage(salesmessageExample4);

        Integer smInventory4 = 0;
        Integer sum4 = 0;
        for (Salesmessage s : status4) {
            smInventory4 = s.getSmInventory();
            sum4 = sum4 + smInventory4;
        }

        HashMap<Object, Object> map4 = new HashMap<>();
        map4.put("name", date4 + "销售额");
        map4.put("value", sum4);
        ls.add(map4);

/**********
 *2019-9-5*
 **********/
        SalesmessageExample salesmessageExample5 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria5 = salesmessageExample5.getOredCriteria();
        SalesmessageExample.Criteria or5 = salesmessageExample5.or();
        Date parse51 = null;
        Date parse52 = null;
        String date5 = "2019-9-5 ";
        try {
            parse51 = simpleDateFormat.parse(date5 + time0);

            parse52 = simpleDateFormat.parse(date5 + time1);
            System.out.println("0点时间" + parse51);
            System.out.println("24点时间" + parse52);

            or5.andSmDataBetween(parse51, parse52);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria5.add(or5);
        List<Salesmessage> status5 = chartService.SellectAllSalesmessage(salesmessageExample5);

        Integer smInventory5 = 0;
        Integer sum5 = 0;
        for (Salesmessage s : status5) {
            smInventory5 = s.getSmInventory();
            sum5 = sum5 + smInventory5;
        }

        HashMap<Object, Object> map5 = new HashMap<>();
        map5.put("name", date5 + "销售额");
        map5.put("value", sum5);
        ls.add(map5);

/**********
 *2019-9-6*
 **********/
        SalesmessageExample salesmessageExample6 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria6 = salesmessageExample6.getOredCriteria();
        SalesmessageExample.Criteria or6 = salesmessageExample6.or();
        Date parse61 = null;
        Date parse62 = null;
        String date6 = "2019-9-6 ";
        try {
            parse61 = simpleDateFormat.parse(date6 + time0);

            parse62 = simpleDateFormat.parse(date6 + time1);
            System.out.println("0点时间" + parse61);
            System.out.println("24点时间" + parse62);

            or6.andSmDataBetween(parse61, parse62);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria6.add(or6);
        List<Salesmessage> status6 = chartService.SellectAllSalesmessage(salesmessageExample6);

        Integer smInventory6 = 0;
        Integer sum6 = 0;
        for (Salesmessage s : status6) {
            smInventory6 = s.getSmInventory();
            sum6 = sum6 + smInventory6;
        }

        HashMap<Object, Object> map6 = new HashMap<>();
        map6.put("name", date6 + "销售额");
        map6.put("value", sum6);
        ls.add(map6);
/**********
 *2019-9-7*
 **********/
        SalesmessageExample salesmessageExample7 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria7 = salesmessageExample7.getOredCriteria();
        SalesmessageExample.Criteria or7 = salesmessageExample7.or();
        Date parse71 = null;
        Date parse72 = null;
        String date7 = "2019-9-7 ";
        try {
            parse71 = simpleDateFormat.parse(date7 + time0);

            parse72 = simpleDateFormat.parse(date7 + time1);
            System.out.println("0点时间" + parse71);
            System.out.println("24点时间" + parse72);

            or7.andSmDataBetween(parse71, parse72);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria7.add(or7);
        List<Salesmessage> status7 = chartService.SellectAllSalesmessage(salesmessageExample7);

        Integer smInventory7 = 0;
        Integer sum7 = 0;
        for (Salesmessage s : status7) {
            smInventory7 = s.getSmInventory();
            sum7 = sum7 + smInventory7;
        }

        HashMap<Object, Object> map7 = new HashMap<>();
        map7.put("name", date7 + "销售额");
        map7.put("value", sum7);
        ls.add(map7);

/**********
 *2019-9-8*
 **********/
        SalesmessageExample salesmessageExample8 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria8 = salesmessageExample8.getOredCriteria();
        SalesmessageExample.Criteria or8 = salesmessageExample8.or();
        Date parse81 = null;
        Date parse82 = null;
        String date8 = "2019-9-8 ";
        try {
            parse81 = simpleDateFormat.parse(date8 + time0);

            parse82 = simpleDateFormat.parse(date8 + time1);
            System.out.println("0点时间" + parse81);
            System.out.println("24点时间" + parse82);

            or8.andSmDataBetween(parse81, parse82);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria8.add(or8);
        List<Salesmessage> status8 = chartService.SellectAllSalesmessage(salesmessageExample8);

        Integer smInventory8 = 0;
        Integer sum8 = 0;
        for (Salesmessage s : status8) {
            smInventory8 = s.getSmInventory();
            sum8 = sum8 + smInventory8;
        }

        HashMap<Object, Object> map8 = new HashMap<>();
        map8.put("name", date8 + "销售额");
        map8.put("value", sum8);
        ls.add(map8);

        /**********
         *2019-9-9*
         **********/
        SalesmessageExample salesmessageExample9 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria9 = salesmessageExample9.getOredCriteria();
        SalesmessageExample.Criteria or9 = salesmessageExample9.or();
        Date parse91 = null;
        Date parse92 = null;
        String date9 = "2019-9-9 ";
        try {
            parse91 = simpleDateFormat.parse(date9 + time0);

            parse92 = simpleDateFormat.parse(date9 + time1);
            System.out.println("0点时间" + parse91);
            System.out.println("24点时间" + parse92);

            or9.andSmDataBetween(parse91, parse92);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria9.add(or9);
        List<Salesmessage> status9 = chartService.SellectAllSalesmessage(salesmessageExample9);

        Integer smInventory9 = 0;
        Integer sum9 = 0;
        for (Salesmessage s : status9) {
            smInventory9 = s.getSmInventory();
            sum9 = sum9 + smInventory9;
        }

        HashMap<Object, Object> map9 = new HashMap<>();
        map9.put("name", date9 + "销售额");
        map9.put("value", sum9);
        ls.add(map9);

/**********
 *2019-9-10*
 **********/
        SalesmessageExample salesmessageExample10 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria10 = salesmessageExample10.getOredCriteria();
        SalesmessageExample.Criteria or10 = salesmessageExample10.or();
        Date parse101 = null;
        Date parse102 = null;
        String date10 = "2019-9-10 ";
        try {
            parse101 = simpleDateFormat.parse(date10 + time0);

            parse102 = simpleDateFormat.parse(date10 + time1);


            or10.andSmDataBetween(parse101, parse102);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria10.add(or10);
        List<Salesmessage> status10 = chartService.SellectAllSalesmessage(salesmessageExample10);

        Integer smInventory10 = 0;
        Integer sum10 = 0;
        for (Salesmessage s : status10) {
            smInventory10 = s.getSmInventory();
            sum10 = sum10 + smInventory10;
        }

        HashMap<Object, Object> map10 = new HashMap<>();
        map10.put("name", date10 + "销售额");
        map10.put("value", sum10);
        ls.add(map10);

/**********
 *2019-9-11*
 **********/
        SalesmessageExample salesmessageExample11 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria11 = salesmessageExample11.getOredCriteria();
        SalesmessageExample.Criteria or11 = salesmessageExample11.or();
        Date parse111 = null;
        Date parse112 = null;
        String date11 = "2019-9-11 ";
        try {
            parse111 = simpleDateFormat.parse(date11 + time0);

            parse112 = simpleDateFormat.parse(date11 + time1);


            or11.andSmDataBetween(parse111, parse112);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria11.add(or11);
        List<Salesmessage> status11 = chartService.SellectAllSalesmessage(salesmessageExample11);

        Integer smInventory11 = 0;
        Integer sum11 = 0;
        for (Salesmessage s : status11) {
            smInventory11 = s.getSmInventory();
            sum11 = sum11 + smInventory11;
        }

        HashMap<Object, Object> map11 = new HashMap<>();
        map11.put("name", date11 + "销售额");
        map11.put("value", sum11);
        ls.add(map11);

/**********
 *2019-9-12*
 **********/
        SalesmessageExample salesmessageExample12 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria12 = salesmessageExample12.getOredCriteria();
        SalesmessageExample.Criteria or12 = salesmessageExample12.or();
        Date parse121 = null;
        Date parse122 = null;
        String date12 = "2019-9-12 ";
        try {
            parse121 = simpleDateFormat.parse(date12 + time0);

            parse122 = simpleDateFormat.parse(date12 + time1);


            or12.andSmDataBetween(parse121, parse122);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria12.add(or12);
        List<Salesmessage> status12 = chartService.SellectAllSalesmessage(salesmessageExample12);

        Integer smInventory12 = 0;
        Integer sum12 = 0;
        for (Salesmessage s : status12) {
            smInventory12 = s.getSmInventory();
            sum12 = sum12 + smInventory12;
        }

        HashMap<Object, Object> map12 = new HashMap<>();
        map12.put("name", date12 + "销售额");
        map12.put("value", sum12);
        ls.add(map12);

        /**********
         *2019-9-13*
         **********/
        SalesmessageExample salesmessageExample13 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria13 = salesmessageExample13.getOredCriteria();
        SalesmessageExample.Criteria or13 = salesmessageExample13.or();
        Date parse131 = null;
        Date parse132 = null;
        String date13 = "2019-9-13 ";
        try {
            parse131 = simpleDateFormat.parse(date13 + time0);

            parse132 = simpleDateFormat.parse(date13 + time1);


            or13.andSmDataBetween(parse131, parse132);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria13.add(or13);
        List<Salesmessage> status13 = chartService.SellectAllSalesmessage(salesmessageExample13);

        Integer smInventory13 = 0;
        Integer sum13 = 0;
        for (Salesmessage s : status13) {
            smInventory13 = s.getSmInventory();
            sum13 = sum13 + smInventory13;
        }

        HashMap<Object, Object> map13 = new HashMap<>();
        map13.put("name", date13 + "销售额");
        map13.put("value", sum13);
        ls.add(map13);

        /**********
         *2019-9-14*
         **********/
        SalesmessageExample salesmessageExample14 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria14 = salesmessageExample14.getOredCriteria();
        SalesmessageExample.Criteria or14 = salesmessageExample14.or();
        Date parse141 = null;
        Date parse142 = null;
        String date14 = "2019-9-14 ";
        try {
            parse141 = simpleDateFormat.parse(date14 + time0);

            parse142 = simpleDateFormat.parse(date14 + time1);


            or14.andSmDataBetween(parse141, parse142);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria14.add(or14);
        List<Salesmessage> status14 = chartService.SellectAllSalesmessage(salesmessageExample14);

        Integer smInventory14 = 0;
        Integer sum14 = 0;
        for (Salesmessage s : status14) {
            smInventory14 = s.getSmInventory();
            sum14 = sum14 + smInventory14;
        }

        HashMap<Object, Object> map14 = new HashMap<>();
        map14.put("name", date14 + "销售额");
        map14.put("value", sum14);
        ls.add(map14);

        /**********
         *2019-9-15*
         **********/
        SalesmessageExample salesmessageExample15 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria15 = salesmessageExample15.getOredCriteria();
        SalesmessageExample.Criteria or15 = salesmessageExample15.or();
        Date parse151 = null;
        Date parse152 = null;
        String date15 = "2019-9-15 ";
        try {
            parse151 = simpleDateFormat.parse(date15 + time0);

            parse152 = simpleDateFormat.parse(date15 + time1);


            or15.andSmDataBetween(parse151, parse152);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria15.add(or15);
        List<Salesmessage> status15 = chartService.SellectAllSalesmessage(salesmessageExample15);

        Integer smInventory15 = 0;
        Integer sum15 = 0;
        for (Salesmessage s : status15) {
            smInventory15 = s.getSmInventory();
            sum15 = sum15 + smInventory15;
        }

        HashMap<Object, Object> map15 = new HashMap<>();
        map15.put("name", date15 + "销售额");
        map15.put("value", sum15);
        ls.add(map15);

        /**********
         *2019-9-16*
         **********/
        SalesmessageExample salesmessageExample16 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria16 = salesmessageExample16.getOredCriteria();
        SalesmessageExample.Criteria or16 = salesmessageExample16.or();
        Date parse161 = null;
        Date parse162 = null;
        String date16 = "2019-9-16 ";
        try {
            parse161 = simpleDateFormat.parse(date16 + time0);

            parse162 = simpleDateFormat.parse(date16 + time1);


            or16.andSmDataBetween(parse161, parse162);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria16.add(or16);
        List<Salesmessage> status16 = chartService.SellectAllSalesmessage(salesmessageExample16);

        Integer smInventory16 = 0;
        Integer sum16 = 0;
        for (Salesmessage s : status16) {
            smInventory16 = s.getSmInventory();
            sum16 = sum16 + smInventory16;
        }

        HashMap<Object, Object> map16 = new HashMap<>();
        map16.put("name", date16 + "销售额");
        map16.put("value", sum16);
        ls.add(map16);

        /**********
         *2019-9-17*
         **********/
        SalesmessageExample salesmessageExample17 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria17 = salesmessageExample17.getOredCriteria();
        SalesmessageExample.Criteria or17 = salesmessageExample17.or();
        Date parse171 = null;
        Date parse172 = null;
        String date17 = "2019-9-17 ";
        try {
            parse171 = simpleDateFormat.parse(date17 + time0);

            parse172 = simpleDateFormat.parse(date17 + time1);


            or17.andSmDataBetween(parse171, parse172);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria17.add(or17);
        List<Salesmessage> status17 = chartService.SellectAllSalesmessage(salesmessageExample17);

        Integer smInventory17 = 0;
        Integer sum17 = 0;
        for (Salesmessage s : status17) {
            smInventory17 = s.getSmInventory();
            sum17 = sum17 + smInventory17;
        }

        HashMap<Object, Object> map17 = new HashMap<>();
        map17.put("name", date17 + "销售额");
        map17.put("value", sum17);
        ls.add(map17);

        /**********
         *2019-9-18*
         **********/
        SalesmessageExample salesmessageExample18 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria18 = salesmessageExample18.getOredCriteria();
        SalesmessageExample.Criteria or18 = salesmessageExample18.or();
        Date parse181 = null;
        Date parse182 = null;
        String date18 = "2019-9-18 ";
        try {
            parse181 = simpleDateFormat.parse(date18 + time0);

            parse182 = simpleDateFormat.parse(date18 + time1);


            or18.andSmDataBetween(parse181, parse182);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria18.add(or18);
        List<Salesmessage> status18 = chartService.SellectAllSalesmessage(salesmessageExample18);

        Integer smInventory18 = 0;
        Integer sum18 = 0;
        for (Salesmessage s : status18) {
            smInventory18 = s.getSmInventory();
            sum18 = sum18 + smInventory18;
        }

        HashMap<Object, Object> map18 = new HashMap<>();
        map18.put("name", date18 + "销售额");
        map18.put("value", sum18);
        ls.add(map18);

/**********
 *2019-9-19*
 **********/
        SalesmessageExample salesmessageExample19 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria19 = salesmessageExample19.getOredCriteria();
        SalesmessageExample.Criteria or19 = salesmessageExample19.or();
        Date parse191 = null;
        Date parse192 = null;
        String date19 = "2019-9-19 ";
        try {
            parse191 = simpleDateFormat.parse(date19 + time0);

            parse192 = simpleDateFormat.parse(date19 + time1);


            or19.andSmDataBetween(parse191, parse192);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria19.add(or19);
        List<Salesmessage> status19 = chartService.SellectAllSalesmessage(salesmessageExample19);

        Integer smInventory19 = 0;
        Integer sum19 = 0;
        for (Salesmessage s : status19) {
            smInventory19 = s.getSmInventory();
            sum19 = sum19 + smInventory19;
        }

        HashMap<Object, Object> map19 = new HashMap<>();
        map19.put("name", date19 + "销售额");
        map19.put("value", sum19);
        ls.add(map19);

        /**********
         *2020-9-20*
         **********/
        SalesmessageExample salesmessageExample20 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria20 = salesmessageExample20.getOredCriteria();
        SalesmessageExample.Criteria or20 = salesmessageExample20.or();
        Date parse201 = null;
        Date parse202 = null;
        String date20 = "2019-9-20 ";
        try {
            parse201 = simpleDateFormat.parse(date20 + time0);

            parse202 = simpleDateFormat.parse(date20 + time1);


            or20.andSmDataBetween(parse201, parse202);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria20.add(or20);
        List<Salesmessage> status20 = chartService.SellectAllSalesmessage(salesmessageExample20);

        Integer smInventory20 = 0;
        Integer sum20 = 0;
        for (Salesmessage s : status20) {
            smInventory20 = s.getSmInventory();
            sum20 = sum20 + smInventory20;
        }

        HashMap<Object, Object> map20 = new HashMap<>();
        map20.put("name", date20 + "销售额");
        map20.put("value", sum20);
        ls.add(map20);

        /**********
         *2121-9-21*
         **********/
        SalesmessageExample salesmessageExample21 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria21 = salesmessageExample21.getOredCriteria();
        SalesmessageExample.Criteria or21 = salesmessageExample21.or();
        Date parse211 = null;
        Date parse212 = null;
        String date21 = "2019-9-21 ";
        try {
            parse211 = simpleDateFormat.parse(date21 + time0);

            parse212 = simpleDateFormat.parse(date21 + time1);


            or21.andSmDataBetween(parse211, parse212);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria21.add(or21);
        List<Salesmessage> status21 = chartService.SellectAllSalesmessage(salesmessageExample21);

        Integer smInventory21 = 0;
        Integer sum21 = 0;
        for (Salesmessage s : status21) {
            smInventory21 = s.getSmInventory();
            sum21 = sum21 + smInventory21;
        }

        HashMap<Object, Object> map21 = new HashMap<>();
        map21.put("name", date21 + "销售额");
        map21.put("value", sum21);
        ls.add(map21);

        /**********
         *2222-9-22*
         **********/
        SalesmessageExample salesmessageExample22 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria22 = salesmessageExample22.getOredCriteria();
        SalesmessageExample.Criteria or22 = salesmessageExample22.or();
        Date parse221 = null;
        Date parse222 = null;
        String date22 = "2019-9-22 ";
        try {
            parse221 = simpleDateFormat.parse(date22 + time0);

            parse222 = simpleDateFormat.parse(date22 + time1);


            or22.andSmDataBetween(parse221, parse222);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria22.add(or22);
        List<Salesmessage> status22 = chartService.SellectAllSalesmessage(salesmessageExample22);

        Integer smInventory22 = 0;
        Integer sum22 = 0;
        for (Salesmessage s : status22) {
            smInventory22 = s.getSmInventory();
            sum22 = sum22 + smInventory22;
        }

        HashMap<Object, Object> map22 = new HashMap<>();
        map22.put("name", date22 + "销售额");
        map22.put("value", sum22);
        ls.add(map22);

        /**********
         *2323-9-23*
         **********/
        SalesmessageExample salesmessageExample23 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria23 = salesmessageExample23.getOredCriteria();
        SalesmessageExample.Criteria or23 = salesmessageExample23.or();
        Date parse231 = null;
        Date parse232 = null;
        String date23 = "2019-9-23 ";
        try {
            parse231 = simpleDateFormat.parse(date23 + time0);

            parse232 = simpleDateFormat.parse(date23 + time1);


            or23.andSmDataBetween(parse231, parse232);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria23.add(or23);
        List<Salesmessage> status23 = chartService.SellectAllSalesmessage(salesmessageExample23);

        Integer smInventory23 = 0;
        Integer sum23 = 0;
        for (Salesmessage s : status23) {
            smInventory23 = s.getSmInventory();
            sum23 = sum23 + smInventory23;
        }

        HashMap<Object, Object> map23 = new HashMap<>();
        map23.put("name", date23 + "销售额");
        map23.put("value", sum23);
        ls.add(map23);

        /**********
         *2424-9-24*
         **********/
        SalesmessageExample salesmessageExample24 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria24 = salesmessageExample24.getOredCriteria();
        SalesmessageExample.Criteria or24 = salesmessageExample24.or();
        Date parse241 = null;
        Date parse242 = null;
        String date24 = "2019-9-24 ";
        try {
            parse241 = simpleDateFormat.parse(date24 + time0);

            parse242 = simpleDateFormat.parse(date24 + time1);


            or24.andSmDataBetween(parse241, parse242);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria24.add(or24);
        List<Salesmessage> status24 = chartService.SellectAllSalesmessage(salesmessageExample24);

        Integer smInventory24 = 0;
        Integer sum24 = 0;
        for (Salesmessage s : status24) {
            smInventory24 = s.getSmInventory();
            sum24 = sum24 + smInventory24;
        }

        HashMap<Object, Object> map24 = new HashMap<>();
        map24.put("name", date24 + "销售额");
        map24.put("value", sum24);
        ls.add(map24);

        /**********
         *2525-9-25*
         **********/
        SalesmessageExample salesmessageExample25 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria25 = salesmessageExample25.getOredCriteria();
        SalesmessageExample.Criteria or25 = salesmessageExample25.or();
        Date parse251 = null;
        Date parse252 = null;
        String date25 = "2019-9-25 ";
        try {
            parse251 = simpleDateFormat.parse(date25 + time0);

            parse252 = simpleDateFormat.parse(date25 + time1);


            or25.andSmDataBetween(parse251, parse252);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria25.add(or25);
        List<Salesmessage> status25 = chartService.SellectAllSalesmessage(salesmessageExample25);

        Integer smInventory25 = 0;
        Integer sum25 = 0;
        for (Salesmessage s : status25) {
            smInventory25 = s.getSmInventory();
            sum25 = sum25 + smInventory25;
        }

        HashMap<Object, Object> map25 = new HashMap<>();
        map25.put("name", date25 + "销售额");
        map25.put("value", sum25);
        ls.add(map25);

        /**********
         *2626-9-26*
         **********/
        SalesmessageExample salesmessageExample26 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria26 = salesmessageExample26.getOredCriteria();
        SalesmessageExample.Criteria or26 = salesmessageExample26.or();
        Date parse261 = null;
        Date parse262 = null;
        String date26 = "2019-9-26 ";
        try {
            parse261 = simpleDateFormat.parse(date26 + time0);

            parse262 = simpleDateFormat.parse(date26 + time1);


            or26.andSmDataBetween(parse261, parse262);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria26.add(or26);
        List<Salesmessage> status26 = chartService.SellectAllSalesmessage(salesmessageExample26);

        Integer smInventory26 = 0;
        Integer sum26 = 0;
        for (Salesmessage s : status26) {
            smInventory26 = s.getSmInventory();
            sum26 = sum26 + smInventory26;
        }

        HashMap<Object, Object> map26 = new HashMap<>();
        map26.put("name", date26 + "销售额");
        map26.put("value", sum26);
        ls.add(map26);

        /**********
         *2727-9-27*
         **********/
        SalesmessageExample salesmessageExample27 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria27 = salesmessageExample27.getOredCriteria();
        SalesmessageExample.Criteria or27 = salesmessageExample27.or();
        Date parse271 = null;
        Date parse272 = null;
        String date27 = "2019-9-27 ";
        try {
            parse271 = simpleDateFormat.parse(date27 + time0);

            parse272 = simpleDateFormat.parse(date27 + time1);


            or27.andSmDataBetween(parse271, parse272);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria27.add(or27);
        List<Salesmessage> status27 = chartService.SellectAllSalesmessage(salesmessageExample27);

        Integer smInventory27 = 0;
        Integer sum27 = 0;
        for (Salesmessage s : status27) {
            smInventory27 = s.getSmInventory();
            sum27 = sum27 + smInventory27;
        }

        HashMap<Object, Object> map27 = new HashMap<>();
        map27.put("name", date27 + "销售额");
        map27.put("value", sum27);
        ls.add(map27);

        /**********
         *2828-9-28*
         **********/
        SalesmessageExample salesmessageExample28 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria28 = salesmessageExample28.getOredCriteria();
        SalesmessageExample.Criteria or28 = salesmessageExample28.or();
        Date parse281 = null;
        Date parse282 = null;
        String date28 = "2019-9-28 ";
        try {
            parse281 = simpleDateFormat.parse(date28 + time0);

            parse282 = simpleDateFormat.parse(date28 + time1);


            or28.andSmDataBetween(parse281, parse282);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria28.add(or28);
        List<Salesmessage> status28 = chartService.SellectAllSalesmessage(salesmessageExample28);

        Integer smInventory28 = 0;
        Integer sum28 = 0;
        for (Salesmessage s : status28) {
            smInventory28 = s.getSmInventory();
            sum28 = sum28 + smInventory28;
        }

        HashMap<Object, Object> map28 = new HashMap<>();
        map28.put("name", date28 + "销售额");
        map28.put("value", sum28);
        ls.add(map28);

/**********
 *2929-9-29*
 **********/
        SalesmessageExample salesmessageExample29 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria29 = salesmessageExample29.getOredCriteria();
        SalesmessageExample.Criteria or29 = salesmessageExample29.or();
        Date parse291 = null;
        Date parse292 = null;
        String date29 = "2019-9-29 ";
        try {
            parse291 = simpleDateFormat.parse(date29 + time0);

            parse292 = simpleDateFormat.parse(date29 + time1);


            or29.andSmDataBetween(parse291, parse292);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria29.add(or29);
        List<Salesmessage> status29 = chartService.SellectAllSalesmessage(salesmessageExample29);

        Integer smInventory29 = 0;
        Integer sum29 = 0;
        for (Salesmessage s : status29) {
            smInventory29 = s.getSmInventory();
            sum29 = sum29 + smInventory29;
        }

        HashMap<Object, Object> map29 = new HashMap<>();
        map29.put("name", date29 + "销售额");
        map29.put("value", sum29);
        ls.add(map29);

        /**********
         *3030-9-30*
         **********/
        SalesmessageExample salesmessageExample30 = new SalesmessageExample();
        List<SalesmessageExample.Criteria> oredCriteria30 = salesmessageExample30.getOredCriteria();
        SalesmessageExample.Criteria or30 = salesmessageExample30.or();
        Date parse301 = null;
        Date parse302 = null;
        String date30 = "2019-9-30 ";
        try {
            parse301 = simpleDateFormat.parse(date30 + time0);

            parse302 = simpleDateFormat.parse(date30 + time1);


            or30.andSmDataBetween(parse301, parse302);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        oredCriteria30.add(or30);
        List<Salesmessage> status30 = chartService.SellectAllSalesmessage(salesmessageExample30);

        Integer smInventory30 = 0;
        Integer sum30 = 0;
        for (Salesmessage s : status30) {
            smInventory30 = s.getSmInventory();
            sum30 = sum30 + smInventory30;
        }

        HashMap<Object, Object> map30 = new HashMap<>();
        map30.put("name", date30 + "销售额");
        map30.put("value", sum30);
        ls.add(map30);

        System.out.println("所有销售量json数据：" + ls);
        return ls;
    }

    //    //*************************【日】销售表****************************************************************
//    @RequestMapping("/DayChart")
//    public String DayChart() {
//        return "DayChart";
//    }
//
//    @RequestMapping(value = "daybar", method = RequestMethod.GET)
//    public String GetDay() {
//        return "DayChart";
//    }
//
//    @RequestMapping(value = "daybar", method = RequestMethod.POST)
//    @ResponseBody
//    public List<Map<Object, Object>> GetDayMessage() {
//
//        SalesmessageExample salesmessageExampleAm = new SalesmessageExample();
//        List<SalesmessageExample.Criteria> oredCriteriaAM = salesmessageExampleAm.getOredCriteria();
//        SalesmessageExample.Criteria orAm = salesmessageExampleAm.or();
//
//        String dateAm = "2019-9-1 ";
//        String timeAm0 = "00:00:00";
//        String timeAm1 = "10:00:00";
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date parseAm0 = null;
//        Date parseAm1 = null;
//        try {
//            parseAm0 = simpleDateFormat.parse(dateAm + timeAm0);
//            parseAm1 = simpleDateFormat.parse(dateAm + timeAm1);
//            orAm.andSmDataBetween(parseAm0,parseAm1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        oredCriteriaAM.add(orAm);
//
//        List<Salesmessage> statuasAm = chartService.SellectAllSalesmessage(salesmessageExampleAm);
//        System.out.println("======================="+statuasAm);
//        Integer smInventory = 0;
//        for (Salesmessage sam: statuasAm) {
//           smInventory = sam.getSmInventory();
//        }
//
//        List<Map<Object, Object>> dayls = new ArrayList<>();
//        HashMap<Object, Object> mapAm = new HashMap<>();
//
//       mapAm.put("上午",timeAm1);
//       mapAm.put("销售量",smInventory);
//
//       dayls.add(mapAm);
//        return dayls;
//
//    }



}
