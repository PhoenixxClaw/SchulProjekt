package console_buecher;

import java.util.List;
import java.util.Scanner;

import dao.BuchDAO;
import entities.Buch;

public class MainBuecherConsole {

	private String format = "%1$-8s|%2$-50s|%3$-20s|%4$-20s|%5$-30s|%6$-20s|\n";
	private BuchDAO buchDAO = new BuchDAO();

	public void start() {
		getBuecher();
		boolean check = true;
		while (check) {
			System.out.println(
					"Wählen sie eine Option aus.\n1: Buchinformationen\n2: Buch bearbeiten\n3: Buch verleihen\n4: Buch löschen\n5: Zum vorherigen Menu zurückkehren\nEingabe: ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			int input2 = 0;
			switch (input) {
			case 1:
				System.out.println("Geben Sie die Nummer des Buches an.\nEingabe: ");
				input2 = sc.nextInt();
				BuchInformationenConsole bic = new BuchInformationenConsole();
				bic.start(buchDAO.find(input2));
				break;
			case 2:
				System.out.println("Geben Sie die Nummer des Buches an.\nEingabe: ");
				input2 = sc.nextInt();
				BuchBearbeitenConsole bbc = new BuchBearbeitenConsole();
				bbc.start(buchDAO.find(input2));
				break;
			case 3:
//				System.out.println("Geben Sie die Nummer des Buches an.\nEingabe: ");
//				input2 = sc.nextInt();
//				BuchVerleihenConsole bvc = new BuchVerleihenConsole();
//				bvc.start(buchDAO.find(input2));

			default:
				break;
			}
		}
	}

	public void getBuecher() {
		List<Buch> buchList = buchDAO.findAllBuecher();
		System.out.format(format, "Nummer", "Titel", "Autor", "ISBN", "Regal", "Status");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < buchList.size(); i++) {
			Buch buch = buchList.get(i);
			String ausleihStatus = "";
			if (buch.getAusweis() != null) {
				ausleihStatus = "Verliehen";
			} else {
				ausleihStatus = "Nicht Verliehen";
			}
			System.out.format(format, buch.getBuchID(), buch.getTitel(), buch.getAuthor(), buch.getISDN(),
					buch.getRegal(), ausleihStatus);
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------");

	}
}
