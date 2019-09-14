package com.ssm.dao.mapper;

import com.ssm.entity.Excel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExcelMapper {
//    List<Excel> InsertExcel(@Param("id") int id, @Param("salmedicinename") String salmedicinename, @Param("salamount") String salamount, @Param("salprice") String salprice, @Param("saldate") Date saldate, @Param("salname") String salname);
      int InsertExcel(Excel excel);
      List<Excel> SelectAllMsg();
}
