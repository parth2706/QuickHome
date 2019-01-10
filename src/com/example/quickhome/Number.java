package com.example.quickhome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Number extends Activity {
public static String no1="";
public static final String Number="Number";
public static final String DEFAULT="";
TextView Text;
EditText edit;
Button butt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.number);
		
		Text=(TextView) findViewById(R.id.textView1);
edit=(EditText) findViewById(R.id.editText1);
	butt=(Button)  findViewById(R.id.button1);
	 SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

	 String NAME1=saved_values.getString(Number,DEFAULT);
edit.setText(NAME1);	
	}
	public void goBack(View view) {
		// TODO Auto-generated method stub
no1= edit.getText().toString();
SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
SharedPreferences.Editor editor=saved_values.edit();
    editor.putString(Number,no1);
    editor.commit();
Intent i= new Intent("com.example.quickhome.DRAWER");
startActivity(i);
	}
}
