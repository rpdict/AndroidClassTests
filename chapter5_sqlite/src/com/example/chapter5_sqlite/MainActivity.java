package com.example.chapter5_sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//打开或创建数据库
        SQLiteDatabase db = openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);  
        db.execSQL("DROP TABLE IF EXISTS person");  
        
        //创建person表
        db.execSQL("CREATE TABLE person (_id INTEGER PRIMARY KEY AUTOINCREMENT, name text, age integer)");

        //插入数据  
       db.execSQL("INSERT INTO person(name,age) VALUES ('mike', 12)");  //第一种写法
       db.execSQL("INSERT INTO person(name,age) VALUES (?, ?)", new Object[]{"lilei", 20});  //第二种写法
       //ContentValues以键值对的形式存放数据  ，第三种写法
       ContentValues cv = new ContentValues();  
       cv.put("name", "hanmeimei");  
       cv.put("age", 22);  
       //插入ContentValues中的数据  
       db.insert("person", null, cv); 
       
       //查询数据
       Cursor c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"5"});  
       while (c.moveToNext()) {  
           int _id = c.getInt(c.getColumnIndex("_id"));  
           String name = c.getString(c.getColumnIndex("name"));  
           int age = c.getInt(c.getColumnIndex("age"));  
           Log.i("db", "_id=>" + _id + ", name=>" + name + ", age=>" + age);  
       }  
       c.close(); 
       
       //更新数据
       db.execSQL("update person set age=100 where name='mike'");  //第一种写法
       db.execSQL("update person set age=? where name=?", new Object[]{101,"lilei"});  //第二种写法
       //ContentValues以键值对的形式存放数据  ，第三种写法
       cv = new ContentValues();  
       cv.put("age", 102);  
       //插入ContentValues中的数据  
       db.update("person", cv, "name = ?", new String[]{"hanmeimei"});  
       
       //删除数据  
       db.execSQL("delete from person where name='mike'");  //第一种写法
       db.execSQL("delete from person where name=?", new Object[]{"lilei"});  //第二种写法
       db.delete("person", "name=?", new String[]{"hanmeimei"});
       
       //关闭当前数据库  
       db.close();
       
       //删除test.db数据库  
       deleteDatabase("test.db");
       
	}

	
}
