package com.example.qr_codescan;


import com.google.zxing.WriterException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends Activity {
	
	private Bitmap qrCodeBitmap;
	private ImageView imageView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		try {
			String contentString = "用户名：张三，账号：zhangsan";
			if (!contentString.equals("")) {
				qrCodeBitmap = EncodingHandler.createQRCode(contentString, 600);
			}else {
				Toast.makeText(MainActivity2.this, "信息获取失败！", Toast.LENGTH_SHORT).show();
			}
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imageView1.setImageBitmap(qrCodeBitmap);
	}
}
