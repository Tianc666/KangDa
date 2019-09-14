package com.ssm.controller;


import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;
import com.ssm.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class MedicineListController {

    @Autowired
    MedicineService medicineService;

    @RequestMapping("/medicineList")
    public String list(Model model){
        MedicineExample example = new MedicineExample();
        List<Medicine> list = medicineService.selectAll(example);
        int num = list.size();
        model.addAttribute("num",num);
        for(int i=0;i<list.size();i++){
            Date etime = list.get(i).getmPastdate();
            //当前时间
            Date date = new Date();
            int day = (int) ((date.getTime()-etime.getTime())/(1000*3600*24));
            //库存
            int inv = list.get(i).getmInventory();
            if(day>0&&inv<11){
                list.get(i).setmState("过期 库存过低");
            }else if(day>0&&inv>10){
                list.get(i).setmState("过期");
            }else if(day<0&&inv<11){
                list.get(i).setmState("库存过低");
            }else {
                list.get(i).setmState("正常");
            }
        }
        model.addAttribute("list",list);
        return  "medicineList";
    }
}
