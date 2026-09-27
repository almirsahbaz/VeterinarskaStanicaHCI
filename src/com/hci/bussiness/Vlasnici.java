package com.hci.bussiness;

import java.io.Serializable;

public class Vlasnici implements Serializable {
 
	private static final long serialVersionUID = -3838857631557741220L;
private int vlasnikID;
   public int getVlasnikID() {
	return vlasnikID;
}
public void setVlasnikID(int vlasnikID) {
	this.vlasnikID = vlasnikID;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getPrezime() {
	return prezime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
private String ime;
   private String prezime;

}