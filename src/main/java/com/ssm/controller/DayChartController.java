package com.ssm.controller;

import com.ssm.entity.Salesmessage;
import com.ssm.service.impl.ChartServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class DayChartController {
    @Autowired
    ChartServiceImpl chartService;
    //*************************【日】销售表****************************************************************
    @RequestMapping("/DayChart")
    public String DayChart(HttpServletRequest request) {
        HttpSession session = request.getSession();

        List<String> SaleTime = chartService.SelectSaleTime();

        session.setAttribute("SaleTime",SaleTime);


//        String changetime = request.getParameter("changetime");

        return "DayChart";
    }

    @RequestMapping(value = "dbar", method = RequestMethod.GET)
    public String GetDay() {



        return "DayChart";
    }

    @PostMapping("/dbar")
    @ResponseBody
    public List<Map<Object, Object>> GetDayMessage(HttpServletRequest request,@Param("changetime") String changetime) {

        System.out.println(changetime);
        if(changetime==null||changetime.equals(" ") || changetime.equals("all")){
            String dateAm = "2019-9-1 ";
            String timeAm0 = "00:00:00";
            String timeAm1 = "12:00:00";

            List<Salesmessage> salesmessagesAm = chartService.SelectDayInventory(dateAm+timeAm0, dateAm+timeAm1);

            Integer InventoryAm = 0;
            Integer sumAm = 0;
            for (Salesmessage sam:salesmessagesAm) {
                InventoryAm = sam.getSmInventory();
                sumAm=sumAm+InventoryAm;
            }

            List<Map<Object, Object>> dayls = new ArrayList<>();
            HashMap<Object, Object> mapAm = new HashMap<>();

            mapAm.put("name","上午销售额");
            mapAm.put("value",sumAm);
            dayls.add(mapAm);
//        中午销售额

            String dateMid = "2019-9-1 ";
            String timeMid0 = "12:00:01";
            String timeMid1 = "17:00:00";


            List<Salesmessage> salesmessagesMid = chartService.SelectDayInventory(dateMid+timeMid0, dateMid+timeMid1);

            Integer InventoryMid = 0;
            Integer sumMid = 0;
            for (Salesmessage smid:salesmessagesMid) {
                InventoryMid = smid.getSmInventory();
                sumMid=sumMid+InventoryMid;
            }

            HashMap<Object, Object> mapMid = new HashMap<>();

            mapMid.put("name","中午销售额");
            mapMid.put("value",sumMid);

            dayls.add(mapMid);

//        下午销售额
            String datePM = "2019-9-1 ";
            String timePM0 = "17:00:01";
            String timePM1 = "23:59:59";


            List<Salesmessage> salesmessagesPM = chartService.SelectDayInventory(datePM+timePM0, datePM+timePM1);

            Integer InventoryPM = 0;
            Integer sumPM = 0;
            for (Salesmessage spm:salesmessagesPM) {
                InventoryPM = spm.getSmInventory();
                sumPM=sumPM+InventoryPM;
            }

            HashMap<Object, Object> mapPM = new HashMap<>();

            mapPM.put("name","下午销售额");
            mapPM.put("value",sumPM);

            dayls.add(mapPM);

            System.out.println("++++++++++++++++"+dayls);

            return dayls;
        }

//        System.out.println("*********************"+changetime);

//,String changetime
//        HttpSession session = request.getSession();
//
//        List<String> SaleTime = chartService.SelectSaleTime();
//
//        session.setAttribute("SaleTime",SaleTime);
//        System.out.println("++++++haha++++++++"+changetime);
else {
        String dateAm = changetime+" ";
        String timeAm0 = "00:00:00";
        String timeAm1 = "12:00:00";

        List<Salesmessage> salesmessagesAm = chartService.SelectDayInventory(dateAm+timeAm0, dateAm+timeAm1);

        Integer InventoryAm = 0;
        Integer sumAm = 0;
        for (Salesmessage sam:salesmessagesAm) {
            InventoryAm = sam.getSmInventory();
            sumAm=sumAm+InventoryAm;
        }

        List<Map<Object, Object>> dayls = new ArrayList<>();
        HashMap<Object, Object> mapAm = new HashMap<>();

        mapAm.put("name","上午销售额");
        mapAm.put("value",sumAm);
        dayls.add(mapAm);
//        中午销售额

        String dateMid = changetime+" ";
        String timeMid0 = "12:00:01";
        String timeMid1 = "17:00:00";


        List<Salesmessage> salesmessagesMid = chartService.SelectDayInventory(dateMid+timeMid0, dateMid+timeMid1);

        Integer InventoryMid = 0;
        Integer sumMid = 0;
        for (Salesmessage smid:salesmessagesMid) {
            InventoryMid = smid.getSmInventory();
            sumMid=sumMid+InventoryMid;
        }

        HashMap<Object, Object> mapMid = new HashMap<>();

        mapMid.put("name","中午销售额");
        mapMid.put("value",sumMid);

        dayls.add(mapMid);

//        下午销售额
        String datePM = changetime+" ";
        String timePM0 = "17:00:01";
        String timePM1 = "23:59:59";


        List<Salesmessage> salesmessagesPM = chartService.SelectDayInventory(datePM+timePM0, datePM+timePM1);

        Integer InventoryPM = 0;
        Integer sumPM = 0;
        for (Salesmessage spm:salesmessagesPM) {
            InventoryPM = spm.getSmInventory();
            sumPM=sumPM+InventoryPM;
        }

        HashMap<Object, Object> mapPM = new HashMap<>();

        mapPM.put("name","下午销售额");
        mapPM.put("value",sumPM);

        dayls.add(mapPM);

        System.out.println("++++++++++++++++"+dayls);

        return dayls;
        }
    }

}
