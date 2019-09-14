package com.ssm.service.impl;

import com.ssm.dao.mapper.Salesmessage2Mapper;
import com.ssm.dao.mapper.SalesmessageMapper;
import com.ssm.entity.Salesmessage;
import com.ssm.entity.SalesmessageExample;
import com.ssm.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {



    @Autowired
    SalesmessageMapper salesmessageMapper;
    @Autowired
    Salesmessage2Mapper salesmessage2Mapper;

    @Override
    public List<Salesmessage> SellectAllSalesmessage(SalesmessageExample salesmessageExample) {
        return salesmessageMapper.selectByExample(salesmessageExample);
    }

    @Override
    public List<Salesmessage> SelectDayInventory(String time0, String time1) {
        return salesmessage2Mapper.SelectDayInventory(time0,time1);
    }

    @Override
    public List<String> SelectSaleTime() {
        return salesmessage2Mapper.SelectSaleTime();
    }


//    @Override
//    public int SelectDayInventory(String time0, String time1) {
//        return salesmessage2Mapper.SelectDayInventory();/*time0,time1*/
//    }


}
