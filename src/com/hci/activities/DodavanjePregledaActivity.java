package com.hci.activities;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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

public class DodavanjePregledaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_dodavanja_pregleda);

		setTitle("ISVS::Dodavanje pregleda");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodavanja_pregleda, menu);
		return true;
	}

	public void btnDodajPregledFrmonClick(View view)
	{
	
		TextView txtSifraPregleda = (TextView) findViewById(R.id.txtSifraPregleda);
		TextView txtDatumPregleda = (TextView) findViewById(R.id.txtDatumPregleda);
		TextView txtCijenaPregleda = (TextView) findViewById(R.id.txtCijena);
		TextView txtKomentarNaPregled = (TextView) findViewById(R.id.txtKomentarNaPregled);
		String strSifraPregleda = txtSifraPregleda.getText().toString();
		String strDatumPregleda = txtDatumPregleda.getText().toString();
		String strCijenaPregleda = txtCijenaPregleda.getText().toString();
		String strKomentarNaPregled = txtKomentarNaPregled.getText().toString();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://hci001.app.fit.ba/hci_ISVS/PreglediInsert.php");
		
		if(!strDatumPregleda.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"))
		{
			Toast.makeText(getApplicationContext(), "Datum mora biti unesen u fotmatu dd/mm/yyyy!", Toast.LENGTH_LONG).show();
    		return;
		}
		if(strSifraPregleda.isEmpty() == true || strDatumPregleda.isEmpty() == true || strCijenaPregleda.isEmpty() == true || strKomentarNaPregled.isEmpty() == true)
	        	{
	        		Toast.makeText(getApplicationContext(), "Sva polja su obavezna za unos!", Toast.LENGTH_LONG).show();
	        		return;
	        	}
	
		else
		{	
		 try
	        {
	        
	        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        	nameValuePairs.add(new BasicNameValuePair("sifraPregleda", strSifraPregleda));
	            nameValuePairs.add(new BasicNameValuePair("datumPregleda", strDatumPregleda));
	            nameValuePairs.add(new BasicNameValuePair("cijena", strCijenaPregleda));
	            nameValuePairs.add(new BasicNameValuePair("komentar", strKomentarNaPregled));
	            
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            HttpResponse response = httpclient.execute(httppost);
	            
	            if(response!=null)
	            {
	            	Toast.makeText(getApplicationContext(), "Pregled uspješno dodan!", Toast.LENGTH_LONG).show();
	            	finish();
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    
			}
	}
}
