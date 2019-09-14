package com.ssm.dao.mapper;

import com.ssm.entity.Salesmessage;
import com.ssm.entity.SalesmessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesmessageMapper {
    long countByExample(SalesmessageExample example);

    int deleteByExample(SalesmessageExample example);

    int deleteByPrimaryKey(Integer smId);

    int insert(Salesmessage record);

    int insertSelective(Salesmessage record);

    List<Salesmessage> selectByExample(SalesmessageExample example);

    Salesmessage selectByPrimaryKey(Integer smId);

    int updateByExampleSelective(@Param("record") Salesmessage record, @Param("example") SalesmessageExample example);

    int updateByExample(@Param("record") Salesmessage record, @Param("example") SalesmessageExample example);

    int updateByPrimaryKeySelective(Salesmessage record);

    int updateByPrimaryKey(Salesmessage record);
}