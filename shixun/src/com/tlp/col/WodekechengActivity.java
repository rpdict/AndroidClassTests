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
        spinner.setPrompt("����");
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
					yi.setText("Android���������⣨1��");
					er.setText("Java�����ȷ壨1��");
					san.setText("Python�����Ĵ�ΰ��1��");
					si.setText("JSP������ʢ�£�1��");
					break;
				case 1:
					yi.setText("Android���������⣨2��");
					er.setText("Java�����ȷ壨2��");
					san.setText("Python�����Ĵ�ΰ��2��");
					si.setText("JSP������ʢ�£�2��");
					break;
				case 2:
					yi.setText("Android���������⣨3��");
					er.setText("Java�����ȷ壨3��");
					san.setText("Python�����Ĵ�ΰ��3��");
					si.setText("JSP������ʢ�£�3��");
					break;
				case 3:
					yi.setText("Android���������⣨4��");
					er.setText("Java�����ȷ壨4��");
					san.setText("Python�����Ĵ�ΰ��4��");
					si.setText("JSP������ʢ�£�4��");
					break;
				case 4:
					yi.setText("Android���������⣨5��");
					er.setText("Java�����ȷ壨5��");
					san.setText("Python�����Ĵ�ΰ��5��");
					si.setText("JSP������ʢ�£�5��");
					break;
				case 5:
					yi.setText("Android���������⣨6��");
					er.setText("Java�����ȷ壨6��");
					san.setText("Python�����Ĵ�ΰ��6��");
					si.setText("JSP������ʢ�£�6��");
					break;
				
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
