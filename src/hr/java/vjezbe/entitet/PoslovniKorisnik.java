package hr.java.vjezbe.entitet;

public class PoslovniKorisnik extends Korisnik {
	
	/**
	 * Klasa Poslovni Korisnik koja nasljeduje klasu Korisnik
	 * 
	 * @author Patrik Mede
	 * @version 1.0
	 */
	
	private String naziv;
	private String web;
	
	/**
	 * Vraca naziv Poslovnog Korisnika
	 * @return
	 */
	public String getNaziv() {
		return naziv;
	}
	
	/**
	 * Postavlja naziv Poslovnog Korisnika
	 * @return
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * Vraca WEB Poslovnog Korisnika
	 * @return
	 */
	public String getWeb() {
		return web;
	}
	/**
	 * Postavlja web Poslovnog Korisnika
	 * @return
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * Konstruktor klase Poslovni korisnik
	 * 
	 * 
	 * @param web	-web adresa korisnika
	 * @param naziv - Naziv korisnika
	 * @param email - email adresa korisnika
	 * @param telefon - telefon korisnika
	 */
	public PoslovniKorisnik(String naziv,String web,String email, String telefon) {
		super(email, telefon);
		this.naziv = naziv;
		this.web = web;
	}

	/**
	 * Vraca informacije Poslovnog Korisnika u obliku Stringa
	 * @return String
	 */
	@Override
	public String dohvatiKontakt() {
		String vrati = "Naziv:" +naziv+", Web:"+web +", email: "+getEmail()+", telefon:"+getTelefon();
		return vrati;
	}
	
	
}
