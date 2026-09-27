package com.hci.bussiness;

import java.io.Serializable;
import java.util.*;

public class Terapije implements Serializable {

	private static final long serialVersionUID = -687616233877394675L;

public int getTerapijaID() {
		return terapijaID;
	}

	public void setTerapijaID(int terapijaID) {
		this.terapijaID = terapijaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Dijagnoze getDijagnoze() {
		return dijagnoze;
	}

	public void setDijagnoze(Dijagnoze dijagnoze) {
		this.dijagnoze = dijagnoze;
	}

private int terapijaID;
   private String naziv;
   private Date datum;
   
   public Dijagnoze dijagnoze;

}