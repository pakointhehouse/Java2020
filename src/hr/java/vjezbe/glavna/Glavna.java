package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Kategorija;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.entitet.Usluga;
import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * 
 * @author Patrik
 * @version 1.0
 */
public class Glavna {

	private static final Logger logger = LoggerFactory.getLogger(Glavna.class);
	
	public static void main(String[] args) throws NemoguceOdreditiGrupuOsiguranjaException {
		
		logger.info("Pocinje program");
		
		Scanner unos = new Scanner(System.in);
		
		//Inicijaliziranje korisnika
		System.out.print("Unesite broj korisnika koje zelite unjeti");
		Integer numKorisnika= unesiBrojUzProvjeru(unos);
		List <Korisnik> listaKorisnika = new ArrayList<Korisnik>();
		unesiKorisnika(unos,listaKorisnika,numKorisnika);
		
		//Inicijaliziranje Kategorija i Artikala
		System.out.print("Unesite broj kategorija koje zelite unjeti");
		Integer brojKategorija = unesiBrojUzProvjeru(unos);
		Map<Kategorija<Artikl>, List<Artikl>> mapaArtikla = new HashMap<Kategorija<Artikl>, List<Artikl>>();
		List<Kategorija<Artikl>> listaKategorije = new ArrayList<Kategorija<Artikl>>();
		unesiKategorije(unos,listaKategorije,brojKategorija,mapaArtikla);
		
		//Inicijaliziranje prodaja
		System.out.println("Unesite broj artikala koji su aktivno na prodaju");
		Integer pomBrojAktivnih = unesiBrojUzProvjeru(unos);
		List <Prodaja> listaProdaja = new ArrayList<Prodaja>();
		unesiProdaju(unos,listaKorisnika,listaKategorije,listaProdaja,pomBrojAktivnih);
		
		//Ispis rjesenja
		ispisi(listaProdaja);
		ispisPoKategorijama(listaKategorije);
		ispisiPoMapi(mapaArtikla);
		
		unos.close();
		logger.info("Kraj programa");
	}
	
	/**
	 * Funkcija koja unosi tip korisnika
	 * 
	 * @param unos
	 * @param listaKorisnika
	 * @param numKorisnika
	 */
	private static  void unesiKorisnika(Scanner unos,List<Korisnik> listaKorisnika,Integer numKorisnika) {
		unos.nextLine();
		for (int i = 0; i<numKorisnika;i++) {
			System.out.print("Unesite tip korisnika\n1.Privatni\n2.Poslovni\n");
			Integer tipKorisnika= unesiBrojUzProvjeru(unos);
			
			if(tipKorisnika==1) {
				unos.nextLine();
				unesiPrivatnogKorisnika(unos,listaKorisnika,i);
				
			}else {
				unos.nextLine();
				unesiPoslovnogKorisnika(unos,listaKorisnika,i);
				
			}
		}
		logger.info("Korisnici odabrani");
	}
	
