package com.example.chapter4_drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private Button button;
	private Button button2;
	private LinearLayout linearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		linearLayout = (LinearLayout)findViewById(R.id.LinearLayout1);
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				linearLayout.setBackground(getResources().getDrawable(R.drawable.example2));
			}
		});
		
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				linearLayout.setBackground(getResources().getDrawable(R.drawable.example));
			}
		});
		
	}

	
}
