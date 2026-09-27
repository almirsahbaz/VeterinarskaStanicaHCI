package com.hci.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hci_isvs.R;
import com.hci.bussiness.Uposlenici;

public class MojProfilActivity extends Activity {

	private Uposlenici uposlenik;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_moj_profil);

		setTitle("ISVS::Korisnièke postavke");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
		uposlenik = (Uposlenici) getIntent().getExtras().getSerializable("LoginResult");
		TextView txtWelcome = (TextView) findViewById(R.id.txtDobrodoslica2);
		txtWelcome.setText("Dobrodošao, " + uposlenik.getIme() + " " +uposlenik.getPrezime() + ".");
		TextView txtIme = (TextView) findViewById(R.id.txtImeProfil);
		txtIme.setText(uposlenik.getIme());
		txtIme.setEnabled(false);
		TextView txtPrezime = (TextView) findViewById(R.id.txtPrezimeProfil);
		txtPrezime.setText(uposlenik.getPrezime());
		txtPrezime.setEnabled(false);
		TextView txtZvanje = (TextView) findViewById(R.id.txtZvanjeProfil);
		txtZvanje.setText(uposlenik.getZvanje());
		txtZvanje.setEnabled(false);
		TextView txtOdjel = (TextView) findViewById(R.id.txtOdjelProfil);
		txtOdjel.setText(uposlenik.getOdjel());
		txtOdjel.setEnabled(false);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.moj_profil, menu);
		return true;
	}
	public void btnSpasiIzmjeneKorisnik(View view)
	{
		TextView txtPass = (TextView) findViewById(R.id.txtPasswordProfil);
		String strPass = txtPass.getText().toString();
		TextView txtPassConfirm = (TextView) findViewById(R.id.txtPasswordProfilConfirm);
		String strPassconf = txtPassConfirm.getText().toString();
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://hci001.app.fit.ba/hci_ISVS/ZaposleniciUpdate.php");
		if((strPass.isEmpty()==false && strPassconf.isEmpty()==false)&&(strPass.equals(strPassconf)==true))
			{
		try {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("UposlenikID",String.valueOf(uposlenik.getUposlenikID())));
		nameValuePairs.add(new BasicNameValuePair("password", strPass));
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		HttpResponse response = httpclient.execute(httppost);
		if(response!=null)
		{
    	Toast.makeText(getApplicationContext(), "Password uspješno izmijenjen!", Toast.LENGTH_LONG).show();
    	finish();
		}
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}
			}
		else
	        {
	       	Toast.makeText(getApplicationContext(), "Uneseni passwordi nisu jednaki!", Toast.LENGTH_LONG).show();
       }
	}

}
