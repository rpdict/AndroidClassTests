package com.example.chapter6_sms;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;

/**
 * class name��SmsChoose<BR>
 * class description����ȡ�ֻ��еĸ��ֶ�����Ϣ<BR>
 * PS�� ��ҪȨ�� <uses-permission android:name="android.permission.READ_SMS" /><BR>
 * Date:2012-3-19<BR>
 *
 * @version 1.00
 * @author CODYY)peijiangping
 */
public class SmsContent {
    private Activity activity;//�����и�activity���󣬲�֪��Ϊɶ��ǰ����Ҫ�����ھ�Ҫ�ˡ��Լ����԰ɡ�
    private Uri uri;
    List<SmsInfo> infos;
 
    public SmsContent(Activity activity, Uri uri) {
        infos = new ArrayList<SmsInfo>();
        this.activity = activity;
        this.uri = uri;
    }
 
    /**
     * Role:��ȡ���ŵĸ�����Ϣ <BR>
     * Date:2012-3-19 <BR>
     *
     * @author CODYY)peijiangping
     */
    public List<SmsInfo> getSmsInfo() {
        String[] projection = new String[] { "_id", "address", "person",
                "body", "date", "type" };
        Cursor cusor = activity.managedQuery(uri, projection, null, null,
                "date desc");
        int nameColumn = cusor.getColumnIndex("person");
        int phoneNumberColumn = cusor.getColumnIndex("address");
        int smsbodyColumn = cusor.getColumnIndex("body");
        int dateColumn = cusor.getColumnIndex("date");
        int typeColumn = cusor.getColumnIndex("type");
        if (cusor != null) {
            while (cusor.moveToNext()) {
                SmsInfo smsinfo = new SmsInfo();
                smsinfo.setName(cusor.getString(nameColumn));
                smsinfo.setDate(cusor.getString(dateColumn));
                smsinfo.setPhoneNumber(cusor.getString(phoneNumberColumn));
                smsinfo.setSmsbody(cusor.getString(smsbodyColumn));
                smsinfo.setType(cusor.getString(typeColumn));
                infos.add(smsinfo);
            }
            cusor.close();
        }
        //infos.add(new SmsInfo("hjashsahjsahj", "128921821821", "2015", "haha", "1"));
        return infos;
    }
}