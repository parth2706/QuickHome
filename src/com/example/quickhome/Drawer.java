package com.example.quickhome;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Drawer extends ListActivity {
	String appliance[]={"Fan","Lights","ACS","Mylayout"};
	ListView l;
	 public static final String on="ON";
	 public static final String off="OFF";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.drawer);
	l=getListView();
	ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,appliance);
	l.setAdapter(adapter);
	
	
	}
  
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	TextView temp=(TextView) v;
  //  Toast.makeText(this,""+temp.getText()+" "+position,Toast.LENGTH_SHORT).show();
    
    if(position==0)
     {Intent in = new Intent("com.example.quickhome.FANS");
	       startActivity(in);
     }
    if(position==1)
    {Intent in = new Intent("com.example.quickhome.LIGHTS");
	       startActivity(in);
    }
    if(position==2)
    {Intent in = new Intent("com.example.quickhome.ACS");
	       startActivity(in);
    }
    if(position==3)
    {Intent in = new Intent("com.example.quickhome.MYLAYOUT");
	       startActivity(in);
    }
	}
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.menu, menu);
		return true;
	}
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.send_message:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
      
        	StringBuffer buffer=new StringBuffer();
        	SharedPreferences saved_values = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        	
        	String value1=saved_values.getString(Fans.F1state,Fans.DEFAULT );
        	String value2=saved_values.getString(Fans.F2state,Fans.DEFAULT );
         	int progress11=saved_values.getInt(Fans.Progress11, 0);
        //    int progress12=saved_values.getInt(Fans.Progress12, 0);
         //   int progress21=saved_values.getInt(Lights.Progress21, 0);
            int progress22=saved_values.getInt(Lights.Progress22, 0);
       //     int progress31=saved_values.getInt(ACS.Progress31, 0);
       //     int progress32=saved_values.getInt(ACS.Progress32, 0);
        	String value3=saved_values.getString(Lights.L1state,Lights.DEFAULT );
        	String value4=saved_values.getString(Lights.L2state,Lights.DEFAULT );
        	String value5=saved_values.getString(ACS.A1state,ACS.DEFAULT );
        //	String value6=saved_values.getString(ACS.A2state,ACS.DEFAULT );
        	
        	if(value1.equals(on))
        	{buffer.append("a");
        	 buffer.append(progress11);
        	}else 
        	{buffer.append("b");
        
        	}
        	if(value2.equals(on))
        	{	buffer.append("c");
        	//buffer.append(progress12);
        	}	else 
            	buffer.append("d");
        	
        	if(value3.equals(on))
            	{buffer.append("e");
            //	buffer.append(progress21);
            	}else 
            	buffer.append("f");
        	
        	if(value4.equals(on))
            	{buffer.append("g");
            	buffer.append(progress22);
            	}else 
            	buffer.append("h");
        	
        	if(value5.equals(on))
            	{buffer.append("i");
            	//buffer.append(progress31); 
            	}else 
            	buffer.append("j");
        	
     //   	if(value6.equals(on))
     //   	{	buffer.append("k");
     //              buffer.append(progress32);        	
      //  	}	else 
      //      	buffer.append("l");
        	String number=Number.no1;
        	String message=buffer.toString();
          Toast.makeText(Drawer.this, "Message has been sent "+message, Toast.LENGTH_SHORT).show();
         	SmsManager sms= SmsManager.getDefault();
          	sms.sendTextMessage(number,null,message,null,null);
            return true;
            
        case R.id.number_save:
        	 Toast.makeText(Drawer.this, "Save your number", Toast.LENGTH_SHORT).show();
        	 Intent i= new Intent("com.example.quickhome.NUMBER");
        	 startActivity(i);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}


