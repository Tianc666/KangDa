package com.ssm.service;

import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;
import com.ssm.entity.Stock;
import com.ssm.entity.StockExample;

import java.util.List;

public interface StockService {

    List<Stock> selectAS(StockExample example);

    //进货
    //先查有没有该编号
    List<Medicine> selectmid(MedicineExample example);
    //没有该编号向药品表插入
    int insertM(Medicine medicine);
    //有该编号修改库存
    int upd(Medicine record, MedicineExample example);
    //插入进货表
    int insertS(Stock stock);
    //按日期搜记录
    List<Stock> selectByDate(StockExample example);

    //删除记录
    int delete(int sid);
}
