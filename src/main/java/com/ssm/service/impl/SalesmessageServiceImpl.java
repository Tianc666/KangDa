package com.ssm.service.impl;

import com.ssm.dao.mapper.Salesmessage2Mapper;
import com.ssm.entity.Salesmessage;
import com.ssm.service.SalesmessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service
public class SalesmessageServiceImpl implements SalesmessageService {
    @Autowired
    Salesmessage2Mapper salesmessageMapper2;


    @Override
    public List<Salesmessage> SellectAllSalesmessage() {
        return salesmessageMapper2.SelectAllSalesmessage();
    }

    @Override
    public List<Salesmessage> SelectUname() {
        return salesmessageMapper2.SelectUname();
    }

    @Override
    public List<Salesmessage> SelectByUname(String uname) {
        return salesmessageMapper2.SelectByUname(uname);
    }

//    @Override
//    public int insertSalesmessage(String smname, String smuid , Date data , int count) {
//        return salesmessageMapper2.insertSalesmessage(smname,smuid,data,count);
//    }
}
