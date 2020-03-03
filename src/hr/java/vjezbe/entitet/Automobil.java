package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

public class Automobil extends Artikl implements Vozilo {
	
	
	private BigDecimal snagaKs;
	
	

	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}

	public Automobil(String naslov, String opis, BigDecimal cijena,BigDecimal snagaKs,Stanje stanje) throws NemoguceOdreditiGrupuOsiguranjaException {
		super(naslov, opis, cijena, stanje);
		this.snagaKs = snagaKs;
	}

	@Override
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		int grupaOsiguranja = 0;
		int grupa = izracunajKw(snagaKs).intValue();
		if (grupa <45) {
			grupaOsiguranja = 0;
		}else if(grupa>45 && grupa<55){
			grupaOsiguranja = 1;
		}else if(grupa>55 && grupa<65){
			grupaOsiguranja = 2;
		}else if(grupa>65 && grupa<75){
			grupaOsiguranja = 3;
		}else if(grupa>75 && grupa<85){
			grupaOsiguranja = 4;
			throw new NemoguceOdreditiGrupuOsiguranjaException("Previše kw, ne mogu odrediti grupu osiguranja.");
		}
		
		BigDecimal vrati = new BigDecimal(grupaOsiguranja);
		return vrati;
	}

	@Override
	public String tekstOglasa() throws NemoguceOdreditiGrupuOsiguranjaException {
		String vrati;
		try {
			vrati = ("Naslov:"+ getNaslov() +", Opis:"+getOpis() + ", snaga "+snagaKs+" ,cijena Osiguranja: "+ IzracunajCijenuOsiguranja() + ",cijena automobila"+ getCijena()+ ", stanje :" + getStanje());
		}catch (NemoguceOdreditiGrupuOsiguranjaException e) {
			vrati = ("Naslov:"+ getNaslov() +", Opis:"+getOpis() + ", snaga "+snagaKs+" ,cijena Osiguranja: "+ IzracunajCijenuOsiguranja() + ",cijena automobila"+ getCijena()+ ", stanje :" + getStanje());

		}
		return vrati;
	}
	

}
