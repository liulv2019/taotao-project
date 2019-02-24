package com.taotao.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

public class HttpClientTest {

	private static final Logger Log = Logger.getLogger(HttpClientTest.class);
	
	@Test
	public  void doGet() throws Exception {
		
		//创建一个httpCient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet get = new HttpGet("http://www.sogou.com");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取相应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Log.info("log:"+statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		Log.info("log:"+string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
	@Test
	public  void doGetWithParam() throws Exception {
		
		//创建一个httpCient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个uri对象
		URIBuilder builder = new URIBuilder("http://www.sogou.com/web");
		builder.addParameter("query", "花千骨");
		//创建一个GET对象
		HttpGet get = new HttpGet(builder.build());
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取相应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
	@Test
	public  void doPost() throws Exception {
		
		//创建一个httpCient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个post对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		//取相应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
	@Test
	public  void doPostWithParam() throws Exception {
	
		//创建一个httpCient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个post对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
		//创建一个entiy。模拟一个表单
		List<NameValuePair> kValuePairs = new ArrayList<>();
		kValuePairs.add(new BasicNameValuePair("username", "张三"));
		kValuePairs.add(new BasicNameValuePair("password", "123456"));
		//包装成一个entity对象
		StringEntity stringEntity = new UrlEncodedFormEntity(kValuePairs, "utf-8");
		//设置请求内容
		post.setEntity(stringEntity);
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		//取相应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
}
