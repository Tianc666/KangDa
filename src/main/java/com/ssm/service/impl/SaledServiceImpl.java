package com.ssm.service.impl;

import com.ssm.dao.mapper.LiuMapper;
import com.ssm.dao.mapper.SaledMapper;
import com.ssm.entity.Medicine;
import com.ssm.service.LiuService;
import com.ssm.service.SaledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaledServiceImpl implements SaledService {
//    @Autowired
//    StockMapper stockMapper;

    @Autowired
    SaledMapper saledMapper;



    @Override
    public List<Medicine> SellecAllSaled() {
        return saledMapper.SelectSaled();
    }
}
