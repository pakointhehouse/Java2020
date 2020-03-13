package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * 
 * @author Patrik
 *
 */
public class Automobil extends Artikl implements Vozilo {
	
	
	private BigDecimal snagaKs;
	
	
	/**
	 * Vraca kolicinu konjskih snaga
	 * 
	 * @return - Konjska snaga
	 */
	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	/**
	 * Postavlja konjske snage
	 * 
	 * @param snagaKs - Konjske snage
	 */
	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}

	/**
	 * Konstruktor za klasu automobil
	 * 
	 * @param naslov  - Naziv automobila
	 * @param opis    - Opis automobila
	 * @param snagaKs - Snaga automobila u konjskim snagama
	 * @param cijena  - Cijena automobila
	 * @param stanje  - Stanje artikla
	 * @throws NemoguceOdreditiGrupuOsiguranjaException - baca inzimku nemoguce odrediti grupu osiguiranja
	 */
	public Automobil(String naslov, String opis, BigDecimal cijena,BigDecimal snagaKs,Stanje stanje) throws NemoguceOdreditiGrupuOsiguranjaException {
		super(naslov, opis, cijena, stanje);
		this.snagaKs = snagaKs;
	}

	@Override
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		double tempSnagaKs = izracunajKw(snagaKs).doubleValue();

		int izracunGrupe = 0;

		if (tempSnagaKs < 40) {
			izracunGrupe = 1;
		}
		if (tempSnagaKs >= 40 && tempSnagaKs < 47) {
			izracunGrupe = 1;
		}
		if (tempSnagaKs >= 47 && tempSnagaKs < 62) {
			izracunGrupe = 2;
		}
		if (tempSnagaKs >= 62 && tempSnagaKs < 80) {
			izracunGrupe = 3;
		}
		if (tempSnagaKs >= 80 && tempSnagaKs < 110) {
			izracunGrupe = 4;
		}
		if (tempSnagaKs >= 110 && tempSnagaKs < 170) {
			izracunGrupe = 5;
		}
		if (tempSnagaKs >= 170) {
			izracunGrupe = 6;
		}

		BigDecimal result = new BigDecimal(izracunGrupe);

		return result;
	}

	@Override
	public String tekstOglasa() throws NemoguceOdreditiGrupuOsiguranjaException {
		String vrati;
		try {
			vrati = ("Naslov:"+ getNaslov() +", Opis:"+getOpis() + ", snaga "+snagaKs+" ,cijena Osiguranja: "+ izracunajCijenuOsiguranja() + ",cijena automobila"+ getCijena()+ ", stanje :" + getStanje());
		}catch (NemoguceOdreditiGrupuOsiguranjaException e) {
			vrati = ("Naslov:"+ getNaslov() +", Opis:"+getOpis() + ", snaga "+snagaKs+" ,cijena Osiguranja: "+ izracunajCijenuOsiguranja() + ",cijena automobila"+ getCijena()+ ", stanje :" + getStanje());

		}
		return vrati;
	}
	

}
