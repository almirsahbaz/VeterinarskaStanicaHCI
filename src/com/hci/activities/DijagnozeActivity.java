package com.hci.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;

import com.example.hci_isvs.R;

public class DijagnozeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_dijagnoze);

		setTitle("ISVS::Dijagnoze");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dijagnoze, menu);
		return true;
	}

	public void btnDodavanjeDijagnozaonClick(View view)
	{
		
		Intent intent = new Intent(DijagnozeActivity.this,DodavanjeDijagnozaActivity.class);
		startActivity(intent);

	}
	
	public void btnPregledDijagnozaonClick(View view)
	{
		
		Intent intent = new Intent(DijagnozeActivity.this,PregledDijagnozaActivity.class);
		startActivity(intent);

	}

	public void btnPovratak2onClick(View view)
	{
		
		finish();

	}
}
