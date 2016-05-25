package com.example.chapter6_connect;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ConnectivityManager manager;
	private Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				checkNetworkState();
			}
		});
	}

	/** 
     * ��������Ƿ����� 
     * @return 
     */  
    private boolean checkNetworkState() {  
        boolean flag = false;  
        //�õ�����������Ϣ  
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);  
        //ȥ�����ж������Ƿ�����  
        if (manager.getActiveNetworkInfo() != null) {  
            flag = manager.getActiveNetworkInfo().isAvailable();  
        }  
        if (!flag) {  
            setNetwork();  
        } else {  
            isNetworkAvailable();  
        }  
  
        return flag;  
    }  
      
  
    /** 
     * ����δ����ʱ���������÷��� 
     */  
    private void setNetwork(){  
        Toast.makeText(this, "wifi is closed!", Toast.LENGTH_SHORT).show();  
          
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  
        builder.setIcon(R.drawable.ic_launcher);  
        builder.setTitle("������ʾ��Ϣ");  
        builder.setMessage("���粻���ã���������������������磡");  
        builder.setPositiveButton("����", new OnClickListener() {  
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
                Intent intent = null;  
                /** 
                 * �ж��ֻ�ϵͳ�İ汾�����API����10 ����3.0+ 
                 * ��Ϊ3.0���ϵİ汾�����ú�3.0���µ����ò�һ�������õķ�����ͬ 
                 */  
                if (android.os.Build.VERSION.SDK_INT > 10) {  
                    intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);  
                } else {  
                    intent = new Intent();  
                    ComponentName component = new ComponentName(  
                            "com.android.settings",  
                            "com.android.settings.WirelessSettings");  
                    intent.setComponent(component);  
                    intent.setAction("android.intent.action.VIEW");  
                }  
                startActivity(intent);  
            }  
        });  
  
        builder.setNegativeButton("ȡ��", new OnClickListener() {  
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
  
            }  
        });  
        builder.create();  
        builder.show();  
    }  
      
    /** 
     * �����Ѿ����ӣ�Ȼ��ȥ�ж���wifi���ӻ���GPRS���� 
     * ����һЩ�Լ����߼����� 
     */  
    private void isNetworkAvailable(){  
          
        State gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();  
        State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();  
        if(gprs == State.CONNECTED || gprs == State.CONNECTING){  
            Toast.makeText(this, "wifi is open! gprs", Toast.LENGTH_SHORT).show();  
        }  
        //�ж�Ϊwifi״̬�²ż��ع�棬�����GPRS�ֻ������򲻼��أ�  
        if(wifi == State.CONNECTED || wifi == State.CONNECTING){  
            Toast.makeText(this, "wifi is open! wifi", Toast.LENGTH_SHORT).show();  
            //loadAdmob();  ���ع��
        }  
          
    }  
}
