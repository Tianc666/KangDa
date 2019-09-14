package com.ssm.service.impl;

import com.ssm.dao.mapper.MedicineMapper;
import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;
import com.ssm.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public List<Medicine> selectAll(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }

    @Override
    public int updaterk(Medicine record,MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public List<Medicine> selectMedicine(MedicineExample example) {
        return medicineMapper.selectByExample(example);
    }
    @Override
    public int updateMedicine(Medicine record, MedicineExample example) {
        return medicineMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int deleteMedicine(MedicineExample example) {
        return medicineMapper.deleteByExample(example);
    }

}
