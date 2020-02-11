package methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import alerts.Alerts;
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

	public void ausweisVerlaengern(String ausweisNummer, int monatsZahl) {
		DateConverter dateConverter = new DateConverter();
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(ausweisNummer);
		ausweis.setAblaufDatum(dateConverter.convertMonth(ausweis.getAblaufDatum(), monatsZahl));
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
	}
	
	public void ausweisVerlaengernByAusweisID(int ausweisID, int monatsZahl) {
		DateConverter dateConverter = new DateConverter();
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.find(ausweisID);
		ausweis.setAblaufDatum(dateConverter.convertMonth(ausweis.getAblaufDatum(), monatsZahl));
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
	}
	
	public void statusAnpassen (String ausweisNummer, int aktion, boolean console) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO
				.findByAusweisNummer(ausweisNummer);
		switch (aktion) {
		case 1:
			ausweis.setStatus("Abgelaufen");
			ausweisDAO.update(ausweis);
			ausweisDAO.shutdown();
			break;
		case 2:
			ausweis.setStatus("Gültig");
			ausweisDAO.update(ausweis);
			ausweisDAO.shutdown();
		case 3:
			Alerts alert = new Alerts();
			ausweis.setStatus("Verloren");
			ausweisDAO.update(ausweis);
			ausweisDAO.shutdown();
			if (console) {
				boolean check = alert.ausweisVerlorenNeuenAnlegen();
				if (check) {
					ausweisAnlegenMitBenutzerNummer(ausweis.getBenutzer().getBenutzerNummer());
				}
			} else {
				System.out.println("Wollen Sie einen neuen Ausweis für den Benutzer anlegen?"
						+"\n1: Ja\n2: Nein\nEingabe: ");
				Scanner sc = new Scanner(System.in);
				if (sc.nextInt()==1) {
					ausweisAnlegenMitBenutzerNummer(ausweis.getBenutzer().getBenutzerNummer());
				}
			}
			
		default:
			break;
		}
	}
	
	public void statusAnpassenByAusweisID (int ausweisID, int aktion, boolean console) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.find(ausweisID);
		switch (aktion) {
		case 1:
			ausweis.setStatus("Abgelaufen");
			ausweisDAO.update(ausweis);
			ausweisDAO.shutdown();
			break;
		case 2:
			ausweis.setStatus("Gültig");
			ausweisDAO.update(ausweis);
			ausweisDAO.shutdown();
		case 3:
			Alerts alert = new Alerts();
			ausweis.setStatus("Verloren");
			ausweisDAO.update(ausweis);
			ausweisDAO.shutdown();
			if (console) {
				boolean check = alert.ausweisVerlorenNeuenAnlegen();
				if (check) {
					ausweisAnlegenMitBenutzerNummer(ausweis.getBenutzer().getBenutzerNummer());
				}
			} else {
				System.out.println("Wollen Sie einen neuen Ausweis für den Benutzer anlegen?"
						+"\n1: Ja\n2: Nein\nEingabe: ");
				Scanner sc = new Scanner(System.in);
				if (sc.nextInt()==1) {
					ausweisAnlegenMitBenutzerNummer(ausweis.getBenutzer().getBenutzerNummer());
				}
			}
		default:
			break;
		}
	}
}
