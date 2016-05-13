package com.example.chapter_listview1;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProblemAdapter extends BaseAdapter{

	private Context context;
	private ArrayList<HashMap<String, String>> list;
	private LayoutInflater inflater;
	
	public ProblemAdapter(Context context, ArrayList<HashMap<String, String>> list) {
		super();
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public HashMap<String, String> getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		ViewHolder holder;
		if(view == null){
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.list, null);
			
			holder.tvQuestion = (TextView) view.findViewById(R.id.tvProblem);
			holder.tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);
			
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		holder.tvQuestion.setText(getItem(arg0).get("question"));
		holder.tvAnswer.setText(getItem(arg0).get("answer"));
		return view;
	}
	
	private class ViewHolder{
		TextView tvQuestion;
		TextView tvAnswer;
	}

}
