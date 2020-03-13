package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;
/**
 * 
 * @author Patrik
 *
 */
public interface Vozilo {

	/**
	 * Izracunava kilowate
	 * 
	 * @param konjskaSnaga - konjska snaga automobila
	 * @return kilowat - vraca snagu u kilowatima
	 */
	 default BigDecimal izracunajKw(BigDecimal konjskaSnaga) {
		 
		BigDecimal koeficijent = new BigDecimal(0.7355);
		BigDecimal kilowat = konjskaSnaga.multiply(koeficijent);

		return kilowat;
		
	}
	
	 /**
	  * Izracunava grupu osiguranja
	  * 
	  * @return grupa osiguranja - vraca iznimku da se nemoze odrediti grupa osiguranja
	  * @throws NemoguceOdreditiGrupuOsiguranjaException - baca iznimku da se nemoze odrediti grupa osiguranja
	  */
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;
	
	/**
	 * Izracunava cijenu osiguranja
	 * 
	 * @return cijena osiguranja - vraca cijenu osiguranja
	 * @throws NemoguceOdreditiGrupuOsiguranjaException - baca iznimku nemoguce odrediti grupu osiguranja
	 */
	default BigDecimal izracunajCijenuOsiguranja() throws  NemoguceOdreditiGrupuOsiguranjaException{

		BigDecimal tempGrupa;
		int tempResult = 0;

		tempGrupa = izracunajGrupuOsiguranja();

		int value = tempGrupa.intValue();

		switch (value) {

		case 1:
			tempResult = 2000;
			break;
		case 2:
			tempResult = 2500;
			break;
		case 3:
			tempResult = 2700;
			break;
		case 4:
			tempResult = 3000;
			break;
		case 5:
			tempResult = 3500;
			break;
		default:
			break;
		}

		BigDecimal result = new BigDecimal(tempResult);

		return result;

	}

	
}
