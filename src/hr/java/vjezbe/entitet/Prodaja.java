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
	 * @param artikl - prima artikl
	 * @param korisnik - prima korisnika
	 * @param datumObjave - prima datum objave
	 */
	public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave) {
		super();
		this.artikl = artikl;
		this.korisnik = korisnik;
		this.datumObjave = datumObjave;
	}
	
	/**
	 * Metoda za dodavanje artikla
	 * @return artikl - vraca artikl
	 */
	public Artikl getArtikl() {
		return artikl;
	}
	
	/**
	 * Postavlja artikl
	 * @param artikl - prima korisnika
	 */
	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	/**
	 *  Vraca korisnika
	 * @return korisnik - vraca korisnika
	 */
	public Korisnik getKorisnik() {
		return korisnik;
	}

	/**
	 *  Postavlja korisnika
	 * @param korisnik - prima korisnika
	 */
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	/**
	 * Vraca datum objave prodaje
	 * @return datum objave - vraca datum objave
	 */
	public LocalDate getDatumObjave() {
		return datumObjave;
	}

	/**
	 * Postavlja datum objave
	 * @param datumObjave - prima datum objave
	 */
	public void setDatumObjave(LocalDate datumObjave) {
		this.datumObjave = datumObjave;
	}

}
