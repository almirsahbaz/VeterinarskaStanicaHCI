package com.hci.helper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class HttpManager
{

	public static String getResponseFromUrl(String url, List<NameValuePair> params)
	{
		InputStream inputStream =
		null;
		try
		{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();

			inputStream = httpEntity.getContent();
		} catch (Exception ex)
		{
			Log.e("greska getResponseFromUrl", ex.getMessage());
		}

		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
			StringBuilder result = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null)
			{
				result.append(line + "\n");
			}
			inputStream.close();
			return result.toString();
		} catch (Exception ex)
		{
			Log.e("Buffering Error  ", ex.toString());
			return null;
		}
	}
}
