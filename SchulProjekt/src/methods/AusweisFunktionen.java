package methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.AusweisDAO;
import dao.BenutzerDAO;
import entities.Ausweis;
import entities.Benutzer;

public class AusweisFunktionen {

	public void ausweisAnlegenMitBenutzer(Benutzer benutzer) {
		BenutzerDAO benutzerDAO = new BenutzerDAO();
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = new Ausweis();

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String datum = dateFormat.format(date);
		ausweis.setErstellDatum(datum);
		String erstellDatum = datum;
		String[] split = erstellDatum.split("-");
		String ablaufJahr = split[2];
		ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
		String ablaufDatum = split[0] + "-" + split[1] + "-" + ablaufJahr;
		ausweis.setAblaufDatum(ablaufDatum);
		ausweis.setBenutzer(benutzer);
		ausweis.setStatus("Gültig");
		String ausweisNummer = "1";
		int latestAusweisID = ausweisDAO.findLastAusweis().getAusweisID();

		System.out.println(latestAusweisID);
		Ausweis latestAusweis = ausweisDAO.find(latestAusweisID);
		System.out.println(latestAusweis.getBenutzer());
		String latestAusweisNumber = latestAusweis.getAusweisNummer();
		System.out.println(latestAusweisNumber);
		int ausweisNumber = (Integer.valueOf(latestAusweisNumber) - 1000000000) + 1;
		int ausweisStringSize = Integer.toString(ausweisNumber).length();

		for (int i = 0; i < (9 - ausweisStringSize); i++) {
			ausweisNummer = ausweisNummer + "0";
		}
		ausweisNummer = ausweisNummer + ausweisNumber;
		ausweis.setAusweisNummer(ausweisNummer);
		ausweis.setBenutzer(benutzer);
		ausweisDAO.persist(ausweis);
		ausweisDAO.shutdown();
		benutzerDAO.shutdown();
	}

	public void ausweisAnlegenMitBenutzerNummer(String benutzerNummer) {
		BenutzerDAO benutzerDAO = new BenutzerDAO();
		Benutzer benutzer = benutzerDAO.findByBenutzerNummer(benutzerNummer);
		benutzerDAO.shutdown();
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = new Ausweis();

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String datum = dateFormat.format(date);
		ausweis.setErstellDatum(datum);
		String erstellDatum = datum;
		String[] split = erstellDatum.split("-");
		String ablaufJahr = split[2];
		ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
		String ablaufDatum = split[0] + "-" + split[1] + "-" + ablaufJahr;
		ausweis.setAblaufDatum(ablaufDatum);
		ausweis.setBenutzer(benutzer);
		ausweis.setStatus("Gültig");
		String ausweisNummer = "1";
		int latestAusweisID = ausweisDAO.findLastAusweis().getAusweisID();

		System.out.println(latestAusweisID);
		Ausweis latestAusweis = ausweisDAO.find(latestAusweisID);
		System.out.println(latestAusweis.getBenutzer());
		String latestAusweisNumber = latestAusweis.getAusweisNummer();
		System.out.println(latestAusweisNumber);
		int ausweisNumber = (Integer.valueOf(latestAusweisNumber) - 1000000000) + 1;
		int ausweisStringSize = Integer.toString(ausweisNumber).length();

		for (int i = 0; i < (9 - ausweisStringSize); i++) {
			ausweisNummer = ausweisNummer + "0";
		}
		ausweisNummer = ausweisNummer + ausweisNumber;
		ausweis.setAusweisNummer(ausweisNummer);
		ausweis.setBenutzer(benutzer);
		ausweisDAO.persist(ausweis);
		ausweisDAO.shutdown();
		benutzerDAO.shutdown();
	}
}
