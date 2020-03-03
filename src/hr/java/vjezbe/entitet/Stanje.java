package hr.java.vjezbe.entitet;

public enum Stanje {
	novo(1, "Novo jos nije raspakirano, garancija 2 godine!"),
	izvrsno(2, "Izvrsno stanje, nije korišteno, kao novo!"),
	rabljeno(3, "Korišteno nekoliko puta, sve ispravno."),
	neispravno(4, "U dijelova ili komplet prodaja.");
	
	private Integer kod;
	private String opis;
	
	
	private Stanje(Integer kod, String opis) {
		this.kod = kod;
		this.opis = opis;
	}
	
	public Integer getKod() {
		return kod;
	}
	public void setKod(Integer kod) {
		this.kod = kod;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
}
