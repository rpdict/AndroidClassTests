package com.example.chapter6_contactlist;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		String str = "";
		// 得到contentresolver对象
		ContentResolver cr = getContentResolver();
		// 取得电话本中开始一项的光标，必须先moveToNext()
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while (cursor.moveToNext()) {
			// 取得联系人的名字索引
			int nameIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String contact = cursor.getString(nameIndex);
			str += (contact + ":" );
			// 取得联系人的ID索引值
			String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);

			// 一个人可能有几个号码
			while (phone.moveToNext()) {
				String strPhoneNumber = phone
						.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				str += (strPhoneNumber + ",");
			}
			phone.close();
			
			str += "<br>";
		}
		cursor.close();
		textView1.setText(Html.fromHtml(str));
	}

	
}
