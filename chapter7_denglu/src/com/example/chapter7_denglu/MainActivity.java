package com.example.chapter7_denglu;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

private EditText etUserName;
private EditText etPwd;
private Button button;


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
etUserName = (EditText) findViewById(R.id.etUserName);
etPwd = (EditText) findViewById(R.id.etPwd);
button = (Button) findViewById(R.id.button1);

button.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {
// TODO Auto-generated method stub
final String userName = etUserName.getText().toString();
final String pwd = etPwd.getText().toString();

new Thread(new Runnable() {
public void run() {
try {

// 构造参数
NameValuePair pair1 = new BasicNameValuePair("userName", userName);
NameValuePair pair2 = new BasicNameValuePair("pwd", pwd);
List<NameValuePair> pairList = new ArrayList<NameValuePair>();
pairList.add(pair1);
pairList.add(pair2);

HttpEntity requestHttpEntity = new UrlEncodedFormEntity(pairList);
// URL使用基本URL即可，其中不需要加参数
//http://localhost:999/chapter6_server/servlet/LoginServlet
HttpPost httpPost = new HttpPost("http://10.64.16.101:999/chapter7_server/servlet/LoginServlet?userName=1&pwd=2");
// 将请求体内容加入请求中
httpPost.setEntity(requestHttpEntity);
// 需要客户端对象来发送请求
HttpClient httpClient = new DefaultHttpClient();
// 发送请求
HttpResponse response = httpClient.execute(httpPost);
if (null == response) {
return;
}
HttpEntity httpEntity = response.getEntity();
InputStream inputStream = httpEntity.getContent();
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
String result = "";
String line = "";
while (null != (line = reader.readLine())) {
result += line;
}

Log.i("MainActivity", result);
JSONObject jsonObject = new JSONObject(result);
String flag = jsonObject.getString("flag");
handler.sendEmptyMessage(Integer.valueOf(flag));
} catch (Exception e) {
e.printStackTrace();
}
}
}).start();

}
});


}
Handler handler = new Handler() {
@Override
public void handleMessage(Message msg) {
super.handleMessage(msg);
switch (msg.what) {
case 0:
Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
break;
case 1:
Intent intent = new Intent(MainActivity.this, MainActivity2.class);
startActivity(intent);
break;
}
}
};


}
