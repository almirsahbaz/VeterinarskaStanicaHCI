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

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_register);
		setTitle("ISVS::Registracija");

		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	public void btnRegistracijaOnClick(View v)
	{
		
		TextView txtIme = (TextView) findViewById(R.id.txtIme);
		TextView txtPrezime = (TextView) findViewById(R.id.txtPrezime);
		TextView txtZvanje = (TextView) findViewById(R.id.txtZvanje);
		TextView txtOdjel = (TextView) findViewById(R.id.txtOdjel);
		TextView txtAdresa = (TextView) findViewById(R.id.txtAdresa);
		TextView txtTelefon = (TextView) findViewById(R.id.txtTelefon);
		TextView txtVrstaPosla = (TextView) findViewById(R.id.txtVrstaPosla);
		TextView txtLogin = (TextView) findViewById(R.id.txtUsernameReg);
		TextView txtPassword = (TextView) findViewById(R.id.txtPassReg);
		String strIme = txtIme.getText().toString();
		String strPrezime = txtPrezime.getText().toString();
		String strZvanje = txtZvanje.getText().toString();
		String strOdjel = txtOdjel.getText().toString();
		String strAdresa = txtAdresa.getText().toString();
		String strTelefon = txtTelefon.getText().toString();
		String strVrstaPosla = txtVrstaPosla.getText().toString();
		String strLogin = txtLogin.getText().toString();
		String strPassword = txtPassword.getText().toString();
		Integer status =1;
		if(strIme.isEmpty() == true || strPrezime.isEmpty() == true || strZvanje.isEmpty() == true || strOdjel.isEmpty() == true
				|| strAdresa.isEmpty() == true || strTelefon.isEmpty() == true || strVrstaPosla.isEmpty() == true 
				|| strLogin.isEmpty() == true || strPassword.isEmpty() == true)
	        	{
	        		Toast.makeText(getApplicationContext(), "Sva polja su obavezna za unos!", Toast.LENGTH_LONG).show();
	        		return;
	        	}
		else
		{	
			
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://hci001.app.fit.ba/hci_ISVS/ZaposleniciInsert.php");
        try
        {
        
        	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("ime", strIme));
            nameValuePairs.add(new BasicNameValuePair("prezime", strPrezime));
            nameValuePairs.add(new BasicNameValuePair("zvanje", strZvanje));
            nameValuePairs.add(new BasicNameValuePair("odjel", strOdjel));
            nameValuePairs.add(new BasicNameValuePair("adresa", strAdresa));
            nameValuePairs.add(new BasicNameValuePair("telefon", strTelefon));
            nameValuePairs.add(new BasicNameValuePair("vrstaPosla", strVrstaPosla));
            nameValuePairs.add(new BasicNameValuePair("username", strLogin));
            nameValuePairs.add(new BasicNameValuePair("password", strPassword));
            nameValuePairs.add(new BasicNameValuePair("status", status.toString()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            if(response!=null)
            {
            	Toast.makeText(getApplicationContext(), "Uspješno dodano!", Toast.LENGTH_LONG).show();
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
