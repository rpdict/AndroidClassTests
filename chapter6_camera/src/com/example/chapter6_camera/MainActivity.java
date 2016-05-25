package com.example.chapter6_camera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

@TargetApi(Build.VERSION_CODES.FROYO)
public class MainActivity extends Activity{
	private PictureAdpter adapter;
	private GridView gridPicture;
	
	private File file;
	private String path;
	private Uri imageUri;
	private String photoName;
	private String photoPath;
	private ImageTools imageTools;
	private static final int IMAGE_REQUEST_CODE = 0;
	private static final int CAMERA_REQUEST_CODE = 1;
	private static final int RESULT_IMAGE_CODE = 2;//相册图片
	private static final int RESULT_CAMERA_CODE = 3;//相机图片
	
	private List<PictureBean> arrList;
	private PictureBean pictureBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById();
		init();
		doLiseners();
	}

	private void init() {
		// TODO Auto-generated method stub
//		GlobalInfo.pictureHimi.clear();
		imageTools = new ImageTools();
		path = Environment.getExternalStorageDirectory() + "/multimedia/";
		createSDCardDir(path);
		arrList = new ArrayList<PictureBean>();
		
		File file = new File(path);
        File[] f = file.listFiles();
        for (int i = 0; i < f.length; i++) {
        	pictureBean = new PictureBean();
			pictureBean.setPhotoName(f[i].getName());
			pictureBean.setPhotoPath(f[i].getPath());
			pictureBean.setPhotoUri(Uri.fromFile(f[i]));
			
			arrList.add(pictureBean);
		}
		adapter = new PictureAdpter(this, arrList);
	}
	
	private void findViewById() {
		// TODO Auto-generated method stub
//		linearBack = (LinearLayout) findViewById(R.id.linear_back);
		gridPicture = (GridView) findViewById(R.id.gridView1);
//		btnConfirm = (Button) findViewById(R.id.btn_confirm);
//		btnCancel = (Button) findViewById(R.id.btn_cancel);
	}
	
	private void doLiseners() {
		// TODO Auto-generated method stub
		gridPicture.setAdapter(adapter);
		gridPicture.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(null != arrList && arrList.size() == arg2){
					showImagePickDialog();
				}else if(null == arrList){
					showImagePickDialog();
				}else {
					showIsDeleteDialog(arg2);
				}
			}
		});
	}
	
	public void showImagePickDialog() {
		String title = "设置";
		String[] choices = new String[]{ "手机相册" ,"相机拍摄"};
		
		new AlertDialog.Builder(this)
			.setTitle(title)
			.setItems(choices, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					Intent intent = new Intent();
					switch (which) {
					case 0:
						intent.setType("image/*"); // 设置文件类型
						intent.setAction(Intent.ACTION_GET_CONTENT);
						startActivityForResult(intent, IMAGE_REQUEST_CODE);
						break;
					case 1:
						file = new File(path, System.currentTimeMillis() + ".png"); 
                        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));  
						startActivityForResult(intent, CAMERA_REQUEST_CODE);
						break;
					}
				}
			})
			.show();
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		//结果码不等于取消时候
		if (resultCode != RESULT_CANCELED) {
			switch (requestCode) {
			case IMAGE_REQUEST_CODE:
				startPhotoZoom(data.getData(),"IMAGE");
				break;
				
			case CAMERA_REQUEST_CODE:
				if(file != null){
					startPhotoZoom(Uri.fromFile(file),"CAMERA");
				}
				break;
				
			case RESULT_IMAGE_CODE:
				if(imageUri != null){
					try {
						Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
						photoName = System.currentTimeMillis() + ".png";
						photoPath = path + photoName;
						imageTools.savePhotoToSDCard(bitmap, photoPath);
						
						pictureBean = new PictureBean();
						pictureBean.setPhotoName(photoName);
						pictureBean.setPhotoPath(photoPath);
						pictureBean.setPhotoUri(imageUri);
						
						arrList.add(pictureBean);
						adapter.notifyDataSetChanged();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}				
				}
				break;
				
			case RESULT_CAMERA_CODE:
				if(imageUri != null){
					try {
						photoName = System.currentTimeMillis() + ".png";
						photoPath = path + photoName;
						
						pictureBean = new PictureBean();
						pictureBean.setPhotoName(photoName);
						pictureBean.setPhotoPath(photoPath);
						pictureBean.setPhotoUri(imageUri);
						
						arrList.add(pictureBean);
						adapter.notifyDataSetChanged();
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}
				break;	
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	/**
	 * 创建文件夹
	 */
	public void createSDCardDir(String strPath){
		File path1 = new File(path);
		if (!path1.exists()) {
			path1.mkdirs();
		}
	}
	
	/**
	 * 裁剪图片方法实现
	 * 
	 * @param uri
	 */
	public void startPhotoZoom(Uri uri,String sign) {
		imageUri = uri;
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("scale", true);
		intent.putExtra("return-data", false);
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 200);
		intent.putExtra("outputY", 200);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
		if(sign.equals("IMAGE")){
			startActivityForResult(intent, RESULT_IMAGE_CODE);
		}else if(sign.equals("CAMERA")){
			startActivityForResult(intent, RESULT_CAMERA_CODE);
		}
		
	}
	
	public void showIsDeleteDialog(final int i){
		
		Dialog dialog = new AlertDialog.Builder(this)
		.setTitle("提示")
		.setMessage("是否确认删除图片?")
		.setPositiveButton("确定", 
		new  DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				File path = new File(arrList.get(i).getPhotoPath());
				path.delete();
				arrList.remove(i);
				adapter.notifyDataSetChanged();
			}
			
		})
		.setNeutralButton("取消", 
		new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).create();
		dialog.setCancelable(false);
		dialog.show();
	}
	
	public void getAttribute(View v){
		for(PictureBean pictureBean : arrList){
			Log.i("log", pictureBean.getPhotoName()+","+pictureBean.getPhotoPath());
		}
	}
}
