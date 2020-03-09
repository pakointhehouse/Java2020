package hr.java.vjezbe.entitet;

public class PrivatniKorisnik extends Korisnik {

	/**
	 * Klasa Privatni Korisnik koja nasljeduje klasu Korisnik
	 * 
	 * @author Patrik Mede
	 * @version 1.0
	 */
	
	private String ime;
	private String prezime;
	
	/**
	 * Vraca ime privatnog Korisnika
	 * @return ime
	 */
	public String getIme() {
		return ime;
	}
	
	/**
	 * Postavlja ime privatnog Korisnika
	 * @return
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	/**
	 * Vraca prezime privatnog Korisnika
	 * @return prezime
	 */
	public String getPrezime() {
		return prezime;
	}
	
	/**
	 * Postavlja prezime privatnog Korisnika
	 * @param prezime
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	/**
	 * Konstruktor klase Privatni korisnik
	 * 
	 * @param ime - ime korisnika
	 * @param prezime - prezime korisnika
	 * @param email - email adresa korisnika
	 * @param telefon - telefon korisnika
	 */
	public PrivatniKorisnik(String ime, String prezime, String email, String telefon) {
		super(email, telefon);
		this.ime = ime;
		this.prezime = prezime;
	}
	
	
	@Override
	public String dohvatiKontakt() {
		String vrati = "Ime:" +ime+", Prezime:"+prezime +", email: "+getEmail()+", telefon:"+getTelefon();
		return vrati;
	}
	
	
	

}
