package console_buecher;

import java.util.List;
import java.util.Scanner;

import dao.BuchDAO;
import dao.RegalDAO;
import entities.Buch;
import entities.Regal;

public class BuchBearbeitenConsole {
	private String format = "%1$-18s%2$s";
	private String formatRegal = "%1$-8s|%2$-10s|";
	private BuchDAO buchDAO = new BuchDAO();
	private RegalDAO regalDAO = new RegalDAO();
	private Buch buch;
	public void start(Buch buchinput) {
		this.buch = buchinput;
		boolean check = true;
		while (check) {
			loadBuchInfo(buch);
			System.out.println("Was wollen sie bearbeiten?\n1: Titel\n2: Autor\n3: ISBN\n4: Regal\n5: Speichern und zum vorherigen Menu zurückkehren\nEingabe: ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			sc.nextLine();
			String input2 = "";
			int input3 = 0;
			switch (input) {
			case 1:
				System.out.println("Geben Sie den neuen Titel an.\nEingabe :");
				input2 = sc.nextLine();
				buch.setTitel(input2);
				break;
			case 2:
				System.out.println("Geben Sie den neuen Autor an.\nEingabe :");
				input2 = sc.nextLine();
				buch.setAuthor(input2);
				buchDAO.update(buch);
				break;
			case 3:
				System.out.println("Geben Sie die neue ISBN an.\nEingabe :");
				input2 = sc.nextLine();
				buch.setISDN(input2);
				break;
			case 4:
				List<Regal> regalList = regalDAO.findAllRegale();
				System.out.format(formatRegal, "Nummer","Regal" );
				System.out.println("------------------------------");
				for (int i = 0; i < regalList.size(); i++) {
					System.out.format(formatRegal, "\n"+regalList.get(i).getRegalID(),regalList.get(i).getRegalName());
				}
				System.out.println("------------------------------\n");
				System.out.println("\nGeben Sie die Nummer des neuen Regals an.\nEingabe: ");
				input3 = sc.nextInt();
				Regal regal = regalDAO.find(input3);
				buch.setRegal(regal);
				break;
			case 5:
				buchDAO.update(buch);
				regalDAO.shutdown();
				buchDAO.shutdown();
				check = false;
				break;

			default:
				System.out.println("Fehlerhafte Eingabe. Bitte erneut versuchen.");
				break;
			}
		}
		
	}
	
	void loadBuchInfo(Buch buch) {
		String ausleihStatus = "";
		if (buch.getAusweis()!=null) {
			ausleihStatus="Verliehen";
		} else {
			ausleihStatus = "Nicht verliehen";
		}
		System.out.format(format, "\n\nBuchtitel:",buch.getTitel());
		System.out.format(format, "\nAutor:", buch.getAuthor());
		System.out.format(format, "\nISBN:",buch.getISDN());
		System.out.format(format, "\nRegal:",buch.getRegal());
		System.out.format(format, "\nStatus:", ausleihStatus);
		System.out.println("\n\n");
	}
}
