package com.ssm.service.impl;


import com.ssm.dao.mapper.MedicineMapper;
import com.ssm.dao.mapper.StockMapper;
import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;
import com.ssm.entity.Stock;
import com.ssm.entity.StockExample;
import com.ssm.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;
    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Stock> selectAS(StockExample example) {
        return stockMapper.selectByExample(example);
    }


    //进货
    @Override
    public int insertM(Medicine medicine) {
        return medicineMapper.insert(medicine);
    }
    @Override
    public List<Medicine> selectmid(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }

    @Override
    public int upd(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int insertS(Stock stock) {
        return stockMapper.insert(stock);
    }

    @Override
    public List<Stock> selectByDate(StockExample example) {
        return stockMapper.selectByExample(example);
    }

    @Override
    public int delete(int sid) {
        return stockMapper.deleteByPrimaryKey(sid);
    }


}
