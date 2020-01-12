package console_Benutzer;

import entities.Benutzer;

public class BenutzerInformationenConsole {
	private String format = "%1$-18s%2$s";

	public void start(Benutzer benutzer) {
		String admin = "";
		System.out.format(format, "\n\nVorname:  ",benutzer.getVorname());
		System.out.format(format, "\nNachname: ",benutzer.getNachname());
		System.out.format(format, "\nGeburtstag: ",benutzer.getGeburtsdatum());
		System.out.format(format, "\nAdresse: ",benutzer.getAdresse());
		System.out.format(format, "\nPostleitzahl: ",benutzer.getPLZ());
		System.out.format(format, "\nOrt: ",benutzer.getORT());
		System.out.format(format, "\nBenutzernummer: ",benutzer.getBenutzerNummer());
		System.out.format(format, "\nBenutzername: ",benutzer.getBenutzerName());
		if (benutzer.getIsAdmin()) {
			admin = "Ja\n\n";
		} else {
			admin = "nein\n\n";
		}
		System.out.format(format, "\nIst Admin: ",admin);
	}
}
