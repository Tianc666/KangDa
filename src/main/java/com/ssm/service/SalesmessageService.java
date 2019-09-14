package com.ssm.service;

import com.ssm.entity.Salesmessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesmessageService {

    List<Salesmessage> SellectAllSalesmessage();
    List<Salesmessage> SelectUname();
    List<Salesmessage> SelectByUname(String uname);
//    int insertSalesmessage(String smname, String smuid, Date data,int count);

}
