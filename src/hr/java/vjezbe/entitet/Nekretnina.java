package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

public interface Nekretnina {
	
	
	
	
	  default BigDecimal izracunajPorez(BigDecimal cijenaNekretnine) {
		  BigDecimal porez = null;
		
		if (cijenaNekretnine.intValue() >= 10000) {
		    porez = cijenaNekretnine.multiply(new BigDecimal(0.03));
		} else {
			throw new CijenaJePreniskaException("Cijena ne smije biti manja od 10000kn");
		}
		
		return porez;
	  }


}

