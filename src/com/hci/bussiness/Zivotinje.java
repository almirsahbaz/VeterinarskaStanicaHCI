package com.hci.bussiness;

import java.io.Serializable;
import java.util.*;

public class Zivotinje implements Serializable{

	private static final long serialVersionUID = -8648441914281937872L;

public int getZivotinjaID() {
		return zivotinjaID;
	}

	public void setZivotinjaID(int zivotinjaID) {
		this.zivotinjaID = zivotinjaID;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getGodiste() {
		return godiste;
	}

	public void setGodiste(Date godiste) {
		this.godiste = godiste;
	}

	public Date getDatumPrijema() {
		return datumPrijema;
	}

	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}

	public Vlasnici getVlasnici() {
		return vlasnici;
	}

	public void setVlasnici(Vlasnici vlasnici) {
		this.vlasnici = vlasnici;
	}

private int zivotinjaID;
   private String ime;
   private Date godiste;
   private Date datumPrijema;
   
   public Vlasnici vlasnici;

}