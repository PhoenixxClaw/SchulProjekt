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
		alert.setContentText("M�chten Sie einen weiteren Benutzer anlegen?");

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
}
