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
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ShetuanhuodongActivity extends Activity {
	private ListView listv;
	HashMap<String, Object> map;
	private Button fanhui;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shetuanhuodong);
		
		
		fanhui=(Button)findViewById(R.id.button1);
		listv=(ListView)findViewById(R.id.listView1);
		ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.zuqiu);
		map.put("zhuti", "�������");
		map.put("mingcheng", "��������");
		map.put("shijian", "2015.6.1.18-30");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.jiaoyou);
		map.put("zhuti", "����");
		map.put("mingcheng", "��������");
		map.put("shijian", "2015.6.1.18-30");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.lanqiu);
		map.put("zhuti", "�������");
		map.put("mingcheng", "��������");
		map.put("shijian", "2015.6.1.18-30");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.sanda);
		map.put("zhuti", "ɢ�����");
		map.put("mingcheng", "����ɢ��");
		map.put("shijian", "2015.6.1.18-30");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.taiji);
		map.put("zhuti", "̫������");
		map.put("mingcheng", "����̫��");
		map.put("shijian", "2015.6.1.18-30");
		list.add(map);
		
		map=new HashMap<String, Object>();
		map.put("img",R.drawable.roudao);
		map.put("zhuti", "�������");
		map.put("mingcheng", "�������");
		map.put("shijian", "2015.6.1.18-30");
		list.add(map);
		
		
		
		SimpleAdapter adapter=new SimpleAdapter(ShetuanhuodongActivity.this,list,R.layout.shetuan,new String[]{"img","zhuti","mingcheng","shijian"},new int[]{R.id.imageView1,R.id.textView4,R.id.textView5,R.id.textView6});
		listv.setAdapter(adapter);
		
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ShetuanhuodongActivity.this,ZhuActivity.class));
			}
		});
	}
}
