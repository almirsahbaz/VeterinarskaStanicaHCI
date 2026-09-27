package com.hci.activities;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hci_isvs.R;
import com.hci.bussiness.Pregledi;
import com.hci.helper.HttpManager;
import com.hci.helper.JSONUtils;
import com.hci.helper.ServiceURL;

public class PregledPregledaActivity extends Activity {
	ListView lstView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_pregled_pregleda);

		setTitle("ISVS::Pregled pregleda");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
		List<Pregledi> stdPregledi = new ArrayList<Pregledi>();
		Pregledi pregled = new Pregledi();
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("getPreglede", "getAllPreglede"));
        String str = HttpManager.getResponseFromUrl(ServiceURL.service_PreglediGetURL, params);
		JSONArray jsonArray = JSONUtils.parseJSONArray(str);	
		for (int i = 0; i < jsonArray.length(); i++) {
			
				JSONObject obj;
				try {
					obj = jsonArray.getJSONObject(i);
					try {
					    pregled = JSONUtils.JSONToModel(obj, Pregledi.class);
						
					} catch (Exception e) {
						Log.e("Greska", e.getMessage());
					}
					
				} catch (JSONException e) {
					Log.e("Greska", e.getMessage());
				}
				stdPregledi.add(pregled);
			}
		
		lstView = (ListView) findViewById(R.id.lstPregledi);
		List<String> lstPregledi = new ArrayList<String>();
		for (Pregledi item : stdPregledi) {
			lstPregledi.add(item.getSifraPregleda());
		}
		ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this,R.layout.pregled_item,lstPregledi);
		lstView.setAdapter(arrayAdapter);
		lstView.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view , int position,
					long id) {
				Toast.makeText(getApplicationContext(),  lstView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregled_pregleda, menu);
		return true;
	}

	

}
