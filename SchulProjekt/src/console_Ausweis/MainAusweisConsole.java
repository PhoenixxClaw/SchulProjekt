package console_Ausweis;

import java.util.List;
import java.util.Scanner;

import dao.AusweisDAO;
import entities.Ausweis;
import entities.Benutzer;
import methods.AusweisFunktionen;

public class MainAusweisConsole {
	private String format = "%1$-8s|%2$-15s|%3$-20s|%4$-15s|%5$-15s|%6$-13s|\n";
	private AusweisDAO ausweisDAO = new AusweisDAO();
	private AusweisFunktionen aF = new AusweisFunktionen();

	public void start() {
		getAusweise();
		boolean check = true;
		while (check) {
			System.out.println("Wählen Sie eine Option aus.\n1: Ausweisinformationen"
					+ "\n2: Status anpassen\n3: Ausweis verlängern\n4: Ausweis löschen"
					+ "\n5: Zum vorherigen Menu zurückkehren\nEingabe: ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			int input2 = 0;
			int input3 = 0;
			switch (input) {
			case 1:
				System.out.println("Geben sie die Nummer des Ausweises an.\nEingabe: ");
				input2 = sc.nextInt();
				AusweisInformationenConsole aic = new AusweisInformationenConsole(); 
				aic.start(ausweisDAO.find(input2));
				 
				break;
			case 2:
				System.out.println("Geben sie die Nummer des Ausweises an.\nEingabe: ");
				input2 = sc.nextInt();
				System.out.println(
						"Welchen Status wollen Sie setzen?\n1: Gültig" + "\n2: Verloren\n3: Abgelaufen\nEingabe:");
				input3 = sc.nextInt();

				switch (input3) {
				case 1:
					aF.statusAnpassenByAusweisID(input2, 2, true);
					break;
				case 2:
					aF.statusAnpassenByAusweisID(input2, 3, true);
					break;
				case 3:
					aF.statusAnpassenByAusweisID(input2, 1, true);
					break;
				default:
					System.out.println("Fehlerhafte Eingabe. Bitte erneut versuchen.");
					break;
				}
			case 3:
				System.out.println("Geben sie die Nummer des Ausweises an.\nEingabe: ");
				input2 = sc.nextInt();
				System.out.println("Wie lange wollen sie den Ausweis verlängern?"
						+ "\n1: 1 Monat\n2: 3 Monate\n3: 6 Monate\n4: 1 jahr");
				input3 = sc.nextInt();
				if (input3 != 4) {
					int monatsZahl = 0;
					switch (input3) {
					case 1:
						monatsZahl = 1;
						break;
					case 2:
						monatsZahl = 3;
						break;
					case 3:
						monatsZahl = 6;
						break;

					default:
						break;
					}
					aF.ausweisVerlaengernByAusweisID(input2, monatsZahl);
				} else {
					Ausweis ausweis = ausweisDAO.find(input2);
					String ablaufDatum = ausweis.getAblaufDatum();
					String[] split = ablaufDatum.split("-");
					String ablaufJahr = split[2];
					ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
					ablaufDatum = split[0] + "-" + split[1] + "-" + ablaufJahr;
					ausweis.setAblaufDatum(ablaufDatum);
					ausweisDAO.update(ausweis);
				}
				break;
			case 4:
				System.out.println("Geben sie die Nummer des Ausweises an.\nEingabe: ");
				input2 = sc.nextInt();
				ausweisDAO.delete(input2);
				break;
			case 5:
				check = false;
				break;
			default:
				System.out.println("Fehlerhafte Eingabe. Bitte erneut versuchen.");
				break;
			}
		}
	}

	public void getAusweise() {

		List<Ausweis> ausweisList = ausweisDAO.findAllAusweise();
		System.out.format(format, "Nummer", "Ausweisnummer", "Nachname", "Benutzernummer", "Ablaufdatum", "Status");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		for (int i = 0; i < ausweisList.size(); i++) {
			Ausweis ausweis = ausweisList.get(i);
			System.out.format(format, ausweis.getAusweisID(), ausweis.getAusweisNummer(),
					ausweis.getBenutzer().getNachname(), ausweis.getBenutzer().getBenutzerNummer(),
					ausweis.getAblaufDatum(), ausweis.getStatus());

		}
		System.out.println(
				"--------------------------------------------------------------------------------------------");
	}
}
