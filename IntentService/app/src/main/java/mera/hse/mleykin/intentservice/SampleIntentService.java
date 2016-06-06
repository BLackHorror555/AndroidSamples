package mera.hse.mleykin.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by mleykin on 04.07.2015.
 */
public class SampleIntentService extends IntentService {

    final String LOG_TAG = "IntentServiceLogs";
    public static final String ACTION_MYINTENTSERVICE = "RESPONSE";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    String extraOut = "All actions done";

    public SampleIntentService() {
        super("myname");
        // TODO Auto-generated constructor stub
    }

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO Auto-generated method stub
        int tm = intent.getIntExtra("time", 0);
        String label = intent.getStringExtra("task");
        Log.d(LOG_TAG, "onHandleIntent start " + label);
        try {
            TimeUnit.SECONDS.sleep(tm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(LOG_TAG, "onHandleIntent end " + label);

        Intent intentResponse = new Intent();
        intentResponse.setAction(ACTION_MYINTENTSERVICE);
        intentResponse.addCategory(Intent.CATEGORY_DEFAULT);
        intentResponse.putExtra(EXTRA_KEY_OUT, extraOut);
        sendBroadcast(intentResponse);
    }
}
