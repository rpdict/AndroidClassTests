package com.example.chapter4_dimen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView1;
	private Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView) findViewById(R.id.textview1);
		textView1.setTextSize(getResources().getDimension(R.dimen.font_size16));
		button1 = (Button) findViewById(R.id.button1);
		
		final float textSize = 30;
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				textView1.setTextSize(textSize);
			}
		});
	}


}
