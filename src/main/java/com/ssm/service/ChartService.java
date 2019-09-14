package com.ssm.service;

import com.ssm.entity.Salesmessage;
import com.ssm.entity.SalesmessageExample;

import java.util.List;


public interface ChartService {

    List<Salesmessage> SellectAllSalesmessage(SalesmessageExample salesmessageExample);

    List<Salesmessage> SelectDayInventory(String time0, String time1);

    List<String> SelectSaleTime();

}
