package com.ssm.service.impl;

import com.ssm.dao.mapper.ExcelMapper;
import com.ssm.entity.Excel;
import com.ssm.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    ExcelMapper excelMapper;

    @Override
    public int InsertExcel(List<Excel> excels) {
        int n=0;
        for (Excel excel:excels) {
//            int id = excel.getId();
//            String salmedicinename = excel.getSalmedicinename();
//            String salamount = excel.getSalamount();
//            String salprice = excel.getSalprice();
//            Date saldate = excel.getSaldate();
//            String salname = excel.getSalname();

//            excelMapper.InsertExcel(id,salmedicinename,salamount,salprice,saldate,salname);
            n = excelMapper.InsertExcel(excel);
        }

        return n;
    }

    @Override
    public List<Excel> SelectAllMsg() {
        return excelMapper.SelectAllMsg();
    }
}
