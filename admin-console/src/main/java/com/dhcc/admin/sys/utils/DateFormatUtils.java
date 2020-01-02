package com.dhcc.admin.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DateFormatUtils.class);
	
	private static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";
	private static final String PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 转换为字符串，格式为yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDDStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDD);
		return sdf.format(date);
	}
	
	/**
	 * 转换为字符串，格式为yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDDHHMMSStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
		return sdf.format(date);
	}
	
	/**
	 * 转换为date，格式为yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date getYYYYMMDDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDD);
		try {
			return sdf.parse(date);
		}catch(Exception ex) {
			logger.error("转换为date，格式为yyyy-MM-dd出错：",ex);
		}
		return null;
	}
	
	/**
	 * 转换为date，格式为yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Date getYYYYMMDDHHMMSSDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
		try {
			return sdf.parse(date);
		}catch(Exception ex) {
			logger.error("转换为date，格式为yyyy-MM-dd HH:mm:ss出错：",ex);
		}
		return null;
	}

}
