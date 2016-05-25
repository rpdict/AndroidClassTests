package com.example.chapter7_http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button1;
	private Button button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		
		//发送GET请求
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 生成请求对象
				new Thread(new Runnable() {
					public void run() {
						try {
							HttpGet httpGet = new HttpGet("http://www.baidu.com?p1=2&p2=2");//参数
							HttpClient httpClient = new DefaultHttpClient();
							HttpResponse response = httpClient.execute(httpGet);
							if (null == response){
								return;
							}
							HttpEntity httpEntity = response.getEntity();
							InputStream inputStream = httpEntity.getContent();
							BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
							String result = "";
							String line = "";
							while (null != (line = reader.readLine())){
								result += line;
							}
							Log.i("MainActivity", result);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		
		//发送POST请求
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 生成请求对象
				new Thread(new Runnable() {
					public void run() {
						try {
							
							//构造参数
							NameValuePair pair1 = new BasicNameValuePair("p1", "1");
				            NameValuePair pair2 = new BasicNameValuePair("p2", "2");
				            List<NameValuePair> pairList = new ArrayList<NameValuePair>();
				            pairList.add(pair1);
				            pairList.add(pair2);
				            
							HttpEntity requestHttpEntity = new UrlEncodedFormEntity(pairList);
			                // URL使用基本URL即可，其中不需要加参数
			                HttpPost httpPost = new HttpPost("http://www.baidu.com");
			                // 将请求体内容加入请求中
			                httpPost.setEntity(requestHttpEntity);
			                // 需要客户端对象来发送请求
			                HttpClient httpClient = new DefaultHttpClient();
			                // 发送请求
			                HttpResponse response = httpClient.execute(httpPost);
							if (null == response){
								return;
							}
							HttpEntity httpEntity = response.getEntity();
							InputStream inputStream = httpEntity.getContent();
							BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
							String result = "";
							String line = "";
							while (null != (line = reader.readLine())){
								result += line;
							}
							Log.i("MainActivity", result);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		
	}

}
