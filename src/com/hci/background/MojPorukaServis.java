package com.hci.background;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MojPorukaServis extends Service
{

	private static final String TAG = "Moj Poruka Servis";

	@Override
	public IBinder onBind(Intent arg0)
	{
		return null;
	}

	@Override
	public void onCreate()
	{

		Toast.makeText(this, "Moj Poruka Servis: Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
	}

	
	@Override
	public void onStart(Intent intent, int startId)
	{
		Toast.makeText(this, "Moj Poruka Servis: STARTED", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");

		final Handler customHandler = new Handler();
		Runnable updateTimerThread = new Runnable()
		{
			@Override
			public void run()
			{
				do_tick();
				customHandler.postDelayed(this, 3000);
			}
		};
		customHandler.postDelayed(updateTimerThread, 0);

	}

	int a = 0;
	protected void do_tick()
	{
		Toast.makeText(getApplicationContext(), "Okidaè za timer br. " + ++a, Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onDestroy()
	{
		Toast.makeText(this, "Moj Poruka Servis: Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
	}
}
