package com.niit.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LayoutSampleActivity extends Activity {
    /** Called when the activity is first created. */
	Button btn1, btn2, btn3, btn4, btn5;
	Activity self;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        self = this;
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		startActivity (new Intent(self, FillParentActivity.class));
        	}
        });
        btn2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		startActivity (new Intent(self, WrapContentActivity.class));
        	}
        });
        btn3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		startActivity (new Intent(self, WeightActivity.class));
        	}
        });
        btn4.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		startActivity (new Intent(self, GravityActivity.class));
        	}
        });
        btn5.setOnClickListener(new OnClickListener() {
        	public void onClick(View v)
        	{
        		startActivity (new Intent(self, PaddingActivity.class));
        	}
        });
    }
}