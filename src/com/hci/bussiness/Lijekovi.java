package com.hci.bussiness;


import java.io.Serializable;

public class Lijekovi implements Serializable {

	private static final long serialVersionUID = -7911913261053553837L;
private int lijekID;
   public int getLijekID() {
	return lijekID;
}
public void setLijekID(int lijekID) {
	this.lijekID = lijekID;
}
public String getNaziv() {
	return naziv;
}
public void setNaziv(String naziv) {
	this.naziv = naziv;
}
public String getVrsta() {
	return vrsta;
}
public void setVrsta(String vrsta) {
	this.vrsta = vrsta;
}
public String getRokTrajanja() {
	return rokTrajanja;
}
public void setRokTrajanja(String rokTrajanja) {
	this.rokTrajanja = rokTrajanja;
}
private String naziv;
   private String vrsta;
   private String rokTrajanja;

}