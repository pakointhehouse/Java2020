package hr.java.vjezbe.entitet;

public abstract  class Korisnik {
	private String email;
	private String telefon;
	
	/**
	 * Konstruktor za klasu Korisnik
	 * 
	 * @param email   - Email korisnika
	 * @param telefon - Broj telefona korisnika
	 * @param id      - Id eniteta
	 */
	public Korisnik(String email,String telefon) {
		this.email = email;
		this.telefon = telefon;
	}

	/**
	 * Dohvaca email korisnika
	 * 
	 * @return - Email korisnika
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Postavlja email korisnika
	 * 
	 * @param email - Email korisnika
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Dohvaca telefon korisnika
	 * 
	 * @return - telefon korisnika
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Postavlja telefon korisnika
	 * 
	 * @param telefon - telefon korisnika
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	/**
	 * Metoda koja sadrzi podatke o kontakt podacima
	 * 
	 * @return - Vraca string koji sadrzi kontakt podatke korisnika
	 */
	public abstract String dohvatiKontakt();

	
	
}
	
	
	
