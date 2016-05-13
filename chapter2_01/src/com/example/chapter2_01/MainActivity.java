package com.example.chapter2_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etUserName;
	private EditText etPwd;
	private Button btnLogin;
	private Button btnReg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etUserName = (EditText)findViewById(R.id.editText1);
		etPwd = (EditText)findViewById(R.id.editText2);
		btnLogin = (Button)findViewById(R.id.button1);

		btnLogin.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if("".equals(etUserName.getText().toString())
						||"".equals(etPwd.getText().toString())){
					Toast.makeText(MainActivity.this, "账号或密码为空！", Toast.LENGTH_LONG).show();
				}else if(!("admin".equals(etUserName.getText().toString())
						&&"123456".equals(etPwd.getText().toString()))){
					Toast.makeText(MainActivity.this, "账号或密码错误！", Toast.LENGTH_LONG).show();
				}else{
				//Toast.makeText(MainActivity.this, "账号:"+etUserName.getText().toString()+"，密码："+etPwd.getText().toString(),
				//			Toast.LENGTH_LONG).show();
					startActivity(new Intent(MainActivity.this, IndexActivity.class));
				}
			}
		});

		btnReg = (Button)findViewById(R.id.button2);

		btnReg.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, RegisterActivity.class));
			}
		});
	}


}
