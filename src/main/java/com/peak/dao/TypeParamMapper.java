package com.peak.dao;

import com.peak.bean.TypeParam;
import com.peak.bean.TypeParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeParamMapper {
    long countByExample(TypeParamExample example);

    int deleteByExample(TypeParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TypeParam record);

    int insertSelective(TypeParam record);

    List<TypeParam> selectByExample(TypeParamExample example);

    TypeParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TypeParam record, @Param("example") TypeParamExample example);

    int updateByExample(@Param("record") TypeParam record, @Param("example") TypeParamExample example);

    int updateByPrimaryKeySelective(TypeParam record);

    int updateByPrimaryKey(TypeParam record);
}