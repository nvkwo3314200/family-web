package com.peak.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface ProcessExcelService<E> {
	
	public E processExcel(HSSFWorkbook workbook);
	
	public Map<String, List<String[]>> readExcel(HSSFWorkbook workbook);

}
