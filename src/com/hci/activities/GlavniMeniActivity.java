package com.hci.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hci_isvs.R;
import com.hci.activities.DijagnozeActivity;
import com.hci.activities.LijekoviActivity;
import com.hci.activities.LoginActivity;
import com.hci.activities.MojProfilActivity;
import com.hci.activities.PreglediActivity;
import com.hci.bussiness.Uposlenici;

public class GlavniMeniActivity extends Activity {
	
	private Uposlenici uposlenik;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_glavni_meni);
		setTitle("ISVS::Glavni meni");
		
		uposlenik = (Uposlenici) getIntent().getExtras().getSerializable("LoginResult");
		TextView txtWelcome = (TextView) findViewById(R.id.txtDobrodoslica);
		txtWelcome.setText("Dobrodošao, " + uposlenik.getIme() + " " +uposlenik.getPrezime() + ".");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.glavni_meni, menu);
		return true;
	}

	
	public void btnMojProfilonClick(View view)
	{
		
		Intent intent = new Intent(GlavniMeniActivity.this,MojProfilActivity.class);
		intent.putExtra("LoginResult", uposlenik);
		startActivity(intent);

	}
	
	
	public void btnLijekovionClick(View view)
	{
		
		Intent intent = new Intent(GlavniMeniActivity.this,LijekoviActivity.class);
		startActivity(intent);

	}
	
	public void btnLogOutonClick(View view)
	{
		
		Intent intent = new Intent(GlavniMeniActivity.this,LoginActivity.class);
		startActivity(intent);
		uposlenik = null;
		Toast.makeText(getApplicationContext(), "Uspješno ste se odjavili!", Toast.LENGTH_SHORT).show();

	}
	
	public void btnDijagnozeonClick(View view)
	{
		Intent intent = new Intent(GlavniMeniActivity.this,DijagnozeActivity.class);
		startActivity(intent);
	}
	
	public void btnPregledionClick(View view)
	{
		Intent intent = new Intent(GlavniMeniActivity.this,PreglediActivity.class);
		startActivity(intent);
	}
}
