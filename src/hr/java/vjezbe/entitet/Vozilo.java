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
	default BigDecimal IzracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		int zaSwitch = IzracunajCijenuOsiguranja().intValue();
		BigDecimal cijenaOsiguranja =new BigDecimal(500) ;
		
			switch(zaSwitch) {
			case 0:
				cijenaOsiguranja = new BigDecimal(3000);
				break;
			case 1:
				 cijenaOsiguranja = new BigDecimal(4000);
				 break;
			case 2:
				 cijenaOsiguranja= new BigDecimal(5000);
				 break;
			case 3:
				 cijenaOsiguranja = new BigDecimal(6000);
				 break;
			default:
				 cijenaOsiguranja = new BigDecimal(10000);
				 break;
			}
		return cijenaOsiguranja;
		
	}
	
}
