package com.ssm.controller;

import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;
import com.ssm.entity.Stock;
import com.ssm.entity.StockExample;
import com.ssm.service.impl.MedicineServiceImpl;
import com.ssm.service.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StockController {

    @Autowired
    StockServiceImpl stockService;
    @Autowired
    MedicineServiceImpl medicineService;

    @RequestMapping("/stock")
    public String stock(Model model){
        StockExample stockExample = new StockExample();
        List<Stock> list = stockService.selectAS(stockExample);
        model.addAttribute("list",list);
        model.addAttribute("num",list.size());
        return "stock";
    }

    //进货
    @RequestMapping("/insert")
    public String insert(HttpServletRequest request) throws ParseException {
        MedicineExample example = new MedicineExample();
        Medicine medicine = new Medicine();
        //先查 是否有该药品
        MedicineExample.Criteria criteria = example.createCriteria();
        criteria.andMMedicineidEqualTo(Integer.parseInt(request.getParameter("mMedicineid")));
        List<Medicine> medicineList= stockService.selectmid(example);
        if(medicineList.size() == 0){
            //没有就插入
            medicine.setmMedicineid(Integer.parseInt(request.getParameter("mMedicineid")));
            medicine.setmName(request.getParameter("mName"));
            medicine.setmPrice(new BigDecimal(request.getParameter("mPrice")));
            medicine.setmInventory(Integer.parseInt(request.getParameter("mInventory")));
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            medicine.setmPastdate(sdf.parse(request.getParameter("mPastdate")));
            medicine.setmClassify(request.getParameter("mClassify"));
            int b = stockService.insertM(medicine);
            //System.out.println("插入数据b="+b);
        }else {
            //有就增加库存
            criteria.andMMedicineidEqualTo(Integer.parseInt(request.getParameter("mMedicineid")));
            List<Medicine> aa = stockService.selectmid(example);
            int inv1 = aa.get(0).getmInventory();
            //System.out.println("原有库存="+inv1);
            medicine.setmInventory(inv1+Integer.parseInt(request.getParameter("mInventory")));
            criteria.andMMedicineidEqualTo(Integer.parseInt(request.getParameter("mMedicineid")));
            int c = stockService.upd(medicine,example);
            //System.out.println("修改数据="+c);
        }
        //向进货表插入进货记录
        Stock stock = new Stock();
        stock.setsMedicineid(Integer.parseInt(request.getParameter("mMedicineid")));
        stock.setsCount(Integer.parseInt(request.getParameter("mInventory")));
        stock.setsData(new Date());
        int a = stockService.insertS(stock);
        //System.out.println("进货表插入"+a);
        return "redirect:/stock";
    }

    //按日期查记录
    @RequestMapping("/selectStock")
    public String selectByData(HttpServletRequest request){
        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        String logmin = request.getParameter("logmin");
        String logmax = request.getParameter("logmax");
        //System.out.println("开始："+logmin+"   结束："+logmax);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date stardate = sdf.parse(logmin);
            Date enddate  = sdf.parse(logmax);
            criteria.andSDataBetween(stardate,enddate);
            List<Stock> list = stockService.selectByDate(stockExample);
            request.setAttribute("num",list.size());
            //System.out.println(list);
            request.setAttribute("list",list);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "stock";
    }

    //删除记录
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request,int sid){
        stockService.delete(sid);
        return "redirect:/stock";
    }
}
