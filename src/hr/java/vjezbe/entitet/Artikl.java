package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

public abstract class Artikl {

	private String naslov;
	private String opis;
	private BigDecimal cijena;
	private Stanje stanje;
	
	public Artikl(String naslov, String opis, BigDecimal cijena,Stanje stanje) {
		
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}
	
	
	
	public Stanje getStanje() {
		return stanje;
	}  

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}



	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

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