	/**
	 * Funkcija koja unosi artikle u ordredene kategorije
	 * 
	 * @param unos
	 * @param listaKategorije
	 * @param brojKategorija
	 * @param mapaArtikla
	 * @throws NemoguceOdreditiGrupuOsiguranjaException
	 */
	private static void unesiKategorije(Scanner unos,List<Kategorija<Artikl>> listaKategorije, Integer brojKategorija, Map<Kategorija<Artikl>, List<Artikl>> mapaArtikla ) throws NemoguceOdreditiGrupuOsiguranjaException{
		unos.nextLine();
		for (int i = 0; i<brojKategorija;i++) {
			System.out.println("Unesite naziv "+ (i +1) +". kategorije");
			String pomNaziv = unos.nextLine();
			System.out.println("Unesite broj artikla koji zelite unijeti za kategoriju");
			Integer pomBrojArtikla = unesiBrojUzProvjeru(unos);
			List <Artikl> listaArtikla = new ArrayList<Artikl>(pomBrojArtikla);
			unos.nextLine();
			//Unosimo artikl i dodajemo ga u neku kategoriju odredenu za artikle
			for (int j = 0;j<pomBrojArtikla;j++) {
				
				System.out.println("Unesite tip "+(j+1)+". artikla\n1. Usluga\n2.Automobil\n3.Stan");
				Integer pomTip = unesiBrojUzProvjeru(unos); 
				
				if(pomTip == 1) {
					unos.nextLine();
					System.out.println("Unesite naslov "+ (j +1) +". oglasa usluge");
					String pomNaslov = unos.nextLine();
					System.out.println("Unesite opis "+ (j +1) +". oglasa usluge");
					String pomOpis = unos.nextLine();
					System.out.println("Unesite cijenu "+ (j +1) +". oglasa usluge");
					String pomStringCijena = unos.nextLine();
					System.out.print("Odabir stanja artikla >> ");
					Stanje pomStanje = unosStanja(unos);
					
					BigDecimal pomCijena = new BigDecimal(pomStringCijena.replaceAll(",", "."));
					Artikl dodajArtikl = new Usluga(pomNaslov,pomOpis,pomCijena,pomStanje);
					listaArtikla.add(dodajArtikl);
					
				}else if(pomTip == 2) {
					unos.nextLine();
					System.out.println("Unesite naslov "+ (j +1) +". oglasa Automobila");
					String pomNaslov = unos.nextLine();
					System.out.println("Unesite opis "+ (j +1) +". oglasa Automobila");
					String pomOpis = unos.nextLine();
					System.out.println("Unesite snagu "+ (j +1) +". oglasa Automobila");
					String stringSnaga = unos.nextLine();
					System.out.println("Unesite cijenu "+ (j +1) +". oglasa Automobila");
					String pomStringCijena = unos.nextLine();
					System.out.print("Odabir stanja artikla >> ");
					Stanje pomStanje = unosStanja(unos);
					
					BigDecimal pomSnaga = new BigDecimal(stringSnaga);
					BigDecimal pomCijena = new BigDecimal(pomStringCijena.replaceAll(",", "."));
					Artikl dodajArtikl = new Automobil(pomNaslov,pomOpis,pomCijena,pomSnaga,pomStanje);
					listaArtikla.add(dodajArtikl);
					
				}else if(pomTip == 3) {
					unos.nextLine();
					System.out.println("Unesite naslov "+ (j +1) +". oglasa stana");
					String pomNaslov = unos.nextLine();
					System.out.println("Unesite opis "+ (j +1) +". oglasa stana");
					String pomOpis = unos.nextLine();
					System.out.println("Unesite kvadraturu "+ (j +1) +". oglasa stana");
					Integer pomKvadratura = unesiBrojUzProvjeru(unos);
					unos.nextLine();
					System.out.println("Unesite cijenu "+ (j +1) +". oglasa stana	");
					String pomStringCijena = unos.nextLine();
					System.out.print("Odabir stanja artikla >> ");
					Stanje pomStanje = unosStanja(unos);
					
					BigDecimal pomCijena = new BigDecimal(pomStringCijena.replaceAll(",", "."));
					Stan dodajArtikl = new Stan(pomNaslov,pomOpis,pomCijena,pomKvadratura,pomStanje);
					listaArtikla.add(dodajArtikl);
					
				}
			}
			Kategorija<Artikl> dodajNovu = new Kategorija<Artikl>(pomNaziv);
			dodajNovu.dodajListuArtikla(listaArtikla);
			mapaArtikla.put(dodajNovu, listaArtikla);
			listaKategorije.add(dodajNovu);
		}
		logger.info("Kategorije i artikli odabrani");
	}
	
	
	/**
	 * Funkcija koja unosi prodaje i odlucuje koje su aktivne
	 * 
	 * @param unos
	 * @param listaKorisnika
	 * @param listaKategorije
	 * @param listaProdaje
	 * @param pomBrojAktivnih
	 */
	private static void unesiProdaju(Scanner unos , List<Korisnik> listaKorisnika,List <Kategorija<Artikl>> listaKategorije,List<Prodaja> listaProdaje, Integer pomBrojAktivnih) {
		for (int i = 0;i<pomBrojAktivnih;i++) {
			System.out.println("Odaberite korisnika: \n");
			
			for (int j = 0; j<listaKorisnika.size();j++) {
				System.out.println((j+1) +listaKorisnika.get(j).dohvatiKontakt()+"\n");
			}
			
			Integer pomKorisnik = unesiBrojUzProvjeru(unos);
			unos.nextLine();
			System.out.println("Odaberite kategoriju:\n");
			
			for (int j = 0;j<listaKategorije.size();j++) {
				System.out.println((j+1)+ ". "+listaKategorije.get(j).getNaziv());
			}
			
			Integer pomKategorija = unesiBrojUzProvjeru(unos);
			unos.nextLine();
			System.out.println("Odaberite artikl:\n");
			System.out.println("size je :" +listaKategorije.get(pomKategorija-1).getListaArtikala().size());
			for (int j = 0;j<listaKategorije.get(pomKategorija-1).getListaArtikala().size();j++) {
				System.out.println((j+1)+ ". " + listaKategorije.get(pomKategorija-1).dohvatiArtikl(j).getNaslov());
			}
			Integer pomArtiklKategorije = unesiBrojUzProvjeru(unos);
			unos.nextLine();
			
			LocalDate datum = LocalDate.now();
			Prodaja dodajNovog= new Prodaja(listaKategorije.get(pomKategorija-1).dohvatiArtikl(pomArtiklKategorije-1),listaKorisnika.get(pomKorisnik-1),datum);
			listaProdaje.add(dodajNovog);
		}
		logger.info("Prodaje unesene");
		
	}
	
	/**
	 * Funkcija koja unosi privatnog korisnika
	 * 
	 * @param unos
	 * @param listaKorisnika
	 * @param i
	 */
	private static void unesiPrivatnogKorisnika(Scanner unos,List<Korisnik> listaKorisnika,Integer i) {

		System.out.println("Unesite ime "+ (i +1) +". Korisnika");
		String pomIme = unos.nextLine();
		System.out.println("Unesite prezime "+ (i +1) +". Korisnika");
		String pomPrezime = unos.nextLine();
		System.out.println("Unesite email "+ (i +1) +". Korisnika");
		String pomEmail = unos.nextLine();
		System.out.println("Unesite telefon "+ (i +1) +". Korisnika");
		String pomTelefon = unos.nextLine();
		PrivatniKorisnik dodajNovog= new PrivatniKorisnik(pomIme,pomPrezime,pomEmail,pomTelefon);
		listaKorisnika.add(dodajNovog);
	}
	
