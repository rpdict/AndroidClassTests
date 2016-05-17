package com.example.chapter4_color;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btnChangeColor;
	private Button btnChangeColor2;
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		btnChangeColor = (Button) findViewById(R.id.btnChangeColor);
		btnChangeColor2 = (Button) findViewById(R.id.btnChangeColor2);
		textView = (TextView) findViewById(R.id.textView1);
		btnChangeColor.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				textView.setBackgroundColor(getResources().getColor(R.color.red));
			}
		});
		
		btnChangeColor2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				textView.setBackgroundColor(getResources().getColor(R.color.gray));
			}
		});
		
	}

	
}
