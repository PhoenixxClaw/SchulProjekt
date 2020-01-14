package console_Benutzer;

import java.io.Console;
import java.util.Scanner;

import dao.BenutzerDAO;
import entities.Benutzer;
import methods.AusweisFunktionen;

public class BenutzerAnlegenConsole {

	public void start() {

		Console console = System.console();
		BenutzerDAO benutzerDAO = new BenutzerDAO();
		Benutzer benutzer = new Benutzer();
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		while (check) {
			System.out.println("Bitte geben Sie den Vornamen an.\nEingabe: ");
			benutzer.setVorname(sc.nextLine());
			System.out.println("Bitte geben Sie den Nachnamen an.\nEingabe: ");
			benutzer.setNachname(sc.nextLine());
			System.out.println("Bitte geben Sie den Geburtstag an.\nEingabe: ");
			benutzer.setGeburtsdatum(sc.nextLine());
			System.out.println("Bitte geben Sie die Adresse an.\nEingabe: ");
			benutzer.setAdresse(sc.nextLine());
			System.out.println("Bitte geben Sie die Postleitzahl an.\nEingabe: ");
			benutzer.setPLZ(sc.nextLine());
			System.out.println("Bitte geben Sie den Ort an.\nEingabe: ");
			benutzer.setORT(sc.nextLine());
			System.out.println("Bitte geben Sie den Benutzernamen an.\nEingabe: ");
			benutzer.setBenutzerName(sc.nextLine());
			System.out.println("Bitte geben Sie das Passwort an.\nEingabe: ");
			benutzer.setPasswort(String.copyValueOf(console.readPassword()));
			System.out.println("Soll der Benutzer Adminrechte haben?\n1: Ja\n2: Nein\nEingabe: ");
			int check2 = sc.nextInt();
			if (check2 == 1) {
				benutzer.setIsAdmin(true);
			} else {
				benutzer.setIsAdmin(false);
			}
			benutzer.setStatus("Aktiv");
			String benutzerNummer = "2";
			int neededSize = (Integer.valueOf(benutzerDAO.findLastBenutzer().getBenutzerNummer()) - 2000000000) + 1;
			int stringSize = Integer.toString(neededSize).length();

			for (int i = 0; i < (9 - stringSize); i++) {
				benutzerNummer = benutzerNummer + "0";
			}
			benutzerNummer = benutzerNummer + neededSize;
			benutzer.setBenutzerNummer(benutzerNummer);

			benutzerDAO.persist(benutzer);
			
			AusweisFunktionen ausweisFunktionen = new AusweisFunktionen();
			ausweisFunktionen.ausweisAnlegenMitBenutzer(benutzer);
			
			System.out.println("Wollen Sie einen weiteren Benutzer anlegen?\n1: Ja\n2: Nein\nEingabe: ");
			
			int check3 = sc.nextInt();
			if (check3 == 2) {
				check = false;
			}
			sc.nextLine();
		}
		

		benutzerDAO.shutdown();
	}
}
