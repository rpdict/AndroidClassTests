package com.example.android_sdcard;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.R.integer;
import android.content.Context;
import android.os.Environment;

public class FileService {

	private Context context;

	public FileService(Context context) {
		this.context = context;
	}

	public FileService() {

	}

	public String getFileFromSdcard(String fileName) {
		FileInputStream inputStream = null;
		// ����������ʹ����޹أ�����Ҫ�ر�
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		File file = new File(Environment.getExternalStorageDirectory(),
				fileName);
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			try {
				inputStream = new FileInputStream(file);
				int len = 0;
				byte[] data = new byte[1024];
				while ((len = inputStream.read(data)) != -1) {
					outputStream.write(data, 0, len);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return new String(outputStream.toByteArray());
	}

	/**
	 * @param fileName
	 *            �ļ�������
	 * @param content
	 *            �ļ�������
	 * @return
	 */
	public boolean saveContentToSdcard(String fileName, String content) {
		boolean flag = false;
		FileOutputStream fileOutputStream = null;
		// ���sdcard�����ڵ�·��
		File file = new File(Environment.getExternalStorageDirectory(),
				fileName);
		// �ж�sdcard���Ƿ����
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			try {
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(content.getBytes());
				flag = true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
	}
}
