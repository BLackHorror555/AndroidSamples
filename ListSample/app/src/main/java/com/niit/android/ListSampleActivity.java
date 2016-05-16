package com.niit.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListSampleActivity extends ListActivity {
	TextView selection;
	String[] items={"ЦСКА","Анжи", "Зенит", "Терек", "Кубань", "Рубин", "Спартак М",  "Локомотив М", "Динамо М", "Краснодар",
			        "Амкар", "Ростов", "Волга НН", "Крылья Советов", "Алания", "Мордовия"};
/** Called with the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
		selection=(TextView)findViewById(R.id.selection);
	}
	public void onListItemClick(ListView parent, View v, int position, long id) {
		selection.setText(items[position]);
	}
}