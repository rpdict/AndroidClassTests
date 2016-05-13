package com.example.chapter2_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RegSureActivity extends Activity {

	//private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg_sure);
		//textView = (TextView) findViewById(R.id.textview22);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String param = bundle.getString("param");
		
		//textView.setText(param);
		Toast.makeText(RegSureActivity.this, param, Toast.LENGTH_SHORT).show();
	}

}
