package com.dhcc.admin.sys.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;


public class FileUtils {
	
	private static String rootPath;//项目根目录
	
	static {
		rootPath = FileUtil.getUserHomePath();
	}

	/**
	 * 获取文件临时目录
	 * @return
	 */
	public static String getTmpPath() {
		return rootPath + "/tmp/";
	}
	
	/**
	 * 根据文件名获取临时文件
	 * @param fileName
	 * @return
	 */
	public static File getFileByName(String fileName) {
		File tmpFile = new File(getTmpPath() + fileName);
		if(tmpFile.exists()) {
			return tmpFile;
		}
		return null;
	}

}
