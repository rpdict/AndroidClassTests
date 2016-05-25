package com.example.chapter6_camera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Õº∆¨≤Ÿ◊˜¿‡
 * 
 * add by sunpeng 
 * date 2013-07-23
 * 
 */

public class ImageTools {
	
	public ImageTools(){
		
	}
	 
	
	
	/**
	 * …Ë÷√Õº∆¨ Ù–‘
	 * add  by  sunpeng 
	 * date 2013-07-23 
	 * @param bitmap
	 * @param width
	 * @param height
	 * @return
	 */
	public  Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix matrix = new Matrix();
		float scaleWidth = ((float) width / w);
		float scaleHeight = ((float) height / h);
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
		return newbmp;
	}
	
	 /**
	  * ±£¥ÊÕº∆¨
	  * add  by sunpeng 
	  * date 2013-07-23
	  * @param photoBitmap
	  * @param path
	  */
		public  void savePhotoToSDCard(Bitmap photoBitmap,String path){
				
				File photoFile = new File(path);
				FileOutputStream fileOutputStream = null;
				try {
					fileOutputStream = new FileOutputStream(photoFile);
					if (photoBitmap != null) {
						if (photoBitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream)) {
							fileOutputStream.flush();
						}
					}
				} catch (FileNotFoundException e) {
					photoFile.delete();
					e.printStackTrace();
				} catch (IOException e) {
					photoFile.delete();
					e.printStackTrace();
				} finally{
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} 

}
