package com.example.chapter7_json;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button button1;
	private EditText editText;
	private TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) findViewById(R.id.button1);
		editText = (EditText) findViewById(R.id.editText1);
		textview = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method st7ub
				try {
					String json = editText.getText().toString();
					
					//{'name':'张三',sex:'男',aihao:[{'name':'音乐'},{'name':'足球'}]}
					JSONObject jsonObject = new JSONObject(json);
					String name = jsonObject.getString("name");
					String sex = jsonObject.getString("sex");
					String aihao = jsonObject.getString("aihao");
					JSONArray jsonArray = new JSONArray(aihao);
					String string = "";
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);
						string += jsonObject2.getString("name");
					}
					
					textview.setText("姓名："+name+",性别："+sex+",爱好："+string);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					Toast.makeText(MainActivity.this, "不是有效的json", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}

	
}
