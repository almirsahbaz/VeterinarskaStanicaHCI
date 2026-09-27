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

public class DodavanjeDijagnozaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_dodavanje_dijagnoza);

		setTitle("ISVS::Dodavanje dijagnoza");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dodavanje_dijagnoza, menu);
		return true;
	}

	public void btnDodajDijagnozuFrmonClick(View view)
	{
	
		TextView txtNazivDijagnoze = (TextView) findViewById(R.id.txtNazivDijagnoze);
		TextView txtIntenzitetDijagnoze = (TextView) findViewById(R.id.txtIntenzitetDijagnoze);
		TextView txtKomentarNaDijagnozu = (TextView) findViewById(R.id.txtKomentarDijagnoze);
		TextView txtVrstaDijagnoze = (TextView) findViewById(R.id.txtVrstaDijagnoze);
		String strNazivDijagnoze = txtNazivDijagnoze.getText().toString();
		String strIntenzitetDijagnoze = txtIntenzitetDijagnoze.getText().toString();
		String strKomentarNaDijagnozu = txtKomentarNaDijagnozu.getText().toString();
		String strVrstaDijagnoze = txtVrstaDijagnoze.getText().toString();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://hci001.app.fit.ba/hci_ISVS/DijagnozeInsert.php");
		
		if(strNazivDijagnoze.isEmpty() == true || strIntenzitetDijagnoze.isEmpty() == true 
		   || strKomentarNaDijagnozu.isEmpty() == true || strVrstaDijagnoze.isEmpty() == true)
	        	{
	        		Toast.makeText(getApplicationContext(), "Sva polja su obavezna za unos!", Toast.LENGTH_LONG).show();
	        		return;
	        	}
	
		else
		{	
		 try
	        {
	        
	        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("naziv", strNazivDijagnoze));
	            nameValuePairs.add(new BasicNameValuePair("intenzitet", strIntenzitetDijagnoze));
	            nameValuePairs.add(new BasicNameValuePair("komentar", strKomentarNaDijagnozu));
	            nameValuePairs.add(new BasicNameValuePair("vrsta", strVrstaDijagnoze));
	            
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	            HttpResponse response = httpclient.execute(httppost);
	            
	            if(response!=null)
	            {
	            	Toast.makeText(getApplicationContext(), "Dijagnoza uspješno dodana!", Toast.LENGTH_LONG).show();
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
