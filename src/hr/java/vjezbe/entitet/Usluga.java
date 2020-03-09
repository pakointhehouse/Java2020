package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * 
 * @author Patrik
 *
 */
public class Usluga extends Artikl {
	/**
	 * Konstruktor usluge
	 * 
	 * @param naslov
	 * @param opis
	 * @param cijena
	 * @param stanje
	 */
	public Usluga(String naslov, String opis, BigDecimal cijena,Stanje stanje) {
		super(naslov, opis, cijena,stanje);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Funkcija koja vraca tekst Oglasa u obliku stringa
	 * @return string oglasa
	 */
	@Override
	public String tekstOglasa() {
		String vrati = ("Naslov:"+ getNaslov() +", Opis:"+getOpis() + ", cijena automobila"+ getCijena() + ", stanje :" + getStanje()) ;
		return vrati;
	}

	
}
