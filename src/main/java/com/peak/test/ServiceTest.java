package com.peak.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peak.dto.AlipayBillResult;
import com.peak.service.ProcessExcelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ServiceTest {
	
	@Autowired
	ProcessExcelService<AlipayBillResult> processExcelService;

	
	@Test
	public void process() throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream("F:\\alipay\\asdf.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(in);
	
		AlipayBillResult result =  processExcelService.processExcel(workbook);
		System.out.println(result);
	}
}
