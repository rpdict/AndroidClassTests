package com.example.chapter6_camera;

import android.net.Uri;

public class PictureBean {
	private String photoPath;
	private Uri photoUri;
	private String photoName;
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public Uri getPhotoUri() {
		return photoUri;
	}
	public void setPhotoUri(Uri photoUri) {
		this.photoUri = photoUri;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
}
