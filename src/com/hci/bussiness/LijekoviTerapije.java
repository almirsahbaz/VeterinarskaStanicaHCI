package com.hci.bussiness;

import java.io.Serializable;

public class LijekoviTerapije implements Serializable{
 
	private static final long serialVersionUID = 5093076105975447248L;
public int getLijekTerapijaID() {
		return lijekTerapijaID;
	}
	public void setLijekTerapijaID(int lijekTerapijaID) {
		this.lijekTerapijaID = lijekTerapijaID;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public String getUpute() {
		return upute;
	}
	public void setUpute(String upute) {
		this.upute = upute;
	}
	public String getDoziranje() {
		return doziranje;
	}
	public void setDoziranje(String doziranje) {
		this.doziranje = doziranje;
	}
	public Terapije getTerapije() {
		return terapije;
	}
	public void setTerapije(Terapije terapije) {
		this.terapije = terapije;
	}
	public Lijekovi getLijekovi() {
		return lijekovi;
	}
	public void setLijekovi(Lijekovi lijekovi) {
		this.lijekovi = lijekovi;
	}
private int lijekTerapijaID;
   private int kolicina;
   private String upute;
   private String doziranje;
   
   public Terapije terapije;
   public Lijekovi lijekovi;

}