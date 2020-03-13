package hr.java.vjezbe.iznimke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.glavna.Glavna;

/**
 * Oznacena klasa NemoguceOdreditiGrupuOsiguranjaException koja se poziva kada
 * je nemoguce odrediti grupu osiguranja
 * 
 * @author Patrik Mede
 * @version 1.0
 */

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(Glavna.class);

	/**
	 * Serijalni broj verzije UID
	 */
	private static final long serialVersionUID = -7129354463190839198L;

	/**
	 * Iznimka za nemogucnost odredivanja osiguranja automobila
	 */
	public NemoguceOdreditiGrupuOsiguranjaException() {
		super();
		logger.info("Nema grupe osiguranja");
	}

	/**
	 * Iznimka za nemogucnost odredivanja osiguranja automobila
	 * 
	 * @param message - Poruka iznimke
	 */
	public NemoguceOdreditiGrupuOsiguranjaException(String message) {
		super(message);
		logger.info("Nema grupe osiguranja");
	}

	/**
	 * Iznimka za nemogucnost odredivanja osiguranja automobila
	 * 
	 * @param message - Poruka iznimke
	 * @param cause   - Razlog iznimke
	 */
	public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Iznimka za nemogucnost odredivanja osiguranja automobila
	 * 
	 * @param cause - Razlog iznimke
	 */
	public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
		super(cause);
	}
}