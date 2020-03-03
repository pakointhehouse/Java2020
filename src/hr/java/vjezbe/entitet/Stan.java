package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Klasa Stan koja nasljeduje klasu Artikl i implemetira sucelje Nekretnina
 * 
 * @author Patrik Mede
 * @version 1.0
 */
public class Stan extends Artikl implements Nekretnina {

	

	/**
	 * 
	 */
	public int kvadratura;

	/**
	 * Konstuktor za podklasu klase Artikl - Stan
	 * 
	 * @param naslov     - Naslov oglasa stana
	 * @param opis       - Opis oglasa stana
	 * @param cijena     - Cijena stana
	 * @param kvadratura - Kvadratura stana
	 * @param stanje     - Stanje artikla
	 * @param id         - Id eniteta
	 */
	public Stan(String naslov, String opis, BigDecimal cijena, int kvadratura,Stanje stanje) {
		super(naslov, opis, cijena,stanje);
		this.kvadratura = kvadratura;
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Dohvaca kvadrauru stana
	 * 
	 * @return - Kvadratura stana
	 */
	public int getKvadratura() {
		return kvadratura;
	}

	/**
	 * Postavlja kvadraturu stana
	 * 
	 * @param kvadratura - Kvadratura stana
	 */
	public void setKvadratura(int kvadratura) {
		this.kvadratura = kvadratura;
	}

	@Override
	public String tekstOglasa() {

		String poruka;
		try {
			BigDecimal porez = izracunajPorez(getCijena());

			poruka = "Naslov nekretnine: " + getNaslov() + "\nOpis nekretnine: " + getOpis()
					+ "\nKvadratura nekretnine: " + getKvadratura() + "\nPorez na nekretnine: " + porez
					 + "\nCijena nekretnine: " + getCijena()+ ", stanje :" + getStanje();

		} catch (CijenaJePreniskaException e) {
			poruka = "Naslov nekretnine: " + getNaslov() + "\nOpis nekretnine: " + getOpis()
					+ "\nKvadratura nekretnine: " + getKvadratura() + "\nPorez na nekretnine: " + e.getMessage()
					 + "\nCijena nekretnine: " + getCijena()+ ", stanje :" + getStanje();
		}

		return poruka;

	}

	@Override
	public String toString() {
		return getNaslov() + ", " + getOpis() + ", " + getCijena() + "kn";
	}

}