package console_Benutzer;

import java.util.Scanner;

import dao.BenutzerDAO;
import entities.Benutzer;

public class BenutzerBearbeitenConsole {

	private String format = "%1$-18s%2$s";
	private BenutzerDAO benutzerDAO = new BenutzerDAO();

	public void start(Benutzer benutzer) {

		boolean check = true;
		while (check) {
			loadBenutzerInfo(benutzer);
			System.out.println("Was wollen sie bearbeiten?\n1. Vorname\n2. Nachname\n3: Geburtsdatum\n"
					+ "4: Adresse\n5: Postleitzahl\n6: Ort\n7: Benutzername\n8: Speichern und zurückkehren\nEingabe: ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			sc.nextLine();
			String input2 = "";
			switch (input) {
			case 1:
				System.out.println("Bitte geben Sie den neuen Vornamen an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setVorname(input2);
				break;
			case 2:
				System.out.println("Bitte geben Sie den neuen Nachnamen an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setNachname(input2);
				break;
			case 3:
				System.out.println("Bitte geben Sie das neue Geburtsdatum an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setGeburtsdatum(input2);
				break;
			case 4:
				System.out.println("Bitte geben Sie die neue Adresse an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setAdresse(input2);
				break;
			case 5:
				System.out.println("Bitte geben Sie die neue Postleitzahl an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setPLZ(input2);
				break;
			case 6:
				System.out.println("Bitte geben Sie den neuen Ort an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setORT(input2);
				break;
			case 7:
				System.out.println("Bitte geben Sie den neuen Benutzernamen an.\nEingabe: ");
				input2 = sc.nextLine();
				benutzer.setBenutzerName(input2);

				break;
			case 8:
				benutzerDAO.update(benutzer);
				benutzerDAO.shutdown();
				check = false;
				break;

			default:
				System.out.println("Fehlerhafte Eingabe. Bitte erneut versuchen.");
				break;
			}
		}
	}

	public void loadBenutzerInfo(Benutzer benutzer) {
		String admin = "";
		System.out.format(format, "\n\nVorname:  ", benutzer.getVorname());
		System.out.format(format, "\nNachname: ", benutzer.getNachname());
		System.out.format(format, "\nGeburtstag: ", benutzer.getGeburtsdatum());
		System.out.format(format, "\nAdresse: ", benutzer.getAdresse());
		System.out.format(format, "\nPostleitzahl: ", benutzer.getPLZ());
		System.out.format(format, "\nOrt: ", benutzer.getORT());
		System.out.format(format, "\nBenutzernummer: ", benutzer.getBenutzerNummer());
		System.out.format(format, "\nBenutzername: ", benutzer.getBenutzerName());
		if (benutzer.getIsAdmin()) {
			admin = "Ja\n\n";
		} else {
			admin = "nein\n\n";
		}
		System.out.format(format, "\nIst Admin: ", admin);
	}
}
