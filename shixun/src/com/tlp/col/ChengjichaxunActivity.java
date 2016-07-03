package com.tlp.col;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ChengjichaxunActivity extends Activity {

	private ListView liebiao;
	private Button fanhui;
	HashMap<String, String> map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chengjichaxun);
		
		liebiao=(ListView)findViewById(R.id.listView1);
		fanhui=(Button)findViewById(R.id.button1);
		
		ArrayList<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		
		map=new HashMap<String, String>();
		map.put("xingming", "王二小");
		map.put("xuehao", "  2013035108015");
		map.put("zhuanye", "  软件技术");
		map.put("xingbie", "  男");
		list.add(map);
		
		map=new HashMap<String, String>();
		map.put("xingming", "方跃");
		map.put("xuehao", "  2013035108016");
		map.put("zhuanye", "  软件技术");
		map.put("xingbie", "  女");
		list.add(map);
		
		map=new HashMap<String, String>();
		map.put("xingming", "王小二");
		map.put("xuehao", "  2013035108017");
		map.put("zhuanye", "  软件技术");
		map.put("xingbie", "  男");
		list.add(map);
		
		SimpleAdapter apter=new SimpleAdapter(ChengjichaxunActivity.this, list, R.layout.chengji, new String[]{"xingming","xuehao","zhuanye","xingbie"}, new int[]{R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4});
		liebiao.setAdapter(apter);
		
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ChengjichaxunActivity.this,ZhuActivity.class));
			}
		});
		
		liebiao.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch(arg2){
					case 0:
						startActivity(new Intent(ChengjichaxunActivity.this,WangerxiaoActivity.class));
						break;
					case 1:
						startActivity(new Intent(ChengjichaxunActivity.this,FangyueActivity.class));
						break;
					case 2:
						startActivity(new Intent(ChengjichaxunActivity.this,WangxiaoerActivity.class));
						break;
				}
			}
		});
	}
}
