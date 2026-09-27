package com.hci.activities;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hci_isvs.R;
import com.hci.bussiness.Uposlenici;
import com.hci.helper.HttpManager;
import com.hci.helper.JSONUtils;
import com.hci.helper.ServiceURL;

public class LoginActivity extends Activity {

	String strLogin;
	String strPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_login);
		setTitle("ISVS::Login");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void btnLoginOnClick(View view)
	{
		
		TextView txtLogin = (TextView) findViewById(R.id.txtUsername);
		 strLogin = txtLogin.getText().toString();

		TextView txtPassword = (TextView) findViewById(R.id.txtPassword);
		 strPassword = txtPassword.getText().toString();

		HTTPLoginAsync execLogin = new HTTPLoginAsync();
		execLogin.execute(strLogin, strPassword);

	}
	
	public void btnRegisterOnClick(View view)
	{
		
		Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
		startActivity(intent);

	}
	
	public class HTTPLoginAsync extends AsyncTask<String, Void, Uposlenici>
	{
		@Override
		protected Uposlenici doInBackground(String... params)
		{

			List<NameValuePair> preparedParams = new ArrayList<NameValuePair>();
			preparedParams.add(new BasicNameValuePair("username", params[0]));
			preparedParams.add(new BasicNameValuePair("password", params[1]));

			JSONObject jsonObj = JSONUtils.parseJSONObject(HttpManager.getResponseFromUrl(ServiceURL.service_loginURL, preparedParams));
			try
			{
				int intStatus = jsonObj.getInt("status");

				if (intStatus == 0)
				{
					String strErrorMessage = jsonObj.getString("error_message");
					Log.e("greska JSON Converter", strErrorMessage);
					return null;
				}

				JSONObject objZaposlenici = jsonObj.getJSONObject("podaci");

				Uposlenici u = JSONUtils.JSONToModel(objZaposlenici, Uposlenici.class);
				return u;

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		}
		@Override
		protected void onPostExecute(Uposlenici result)
		{
			try
			{
				if (result != null)
				{
					Intent intent = new Intent(getApplicationContext(), GlavniMeniActivity.class);
					intent.putExtra("LoginResult", result);
					startActivity(intent);
				} else
				{
					Toast.makeText(getApplicationContext(), "Unijeli ste pogrešne pristupne podatke!", Toast.LENGTH_LONG).show();
				}

			} catch (Exception e)
			{
				Toast.makeText(getApplicationContext(), "Dogodila se greška prilikom uèitavanja: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
		}
		
}
}
