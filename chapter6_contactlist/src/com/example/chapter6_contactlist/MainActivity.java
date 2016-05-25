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
		// �õ�contentresolver����
		ContentResolver cr = getContentResolver();
		// ȡ�õ绰���п�ʼһ��Ĺ�꣬������moveToNext()
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while (cursor.moveToNext()) {
			// ȡ����ϵ�˵���������
			int nameIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String contact = cursor.getString(nameIndex);
			str += (contact + ":" );
			// ȡ����ϵ�˵�ID����ֵ
			String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);

			// һ���˿����м�������
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
