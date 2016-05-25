package com.example.chapter6_logcat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("MainActivity", "这是一个v级别的日志输出！");
		Log.d("MainActivity", "这是一个d级别的日志输出！");
		Log.i("MainActivity", "这是一个i级别的日志输出！");
		Log.w("MainActivity", "这是一个w级别的日志输出！");
		Log.e("MainActivity", "这是一个e级别的日志输出！");
	}
}
