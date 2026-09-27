package com.hci.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;

import com.example.hci_isvs.R;

public class LijekoviActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_lijekovi);

		setTitle("ISVS::Lijekovi");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lijekovi, menu);
		return true;
	}
	
	public void btnPovratak1onClick(View view)
	{
		
		finish();

	}

	public void btnDodajLijekonClick(View view)
	{
		
		Intent intent = new Intent(LijekoviActivity.this,DodavanjeLijekovaActivity.class);
		startActivity(intent);

	}
	
	public void btnPregledLijekovaonClick(View view)
	{
		
		Intent intent = new Intent(LijekoviActivity.this,PregledLijekovaActivity.class);
		startActivity(intent);

	}
}
