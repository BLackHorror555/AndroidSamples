package com.niit.android;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class ServiceExample extends Service {

	  public static final int INTERVAL = 10000; // 10 sec
	  public static final int FIRST_RUN = 5000; // 5 seconds
	  int REQUEST_CODE = 11223344;

	  AlarmManager alarmManager;

	  @Override
	  public void onCreate() {
	    super.onCreate();

	    startService();
	    Log.v(this.getClass().getName(), "onCreate(..)");
	  }

	  @Override
	  public IBinder onBind(Intent intent) {
	    Log.v(this.getClass().getName(), "onBind(..)");
	    return null;
	  }

	  @Override
	  public void onDestroy() {
	    if (alarmManager != null) {
	      Intent intent = new Intent(this, RepeatingAlarmService.class);
	      alarmManager.cancel(PendingIntent.getBroadcast(this, REQUEST_CODE, intent, 0));
	    }
	    Toast.makeText(this, "Service Stopped!", Toast.LENGTH_LONG).show();
	    Log.v(this.getClass().getName(), "Service onDestroy(). Stop AlarmManager at " + new java.sql.Timestamp(System.currentTimeMillis()).toString());
	  }

	  private void startService() {

		Intent intent = new Intent(this, RepeatingAlarmService.class);
		// REQUEST_CODE - простой набор цифр, параметр остался, но от его использования отказались в новых версиях SDK
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, REQUEST_CODE, intent, 0);

		// создаем AlarmManager
		alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		// устанавливаем параметры AlarmManager:
		// AlarmManager.ELAPSED_REALTIME_WAKEUP - значит, что время мы используем системное;
		// SystemClock.elapsedRealtime() + FIRST_RUN - второй параметр отвечает за время, когда будет запущен AlarmManager;
		// INTERVAL - отвечает за интервал между вызовами AlarmManager
		// и последним параметром передаем наш Intent, который собственно и будет вызываться по расписанию.
		alarmManager.setRepeating(
		        AlarmManager.ELAPSED_REALTIME_WAKEUP,
		        SystemClock.elapsedRealtime() + FIRST_RUN,
		        INTERVAL,
		        pendingIntent);

		// выводим сообщение на экран, что сервис запущен
		Toast.makeText(this, "Service Started.", Toast.LENGTH_LONG).show();
		// пишем в лог
		Log.v(this.getClass().getName(), "AlarmManger started at " + new java.sql.Timestamp(System.currentTimeMillis()).toString());
	  }
	}