	/**
	 * Funkcija koja unsi poslovnog korisnika
	 * 
	 * @param unos
	 * @param listaKorisnika
	 * @param i
	 */
	private static void unesiPoslovnogKorisnika(Scanner unos,List<Korisnik> listaKorisnika,Integer i) {
		System.out.println("Unesite naziv "+ (i +1) +". Korisnika");	
		String pomNaziv = unos.nextLine();
		System.out.println("Unesite web "+ (i +1) +". Korisnika");
		String pomWeb = unos.nextLine();
		System.out.println("Unesite email "+ (i +1) +". Korisnika");
		String pomEmail = unos.nextLine();
		System.out.println("Unesite telefon "+ (i +1) +". Korisnika");
		String pomTelefon = unos.nextLine();
		PoslovniKorisnik dodajNovog= new PoslovniKorisnik(pomNaziv,pomWeb,pomEmail,pomTelefon);
		listaKorisnika.add(dodajNovog);
	}
	
	/**
	 * Funkcija koja provjerava Integer
	 * @param unos
	 * @return provjerena brojka
	 */
	private static Integer unesiBrojUzProvjeru(Scanner unos) {
		boolean pogodio = false;
		Integer provjerenaBrojka= 0;
		do {
			try {
				provjerenaBrojka = unos.nextInt();
				pogodio = true;
			} catch (Exception e ) {
				unos.nextLine();
				  pogodio = false;
				  e.printStackTrace();
				  System.err.println("Unesite brojku");
				  logger.info("Unesen kriv tip podataka, upisite brojku");
				  
			}
		}while(pogodio==false);
		System.out.println(provjerenaBrojka);
		return provjerenaBrojka;
	}
	
	/**
	 * Funkcija za unos stanja artikla
	 * 
	 * @param unos
	 * @return
	 */
	private static Stanje unosStanja(Scanner unos) {
		 for (int i = 0; i < Stanje.values().length; i++) {
			 System.out.println((i + 1) + ". " + Stanje.values()[i]);
		 }
		Integer stanjeRedniBroj = unesiBrojUzProvjeru(unos);
		unos.nextLine();
		return Stanje.values()[stanjeRedniBroj - 1];
	}
	
	/**
	 * Funkcija za ispis aktivnih prodaja
	 * 
	 * @param listaProdaja
	 */
	private static void ispisi(List<Prodaja> listaProdaja) {
		System.out.println("Trenutni su oglasi na prodaju:");
		for (int i = 0; i<listaProdaja.size();i++) {
			System.out.println("Naslov : " + listaProdaja.get(i).getArtikl().getNaslov());
			System.out.println("Opis: "+ listaProdaja.get(i).getArtikl().getOpis());
			System.out.println("Cijena: "+ listaProdaja.get(i).getArtikl().getCijena());
			//Datum objave nije u Stringu i tu ga moramo pretvorit u string
			LocalDate datum = listaProdaja.get(i).getDatumObjave();
			String stringDatum = datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			System.out.println("Datum: " + stringDatum +"\n" );
			//finalni ispis
			System.out.println(listaProdaja.get(i).getKorisnik().dohvatiKontakt());
		}
	}
	
	/**
	 * Funkcija za ispit artikala po kategorijama
	 * 
	 * @param listaKategorija
	 * @throws NemoguceOdreditiGrupuOsiguranjaException
	 */
	private static void ispisPoKategorijama(List<Kategorija<Artikl>> listaKategorija) throws NemoguceOdreditiGrupuOsiguranjaException {
		System.out.println("\nTrenutni oglasi po kategorijama:\n");
		for(int i = 0;i < listaKategorija.size(); i++) {
			System.out.println("Kategorija" + listaKategorija.get(i).getNaziv());
			for (int j = 0;j < listaKategorija.get(i).getListaArtikala().size();j++) {
				System.out.println(listaKategorija.get(i).dohvatiArtikl(j).tekstOglasa());
			}
		}
	}
	
	/**
	 * Funkcija za ispis artikala kategorija iz mape
	 * 
	 * @param mapaArtikla
	 */
	private static void ispisiPoMapi(Map <Kategorija<Artikl>,List<Artikl>> mapaArtikla) {
		System.out.println("\nTrenutni oglasi po mapama:\n");
		
		mapaArtikla.forEach((k, v) -> {
		System.out.println("Kategorija : " + k.getNaziv());
		System.out.println("--------------------------------------------------------------------------------");
		mapaArtikla.get(k).forEach(m -> {
			try {
				System.out.println(m.tekstOglasa()
						+ "\n--------------------------------------------------------------------------------");
			} catch (NemoguceOdreditiGrupuOsiguranjaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});});
	}

}
