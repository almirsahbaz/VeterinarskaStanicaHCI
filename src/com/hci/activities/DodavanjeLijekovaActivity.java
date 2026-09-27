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

public class DodavanjeLijekovaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_dodavanje_lijekova);

		setTitle("ISVS::Dodavanje lijekova");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodavanje_lijekova, menu);
		return true;
	}

	public void btnDodajLijekFrmonClick(View view)
	{
	
		TextView txtNazivLijeka = (TextView) findViewById(R.id.txtNazivLijeka2);
		TextView txtVrstaLijeka = (TextView) findViewById(R.id.txtVrstaLijeka1);
		TextView txtRokTrajanjaLijeka = (TextView) findViewById(R.id.txtRokTrajanja);
		String strNazivLijeka = txtNazivLijeka.getText().toString();
		String strVrstaLijeka = txtVrstaLijeka.getText().toString();
		String RokTrajanjaLijeka = txtRokTrajanjaLijeka.getText().toString();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://hci001.app.fit.ba/hci_ISVS/LijekoviInsert.php");
		if(!RokTrajanjaLijeka.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"))
		{
			Toast.makeText(getApplicationContext(), "Datum mora biti unesen u fotmatu dd/mm/yyyy!", Toast.LENGTH_LONG).show();
    		return;
		}
		if(strNazivLijeka.isEmpty() == true || strVrstaLijeka.isEmpty() == true || RokTrajanjaLijeka.isEmpty() == true)
	        	{
	        		Toast.makeText(getApplicationContext(), "Sva polja su obavezna za unos!", Toast.LENGTH_LONG).show();
	        		return;
	        	}
	
		else
		{	
		 try
	        {
	        
	        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("naziv", strNazivLijeka));
	            nameValuePairs.add(new BasicNameValuePair("vrsta", strVrstaLijeka));
	            nameValuePairs.add(new BasicNameValuePair("rokTrajanja", RokTrajanjaLijeka));
	            
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            HttpResponse response = httpclient.execute(httppost);
	            
	            if(response!=null)
	            {
	            	Toast.makeText(getApplicationContext(), "Lijek uspješno dodan!", Toast.LENGTH_LONG).show();
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

