package com.ssm.dao.mapper;

import com.ssm.entity.Salesmessage;
import org.apache.ibatis.annotations.Param;


import java.sql.Date;
import java.util.List;

public interface Salesmessage2Mapper {

    List<Salesmessage> SelectAllSalesmessage();
    List<Salesmessage> SelectDayInventory(@Param("time0") String time0,@Param("time1") String time1);
    List<Salesmessage> SelectUname();
    List<Salesmessage> SelectByUname(@Param("uname") String uname);
    List<String> SelectSaleTime();
    int insertSalesmessage(@Param("smmid") String smname, @Param("smuid") String smuid, @Param("data") Date data, @Param("count") int count);

}
