package com.hci.bussiness;

import java.io.Serializable;
import java.util.*;

public class Narudzbe implements Serializable {

	private static final long serialVersionUID = -2813838470697273920L;

public int getNarudzbaID() {
		return narudzbaID;
	}

	public void setNarudzbaID(int narudzbaID) {
		this.narudzbaID = narudzbaID;
	}

	public String getSifraNarudzbe() {
		return sifraNarudzbe;
	}

	public void setSifraNarudzbe(String sifraNarudzbe) {
		this.sifraNarudzbe = sifraNarudzbe;
	}

	public String getNacinDostave() {
		return nacinDostave;
	}

	public void setNacinDostave(String nacinDostave) {
		this.nacinDostave = nacinDostave;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Uposlenici getUposlenici() {
		return uposlenici;
	}

	public void setUposlenici(Uposlenici uposlenici) {
		this.uposlenici = uposlenici;
	}

private int narudzbaID;
   private String sifraNarudzbe;
   private String nacinDostave;
   private Date datum;
   
   public Uposlenici uposlenici;

}