package com.tlp.col;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class GrenshezhiActivity extends Activity {

	private Button fanhui;
	private Button chongzhi;
	private Button baocun;
	private EditText xingming;
	private EditText dianhua;
	private EditText zhuanye;
	private EditText xuexiao;
	private RadioButton nan;
	private RadioButton nv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gerenshezhi);
		
		fanhui=(Button)findViewById(R.id.button3);
		chongzhi=(Button)findViewById(R.id.button1);
		xingming=(EditText)findViewById(R.id.editText1);
		dianhua=(EditText)findViewById(R.id.editText2);
		zhuanye=(EditText)findViewById(R.id.editText3);
		xuexiao=(EditText)findViewById(R.id.editText4);
		baocun=(Button)findViewById(R.id.button2);
		nan=(RadioButton)findViewById(R.id.radioButton1);
		nv=(RadioButton)findViewById(R.id.radioButton2);
		
		final SharedPreferences share=getSharedPreferences("users", Activity.MODE_PRIVATE);
		
		xingming.setText(share.getString("xm",""));
		dianhua.setText(share.getString("dh",""));
		zhuanye.setText(share.getString("zy",""));
		xuexiao.setText(share.getString("xx",""));
		String xb=share.getString("xb","");
		if("男".equals(xb)){
			nan.setChecked(true);
		}else if("女".equals(xb)){
			nv.setChecked(true);
		}
		
		
		chongzhi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				xingming.setText("");
				dianhua.setText("");
				zhuanye.setText("");
				xuexiao.setText("");
				nan.setChecked(true);
			}
		});
		
		
		baocun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String xm=xingming.getText().toString();
				String dh=dianhua.getText().toString();
				String zy=zhuanye.getText().toString();
				String xx=xuexiao.getText().toString();
				String xb="";
				if(nan.isChecked()){
					xb="男";
				}else if(nv.isChecked()){
					xb="女";
				}
				SharedPreferences.Editor editor=share.edit();
				editor.putString("xm", xm);
				editor.putString("dh", dh);
				editor.putString("zy", zy);
				editor.putString("xx", xx);
				editor.putString("xb", xb);
				
				editor.commit();
				Toast.makeText(GrenshezhiActivity.this, "保存成功！", Toast.LENGTH_LONG).show();
			}
		});
		
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(GrenshezhiActivity.this,ZhuActivity.class));
			}
		});
		
	}
}
