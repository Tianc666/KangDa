package com.ssm.service;

import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;

import java.util.List;

public interface MedicineService {
    List<Medicine> selectAll(MedicineExample example);
    //修改记录
    int updaterk(Medicine record,MedicineExample example);

    //编辑 先查找 再修改
    List<Medicine> selectMedicine(MedicineExample example);
    int updateMedicine(Medicine record,MedicineExample example);

    //删除药品
    int deleteMedicine(MedicineExample example);

}
