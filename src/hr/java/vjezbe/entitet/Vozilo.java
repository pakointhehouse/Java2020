package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

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
	 * @param konjskaSnaga
	 * @return kilowat
	 */
	 default BigDecimal izracunajKw(BigDecimal konjskaSnaga) {
		 
		BigDecimal koeficijent = new BigDecimal(0.7355);
		BigDecimal kilowat = konjskaSnaga.multiply(koeficijent);

		return kilowat;
		
	}
	
	 /**
	  * Izracunava grupu osiguranja
	  * 
	  * @return grupa osiguranja
	  * @throws NemoguceOdreditiGrupuOsiguranjaException
	  */
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;
	
	/**
	 * Izracunava cijenu osiguranja
	 * 
	 * @return cijena osiguranja
	 * @throws NemoguceOdreditiGrupuOsiguranjaException
	 */
	default BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {

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
