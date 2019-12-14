package org.linlinjava.litemall.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 向指定 URL 发送POST方法的请求
 *
 * @return 远程资源的响应结果
 */
public class HttpUtil {
	private final static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	public static String httpPostForm(String url,Map<String,String> params, Map<String,String> headers,String encode){
		if(encode == null){
			encode = "utf-8";
		}
		//HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpPost httpost = new HttpPost(url);

		//设置header
		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpost.setHeader(entry.getKey(),entry.getValue());
			}
		}
		//组织请求参数
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		if(params != null && params.size() > 0){
			Set<String> keySet = params.keySet();
			for(String key : keySet) {
				paramList.add(new BasicNameValuePair(key, params.get(key)));
			}
		}
		try {
			httpost.setEntity(new UrlEncodedFormEntity(paramList, encode));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String content = null;
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = closeableHttpClient.execute(httpost);
			HttpEntity entity = httpResponse.getEntity();
			content = EntityUtils.toString(entity, encode);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {  //关闭连接、释放资源
			closeableHttpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url    发送请求的 URL
	 * @param params 请求的参数集合
	 * @return 远程资源的响应结果
	 */
	@SuppressWarnings("unused")
	public static String sendPost(String url, Map<String, String> params) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// POST方法
			conn.setRequestMethod("POST");
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.connect();
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			// 发送请求参数
			if (params != null) {
				StringBuilder param = new StringBuilder();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					if (param.length() > 0) {
						param.append("&");
					}
					param.append(entry.getKey());
					param.append("=");
					param.append(entry.getValue());
					// System.out.println(entry.getKey()+":"+entry.getValue());
				}
				// System.out.println("param:"+param.toString());
				out.write(param.toString());
			}
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	public static String sendGet(String urlStr) {

		// 请求的url
		URL url = null;

		// 建立的http链接
		HttpURLConnection httpConn = null;

		// 请求的输入流
		BufferedReader in = null;

		// 输入流的缓冲
		StringBuffer sb = new StringBuffer();

		try {
			url = new URL(urlStr);

			in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

			String str = null;

			// 一行一行进行读入
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close(); // 关闭流
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		String result = sb.toString();
		return result;
	}
}
