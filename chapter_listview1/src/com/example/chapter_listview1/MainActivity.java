package com.example.chapter_listview1;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView1);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();

		//这是第一行数据
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("question", "什么是提现？提现需要注意哪些问题");
		map.put("answer", "提现是指个人账户...");
		list.add(map);

		//这是第二行数据
		map = new HashMap<String, String>();
		map.put("question", "什么是可提现金额");
		map.put("answer", "可提现金额=我的余额-已冻结金额");
		list.add(map);

		//这是第三行数据
		map = new HashMap<String, String>();
		map.put("question", "什么是可提现金额hh");
		map.put("answer", "可提现金额=我的余额-已冻结金额yyy");
		list.add(map);

		//这是第四行数据
		map = new HashMap<String, String>();
		map.put("question", "什么是可提现金额2323");
		map.put("answer", "可提现金额=我的余额-已冻结金额gfgf");
		list.add(map);

		//这是第五行数据
		map = new HashMap<String, String>();
		map.put("question", "什么是可提现金额122");
		map.put("answer", "可提现金额=我的余额-已冻结金额22");
		list.add(map);

		SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,list, R.layout.list, new String[]{"question", "answer"}, new int[]{R.id.tvProblem, R.id.tvAnswer});

		// ProblemAdapter adapter = new ProblemAdapter(MainActivity.this, list);

		listView.setAdapter(adapter);


	}


}
