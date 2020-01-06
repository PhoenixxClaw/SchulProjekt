package alerts;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alerts {

	/*
	 * 
	 * 
	 * 	CONFIRMATIONS
	 * 
	 * 
	 */
	
	public boolean benutzerWeiterenBenutzerAnlegen() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Weiteren Benutzer anlegen");
		alert.setHeaderText("Weiteren Benutzer anlegen");
		alert.setContentText("Möchten Sie einen weiteren Benutzer anlegen?");

		ButtonType buttonTypeJa = new ButtonType("Ja");
		ButtonType buttonTypeNein = new ButtonType("Nein");

		alert.getButtonTypes().setAll(buttonTypeJa, buttonTypeNein);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeJa) {
			return true;
		} else {
			if (result.get() == buttonTypeNein) {
				return false;
			} else
				return false;
		}
	}
	
	public boolean ausweisVerlorenNeuenAnlegen() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Ausweis Verloren");
		alert.setHeaderText("Ausweis Verloren");
		alert.setContentText("Soll ein neuer Ausweis für den Benutzer angelegt werden?");

		ButtonType buttonTypeJa = new ButtonType("Ja");
		ButtonType buttonTypeNein = new ButtonType("Nein");

		alert.getButtonTypes().setAll(buttonTypeJa, buttonTypeNein);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeJa) {
			return true;
		} else {
			if (result.get() == buttonTypeNein) {
				return false;
			} else
				return false;
		}
	}
	
	public boolean regalWeiteresRegalAnlegen() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Weiteres Regal anlegen");
		alert.setHeaderText("Weiteres Regal anlegen");
		alert.setContentText("Möchten Sie ein weiteres Regal anlegen?");

		ButtonType buttonTypeJa = new ButtonType("Ja");
		ButtonType buttonTypeNein = new ButtonType("Nein");

		alert.getButtonTypes().setAll(buttonTypeJa, buttonTypeNein);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeJa) {
			return true;
		} else {
			if (result.get() == buttonTypeNein) {
				return false;
			} else
				return false;
		}
	}
	
	public boolean buchWeiteresBuchAnlegen() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Weiteres Buch anlegen");
		alert.setHeaderText("Weiteres Buch anlegen");
		alert.setContentText("Möchten Sie ein weiteres Buch anlegen?");

		ButtonType buttonTypeJa = new ButtonType("Ja");
		ButtonType buttonTypeNein = new ButtonType("Nein");

		alert.getButtonTypes().setAll(buttonTypeJa, buttonTypeNein);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeJa) {
			return true;
		} else {
			if (result.get() == buttonTypeNein) {
				return false;
			} else
				return false;
		}
	}
	
	/*
	 * 
	 * 
	 *  ERRORS
	 * 
	 * 
	 */
	
	public void buchVerleihenKeineCBBAusgewaehlt () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Keine Ausleihdauer ausgewählt.\nBitte wählen sie eine Ausleihdauer aus.");
		alert.showAndWait();
	}
}
