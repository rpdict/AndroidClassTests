package com.example.chapter6_gps;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */  
    Button button;  
    TextView textview;  
    LocationManager manager;  
    Location location;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        textview=(TextView)findViewById(R.id.textView1);  
        button=(Button)findViewById(R.id.button);  
        manager=(LocationManager)getSystemService(LOCATION_SERVICE);  
        //��GPS_PROVIDER��ȡ����Ķ�λ��Ϣ  
        location=manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);  
        updateView(location);  
        //�ж�GPS�Ƿ����  
        System.out.println("state="+manager.isProviderEnabled(LocationManager.GPS_PROVIDER));  
        button.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                //����ÿ60�룬ÿ�ƶ�ʮ����LocationProvider��ȡһ��GPS�Ķ�λ��Ϣ  
                //��LocationProvider���ã������û�λ��Ϣ�ı�ʱ������updateView,������ʾ  
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 10, new LocationListener() {  
                      
                    @Override  
                    public void onStatusChanged(String provider, int status, Bundle extras) {  
                        // TODO Auto-generated method stub  
                          
                    }  
                      
                    @Override  
                    public void onProviderEnabled(String provider) {  
                        // TODO Auto-generated method stub  
                        //  
                        updateView(manager.getLastKnownLocation(provider));  
                    }  
                      
                    @Override  
                    public void onProviderDisabled(String provider) {  
                        // TODO Auto-generated method stub  
                        updateView(null);  
                    }  
                      
                    @Override  
                    public void onLocationChanged(Location location) {  
                        // TODO Auto-generated method stub  
                        //locationΪ�仯�����λ�ã�������ʾ  
                        updateView(location);  
                    }  
                });  
            }  
        });  
    }  
    //������ʾ���ݵķ���  
    public void updateView(Location location)  
    {  
        StringBuffer buffer=new StringBuffer();  
        if(location==null)  
        {  
            textview.setText("δ��÷���");  
            return;  
        }  
        buffer.append("���ȣ�"+location.getLongitude()+"\n");  
        buffer.append("γ�ȣ�"+location.getLatitude()+"\n");  
        buffer.append("�߶ȣ�"+location.getAltitude()+"\n");  
        buffer.append("�ٶȣ�"+location.getSpeed()+"\n");  
        buffer.append("����"+location.getBearing()+"\n");  
        textview.setText(buffer.toString());  
    } 
}
