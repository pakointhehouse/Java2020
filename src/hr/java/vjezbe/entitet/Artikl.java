package hr.java.vjezbe.entitet;
 
import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * 
 * @author Patrik
 *
 */
public abstract class Artikl {

	private String naslov;
	private String opis;
	private BigDecimal cijena;
	private Stanje stanje;
	
	/**
	 * Konstruktor klase Artikl
	 * 
	 * 
	 * @param naslov - Naziv kategorije
	 * @param cijena - Cijena kategorije
	 * @param stanje - Stanje kategorije
	 * @param  opis - opis kategorije
	 */
	
	public Artikl(String naslov, String opis, BigDecimal cijena,Stanje stanje) {
		
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}
	
	/**
	 * Dohvaca stanje Kategorije
	 * @return stanje kategorije
	 */
	
	public Stanje getStanje() {
		return stanje;
	}  

	/**
	 * Postavlja stanje kategorije
	 * @param stanje kategorije
	 */
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}


	/**
	 * Dohvaca naslov Kategorije
	 * @return naslov kategorije
	 */
	public String getNaslov() {
		return naslov;
	}

	/**
	 * Postavlja naslov kategorije
	 * @param naslov kategorije
	 */
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	
	/**
	 * Dohvaca opis Kategorije
	 * @return opis kategorije
	 */
	public String getOpis() {
		return opis;
	}
	
	/**
	 * Postavlja opis kategorije
	 * @param opis kategorije
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	public abstract String tekstOglasa() throws NemoguceOdreditiGrupuOsiguranjaException;
	
	
}
