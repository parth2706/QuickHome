package com.example.quickhome;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Lights extends Activity  {
	 ToggleButton TB21,TB22;
	 EditText label21,label22;
	 SeekBar seek21,seek22;
	Button B1;
	 Context context;
	 public static final String L1name="Light1name";
	 public static final String L1state="Light1state";
	 public static final String L2name="Light2name";
	 public static final String L2state="Light2state";
	 public static final String Label21="LIGHTS1";
		public static final String Label22="LIGHTS2";
	 public static final String on="ON";
	 public static final String off="OFF";
	 public static final String Progress21="prog21";
	 public static final String Progress22="prog22";
	 public static final String DEFAULT="N/A";
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	super.onCreate(savedInstanceState);
	setContentView(R.layout.light);
//	final TextView TV;
//	boolean val_but1,val_but2;
	TB21 = (ToggleButton) findViewById(R.id.TB21);
	TB22 = (ToggleButton) findViewById(R.id.TB22);
	label21= (EditText) findViewById (R.id.editlit1);
	label22=	(EditText) findViewById (R.id.editlit2);
//	 seek21=(SeekBar) findViewById(R.id.seekBar21);
	 seek22=(SeekBar) findViewById(R.id.seekBar22);
	 
//	B1=(Button) findViewById(R.id.button1);
	//B2=(Button) findViewById(R.id.button2);
	 SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

String NAME1=saved_values.getString(L1name,DEFAULT);
String STATE1=saved_values.getString(L1state,DEFAULT );
String NAME2=saved_values.getString(L2name,DEFAULT);
String STATE2=saved_values.getString(L2state,DEFAULT );
String label1_string=saved_values.getString(Label21,DEFAULT);
String label2_string=saved_values.getString(Label22,DEFAULT);
//int progress21=saved_values.getInt(Progress21, 0);
int progress22=saved_values.getInt(Progress22, 0);
label21.setText(label1_string);
label22.setText(label2_string);
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
	TB21.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
else 
TB21.setChecked(false);
Log.i("Divya","works till hre state1 "+STATE1);

if (STATE2.equals(on))

	TB22.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
else 
TB22.setChecked(false);
Log.i("Divya","works till hre state2 "+STATE2);
//seek21.setProgress(progress21);
seek22.setProgress(progress22);
	Log.i("Divya","thuisis oncreate method for light");
	
	}

	
	
	public void onlight1(View view) {
		// TODO Auto-generated method stub
		Log.i("Manan","thuisis shownn wen u have clicked 1");
	//	 Toast.makeText(context," TB11 toggle button clicked",Toast.LENGTH_SHORT ).show();        //
	//	Message.message(this, "TB21 toggle button clicked");
		 boolean state_b1= ((ToggleButton) view).isChecked();
		 Log.i("Manan","thuisis state of button 1"+state_b1);
		        // your click actions go here
		
		 
		 String state,name;
		 if(state_b1 == true)
			 state="ON";
		 else
			 state="OFF";
		   name="Light1";
		    Log.i("Manan","thuisis state of button 1"+state+"and name is "+name);
		    SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(L1name,name);
			     editor.putString(L1state,state);
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
	//	   seek21=(SeekBar) findViewById(R.id.seekBar21);
	//		 if(state == "ON")
	//		   seek21.setProgress(2);
	//		 else
	//			 seek21.setProgress(0);
	}
	
	
	
	public void onlight2(View view) {
		// TODO Auto-generated method stub
		Log.i("Manan","thuisis shownn wen u have clicked 2");
		// Toast.makeText(getApplicationContext()," TB22 toggle button clicked",Toast.LENGTH_SHORT ).show();
		 boolean state_b2= ((ToggleButton) view).isChecked();
		 Log.i("Manan","thuisis state of button 2"+state_b2);
		        // your click actions go here
		
		 
		 String state,name;
		 if(state_b2 == true)
			 state="ON";
		 else
			 state="OFF";
		   name="Light2";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			     editor.putString(L2name,name);
			     editor.putString(L2state,state);
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
	*/
		   seek22=(SeekBar) findViewById(R.id.seekBar22);
			 if(state == "ON")
				   seek22.setProgress(2);
				 else
					 seek22.setProgress(0);
	}
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("Divya","thuisis onStart method");
	}
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("Divya","thuisis onresume method");
	}
	//letsCheck();
	
	/*public  void letsCheck()
	{
	TB21.setOnClickListener(new OnClickListener()
	{
	    @Override
	    public void onClick(View v)
	    { Toast.makeText(context," TB21 toggle button clicked",Toast.LENGTH_SHORT );
	        // your click actions go here
	    }
	});
	}*/
	
	 @Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
			label21= (EditText) findViewById (R.id.editlit1);
			label22=	(EditText) findViewById (R.id.editlit2);
	//		seek21=(SeekBar) findViewById(R.id.seekBar21);
			seek22=(SeekBar) findViewById(R.id.seekBar22);
			String name1=label21.getText().toString();
			String name2=label22.getText().toString();
			  SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
				 SharedPreferences.Editor editor=saved_values.edit();
				     editor.putString(Label21,name1);
				     editor.putString(Label22,name2);
			//	     editor.putInt(Progress21, seek21.getProgress());
				     editor.putInt(Progress22, seek22.getProgress());
				     editor.commit();
		 
		 }
}
