package com.webbrowser;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	protected static final int RESULT_SPEECH = 1;
	private EditText editText;
	private String address = "";

	private Button actionButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionButton = (Button)findViewById(R.id.speakBt);
		actionButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				editText = (EditText)findViewById(R.id.editText1);
				address = editText.getText().toString();
				editText.setText("");
				
				if(address == null || address.equals(""))					
				{
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
				else
					openWebPage();			
			}
		});
		
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
	 
	 public void openWebPage()
	 {
		Intent i = new Intent(MainActivity.this,WebViewActivity.class);
		i.putExtra("url", address);
		i.putExtra("flag", "webpage");
		startActivity(i);		 
	 }
	 
	 public void takeAction(String input)
	 {
		 if(input.equalsIgnoreCase("e-mail") || input.equalsIgnoreCase("email"))
		 {
			 Intent i = new Intent(MainActivity.this, EmailPage.class);
			 startActivity(i);
		 }
		 else if(input.equalsIgnoreCase("exit"))
			 		System.exit(0);
		 else
		 {
			 address = input;
//			 formAddress();
			 openWebPage();
		 }		 
	 }
	 
/*	 public void formAddress()
	 {
		 if(address.equals(""))
			 return;
		 else
		 {
			 if(address.contains("."))
			 {
				 if(!address.contains("www"))
					 address = "http://www." + address + "/";
				 else
					 address = "http://" + address + "/";
			 }
			 else
			 {
				 address = "http://www." + address + ".com/";
			 }	 
		 }		 
	 }
	
*/	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
