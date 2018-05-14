package com.peak.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

public class DateUtil {
	private static final Logger _log = Logger.getLogger(DateUtil.class);  
	public static final String[] DATE_FMT = {"yyyy-MM-dd hh:mm:ss"};
	
	public static Date parseDate(String dateStr) {
		try {
			return DateUtils.parseDate(dateStr, DateUtil.DATE_FMT);
		} catch (ParseException e) {
			_log.error(e);
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		String dateStr = "2017/1/20 11:58:48";
		System.out.println( parseDate(dateStr));
	}
}
