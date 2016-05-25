package com.example.chapter6_intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends Activity {

	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		Bundle bundle = getIntent().getExtras();
		String name = bundle.getString("name");
		String sex = bundle.getString("sex");
		
		textView = (TextView) findViewById(R.id.textView1);
		textView.setText("ÐÕÃû£º"+name+",ÐÔ±ð£º"+sex);
	}

	
}
