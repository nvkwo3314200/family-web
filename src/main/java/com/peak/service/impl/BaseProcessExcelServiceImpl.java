package com.peak.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.peak.service.ProcessExcelService;
import com.peak.utils.ExportExcelUtil;

public abstract class BaseProcessExcelServiceImpl<E> implements ProcessExcelService<E> {
	
	public Map<String, List<String[]>> readExcel(HSSFWorkbook workbook) {
		Map<String, List<String[]>> rtn = new HashMap<String, List<String[]>>();
 		try {
			for(int i = 0; i < workbook.getNumberOfSheets(); i ++) {
				// step 1    解析sheet
				HSSFSheet sheet = workbook.getSheetAt(i);
				// step 2  处理 Data  
				List<String[]> data = resolveSheet(sheet);
				if(data != null && data.size() > 0) rtn.put(sheet.getSheetName(), data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(workbook != null) try {workbook.close();} catch (IOException e) {/*ingore*/}
		}
		return rtn;
	}

	protected List<String[]> resolveSheet(HSSFSheet sheet) {
		int first = sheet.getFirstRowNum();
		int last = sheet.getLastRowNum();
		List<String[]> rtn = new ArrayList<String[]>();
		for(int i = first; i<last + 1; i++) {
			if(i < getJumpHeader() || (i > (last + 1 - getIngoreEnd()))) continue ;
			HSSFRow row = sheet.getRow(i);  
            if(row == null){  
                continue;  
            }
            int firstCellNum = row.getFirstCellNum();  
            int lastCellNum = row.getPhysicalNumberOfCells();
            String[] cells = new String[row.getPhysicalNumberOfCells()];  
            for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){  
            	HSSFCell cell = row.getCell(cellNum);  
                cells[cellNum] = ExportExcelUtil.getCellValue(cell);  
            }
            rtn.add(cells);
		}
		return rtn;
	}

	public int getJumpHeader() {
		return 0;
	}
	
	public int getIngoreEnd() {
		return 0;
	}
}
