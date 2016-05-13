package com.example.chapter3_event;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button button2;
	private Button button3;
	private Button button4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(listener);

		button3 = (Button) findViewById(R.id.button3);
		//第三种方法：匿名内部类写法
		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "匿名内部类写法", Toast.LENGTH_LONG).show();
			}
		});

		//长按事件
		button4 = (Button) findViewById(R.id.button4);
		button4.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "长按事件写法", Toast.LENGTH_LONG).show();
				return false;
			}
		});
	}

	/**
	 * 第一种方法：XML配置方法
	 * @param v
	 */
	public void button1(View v){
		Toast.makeText(MainActivity.this, "XML配置方法", Toast.LENGTH_LONG).show();
	}

	/**
	 * 第二种方法：内部类写法
	 */
	private OnClickListener listener = new OnClickListener() {

		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "内部类写法", Toast.LENGTH_LONG).show();
		}
	};
}
