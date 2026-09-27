package com.hci.bussiness;

import java.io.Serializable;

public class Pregledi implements Serializable{
 
	private static final long serialVersionUID = -2242186838446467663L;
public int getPregledID() {
		return pregledID;
	}
	public void setPregledID(int pregledID) {
		this.pregledID = pregledID;
	}
	public String getDatumPregleda() {
		return datumPregleda;
	}
	public void setDatumPregleda(String datumPregleda) {
		this.datumPregleda = datumPregleda;
	}
	public String getCijena() {
		return cijena;
	}
	public void setCijena(String cijena) {
		this.cijena = cijena;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public Uposlenici getUposlenici() {
		return uposlenici;
	}
	public void setUposlenici(Uposlenici uposlenici) {
		this.uposlenici = uposlenici;
	}
	public Zivotinje getZivotinje() {
		return zivotinje;
	}
	public void setZivotinje(Zivotinje zivotinje) {
		this.zivotinje = zivotinje;
	}
private int pregledID;
   private String sifraPregleda;
   public String getSifraPregleda() {
	return sifraPregleda;
}
public void setSifraPregleda(String sifraPregleda) {
	this.sifraPregleda = sifraPregleda;
}
private String datumPregleda;
   private String cijena;
   private String komentar;
   
   public Uposlenici uposlenici;
   public Zivotinje zivotinje;


}