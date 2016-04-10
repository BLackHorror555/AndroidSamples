package com.nnsu.mobileweek;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SimpleCallerActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */    
	Button btnCall;
	EditText numberField;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        btnCall = (Button)findViewById(R.id.btnCall);
        numberField = (EditText)findViewById(R.id.Number);
        btnCall.setOnClickListener(this);
    }
    
    private void phoneCall() {     	
     String phoneCallUri = "tel:" + numberField.getText().toString();
     Intent phoneCallIntent = new Intent(Intent.ACTION_DIAL);
     phoneCallIntent.setData(Uri.parse(phoneCallUri));
     startActivity(phoneCallIntent);
    }

 public void onClick(View v) {
    phoneCall();
  }
}