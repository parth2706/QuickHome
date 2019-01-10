package com.example.quickhome;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView usertext,passtext,welcome; 
		final Button blogin;
		final EditText username,password;
		
	
		
		 blogin = (Button) findViewById(R.id.blogin);
	     username=(EditText) findViewById(R.id.username);
	     password=(EditText) findViewById(R.id.password);
	     welcome=(TextView) findViewById(R.id.welcome);
	
		
	     
	        blogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String str1,str2,p,q;
				p="a";
				q="b";
				str1 = username.getText().toString();
				str2 = password.getText().toString();
			if( str1.compareTo(p) == 0 && str2.compareTo(q)==0 )
				{ welcome.setText("WELCOME "+str1 +" "+ str2);
				Thread timer = new Thread(){
					public void run(){
					try{ 
						sleep(1500);
						}
					
					catch(InterruptedException e)
					{
						 e.printStackTrace();
						
					}
					finally{
						Intent in = new Intent("com.example.quickhome.DRAWER");
						startActivity(in);
						
					}
					}
					
				} ;
				timer.start();
				}
		                			
			
			else
				welcome.setText("ACCESS DENIED");
		}
		
		});
	}
	protected void onPause()
	{
		super.onPause();
		finish();
	}


	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
*/
