package com.hci.activities;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.os.AsyncTask;
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
import com.hci.bussiness.Dijagnoze;
import com.hci.bussiness.Lijekovi;
import com.hci.helper.DijagnozeAdapter;
import com.hci.helper.HttpManager;
import com.hci.helper.JSONUtils;
import com.hci.helper.ServiceURL;

public class PregledDijagnozaActivity extends Activity {

	ListView lstView;
	List<Dijagnoze> stdDijagnoze;
	DijagnozeAdapter dijagnozeAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_pregled_dijagnoza);
		lstView = (ListView) findViewById(R.id.listViewDijagnoze);
		stdDijagnoze =   new ArrayList<Dijagnoze>();
		Dijagnoze dijagnoza = new Dijagnoze();
		 List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("getDijagnoze", "getAllDijagnoze"));
	        String str = HttpManager.getResponseFromUrl(ServiceURL.service_DijagnozeGetURL, params);
			JSONArray jsonArray = JSONUtils.parseJSONArray(str);	
			for (int i = 0; i < jsonArray.length(); i++) {
				
					JSONObject obj;
					try {
						obj = jsonArray.getJSONObject(i);
						try {
							dijagnoza = JSONUtils.JSONToModel(obj, Dijagnoze.class);
							
						} catch (Exception e) {
							Log.e("Greska", e.getMessage());
						}
						
					} catch (JSONException e) {
						Log.e("Greska", e.getMessage());
					}
					stdDijagnoze.add(dijagnoza);
				}
		setTitle("ISVS::Pregled dijagnoza");
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(tp);
		}
		
		
		HTTPTask task =  new HTTPTask();
		task.execute(ServiceURL.service_DijagnozeGetURL,"getDijagnoze","getAllDijagnoze");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregled_dijagnoza, menu);
		return true;
	}

	private class HTTPTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... params) {
		
			List<NameValuePair> headParams =  new ArrayList<NameValuePair>();
			headParams.add(new BasicNameValuePair(params[1], params[2]));
			
			return new HttpManager().getResponseFromUrl(params[0], headParams);
		}
		protected void onPostExecute(String result)
		{
			dijagnozeAdapter = new DijagnozeAdapter(getApplicationContext(), R.layout.dijagnoze_item, stdDijagnoze);
			lstView.setAdapter(dijagnozeAdapter);
		}
	}

}
