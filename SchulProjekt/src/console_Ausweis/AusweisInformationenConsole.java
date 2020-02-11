package console_Ausweis;

import entities.Ausweis;

public class AusweisInformationenConsole {
	private String format = "%1$-18s%2$s";

	public void start(Ausweis ausweis) {
		System.out.format(format, "\n\nAusweisnummer: ", ausweis.getAusweisNummer());
		System.out.format(format, "\nErstelldatum: ", ausweis.getErstellDatum());
		System.out.format(format, "\nAblaufdatum: ", ausweis.getAblaufDatum());
		System.out.format(format, "\nStatus: ", ausweis.getStatus());
		System.out.format("%1$-18s", "\nAusgeliehene Bücher:\n");
		if (ausweis.getBuecher().size() != 0) {
			for (int i = 0; i < ausweis.getBuecher().size(); i++) {
				System.out.println(ausweis.getBuecher().get(i).getTitel());
			}
		} else {
			System.out.println("Keine Bücher ausgeliehen.");
		}
		System.out.println("\n\n");

	}
}
