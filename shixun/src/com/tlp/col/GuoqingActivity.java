package com.tlp.col;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuoqingActivity extends Activity {
	private Button fanhui;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guoqing);
		
		fanhui=(Button)findViewById(R.id.button1);
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(GuoqingActivity.this,DianzigonggaoActivity.class));
			}
		});
		
	}
}
