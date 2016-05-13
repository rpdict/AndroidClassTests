package com.example.chapter2_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private EditText edPhone;
	private EditText edPwd;
	private EditText edPwd2;
	private RadioButton radMan;
	private RadioButton radWoman;
	private Spinner spCity;
	private DatePicker datepBirthday;
	private CheckBox cbAgreement;
	private Button btnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		edPhone = (EditText) findViewById(R.id.editText1);
		edPwd = (EditText) findViewById(R.id.editText2);
		edPwd2 = (EditText) findViewById(R.id.editText3);
		radMan = (RadioButton) findViewById(R.id.radioButton1);
		radWoman = (RadioButton) findViewById(R.id.radioButton2);
		spCity = (Spinner) findViewById(R.id.spinner1);
		datepBirthday = (DatePicker) findViewById(R.id.datePicker1);
		cbAgreement = (CheckBox) findViewById(R.id.checkBox1);
		btnRegister = (Button) findViewById(R.id.button1);

		btnRegister.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if("".equals(edPhone.getText().toString())){
					Toast.makeText(RegisterActivity.this, "手机号不能为空！", Toast.LENGTH_SHORT).show();
					return;
				}
				if("".equals(edPwd.getText().toString())){
					Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
					return;
				}
				if("".equals(edPwd2.getText().toString())){
					Toast.makeText(RegisterActivity.this, "确认密码不能为空！", Toast.LENGTH_SHORT).show();
					return;
				}
				if(! edPwd.getText().toString().equals(edPwd2.getText().toString())){
					Toast.makeText(RegisterActivity.this, "两次输入密码必须一致！", Toast.LENGTH_SHORT).show();
					return;
				}
				if(! cbAgreement.isChecked()){
					Toast.makeText(RegisterActivity.this, "必须同意协议才能完成注册！", Toast.LENGTH_SHORT).show();
					return;
				}


				String phone = edPhone.getText().toString();
				String pwd = edPwd.getText().toString();
				String sex = radMan.isChecked()?"男":"女";
				String city = spCity.getSelectedItem().toString();
				String birthday = datepBirthday.getYear()+"-"+(datepBirthday.getMonth()+1)+"-"+datepBirthday.getDayOfMonth();



				Intent intent = new Intent(RegisterActivity.this, RegSureActivity.class);
				intent.putExtra("param", phone+"="+pwd+"="+sex+"="+city+"="+birthday);
				startActivity(intent);
			}
		});


	}

}
