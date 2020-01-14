package console_Benutzer;

import java.util.List;
import java.util.Scanner;

import dao.BenutzerDAO;
import entities.Ausweis;
import entities.Benutzer;

public class MainBenutzerConsole {
	private String format = "%1$-8s|%2$-20s|%3$-20s|%4$-15s|%5$-10s|%6$-30s|\n";
	private BenutzerDAO benutzerDAO = new BenutzerDAO();
	public void start() {
		getBenutzer();
		boolean check = true;
		while (check) {
			System.out.println(
					"Wählen Sie eine Option aus. \n1: Benutzer anlegen\n2: Benutzer Informationen\n3: Benutzer Bearbeiten\n4: Zum vorherigen Menu zurückkehren\nEingabe: ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			int input2;
			switch (input) {
			case 1:
				BenutzerAnlegenConsole bac = new BenutzerAnlegenConsole();
				bac.start();
				break;
			case 2:
				// Input InformationenCall
				System.out.println("Geben sie die Nummer des Benutzers an.\nEingabe: ");
				input2 = sc.nextInt();
				BenutzerInformationenConsole bic = new BenutzerInformationenConsole();
				bic.start(benutzerDAO.find(input2));
				break;
			case 3:
				// Input BearbeitenCall
				System.out.println("Geben sie die Nummer des Benutzers an.\nEingabe: ");
				input2 = sc.nextInt();
				BenutzerBearbeitenConsole bbc = new BenutzerBearbeitenConsole();
				bbc.start(benutzerDAO.find(input2));
				break;

			case 4:
				check = false;
				benutzerDAO.shutdown();
				break;

			default:
				System.out.println("Fehlerhafte Eingabe. Bitte erneut versuchen.");
				break;
			}
		}

	}

	public String getAusleihStatus(Benutzer benutzer, String ausleihStatus) {
		int buecherzahl = 0;
		for (int j = 0; j < benutzer.getAusweis().size(); j++) {
			Ausweis ausweis = benutzer.getAusweis().get(j);

			if (ausweis.getBuecher().size() == 0 || ausweis.getBuecher() == null && buecherzahl == 0) {
				ausleihStatus = "Keine Bücher ausgeliehen";
			} else {
				buecherzahl = buecherzahl + ausweis.getBuecher().size();
				ausleihStatus = buecherzahl + " Bücher ausgeliehen";
			}

		}
		return ausleihStatus;
	}

	public void getBenutzer() {

		
		List<Benutzer> benutzerList = benutzerDAO.findAllBenutzer();
		System.out.format(format, "Nummer", "Vorname", "Nachname", "Benutzernummer", "Status", "Ausleihstatus");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < benutzerList.size(); i++) {
			Benutzer benutzer = benutzerList.get(i);
			String ausleihStatus = "";
			ausleihStatus = getAusleihStatus(benutzer, ausleihStatus);
			System.out.format(format, benutzer.getBenutzerID(), benutzer.getVorname(), benutzer.getNachname(), benutzer.getBenutzerNummer(),
					benutzer.getStatus(), ausleihStatus);

		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
	}
}
