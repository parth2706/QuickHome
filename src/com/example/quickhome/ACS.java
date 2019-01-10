package com.example.quickhome;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
//import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ACS extends Activity  {
	 ToggleButton TB31,TB32;
	 EditText label31,label32;
	 SeekBar seek31,seek32;
	// Button B1,B2;
	 Context context;
	 public static final String A1name="AC1name";
	 public static final String A1state="A1state";
	 public static final String A2name="A2name";
	 public static final String A2state="A2state";
	 public static final String Label31="ACS1";
		public static final String Label32="ACS2";
	 public static final String on="ON";
	 public static final String off="OFF";
	 public static final String Progress31="prog31";
	 public static final String Progress32="prog32";
	
	 public static final String DEFAULT="N/A";
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	super.onCreate(savedInstanceState);
	setContentView(R.layout.acs);
//	final TextView TV;
//	boolean val_but1,val_but2;
	TB31 = (ToggleButton) findViewById(R.id.TB31);
//	TB32 = (ToggleButton) findViewById(R.id.TB32);
	label31= (EditText) findViewById (R.id.editac1);
//	label32=	(EditText) findViewById (R.id.editfan2);
//	seek31=(SeekBar) findViewById(R.id.seekBar31);
//	 seek32=(SeekBar) findViewById(R.id.seekBar32);
	//B1=(Button) findViewById(R.id.button1);
	//B2=(Button) findViewById(R.id.button2);
	 SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

String NAME1=saved_values.getString(A1name,DEFAULT);
String STATE1=saved_values.getString(A1state,DEFAULT );
//String NAME2=saved_values.getString(A2name,DEFAULT);
//String STATE2=saved_values.getString(A2state,DEFAULT );
String label1_string=saved_values.getString(Label31,DEFAULT);
//String label2_string=saved_values.getString(Label32,DEFAULT);
//int progress31=saved_values.getInt(Progress31, 0);
//int progress32=saved_values.getInt(Progress32, 0);
label31.setText(label1_string);
//label32.setText(label2_string);
Log.i("Divya",NAME1+"is"+STATE1);
//Log.i("Divya",NAME2+"is"+STATE2);

/*
if (NAME1.equals(DEFAULT) && STATE1.equals(DEFAULT))
Message.message(this, "Data was not found for 1");
else
Message.message(this, "Data was found for 1");

if (NAME2.equals(DEFAULT) && STATE2.equals(DEFAULT))
Message.message(this, "Data was not found for 2");
else
Message.message(this, "Data was found for 2");
*/

Log.i("Divya","works till hre state1 "+STATE1+" "+NAME1);
//Log.i("Divya","works till hre state2 "+STATE2);




if (STATE1.equals(on))
	TB31.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
else 
TB31.setChecked(false);
Log.i("Divya","works till hre state1 "+STATE1);

//if (STATE2.equals(on))

//	TB32.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
//else 
//TB32.setChecked(false);
//Log.i("Divya","works till hre state2 "+STATE2);

//seek31.setProgress(progress31);
//seek32.setProgress(progress32);
	
	Log.i("Divya","thuisis oncreate method");
	
	}

	
	
	public void onACS1(View view) {
		// TODO Auto-generated method stub
		Log.i("Manan","thuisis shownn wen u have clicked 1");
	//	 Toast.makeText(context," TB11 toggle button clicked",Toast.LENGTH_SHORT ).show();        //
	//	Message.message(this, "TB31 toggle button clicked");
		 boolean state_b1= ((ToggleButton) view).isChecked();
		 Log.i("Manan","thuisis state of button 1"+state_b1);
		        // your click actions go here
		
		 
		 String state,name;
		 if(state_b1 == true)
			 state="ON";
		 else
			 state="OFF";
		   name="ACS1";
		    Log.i("Manan","thuisis state of button 1"+state+"and name is "+name);
		    SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(A1name,name);
			     editor.putString(A1state,state);
			     editor.commit();
		   Log.i("Divya", "Data was saved successfully");
		    //	  long id= vivzhelpers.updateState(name, state);    //the point here is not to insert BUT UPDATE
		//    if(id<0)
		/*
		   if(state == "ON")
		    {
		    	Message.message(this, "successful");
		    }
		    else
		    {
		    	Message.message(this, "unsuccessful");	
		    }
		    
		*/
		//   seek31=(SeekBar) findViewById(R.id.seekBar31);
		//	 if(state == "ON")
		//	   seek31.setProgress(2);
		//	 else
		//		 seek31.setProgress(0);
	}
	/*
	public void onACS2(View view) {
		// TODO Auto-generated method stub
		Log.i("Manan","thuisis shownn wen u have clicked 2");
		// Toast.makeText(getApplicationContext()," TB32 toggle button clicked",Toast.LENGTH_SHORT ).show();
		 boolean state_b2= ((ToggleButton) view).isChecked();
		 Log.i("Manan","thuisis state of button 2"+state_b2);
		        // your click actions go here
		
		 
		 String state,name;
		 if(state_b2 == true)
			 state="ON";
		 else
			 state="OFF";
		   name="ACS2";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(A2name,name);
			     editor.putString(A2state,state);
			     editor.commit();
		   Log.i("Divya", "Data was saved successfully");
		//  long id= vivzhelpers.updateState(name, state);
		 //   if(id<0)
		  /*
		   if(state.equals(on))
		    {
		    	Message.message(this, "successful");
		    }
		    else
		    {
		    	Message.message(this, "unsuccessful");	
		    }	
	
		   seek32=(SeekBar) findViewById(R.id.seekBar32);
			 if(state == "ON")
				   seek32.setProgress(2);
				 else
					 seek32.setProgress(0);
	}
	 
	
	
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("Manan","this is start");
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("Manan","this is onrestart");
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("Manan","this is resume");
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("Manan","this is destroy");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("Manan","this is pause");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("Manan","this is onstop");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i("Manan","this is onSave");
	}
	 public  void giveStatus( int switch_no,int n)
		{
			if(n==1 && switch_no==1)
				TB31.setChecked(true);
			else if(n==0 && switch_no==1)
				TB31.setChecked(false);
			else if(n==1 && switch_no==2)
				TB32.setChecked(true);
			else if(n==0 && switch_no==2)
				TB32.setChecked(false);
			
			
		}
		*/
	 @Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
			label31= (EditText) findViewById (R.id.editac1);
			//label32=	(EditText) findViewById (R.id.editfan2);
			String name1=label31.getText().toString();
		//	String name2=label32.getText().toString();
			  SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
				 SharedPreferences.Editor editor=saved_values.edit();
				     editor.putString(Label31,name1);
				  //   editor.putString(Label32,name2);
				  //   editor.putInt(Progress31, seek31.getProgress());
				  //   editor.putInt(Progress32, seek32.getProgress());
				     editor.commit();
		 
		 }
}

