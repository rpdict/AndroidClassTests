package com.tlp.col;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class WodekechengActivity extends Activity {
	private TextView yi;
	private TextView er;
	private TextView san;
	private TextView si;
	private Spinner spinner=null;
	private Button fanhui;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wodekecheng);
		
		yi=(TextView)findViewById(R.id.textView2);
		er=(TextView)findViewById(R.id.textView3);
		san=(TextView)findViewById(R.id.textView4);
		si=(TextView)findViewById(R.id.textView5);
		fanhui=(Button)findViewById(R.id.button1);
		
		fanhui.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(WodekechengActivity.this,ZhuActivity.class));
			}
		});
		
		spinner=(Spinner)findViewById(R.id.spinner);
        
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.caidan_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt("星期");
        Adapterlistener listener=new Adapterlistener();
        spinner.setOnItemSelectedListener(listener);
    }
    
    class Adapterlistener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			switch(arg2){
				case 0:
					yi.setText("Android——岳增光（1）");
					er.setText("Java——谷峰（1）");
					san.setText("Python——夏大伟（1）");
					si.setText("JSP——刘盛新（1）");
					break;
				case 1:
					yi.setText("Android——岳增光（2）");
					er.setText("Java——谷峰（2）");
					san.setText("Python——夏大伟（2）");
					si.setText("JSP——刘盛新（2）");
					break;
				case 2:
					yi.setText("Android——岳增光（3）");
					er.setText("Java——谷峰（3）");
					san.setText("Python——夏大伟（3）");
					si.setText("JSP——刘盛新（3）");
					break;
				case 3:
					yi.setText("Android——岳增光（4）");
					er.setText("Java——谷峰（4）");
					san.setText("Python——夏大伟（4）");
					si.setText("JSP——刘盛新（4）");
					break;
				case 4:
					yi.setText("Android——岳增光（5）");
					er.setText("Java——谷峰（5）");
					san.setText("Python——夏大伟（5）");
					si.setText("JSP——刘盛新（5）");
					break;
				case 5:
					yi.setText("Android——岳增光（6）");
					er.setText("Java——谷峰（6）");
					san.setText("Python——夏大伟（6）");
					si.setText("JSP——刘盛新（6）");
					break;
				
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
