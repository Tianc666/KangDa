package com.ssm.controller;

import com.ssm.entity.Excel;
import com.ssm.entity.ExcelBean;
import com.ssm.service.ExcelService;
import com.ssm.service.impl.ExcelServiceImpl;
import com.ssm.util.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ExcelController {
    @Autowired
    ExcelServiceImpl excelService;

    @RequestMapping("/Excel")
        public String excel(){
        return "excel";
        }

    @RequestMapping(value = "/getExcelData",method = RequestMethod.POST)
    public String getExcelData(MultipartFile file, HttpServletRequest request){


        try {
            List<List<Object>> lists = ExcelUtil.getUserListByExcel(file.getInputStream(), file.getOriginalFilename());
            List<Excel> excels = new ArrayList<>();
            for(int i = 0 ; i < lists.size() ; i++){
                Excel excel = new Excel();
                List<Object> ob = lists.get(i);/*注意！！！强制类型转换*/
                excel.setId(Integer.parseInt(ob.get(0).toString()));
                excel.setSalmedicinename(ob.get(1).toString());
                excel.setSalamount(ob.get(2).toString());
                excel.setSalprice(ob.get(3).toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = sdf.parse(ob.get(4).toString());
                excel.setSaldate(date);
                excel.setSalname(ob.get(5).toString());
                excels.add(excel);
            }
            excelService.InsertExcel(excels);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        List<Excel> excels = excelService.SelectAllMsg();
        session.setAttribute("excels",excels);

//        List<Excel> excels1 = excelService.InsertExcel(excels);
//        model.addAttribute("all",excels1);
        return "excel";
    }

    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ResponseBody
    public void exportUser(HttpServletRequest req, HttpServletResponse reps) throws IOException, Exception {
        reps.reset(); // 清除buffer缓存
        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
        reps.setHeader("Content-Disposition",
                "attachment;filename=" + new String("CrazyApeSalePage.xlsx".getBytes("GBK"), "UTF-8"));
        reps.setContentType("application/vnd.ms-excel;charset=UTF-8");
        reps.setHeader("Pragma", "no-cache");
        reps.setHeader("Cache-Control", "no-cache");
        reps.setDateHeader("Expires", 0);
//        UserExample example = new UserExample();
//        List<User> userList = userService.selectByExample(example);

        List<Excel> excelList = excelService.SelectAllMsg();
        // 导出Excel对象
        OutputStream output;
        List<ExcelBean> excel=new ArrayList<>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
        //设置标题栏
        excel.add(new ExcelBean("编号","id",0));
        excel.add(new ExcelBean("药品名称","salmedicinename",0));
        excel.add(new ExcelBean("销售件数","salamount",0));
        excel.add(new ExcelBean("药品价格","salprice",0));
        excel.add(new ExcelBean("销售日期","saldate",0));
        excel.add(new ExcelBean("用户名","salname",0));
        map.put(0, excel);
        String sheetName = "用户一览";
        //调用ExcelUtil的方法
        XSSFWorkbook workbook = ExcelUtil.createExcelFile(Excel.class, excelList, map, sheetName);
        try {
            output = reps.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
