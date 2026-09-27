package com.hci.bussiness;
import java.io.Serializable;


public class Uposlenici implements Serializable {

	private static final long serialVersionUID = -2507104892577084463L;
public int getUposlenikID() {
		return uposlenikID;
	}
	public void setUposlenikID(int uposlenikID) {
		this.uposlenikID = uposlenikID;
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
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public String getOdjel() {
		return odjel;
	}
	public void setOdjel(String odjel) {
		this.odjel = odjel;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVrstaPosla() {
		return vrstaPosla;
	}
	public void setVrstaPosla(String vrstaPosla) {
		this.vrstaPosla = vrstaPosla;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
private int uposlenikID;
   private String ime;
   private String prezime;
   private String zvanje;
   private String odjel;
   private String adresa;
   private String telefon;
   private String username;
   private String password;
   private String vrstaPosla;
   private Boolean status;
}