//package com.dhcc.admin.sys.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//@Configuration
//public class FastDfsConfig {
//	private static String fileServerAddr;//文件服务器地址
//	private static Integer maxStorageConnection; //最大连接数 并发量较大的话可加大该连接数
//	private static String httpSecretKey;//密钥
//	private static String trackerServers;//跟踪器服务地址
//	private static String httpTrackerHttpPort;//跟踪器服务http端口
//	private static String httpAntiStealToken;//token 防盗链功能
//	private static String connectTimeoutInSeconds;//连结超时时间
//	private static String networkTimeoutInSeconds;//网络超时时间
//	private static String charset;//字符
//	@Value("${fastdfs.file-server-addr}")
//	public  void setFileServerAddr(String  fileServerAddr) {
//		FastDfsConfig.fileServerAddr=fileServerAddr;
//	}
//	@Value("${fastdfs.max-storage-connection}")
//	public  void setMaxStorageConnection(Integer  maxStorageConnection) {
//		FastDfsConfig.maxStorageConnection=maxStorageConnection;
//	}
//	@Value("${fastdfs.http-secret-key}")
//	public  void setHttpSecretKey(String  httpSecretKey) {
//		FastDfsConfig.httpSecretKey=httpSecretKey;
//	}
//	@Value("${fastdfs.tracker-servers}")
//	public void setTrackerServers(String trackerServers) {
//		FastDfsConfig.trackerServers = trackerServers;
//	}
//	@Value("${fastdfs.http-tracker-http-port}")
//	public void setHttpTrackerHttpPort(String httpTrackerHttpPort) {
//		FastDfsConfig.httpTrackerHttpPort = httpTrackerHttpPort;
//	}
//	@Value("${fastdfs.http-anti-steal-token}")
//	public void setHttpAntiStealToken(String httpAntiStealToken) {
//		FastDfsConfig.httpAntiStealToken = httpAntiStealToken;
//	}
//	@Value("${fastdfs.connect-timeout-in-seconds}")
//	public void setConnectTimeoutInSeconds(String connectTimeoutInSeconds) {
//		FastDfsConfig.connectTimeoutInSeconds = connectTimeoutInSeconds;
//	}
//	@Value("${fastdfs.network-timeout-in-seconds}")
//	public void setNetworkTimeoutInSeconds(String networkTimeoutInSeconds) {
//		FastDfsConfig.networkTimeoutInSeconds = networkTimeoutInSeconds;
//	}
//	@Value("${fastdfs.charset}")
//	public void setCharset(String charset) {
//		FastDfsConfig.charset = charset;
//	}
//	public static String getFileServerAddr() {
//		return fileServerAddr;
//	}
//	public static Integer getMaxStorageConnection() {
//		return maxStorageConnection;
//	}
//	public static String getHttpSecretKey() {
//		return httpSecretKey;
//	}
//	public static String getTrackerServers() {
//		return trackerServers;
//	}
//	public static String getHttpTrackerHttpPort() {
//		return httpTrackerHttpPort;
//	}
//	public static String getHttpAntiStealToken() {
//		return httpAntiStealToken;
//	}
//	public static String getConnectTimeoutInSeconds() {
//		return connectTimeoutInSeconds;
//	}
//	public static String getNetworkTimeoutInSeconds() {
//		return networkTimeoutInSeconds;
//	}
//	public static String getCharset() {
//		return charset;
//	}
//}
