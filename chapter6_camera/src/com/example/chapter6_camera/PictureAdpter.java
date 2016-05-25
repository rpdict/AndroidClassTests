package com.example.chapter6_camera;

import java.io.FileNotFoundException;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class PictureAdpter extends BaseAdapter{
	private Context mContext;
	private List<PictureBean> mList;
	private LayoutInflater mInflater;
	
	public PictureAdpter(Context context, List<PictureBean> arrList) {
		this.mContext = context;
		this.mList = arrList;
		this.mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size()+1;
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
		// TODO Auto-generated method stub
		ViewHolder holder = null;
//		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_picture_item,null);
			holder.imgPicture = (ImageView) convertView.findViewById(R.id.imgPicture);
			convertView.setTag(holder);
//		} else {
//			holder = (ViewHolder) convertView.getTag();
//		}
		if(position != mList.size()){
			try {
				holder.imgPicture.setImageBitmap(
						BitmapFactory.decodeStream(
								mContext.getContentResolver().openInputStream(
										mList.get(position).getPhotoUri())));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return convertView;
	}

	private class ViewHolder {
		ImageView imgPicture;
	}
}
