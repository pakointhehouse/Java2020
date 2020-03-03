package hr.java.vjezbe.entitet;

import java.util.List;

public class Kategorija {
	private String naziv;
	private List<Artikl> artikli;
		
	public Kategorija(String naziv, List<Artikl> artikl) {
			
			this.naziv = naziv;
			this.artikli = artikli;
		}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Artikl> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikl> artikli) {
		this.artikli = artikli;
	}

	

}
