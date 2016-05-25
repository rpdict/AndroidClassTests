package com.example.chapter6_notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnNotification;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnNotification = (Button) findViewById(R.id.button1);
		
		btnNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Bitmap btm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
				NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this)
						.setSmallIcon(R.drawable.ic_launcher).setContentTitle("5 new message")
						.setContentText("twain@android.com");
				mBuilder.setTicker("New message");				// ��һ����ʾ��Ϣ��ʱ����ʾ��֪ͨ����
				mBuilder.setNumber(12);
				mBuilder.setLargeIcon(btm);
				mBuilder.setAutoCancel(true);					// �Լ�ά��֪ͨ����ʧ,�������Զ�ȡ��
				mBuilder.setWhen(System.currentTimeMillis()); 	//��ʾʱ��
				mBuilder.setOnlyAlertOnce(true);				//���²������µ���

				// ����һ��Intent
				Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
				// ��װһ��Intent
				PendingIntent resultPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, resultIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
				// ����֪ͨ�������ͼ
				mBuilder.setContentIntent(resultPendingIntent);
				// ��ȡ֪ͨ����������
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(
						Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, mBuilder.build());
			}
		});
	}

	
}
