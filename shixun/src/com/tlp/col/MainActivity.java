package com.tlp.col;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button denglu;
	private EditText zhanghao;
	private EditText mima;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		denglu=(Button)findViewById(R.id.button1);
		zhanghao=(EditText)findViewById(R.id.editText1);
		mima=(EditText)findViewById(R.id.editText2);
		
		denglu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if("".equals(zhanghao.getText().toString())||"".equals(mima.getText().toString())){
					Toast.makeText(MainActivity.this,"账号或密码不能为空！", Toast.LENGTH_SHORT).show();
				}
				if("962464".equals(zhanghao.getText().toString())&&"962464".equals(mima.getText().toString())){
					//Toast.makeText(MainActivity.this,"登陆成功！", Toast.LENGTH_SHORT).show();
					startActivity(new Intent(MainActivity.this,ZhuActivity.class));
				}else{
					Toast.makeText(MainActivity.this,"账号或密码不正确！", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
}
