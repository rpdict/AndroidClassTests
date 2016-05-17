package com.example.chapter5_raw;

import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			InputStream is = getResources().openRawResource(R.raw.test);
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			String text = new String(buffer,"UTF-8");
			
			Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
}
