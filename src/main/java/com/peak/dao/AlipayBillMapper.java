package com.peak.dao;

import com.peak.bean.AlipayBill;
import com.peak.bean.AlipayBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayBillMapper {
    long countByExample(AlipayBillExample example);

    int deleteByExample(AlipayBillExample example);

    int insert(AlipayBill record);

    int insertSelective(AlipayBill record);

    List<AlipayBill> selectByExample(AlipayBillExample example);

    int updateByExampleSelective(@Param("record") AlipayBill record, @Param("example") AlipayBillExample example);

    int updateByExample(@Param("record") AlipayBill record, @Param("example") AlipayBillExample example);
}