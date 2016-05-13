package com.example.webview_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button button;
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button1);
		webView = (WebView) findViewById(R.id.webView1);
		
		//��һ�ַ�ʽ
		/*button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
	}

	/**
	 * ʵ��button����
	 * @param v
	 */
	public void gotoNSI(View v){
		//Toast.makeText(MainActivity.this, "ʵ��button����", Toast.LENGTH_LONG).show();
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://t.nsi/");
	}
	
}
