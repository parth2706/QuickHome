package com.example.quickhome;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ToggleButton;

public class Mylayout extends Activity {
	ToggleButton mytogfan1,mytogfan2,mytoglight1,mytoglight2,mytogac;
	String on="ON";
	String off="OFF";
	String value1,value2,value3,value4,value5;
	String label_fan1,label_fan2,label_light1,label_light2,label_ac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
			
		
		
		mytogfan1 = (ToggleButton) findViewById(R.id.myfan1);
		mytogfan2 = (ToggleButton) findViewById(R.id.myfan2);
		mytoglight1 = (ToggleButton) findViewById(R.id.mylight1);
		mytoglight2 = (ToggleButton) findViewById(R.id.mylight2);
		mytogac = (ToggleButton) findViewById(R.id.myac);
			
		SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    	value1=saved_values.getString(Fans.F1state,Fans.DEFAULT );
    	 label_fan1=saved_values.getString(Fans.Label11, Fans.DEFAULT);
    	
    	value2=saved_values.getString(Fans.F2state,Fans.DEFAULT );
    	 label_fan2=saved_values.getString(Fans.Label12, Fans.DEFAULT);
    	
    	value3=saved_values.getString(Lights.L1state,Lights.DEFAULT );
    	 label_light1=saved_values.getString(Lights.Label21, Fans.DEFAULT);
    	
    	value4=saved_values.getString(Lights.L2state,Lights.DEFAULT );
    	 label_light2=saved_values.getString(Lights.Label22, Fans.DEFAULT);
    	
    	value5=saved_values.getString(ACS.A1state,Fans.DEFAULT );
    	 label_ac=saved_values.getString(ACS.Label31, Fans.DEFAULT);
    	
    	if (value1.equals(on))
    	mytogfan1.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
    	else
    mytogfan1.setChecked(false);
    	
    	mytogfan1.setText(label_fan1);
    	//mytogfan1.setTextOff(label_fan1);
    	
    	
    	if (value2.equals(on))
        	mytogfan2.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
        	else
        mytogfan2.setChecked(false);
        	
        	mytogfan2.setText(label_fan2);
        //	mytogfan2.setTextOff(label_fan2);
        	
        	
        	if (value3.equals(on))
            	mytoglight1.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
            	else
            mytoglight1.setChecked(false);
            	
            	mytoglight1.setText(label_light1);
            	//mytoglight1.setTextOff(label_light1);
            	
            	
            	if (value4.equals(on))
                	mytoglight2.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
                	else
                mytoglight2.setChecked(false);
                	
                	mytoglight2.setText(label_light2);
                //	mytoglight2.setTextOff(label_light2);
                	
                	if (value5.equals(on))
                    	mytogac.setChecked(true);  	//Log.i("Divya","works till hre state1 "+STATE1);                       
                    	else
                    mytogac.setChecked(false);
                    	
                    	mytogac.setText(label_ac);
                    //	mytogac.setTextOff(label_ac);

    	/*	String value2=saved_values.getString(Fans.F2state,Fans.DEFAULT );
     	int progress11=saved_values.getInt(Fans.Progress11, 0);
        int progress12=saved_values.getInt(Fans.Progress12, 0);
        int progress21=saved_values.getInt(Lights.Progress21, 0);
        int progress22=saved_values.getInt(Lights.Progress22, 0);
        int progress31=saved_values.getInt(ACS.Progress31, 0);
        int progress32=saved_values.getInt(ACS.Progress32, 0);
    	String value3=saved_values.getString(Lights.L1state,Lights.DEFAULT );
    	String value4=saved_values.getString(Lights.L2state,Lights.DEFAULT );
    	String value5=saved_values.getString(ACS.A1state,ACS.DEFAULT );
    	String value6=saved_values.getString(ACS.A2state,ACS.DEFAULT );
   
    	if (value1.equals(Drawer.on))
		{	mytogfan.setChecked(true); //Log.i("Divya","works till hre state1 "+STATE1);
		    
		}
		else 
		mytogfan.setChecked(false);
    	 */
    	//SharedPreferences.Editor editor=saved_values.edit();
	  //   editor.putString(Fans.F1state,value1);
	  //   editor.commit();
	}
	 
	
	public void clickmefan1(View view) {
		// TODO Auto-generated method stub
		mytogfan1.setText(label_fan1);
		 boolean state_b1try= ((ToggleButton) view).isChecked();
		 String state,name;
		 if(state_b1try == true)
			 state="ON";
		 else
			 state="OFF";
		   name="Fan1";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			    // editor.putString(Fans.F1name,name);
			     editor.putString(Fans.F1state,state);
			     editor.commit();
	}
	public void clickmefan2(View view) {
		// TODO Auto-generated method stub
		mytogfan2.setText(label_fan2);
		boolean state_b1try= ((ToggleButton) view).isChecked();
		 String state,name;
		 if(state_b1try == true)
			 state="ON";
		 else
			 state="OFF";
		//   name="Fan2";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			    // editor.putString(Fans.F1name,name);
			     editor.putString(Fans.F2state,state);
			     editor.commit();
	}
	public void clickmelight1(View view) {
		// TODO Auto-generated method stub
		mytoglight1.setText(label_light1); 
		boolean state_b1try= ((ToggleButton) view).isChecked();
		 String state,name;
		 if(state_b1try == true)
			 state="ON";
		 else
			 state="OFF";
	//	   name="Fan1";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			    // editor.putString(Fans.F1name,name);
			     editor.putString(Lights.L1state,state);
			     editor.commit();
	}
	public void clickmelight2(View view) {
		// TODO Auto-generated method stub
		mytoglight2.setText(label_light2);
		 boolean state_b1try= ((ToggleButton) view).isChecked();
		 String state,name;
		 if(state_b1try == true)
			 state="ON";
		 else
			 state="OFF";
	//	   name="Fan1";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			    // editor.putString(Fans.F1name,name);
			     editor.putString(Lights.L2state,state);
			     editor.commit();
	}
	public void clickmeac(View view) {
		// TODO Auto-generated method stub
		mytogac.setText(label_ac);
		 boolean state_b1try= ((ToggleButton) view).isChecked();
		 String state,name;
		 if(state_b1try == true)
			 state="ON";
		 else
			 state="OFF";
	//	   name="Fan1";
		   SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			 SharedPreferences.Editor editor=saved_values.edit();
			    // editor.putString(Fans.F1name,name);
			     editor.putString(ACS.A1state,state);
			     editor.commit();
	} 
	
}
