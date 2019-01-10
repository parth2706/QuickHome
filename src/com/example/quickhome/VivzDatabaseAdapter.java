package com.example.quickhome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VivzDatabaseAdapter  {
	
	VivzHelper helper;
public VivzDatabaseAdapter(Context context) {
	// TODO Auto-generated constructor stub
helper=new VivzHelper(context);
}
	
	public long insertData(String name,String state)
	{
		SQLiteDatabase db=helper.getWritableDatabase();
       ContentValues contentValues=new ContentValues();
        contentValues.put(VivzHelper.NAME, name);
       contentValues.put(VivzHelper.STATE, state);
		long id=db.insert(VivzHelper.TABLE_NAME, null, contentValues); 
	return id;
	}
	/*
	public String getAllData()
	{
		SQLiteDatabase db=helper.getWritableDatabase();
		
	String columns[]={VivzHelper.UID,VivzHelper.NAME,VivzHelper.STATE};
		Cursor cursor=db.query(VivzHelper.TABLE_NAME, columns, null, null, null, null, null);
		StringBuffer buffer=new StringBuffer();
	int i=cursor.getCount();
		Log.i("Divya","row number is"+i);
		while(cursor.moveToNext())
		{ // int index1=cursor.getColumnIndex(VivzHelper.UID);
			int cid=cursor.getInt(0);
		//	int a,b;
			String name,state;
			//a=cursor.getColumnIndex(VivzHelper.NAME);
           name=cursor.getString(1);
         //  b=cursor.getColumnIndex(VivzHelper.STATE);
           state=cursor.getString(2);
           Log.i("Divya","id "+cid+" name "+name+" state "+state);
		buffer.append(cid+" "+name+" "+state+"\n");
		}
	return buffer.toString();
	}
	public String getState(String Name) {
		// TODO Auto-generated method stub
		//String state="";
		SQLiteDatabase db=helper.getReadableDatabase();
		String columns[]={VivzHelper.STATE};
		String[] selectionArgs={Name};
		Cursor cursor=db.query(VivzHelper.TABLE_NAME, columns, VivzHelper.NAME+" =? ", selectionArgs, null, null, null);
		StringBuffer buffer=new StringBuffer();
		int i=cursor.getCount();
		Log.i("Divya","row number is"+i);
		while(cursor.moveToNext())
		{ String state=cursor.getString(2);
		buffer.append(state); 
		}
		return  buffer.toString();
	}
	public int updateState(String Name,String State) {
		// TODO Auto-generated method stub
SQLiteDatabase db=helper.getWritableDatabase(); 
	ContentValues contentValues=new ContentValues();	
	contentValues.put(VivzHelper.STATE, State);
	String whereArgs[]={Name};
		return db.update(VivzHelper.TABLE_NAME, contentValues,VivzHelper.NAME+" =? " , whereArgs);
	}
	public void deleteRow() {
		// TODO Auto-generated method stub
		SQLiteDatabase db=helper.getWritableDatabase(); 
		//String whereArgs[]={""};
		db.delete(VivzHelper.TABLE_NAME, null,null );
		//VivzHelper.UID=0;
		
	}
	*/
	static class VivzHelper extends SQLiteOpenHelper
	{
		private static final String DATABASE_NAME= "mytable";
		private static final String TABLE_NAME="VIVZTABLE";
		private static final String UID="_id";
		private static final String NAME="Name";
		private static final String STATE="State";
		private static final int DATABASE_VERSION=5;
		private static final String CREATE_TABLE="CREATE TABLE " + TABLE_NAME+ " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+STATE +" VARCHAR(255));";
		private static final String DROP_TABLE="DROP TABLE "+TABLE_NAME+" IF EXISTS";
		private Context context;
		VivzHelper(Context context)
	  {
	super(context,DATABASE_NAME, null, DATABASE_VERSION) ;
	context=this.context;
	  }
	  
	 public void onCreate(SQLiteDatabase db) 
	{  try{
		db.execSQL(CREATE_TABLE);
		Message.message(context, "onCreate called");
	    //onCreate(db); 
		} 
	catch(SQLException e)
	  {  
	  Message.message(context, ""+e);
	   // can print any log statements here
	  }

	}


	 public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) 
	{ //db.execSQL("DROP TABLE IF EXISTS VIVZTABLE");
	try{Message.message(context,"onupgrade called");
	db.execSQL(DROP_TABLE);
	onCreate(db);  
}catch(SQLException e)
{ Message.message(context, ""+e);
	}
		
	}
	}
 }



