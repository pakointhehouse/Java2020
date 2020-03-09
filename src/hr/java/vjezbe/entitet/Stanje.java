package hr.java.vjezbe.entitet;

/**
 * 
 * @author Patrik
 *
 */
public enum Stanje {
	novo(1, "Novo jos nije raspakirano, garancija 2 godine!"),
	izvrsno(2, "Izvrsno stanje, nije korišteno, kao novo!"),
	rabljeno(3, "Korišteno nekoliko puta, sve ispravno."),
	neispravno(4, "U dijelova ili komplet prodaja.");
	
	private Integer kod;
	private String opis;
	
	/**
	 * Konstruktor enumeriacije za stanje usluge
	 * 
	 * @param kod
	 * @param opis
	 */
	private Stanje(Integer kod, String opis) {
		this.kod = kod;
		this.opis = opis;
	}
	/**
	 * Metoda koja vraca kod
	 * @return kod 
	 */
	public Integer getKod() {
		return kod;
	}
	/**
	 *Metoda koja postavlja kod 
	 * @param kod
	 */
	public void setKod(Integer kod) {
		this.kod = kod;
	}
	/**
	 * Metoda koja vraca opis
	 * @return opis 
	 */
	public String getOpis() {
		return opis;
	}
	/**
	 *Metoda koja postavlja opis 
	 * @param opis
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
}
