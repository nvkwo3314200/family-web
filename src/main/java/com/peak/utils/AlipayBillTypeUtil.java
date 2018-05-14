package com.peak.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.peak.bean.AlipayBill;
import com.peak.bean.TypeParam;

public class AlipayBillTypeUtil {
	private static final String USE_TYPE = "use_type";
	private static final String HUMAN_TYPE = "human_type";
	private static final String OBJ_TYPE = "obj_type";
	
	public static void setType(List<TypeParam> typeList, AlipayBill alipayBill) {
		alipayBill.setUseType(getType(USE_TYPE, typeList, alipayBill));
		alipayBill.setHumanType(getType(HUMAN_TYPE, typeList, alipayBill));
		alipayBill.setObjType(getType(OBJ_TYPE, typeList, alipayBill));
	}

	
	
	private static String getType(String checkType, List<TypeParam> typeList, AlipayBill alipayBill) {
		if(StringUtils.isEmpty(alipayBill.getProductName())) return "";
		
		StringBuffer sb = new StringBuffer();
		for(TypeParam type : typeList) {
			if(checkType.equals(type.getType())) {
				String keyWord = type.getKeyWord();
				if(StringUtils.isNotEmpty(keyWord)) {
					for(String key : keyWord.split(";")) {
						if(StringUtils.isNotEmpty(key)) {
							if(alipayBill.getProductName().indexOf(key) > -1) {
								sb.append(type.getOption());
								break ;
							}
						}
					}
				}
			}
		}
		return sb.toString();

	}

}
