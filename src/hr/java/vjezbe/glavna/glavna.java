package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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


public class glavna {

	private static final Logger logger = LoggerFactory.getLogger(glavna.class);
	
	public static void main(String[] args) throws NemoguceOdreditiGrupuOsiguranjaException {
		
		logger.info("Picka ti se zgadola");
		
		Scanner unos = new Scanner(System.in);
		
		//Inicijaliziranje korisnika
		System.out.print("Unesite broj korisnika koje zelite unjeti");
		Integer numKorisnika= unesiBrojUzProvjeru(unos);
		List <Korisnik> listaKorisnika = new ArrayList<Korisnik>(numKorisnika);
		unesiKorisnika(unos,listaKorisnika,numKorisnika);
		
		//Inicijaliziranje Kategorija i Artikala
		System.out.print("Unesite broj kategorija koje zelite unjeti");
		Integer brojKategorija = unesiBrojUzProvjeru(unos);
		List<Kategorija> listaKategorije = new ArrayList<Kategorija>(brojKategorija);
		unesiKategorije(unos,listaKategorije,brojKategorija);
		
		//Inicijaliziranje prodaja
		System.out.println("Unesite broj artikala koji su aktivno na prodaju");
		Integer pomBrojAktivnih = unesiBrojUzProvjeru(unos);
		List <Prodaja> listaProdaja = new ArrayList<Prodaja>(pomBrojAktivnih);
		
		unesiProdaju(unos,listaKorisnika,listaKategorije,listaProdaja,pomBrojAktivnih);
		
		//Ispis rjesenja
		ispisi(listaProdaja);
		
		unos.close();
	}
	
	//Unosimo private ili poslovne korisnike u polje korisnika
	private static  void unesiKorisnika(Scanner unos,List<Korisnik> listaKorisnika,Integer numKorisnika) {
		unos.nextLine();
		System.out.println("Tz sam");
		for (int i = 0; i<numKorisnika;i++) {
			System.out.println(listaKorisnika.size());
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
	}
	
	//Unosi kategoriju i artikle koji su dio kategorija
	private static void unesiKategorije(Scanner unos,List<Kategorija> listaKategorije, Integer brojKategorija ) throws NemoguceOdreditiGrupuOsiguranjaException{
		unos.nextLine();
		for (int i = 0; i<listaKategorije.size()+1;i++) {
			System.out.println("Unesite naziv "+ (i +1) +". kategorije");
			String pomNaziv = unos.nextLine();
			System.out.println("Unesite broj artikla koji zelite unijeti za kategoriju");
			Integer pomBrojArtikla = unesiBrojUzProvjeru(unos);
			List <Artikl> listaArtikla = new ArrayList<Artikl>(pomBrojArtikla);
			unos.nextLine();
			for (int j = 0;j<pomBrojArtikla;j++) {
				
				System.out.println("Unesite tip "+(j+1)+". artikla\n1. Usluga\n2.Automobil");
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
					System.out.println("Unesite cijenu "+ (j +1) +". oglasa stana	");
					String pomStringCijena = unos.nextLine();
					System.out.print("Odabir stanja artikla >> ");
					Stanje pomStanje = unosStanja(unos);
					
					BigDecimal pomCijena = new BigDecimal(pomStringCijena.replaceAll(",", "."));
					Stan dodajArtikl = new Stan(pomNaslov,pomOpis,pomCijena,pomKvadratura,pomStanje);
					listaArtikla.add(dodajArtikl);
					
				}
			}
			Kategorija dodajNovu = new Kategorija(pomNaziv,listaArtikla);
			listaKategorije.add(dodajNovu);
		}
	}
	
	
	//Metoda za unos prodaje
	private static void unesiProdaju(Scanner unos , List<Korisnik> listaKorisnika,List <Kategorija> poljeKategorije,List<Prodaja> poljeProdaje, Integer pomBrojAktivnih) {
		for (int i = 0;i<poljeProdaje.size()+1;i++) {
			System.out.println("Odaberite korisnika: \n");
			
			for (int j = 0; j<listaKorisnika.size()+1;j++) {
				System.out.println((j+1) +listaKorisnika.get(j).dohvatiKontakt()+"\n");
			}
			
			Integer pomKorisnik = unesiBrojUzProvjeru(unos);
			unos.nextLine();
			System.out.println("Odaberite kategoriju:\n");
			
			for (int j = 0;j<poljeKategorije.size()+1;j++) {
				System.out.println((j+1)+ ". "+poljeKategorije.get(j).getNaziv());
			}
			
			Integer pomKategorija = unesiBrojUzProvjeru(unos);
			unos.nextLine();
			System.out.println("Odaberite artikl:\n");
			
			for (int j = 0;j<poljeKategorije.get(pomKategorija-1).getArtikli().size()+1;j++) {
				System.out.println((j+1)+ ". " + poljeKategorije.get(pomKategorija-1).getArtikli().get(j).getNaslov());
			}
			Integer pomArtiklKategorije = unesiBrojUzProvjeru(unos);
			unos.nextLine();
			
			LocalDate datum = LocalDate.now();
			Prodaja dodajNovog= new Prodaja(poljeKategorije.get(pomKategorija-1).getArtikli().get(pomArtiklKategorije-1),listaKorisnika.get(pomKorisnik-1),datum);
			poljeProdaje.add(dodajNovog);
		}
		
	}
	
	//unos novog privatnog Korisnika u polje Korisnika
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
	
	//unos novog poslovnog Korisnika u polje Korisnika
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
	
	//funkcija za provjeru integera
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
				  
			}
		}while(pogodio==false);
		System.out.println(provjerenaBrojka);
		return provjerenaBrojka;
	}
	
	//metoda za unos stanja
	private static Stanje unosStanja(Scanner unos) {
		 for (int i = 0; i < Stanje.values().length; i++) {
			 System.out.println((i + 1) + ". " + Stanje.values()[i]);
		 }
		Integer stanjeRedniBroj = unesiBrojUzProvjeru(unos);
		unos.nextLine();
		return Stanje.values()[stanjeRedniBroj - 1];
	}
	
	//Metoda za ispis
	private static void ispisi(List<Prodaja> listaProdaja) {
		System.out.println("Trenutni su oglasi na prodaju:");
		for (int i = 0; i< listaProdaja.size()+1;i++) {
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

}
