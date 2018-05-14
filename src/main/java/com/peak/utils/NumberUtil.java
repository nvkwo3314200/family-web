package com.peak.utils;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class NumberUtil {
	private static final Logger _log = Logger.getLogger(NumberUtil.class);
	
	public static Float parseFloat(String str) {
		if(StringUtils.isEmpty(str)) return null;
		try {
			return Float.valueOf(str);
		}catch (Exception e) {
			_log.error(e);
		}
		return null;
	}
}
