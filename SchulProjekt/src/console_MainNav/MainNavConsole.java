package console_MainNav;

import java.util.Scanner;

import console_Ausweis.MainAusweisConsole;
import console_Benutzer.MainBenutzerConsole;
import console_buecher.MainBuecherConsole;

public class MainNavConsole {

	public void start() {
		boolean schleifenCheck = true;
		while (schleifenCheck) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Zu welchem menu wollen Sie wechseln?\n1: Benutzer\n2: Ausweis\n3: Buch\n4: Regal\nX: Programm beenden\nEingabe: ");
			String input = sc.next();
			switch (input) {
			case "1":
				System.out.println("Benutzermenu wird geladen..");
				MainBenutzerConsole mbc = new MainBenutzerConsole();
				mbc.start();
				break;
			case "2":
				System.out.println("Ausweismenu wird geladen..");
				MainAusweisConsole mac = new MainAusweisConsole();
				mac.start();
				break;
			case "3":
				System.out.println("Buchmenu wird geladen..");
				MainBuecherConsole mbuc = new MainBuecherConsole();
				mbuc.start();
				break;
			case "4":
				System.out.println("Regalmenu wird geladen..");
				//INPUT BUCHMENUCALL
				break;
			case "x":
				System.out.println("Programm wird beendet..\nProgramm beendet.");
				System.exit(0);
			default:
				System.out.println("Fehlerhafte Eingabe.. Bitte Eingabe wiederholen");
				break;
			}
		}
	}

}
