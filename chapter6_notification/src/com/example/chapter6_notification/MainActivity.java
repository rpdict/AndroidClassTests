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
				mBuilder.setTicker("New message");				// 第一次提示消息的时候显示在通知栏上
				mBuilder.setNumber(12);
				mBuilder.setLargeIcon(btm);
				mBuilder.setAutoCancel(true);					// 自己维护通知的消失,单击后自动取消
				mBuilder.setWhen(System.currentTimeMillis()); 	//显示时间
				mBuilder.setOnlyAlertOnce(true);				//更新不再重新弹出

				// 构建一个Intent
				Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
				// 封装一个Intent
				PendingIntent resultPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, resultIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
				// 设置通知主题的意图
				mBuilder.setContentIntent(resultPendingIntent);
				// 获取通知管理器对象
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(
						Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, mBuilder.build());
			}
		});
	}

	
}
