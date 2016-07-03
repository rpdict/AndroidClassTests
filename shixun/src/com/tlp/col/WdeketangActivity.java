package com.tlp.col;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class WdeketangActivity extends Activity {
	private Button fanhui;
	private ListView liebiao;
	HashMap<String, Object> map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wdkt);
		
		liebiao=(ListView)findViewById(R.id.listView1);
		fanhui=(Button)findViewById(R.id.button1);
		
		ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
		
		map=new HashMap<String, Object>();
		map.put("img", R.drawable.ic_launcher);
		map.put("shouke", "授课名称：Android");
		map.put("jiaoshi", "授课教师：岳增光");
		map.put("shijian", "2016.6.2.18-20");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img", R.drawable.java);
		map.put("shouke", "授课名称：java");
		map.put("jiaoshi", "授课教师：谷峰");
		map.put("shijian", "2016.6.2.18-20");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img", R.drawable.python);
		map.put("shouke", "授课名称：Python");
		map.put("jiaoshi", "授课教师：夏大伟");
		map.put("shijian", "2016.6.2.18-20");
		list.add(map);
		
		SimpleAdapter apter=new SimpleAdapter(WdeketangActivity.this, list, R.layout.ketang, new String[]{"img","shouke","jiaoshi","shijian"}, new int[]{R.id.imageView1,R.id.textView1,R.id.textView2,R.id.textView3});
		liebiao.setAdapter(apter);
		
		
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(WdeketangActivity.this,ZhuActivity.class));
			}
		});
	}
}
