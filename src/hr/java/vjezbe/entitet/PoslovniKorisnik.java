package hr.java.vjezbe.entitet;

public class PoslovniKorisnik extends Korisnik {
	
	private String naziv;
	private String web;
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public PoslovniKorisnik(String naziv,String web,String email, String telefon) {
		super(email, telefon);
		this.naziv = naziv;
		this.web = web;
	}

	@Override
	public String dohvatiKontakt() {
		String vrati = "Naziv:" +naziv+", Web:"+web +", email: "+getEmail()+", telefon:"+getTelefon();
		return vrati;
	}
	
	
}
