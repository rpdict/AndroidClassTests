package com.tlp.col;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Switch;

public class ZhuActivity extends Activity {
	private GridView gridview;
	HashMap<String, Object> map;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhu);
		
		gridview=(GridView)findViewById(R.id.gridView1);
		ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.chuangyi);
		map.put("timu", "我的课堂");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.shuji);
		map.put("timu", "我的课程");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.dzgg);
		map.put("timu", "电子公告");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.tiyu);
		map.put("timu", "社团活动");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.cjcx);
		map.put("timu", "成绩查询");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.grsz);
		map.put("timu", "个人设置");
		list.add(map);
		
		
		
		SimpleAdapter adapter=new SimpleAdapter(ZhuActivity.this,list,R.layout.activity_kecheng,new String[]{"img","timu"},new int[]{R.id.imageView1,R.id.textView1});
		gridview.setAdapter(adapter);
		
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				switch(arg2){
					case 0:
						startActivity(new Intent(ZhuActivity.this,WdeketangActivity.class));
						break;
					case 1:
						startActivity(new Intent(ZhuActivity.this,WodekechengActivity.class));
						break;
					case 2:
						startActivity(new Intent(ZhuActivity.this,DianzigonggaoActivity.class));
						break;
					case 3:
						startActivity(new Intent(ZhuActivity.this,ShetuanhuodongActivity.class));
						break;
					case 4:
						startActivity(new Intent(ZhuActivity.this,ChengjichaxunActivity.class));
						break;
					case 5:
						startActivity(new Intent(ZhuActivity.this,GrenshezhiActivity.class));
						break;
				}
			}
		});
	}
}
