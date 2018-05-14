package com.peak.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.peak.bean.AlipayBill;
import com.peak.dto.AlipayBillResult;

@Service
public class ProcessExcelServiceImpl extends BaseProcessExcelServiceImpl<AlipayBillResult>
{
	
	public AlipayBillResult processExcel(HSSFWorkbook workbook) {
		AlipayBillResult result = new AlipayBillResult();
		Map<String, List<String[]>> resultMap = readExcel(workbook);
		for(String key : resultMap.keySet()) {
			result.getSuccessData().addAll(convert(resultMap.get(key)));
		}
		return result;
	}
	
	private List<AlipayBill> convert(List<String[]> list)  {
		List<AlipayBill> rtn = new ArrayList<AlipayBill>();
		if(list == null) return rtn;
		for(String[] item : list) {
			rtn.add(new AlipayBill(item));
		}
		return rtn;
	}
	
	
	@Override
	public int getJumpHeader() {
		return 5;
	}
	
	@Override
	public int getIngoreEnd() {
		return 8;
	}
	
}
	