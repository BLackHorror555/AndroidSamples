package mera.hse.mleykin.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView tvResult1;
    private MyBroadcastReceiver myBroadcastReceiver;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tvResult1 = (TextView) findViewById(R.id.textView1);

        Intent intentMyIntentService = new Intent(this, SampleIntentService.class);

        startService(intentMyIntentService.putExtra("time", 3).putExtra("task",
                "Action1"));
        startService(intentMyIntentService.putExtra("time", 1).putExtra("task",
                "Action2"));
        intentMyIntentService.putExtra("time", 4);

        intentMyIntentService.putExtra("task", "Action3");
        startService(intentMyIntentService);


        myBroadcastReceiver = new MyBroadcastReceiver();

        IntentFilter intentFilter = new IntentFilter(
                SampleIntentService.ACTION_MYINTENTSERVICE);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // un-register BroadcastReceiver
        unregisterReceiver(myBroadcastReceiver);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String result = intent
                    .getStringExtra(SampleIntentService.EXTRA_KEY_OUT);
            tvResult1.setText(result);
        }
    }
}
