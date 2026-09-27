package com.hci.bussiness;

import java.io.Serializable;




public class LijekoviNarudzbe implements Serializable{

	private static final long serialVersionUID = -1406217248957912227L;
private int lijekNarudzbaID;
   public int getLijekNarudzbaID() {
	return lijekNarudzbaID;
}
public void setLijekNarudzbaID(int lijekNarudzbaID) {
	this.lijekNarudzbaID = lijekNarudzbaID;
}
public int getKolicina() {
	return kolicina;
}
public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}
public String getCijena() {
	return cijena;
}
public void setCijena(String cijena) {
	this.cijena = cijena;
}
public Lijekovi getLijekovi() {
	return lijekovi;
}
public void setLijekovi(Lijekovi lijekovi) {
	this.lijekovi = lijekovi;
}
public Narudzbe getNarudzbe() {
	return narudzbe;
}
public void setNarudzbe(Narudzbe narudzbe) {
	this.narudzbe = narudzbe;
}
private int kolicina;
   private String cijena;
   
   public Lijekovi lijekovi;
   public Narudzbe narudzbe;

}