package com.example.quickhome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.*;
//import android.widget.SeekBar.OnSeekBarChangeListener;
//import android.view.View.OnClickListener;

public class Fans extends Activity  {
	 ToggleButton TB11,TB12;
	 SeekBar seek1,seek2;
	 EditText label11,label12;
	 Button B1,B2;
	 Context context;
	 public static final String F1name="F1name";
	 public static final String F1state="F1state";
	 public static final String F2name="F2name";
	 public static final String F2state="F2state";
	public static final String Label11="FAN1";
	public static final String Label12="FAN2";
	 public static final String on="ON";
	 public static final String off="OFF";
	 public static final String Progress11="prog11";
	 public static final String Progress12="prog12";
//	String name1,name2;
	 public static final String DEFAULT="N/A";
	 int progress = 0;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	super.onCreate(savedInstanceState);
	setContentView(R.layout.fan);
//	final TextView TV;
//	boolean val_but1,val_but2;
	TB11 = (ToggleButton) findViewById(R.id.TB11);
	TB12 = (ToggleButton) findViewById(R.id.TB12);
	label11= (EditText) findViewById (R.id.editfan1);
	label12=	(EditText) findViewById (R.id.editfan2);
	 seek1=(SeekBar) findViewById(R.id.seekBar11);
	// seek2=(SeekBar) findViewById(R.id.seekBar12);
//	B1=(Button) findViewById(R.id.button1);
//	B2=(Button) findViewById(R.id.button2);
	 SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

String NAME1=saved_values.getString(F1name,DEFAULT);
String STATE1=saved_values.getString(F1state,DEFAULT );
String NAME2=saved_values.getString(F2name,DEFAULT);
String STATE2=saved_values.getString(F2state,DEFAULT );
String label1_string=saved_values.getString(Label11,DEFAULT);
String label2_string=saved_values.getString(Label12,DEFAULT);
int progress11=saved_values.getInt(Progress11, 0);
//int progress12=saved_values.getInt(Progress12, 0);
label11.setText(label1_string);
label12.setText(label2_string);
Log.i("Divya",NAME1+"is"+STATE1);
Log.i("Divya",NAME2+"is"+STATE2);

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
Log.i("Divya","works till hre state1 "+STATE1);
Log.i("Divya","works till hre state2 "+STATE2);




if (STATE1.equals(on))
{	TB11.setChecked(true); //Log.i("Divya","works till hre state1 "+STATE1);
    
}
else 
TB11.setChecked(false);

Log.i("Divya","works till hre state1 "+STATE1);

if (STATE2.equals(on))
{
	TB12.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
    
}
	else 
TB12.setChecked(false);

Log.i("Divya","works till hre state2 "+STATE2);
seek1.setProgress(progress11);
//seek2.setProgress(progress12);
	
	Log.i("Divya","thuisis oncreate method for fan");
	
	}

	
	
	public void onPressfan1(View view) {
		// TODO Auto-generated method stub
		Log.i("Manan","thuisis shownn wen u have clicked 1");
	//	 Toast.makeText(context," TB11 toggle button clicked",Toast.LENGTH_SHORT ).show();        //
	//	Message.message(this, "TB11 toggle button clicked");
		 boolean state_b1= ((ToggleButton) view).isChecked();
		 Log.i("Manan","thuisis state of button 1"+state_b1);
		        // your click actions go here
		
		 
		 String state,name;
		 if(state_b1 == true)
			 state="ON";
		 else
			 state="OFF";
		   name="Fan1";
		    Log.i("Manan","thuisis state of button 1"+state+"and name is "+name);
		    SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(F1name,name);
			     editor.putString(F1state,state);
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
		   seek1=(SeekBar) findViewById(R.id.seekBar11);
		 if(state == "ON")
		   seek1.setProgress(2);
		 else
			 seek1.setProgress(0);
		//   seek1.setOnSeekBarChangeListener(this);
				  
				  
				 
			   
		   //seek1.setOnSeekBarChangeListener(l);
		//   seek1.setVisibility(View.VISIBLE);
		/*   Thread mythread=new Thread(){
			   public void run()
			   {  
				   try{ 
						sleep(5000);
						}
					
					catch(InterruptedException e)
					{
						 e.printStackTrace();
						
					}
					finally{
						Log.i("Parth","working before");
						 seek1.setVisibility(View.INVISIBLE);
						Log.i("Parth","working after");
						//finish();
					}
				   
			   }
			   
		   };
		   mythread.start();
		*/
	
	/*
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
finish();
	}
	*/
/*	// @Override
	  public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
		//  progress = progresValue;
		  //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
	  }
	
	//  @Override
	  public void onStartTrackingTouch(SeekBar seekBar) {
	//	  Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
	 }
	
	  @Override
	  public void onStopTrackingTouch(SeekBar seekBar) {
		//  textView.setText("Covered: " + progress + "/" + seekBar.getMax());
		  Toast.makeText(getApplicationContext(), "Stopped tracking seekbar "+seek1.getProgress(), Toast.LENGTH_SHORT).show();
	*/
	  }
	public void onfan2(View view) {
		// TODO Auto-generated method stub
		Log.i("Manan","thuisis shownn wen u have clicked 2");
//		 Toast.makeText(getApplicationContext()," TB12 toggle button clicked",Toast.LENGTH_SHORT ).show();
		 boolean state_b2= ((ToggleButton) view).isChecked();
		 Log.i("Manan","thuisis state of button 2"+state_b2);
		        // your click actions go here
		
		 
		 String state,name;
		 if(state_b2 == true)
			 state="ON";
		 else
			 state="OFF";
		   name="Fan2";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(F2name,name);
			     editor.putString(F2state,state);
			     editor.commit();
		   Log.i("Divya", "Data was saved successfully");
		//  long id= vivzhelpers.updateState(name, state);
		 //   if(id<0)
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
	//	   seek2=(SeekBar) findViewById(R.id.seekBar12);
	//		 if(state == "ON")
	//			   seek2.setProgress(2);
	//			 else
	//				 seek2.setProgress(0);
		 //  seek2.setOnSeekBarChangeListener(this) ;
	}
	 @Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		label11= (EditText) findViewById (R.id.editfan1);
		label12=	(EditText) findViewById (R.id.editfan2);
		seek1=(SeekBar) findViewById(R.id.seekBar11);
	//	seek2=(SeekBar) findViewById(R.id.seekBar12);
		String name1=label11.getText().toString();
		String name2=label12.getText().toString();
		  SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(Label11,name1);
			     editor.putString(Label12,name2);
			     editor.putInt(Progress11, seek1.getProgress());
			 //    editor.putInt(Progress12, seek2.getProgress());
			     editor.commit();
	 
	 }
	 
}
