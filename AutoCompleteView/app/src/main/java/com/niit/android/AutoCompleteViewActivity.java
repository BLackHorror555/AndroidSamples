package com.niit.android;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteViewActivity extends Activity implements TextWatcher {
	TextView selection;
	AutoCompleteTextView edit;
	String[] items={"Moscow","London", "Paris", "Madrid", "Perm", "Nizhny Novgorod", "Minsk"};
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		selection=(TextView)findViewById(R.id.selection);
		edit=(AutoCompleteTextView)findViewById(R.id.edit);
		edit.addTextChangedListener(this);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, items);
		edit.setAdapter(aa);
	}
	public void onTextChanged(CharSequence s, int start, int before, int count) {

		  }
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// needed for interface, but not used
		}
	public void afterTextChanged(Editable s) {
		boolean flag = false;
		String s1 = edit.getText().toString();
		for (int i=0; i<items.length; i++) {
			if (s1.equals(items[i])) {
				flag = true;
				break;
			}
		}
		if (flag)
			selection.setText(edit.getText());
		else
			selection.setText("Incorrect choice");
	}
}
