package com.hci.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hci_isvs.R;
import com.hci.bussiness.Dijagnoze;

public class DijagnozeAdapter extends ArrayAdapter<Dijagnoze>{

	private ArrayList<Dijagnoze> object;
	public DijagnozeAdapter(Context context, int resource, List<Dijagnoze> objects) {
		super(context, resource, objects);
		this.object = (ArrayList<Dijagnoze>) objects;
		
	}
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if(convertView==null)
		{
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView= inflater.inflate(R.layout.dijagnoze_item,null);
		}
		Dijagnoze dijagnoza = this.object.get(position);
		if(dijagnoza!=null)
		{
			TextView NazivDijagnoze = (TextView) convertView.findViewById(R.id.Naziv);
			if(NazivDijagnoze!=null)
				NazivDijagnoze.setText(dijagnoza.getNaziv());
			
		}
		return convertView;
	}
	
}
