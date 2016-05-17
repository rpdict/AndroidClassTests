package com.example.android_sdcard;

import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private final String TAG = "MainActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        /*FileService fileService = new FileService(MainActivity.this);
        
        boolean b = fileService.saveContentToSdcard("hello.txt" ,"ÄãºÃ");
		Log.i(TAG, "--->>" + b);
		
		String msgString = fileService.getFileFromSdcard("hello.txt");
		Log.i(TAG, "--->>" + msgString);*/
        
        /*try {
        	InputStream is = getAssets().open("agreement.txt");
        	int size = is.available();
        	byte[] buffer = new byte[size];
        	is.read(buffer);
        	is.close();
        	String text = new String(buffer,"UTF-8");
        	Log.i(TAG, "--->>" + text);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
        
        try {
        	InputStream is = getResources().openRawResource(R.raw.clouds);
        	int size = is.available();
        	byte[] buffer = new byte[size];
        	is.read(buffer);
        	is.close();
        	String text = new String(buffer,"UTF-8");
        	Log.i(TAG, "--->>" + text);
		} catch (Exception e) {
			// TODO: handle exception
		}

		
    }

   
}
