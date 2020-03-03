package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Usluga extends Artikl {

	public Usluga(String naslov, String opis, BigDecimal cijena,Stanje stanje) {
		super(naslov, opis, cijena,stanje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String tekstOglasa() {
		String vrati = ("Naslov:"+ getNaslov() +", Opis:"+getOpis() + ", cijena automobila"+ getCijena() + ", stanje :" + getStanje()) ;
		return vrati;
	}

	
}
