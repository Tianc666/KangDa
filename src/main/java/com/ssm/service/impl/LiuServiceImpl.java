package com.ssm.service.impl;

import com.ssm.dao.mapper.LiuMapper;
import com.ssm.entity.Medicine;
import com.ssm.service.LiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiuServiceImpl implements LiuService {
//    @Autowired
//    StockMapper stockMapper;

    @Autowired
    LiuMapper liuMapper;


    @Override
    public List<Medicine> SellecAllInventory() {

        return liuMapper.SelectInventory();
    }
}
