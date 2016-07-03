package com.tlp.col;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DianzigonggaoActivity extends Activity {
	
	private Button fanhui;
	private ListView liebiao;
	HashMap<String, String> map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dianzigonggao);
		
		liebiao=(ListView)findViewById(R.id.listView1);
		fanhui=(Button)findViewById(R.id.button1);
		
		ArrayList<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		
		map=new HashMap<String, String>();
		map.put("biaoti", "课程暂停通知");
		map.put("difang", "北软教务处");
		map.put("shijian", "2016.6.2.18-20");
		list.add(map);
		
		map=new HashMap<String, String>();
		map.put("biaoti", "国庆节放假安排");
		map.put("difang", "北软教务处");
		map.put("shijian", "2016.6.3.18-20");
		list.add(map);
		
		map=new HashMap<String, String>();
		map.put("biaoti", "五一放假安排");
		map.put("difang", "北软教务处");
		map.put("shijian", "2016.6.4.18-20");
		list.add(map);
		
		SimpleAdapter apter=new SimpleAdapter(DianzigonggaoActivity.this, list, R.layout.gonggao, new String[]{"biaoti","difang","shijian"}, new int[]{R.id.textView1,R.id.textView2,R.id.textView3});
		liebiao.setAdapter(apter);
		
		liebiao.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch(arg2){
					case 0:
						startActivity(new Intent(DianzigonggaoActivity.this,KechengzantingActivity.class));
						break;
					case 1:
						startActivity(new Intent(DianzigonggaoActivity.this,GuoqingActivity.class));
						break;
					case 2:
						startActivity(new Intent(DianzigonggaoActivity.this,WuyiActivity.class));
						break;
				}
			}
		});
		
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(DianzigonggaoActivity.this,ZhuActivity.class));
			}
		});
	}
}
