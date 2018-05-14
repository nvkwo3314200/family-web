package com.peak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peak.bean.AlipayBill;
import com.peak.dao.AlipayBillMapper;
import com.peak.service.AlipayBillService;

@Service
public class AlipayBillServiceImpl implements AlipayBillService{
	
	@Autowired
	AlipayBillMapper alipayBillMapper;
	
	public boolean insert(AlipayBill alipayBill) {
		return alipayBillMapper.insert(alipayBill) == 1;
	}
	
}
