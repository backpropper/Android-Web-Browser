package com.webbrowser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UsernamePassword extends Activity 
{
	
	protected static final int RESULT_SPEECH = 1;
	private String email;
	private Button speakBt;
	private String username;
	private String password;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.username_password_field);	
		
		Bundle extra = getIntent().getExtras();
		email = extra.getString("email");
		
		EditText emailField = (EditText)findViewById(R.id.editText2);
		emailField.setText(email);
		if(!(email == null || email.equalsIgnoreCase("")))
			emailField.setFocusable(false);
		
		speakBt = (Button)findViewById(R.id.speakBt);
		speakBt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{	// TODO Auto-generated method stub				
/*				Intent speechEngine = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
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
*/			
				EditText username = (EditText)findViewById(R.id.editText1);
				EditText password = (EditText)findViewById(R.id.editText3);
				
				Intent i = new Intent(UsernamePassword.this, WebViewActivity.class);
				i.putExtra("flag", "mail");
				i.putExtra("username", username.getText().toString());
				i.putExtra("password", password.getText().toString());
				if(email.equals(""))
					email = ((EditText)findViewById(R.id.editText2)).getText().toString();
				
				i.putExtra("url", email);
				
				startActivity(i);
				
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
