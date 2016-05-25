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
     * 检测网络是否连接 
     * @return 
     */  
    private boolean checkNetworkState() {  
        boolean flag = false;  
        //得到网络连接信息  
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);  
        //去进行判断网络是否连接  
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
     * 网络未连接时，调用设置方法 
     */  
    private void setNetwork(){  
        Toast.makeText(this, "wifi is closed!", Toast.LENGTH_SHORT).show();  
          
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  
        builder.setIcon(R.drawable.ic_launcher);  
        builder.setTitle("网络提示信息");  
        builder.setMessage("网络不可用，如果继续，请先设置网络！");  
        builder.setPositiveButton("设置", new OnClickListener() {  
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
                Intent intent = null;  
                /** 
                 * 判断手机系统的版本！如果API大于10 就是3.0+ 
                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同 
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
  
        builder.setNegativeButton("取消", new OnClickListener() {  
            @Override  
            public void onClick(DialogInterface dialog, int which) {  
  
            }  
        });  
        builder.create();  
        builder.show();  
    }  
      
    /** 
     * 网络已经连接，然后去判断是wifi连接还是GPRS连接 
     * 设置一些自己的逻辑调用 
     */  
    private void isNetworkAvailable(){  
          
        State gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();  
        State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();  
        if(gprs == State.CONNECTED || gprs == State.CONNECTING){  
            Toast.makeText(this, "wifi is open! gprs", Toast.LENGTH_SHORT).show();  
        }  
        //判断为wifi状态下才加载广告，如果是GPRS手机网络则不加载！  
        if(wifi == State.CONNECTED || wifi == State.CONNECTING){  
            Toast.makeText(this, "wifi is open! wifi", Toast.LENGTH_SHORT).show();  
            //loadAdmob();  加载广告
        }  
          
    }  
}
