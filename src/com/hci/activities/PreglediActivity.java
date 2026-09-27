package com.hci.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;

import com.example.hci_isvs.R;

public class PreglediActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_pregledi);

		setTitle("ISVS::Pregledi");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregledi, menu);
		return true;
	}

	public void btnDodajPregledonClick(View view)
	{
		
		Intent intent = new Intent(PreglediActivity.this,DodavanjePregledaActivity.class);
		startActivity(intent);

	}
	
	public void btnPregledajPregledonClick(View view)
	{
		
		Intent intent = new Intent(PreglediActivity.this,PregledPregledaActivity.class);
		startActivity(intent);

	}

	public void btnPovratak3onClick(View view)
	{

		finish();

	}
	
}
