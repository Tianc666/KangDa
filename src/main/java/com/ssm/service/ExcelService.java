package com.ssm.service;

import com.ssm.entity.Excel;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ExcelService {
//    int InsertExcel(int id,String salmedicinename,String salamount,String salprice,Date saldate,String salname);
      int InsertExcel(List<Excel> excels);
      List<Excel> SelectAllMsg();
}
