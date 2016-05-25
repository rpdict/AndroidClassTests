package com.example.chapter7_handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Thread(new Runnable() {
			public void run() {
				//code here
				handler.sendEmptyMessage(1);
			}
		}).start();
	}

	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:	
				//code here
				Toast.makeText(MainActivity.this, "haha", Toast.LENGTH_LONG).show();
				break;
			}
		}
	};
	
}
