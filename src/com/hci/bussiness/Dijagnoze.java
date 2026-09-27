package com.hci.bussiness;

import java.io.Serializable;





public class Dijagnoze implements Serializable
{
private static final long serialVersionUID = -3702996806935096920L;
private int dijagnozaID;
   public int getDijagnozaID() {
	return dijagnozaID;
}

public void setDijagnozaID(int dijagnozaID) {
	this.dijagnozaID = dijagnozaID;
}

public String getNaziv() {
	return naziv;
}

public void setNaziv(String naziv) {
	this.naziv = naziv;
}

public String getIntenzitet() {
	return intenzitet;
}

public void setIntenzitet(String intenzitet) {
	this.intenzitet = intenzitet;
}

public String getKomentar() {
	return komentar;
}

public void setKomentar(String komentar) {
	this.komentar = komentar;
}

public String getVrsta() {
	return vrsta;
}

public void setVrsta(String vrsta) {
	this.vrsta = vrsta;
}

public Pregledi getPregledi() {
	return pregledi;
}

public void setPregledi(Pregledi pregledi) {
	this.pregledi = pregledi;
}

   private String naziv;
   private String intenzitet;
   private String komentar;
   private String vrsta;
   private Pregledi pregledi;
}