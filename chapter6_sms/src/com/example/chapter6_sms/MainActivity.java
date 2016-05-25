package com.example.chapter6_sms;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView listview;
    private List<SmsInfo> infos;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri = Uri.parse(AllFinalInfo.SMS_URI_INBOX);
        SmsContent sc = new SmsContent(this, uri);
        infos = sc.getSmsInfo();
        listview = (ListView) this.findViewById(R.id.ListView_Sms);
        listview.setAdapter(new SmsListAdapter(this));
    }
 
    class SmsListAdapter extends BaseAdapter {
        private LayoutInflater layoutinflater;
        private View myview;
 
        public SmsListAdapter(Context c) {
            layoutinflater = LayoutInflater.from(c);
        }
 
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return infos.size();
        }
 
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }
 
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }
 
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                myview = layoutinflater.inflate(R.layout.smsitem, null);
            }
            TextView body = (TextView) myview
                    .findViewById(R.id.TextView_SmsBody);
            TextView name = (TextView) myview
                    .findViewById(R.id.TextView_SmsName);
            body.setText(infos.get(position).getSmsbody());
            name.setText(infos.get(position).getName());
            return myview;
        }
 
    }
}