package com.webbrowser;


import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class EmailPage extends Activity{
	
	protected static final int RESULT_SPEECH = 1;
	private Button speakBt, gmail, msn, yahoo;
	private Button others;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_opt);	
		
		speakBt = (Button)findViewById(R.id.speak);
		Intent speechEngine = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		speechEngine.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-IN");
		speakBt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{	// TODO Auto-generated method stub				
				Intent speechEngine = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				speechEngine.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-IN");
				
				try
				{
					startActivityForResult(speechEngine, RESULT_SPEECH);
				}
				catch(ActivityNotFoundException e)
				{
					Toast t = Toast.makeText(getApplicationContext(),  "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
					t.show();
				}						
			}
		});
		
//		speak = (ImageButton)findViewById()
	
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	 {
	        super.onActivityResult(requestCode, resultCode, data);
	 
	        switch (requestCode) 
	        {
		        case RESULT_SPEECH: 
		        {
		            if (resultCode == RESULT_OK && null != data) 
		            {
		 
		                ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);		 
		                String input = text.get(0);
		                takeAction(input);					
		            }
		            break;
		        }	 
	        }
	    }
	
	
	
	public void takeAction(String input)
	 {
		  Log.d("EmailPage","Inside take action function\n");
		 Intent i = new Intent(EmailPage.this, UsernamePassword.class);
		 if(input.equalsIgnoreCase("gmail") || input.equalsIgnoreCase("g-mail"))
			 i.putExtra("email", "gmail.com");		
		 else if(input.equalsIgnoreCase("yahoo"))
			 		i.putExtra("email", "mail.yahoo.com");
		 else if(input.equalsIgnoreCase("aol"))
			 		i.putExtra("email", "mail.aol.com");
		 else if(input.equalsIgnoreCase("bits"))
			 i.putExtra("email", "bits-pilani-login.appspot.com");
		 else if(input.equalsIgnoreCase("exit"))
			 		System.exit(0);
		 
		 startActivity(i);
	 }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}