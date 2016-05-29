package com.niit.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class SharedPrefsActivity extends Activity implements CompoundButton.OnCheckedChangeListener
{
	CheckBox cb;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		cb=(CheckBox)findViewById(R.id.check);
		cb.setOnCheckedChangeListener(this);
		Button btn=(Button)findViewById(R.id.close);
		btn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			cb.setText("This checkbox is: checked");
		}
		else {
			cb.setText("This checkbox is: unchecked");
		}
	}

	public void onResume() {
		super.onResume();
		SharedPreferences settings=getPreferences(0);
		cb.setChecked(settings.getBoolean("cb_checked", false));
	}

	public void onPause() {
		super.onPause();
		SharedPreferences settings=getPreferences(0);
		SharedPreferences.Editor editor=settings.edit();
		editor.putBoolean("cb_checked", cb.isChecked());
		editor.commit();
	}
}