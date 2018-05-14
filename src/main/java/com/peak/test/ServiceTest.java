package com.peak.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peak.bean.AlipayBill;
import com.peak.bean.TypeParam;
import com.peak.dto.AlipayBillResult;
import com.peak.service.ProcessExcelService;
import com.peak.service.TypeParamService;
import com.peak.utils.AlipayBillTypeUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ServiceTest {
	
	@Autowired
	ProcessExcelService<AlipayBillResult> processExcelService;
	
	@Autowired
	TypeParamService typeParamService; 

	@Test
	public void process() throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream("F:\\alipay\\asdf.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(in);
	
		AlipayBillResult result =  processExcelService.processExcel(workbook);
		List<TypeParam> typeList = typeParamService.findAll();
		for(AlipayBill bill : result.getSuccessData()) {
			AlipayBillTypeUtil.setType(typeList, bill);
		}
		System.out.println(result);
	}
}
