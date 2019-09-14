package com.ssm.dao.mapper;

import com.ssm.entity.Medicine;
import com.ssm.entity.MedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicineMapper {
    long countByExample(MedicineExample example);

    int deleteByExample(MedicineExample example);

    int deleteByPrimaryKey(Integer mId);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    List<Medicine> selectByExample(MedicineExample example);

    Medicine selectByPrimaryKey(Integer mId);

    int updateByExampleSelective(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByExample(@Param("record") Medicine record, @Param("example") MedicineExample example);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);
}