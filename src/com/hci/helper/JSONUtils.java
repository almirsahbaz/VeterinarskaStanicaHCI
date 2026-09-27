package com.hci.helper;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.util.Log;

import com.hci.bussiness.Lijekovi;

public class JSONUtils
{
	public static JSONObject parseJSONObject(String jsonString)
	{

		JSONObject jsonObject = null;
		try
		{
			jsonObject = new JSONObject(jsonString);
		} catch (Exception ex)
		{
			Log.e("JSON Parser error", "Error Parsing data " + ex.getMessage());
		}
		return jsonObject;
	}
	
	public static JSONArray parseJSONArray(String jsonString)
	{

		JSONArray jsonObject = null;
		try
		{
			jsonObject = new JSONArray(jsonString);
		} catch (Exception ex)
		{
			Log.e("JSON Parser error", "Error Parsing data " + ex.getMessage());
		}
		return jsonObject;
	}
	
	@SuppressLint("SimpleDateFormat")
	@SuppressWarnings("unchecked")
	public static <T> T JSONToModel(JSONObject j, Class<T> type) throws Exception
	{
	
		T s = null;
		try
		{
			
			s = (T) type.newInstance();
		} catch (Exception e1)
		{
			Log.e("greska JSON Converter", "can't create new instance of " + type.getSimpleName());
			throw new Exception();
		}
		
		Field[] fields = type.getDeclaredFields();
		for (Field f : fields)
		{
			String fieldName = f.getName();
		
			try
			{
				 f.setAccessible(true);
				 if (f.getGenericType() == int.class || f.getGenericType() == Integer.class )
				 {
					 Integer v =j.getInt(fieldName);
					 f.set(s, v);
				 }
				 if (f.getGenericType() == float.class || f.getGenericType() == Float.class )
				 {
					 	Float v = (float) j.getDouble(fieldName);
					 	f.set(s, v);
				 }
				 if (f.getGenericType() == double.class || f.getGenericType() == Double.class)
				 {
					 	Double v =  j.getDouble(fieldName);
					 	f.set(s, v);
				 }
				 if (f.getGenericType() == boolean.class || f.getGenericType() == Boolean.class )
				 {
					 Boolean v =j.getBoolean(fieldName);
					 f.set(s, v);
				 }
				 if (f.getGenericType() == Date.class)
				 {
					 String v =j.getString(fieldName);
					 SimpleDateFormat dateInstance = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 Date d = dateInstance.parse(v);
					 f.set(s, d);
				 }
				 if (f.getGenericType() == String.class)
				 {
					 	String v =  j.getString(fieldName);
					 	f.set(s, v);
				 }
				 
				 if (f.getType().isEnum())
				 {
					 String v =  j.getString(fieldName);
					 f.set(s, Enum.valueOf((Class<Enum>) f.getType(), v));
				 }
										
				
			} catch (Exception e)
			{
				Log.e("greska JSON Converter", fieldName + ", " + e.getLocalizedMessage());
			} 
		}
		return s;
	}

	
}
