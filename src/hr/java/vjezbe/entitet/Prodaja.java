package hr.java.vjezbe.entitet;

import java.time.LocalDate;

/**
 * 
 * @author Patrik
 *
 */
public class Prodaja {
	private Artikl artikl;
	private Korisnik korisnik;
	private LocalDate datumObjave;
	
	/**
	 * Konstruktor klase prodaja
	 * 
	 * @param artikl
	 * @param korisnik
	 * @param datumObjave
	 */
	public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
		super();
		this.artikl = artikl;
		this.korisnik = korisnik;
		this.datumObjave = datumObjave;
	}
	
	/**
	 * Metoda za dodavanje artikla
	 * @return artikl
	 */
	public Artikl getArtikl() {
		return artikl;
	}
	
	/**
	 * Postavlja artikl
	 * @param artikl
	 */
	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	/**
	 *  Vraca korisnika
	 * @return korisnik
	 */
	public Korisnik getKorisnik() {
		return korisnik;
	}

	/**
	 *  Postavlja korisnika
	 * @param korisnik
	 */
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	/**
	 * Vraca datum objave prodaje
	 * @return datum objave
	 */
	public LocalDate getDatumObjave() {
		return datumObjave;
	}

	/**
	 * Postavlja datum objave
	 * @param datumObjave
	 */
	public void setDatumObjave(LocalDate datumObjave) {
		this.datumObjave = datumObjave;
	}

}
