package com.example.chapter5_shared;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences mySharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
		Editor editor = mySharedPreferences.edit();
		editor.putString("name", "ÕÅÈý");
		editor.putString("sex", "ÄÐ");
		editor.commit();
		String name = mySharedPreferences.getString("name", "");
		String sex = mySharedPreferences.getString("sex", "");
		Toast.makeText(MainActivity.this, "name:"+name+",sex:"+sex, Toast.LENGTH_LONG).show();
		
	}
}
