package hr.java.vjezbe.iznimke;


/**
 * Klasa neoznacene iznimke CijenaJePreniskaException za obradu iznimke o cijeni
 * osiguranja
 * 
 * @author Marko Prtenjaca
 * @version 1.0
 */
public class CijenaJePreniskaException extends RuntimeException {


	/**
	 * Serijalni broj verzije UID
	 */
	private static final long serialVersionUID = 2555341954833609776L;

	/**
	 * Iznimka za nemogucnost odredivanja cijene
	 */
	public CijenaJePreniskaException() {
		super();
	}

	/**
	 * Iznimka za nemogucnost odredivanja cijene
	 * 
	 * @param message - Poruka
	 */
	public CijenaJePreniskaException(String message) {
		super(message);
	}

	/**
	 * Iznimka za nemogucnost odredivanja cijene
	 * 
	 * @param message - Poruka
	 * @param cause   - Razlog iznimke
	 */
	public CijenaJePreniskaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Iznimka za nemogucnost odredivanja cijene
	 * 
	 * @param cause - Razlog iznimke
	 */
	public CijenaJePreniskaException(Throwable cause) {
		super(cause);
	}

}