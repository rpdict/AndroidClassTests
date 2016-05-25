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
		
		Log.v("MainActivity", "����һ��v�������־�����");
		Log.d("MainActivity", "����һ��d�������־�����");
		Log.i("MainActivity", "����һ��i�������־�����");
		Log.w("MainActivity", "����һ��w�������־�����");
		Log.e("MainActivity", "����һ��e�������־�����");
	}
}
