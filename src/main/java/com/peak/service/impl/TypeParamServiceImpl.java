package com.peak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peak.bean.TypeParam;
import com.peak.dao.TypeParamMapper;
import com.peak.service.TypeParamService;

@Service
public class TypeParamServiceImpl implements TypeParamService {
	
	@Autowired
	TypeParamMapper typeParamMapper;
	
	@Override
	public List<TypeParam> findAll() {
		return typeParamMapper.selectByExample(null);
	}

}
