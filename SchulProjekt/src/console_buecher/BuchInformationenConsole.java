package console_buecher;

import entities.Buch;

public class BuchInformationenConsole {
	private String format = "%1$-18s%2$s";
	public void start(Buch buch) {
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
	}
}
