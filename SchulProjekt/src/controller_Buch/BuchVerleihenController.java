package controller_Buch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import alerts.Alerts;
import dao.AusweisDAO;
import dao.BuchDAO;
import entities.Buch;
import filter_ENums.FILTER_Ausleihdauer;
import filter_ENums.FILTER_Buecher;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuchVerleihenController {

	@FXML
	private Button btnSpeichern;

	@FXML
	private Button btnSchliessen;

	@FXML
	private TextField txtTitel;

	@FXML
	private TextField txtAuthor;

	@FXML
	private TextField txtAusweisNummer;

	@FXML
	private ComboBox<FILTER_Ausleihdauer> cbbAusleihDauer;

	private Buch buch;

	@FXML
	void btnSchliessen(MouseEvent event) {

		Stage stage = (Stage) btnSchliessen.getScene().getWindow();
		stage.close();

	}

	@FXML
	void btnSpeichern(MouseEvent event) {

		int ablaufTagInt = 0, ablaufMonatInt = 0, ablaufJahrInt = 0;
		String ablaufTag, ablaufMonat, ablaufJahr, ablaufDatum;
		AusweisDAO ausweisDAO = new AusweisDAO();
		BuchDAO buchDAO = new BuchDAO();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String datum = dateFormat.format(date);
		buch.setVerleihDatum(datum);
		String erstellDatum = datum;
		String[] split = erstellDatum.split("-");
		String erstellTag = split[0];
		String erstellMonat = split[1];
		String erstellJahr = split[2];
		int erstellJahrInt = Integer.valueOf(erstellJahr);
		int erstellTagInt = Integer.valueOf(erstellTag);
		int erstellMonatInt = Integer.valueOf(erstellMonat);
		int ausleihTagZahl = 0;
		switch (cbbAusleihDauer.getSelectionModel().getSelectedItem()) {
		case ONE:
			ausleihTagZahl = 1;
			break;
		case THREE:
			ausleihTagZahl = 3;
			break;
		case SEVEN:
			ausleihTagZahl = 7;
			break;
		case FOURTEEN:
			ausleihTagZahl = 14;
			break;
		default:
			Alerts alert = new Alerts();
			alert.buchVerleihenKeineCBBAusgewaehlt();
			break;
		}
		int numDays = 0;
		switch (erstellMonatInt) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			if (((erstellJahrInt % 4 == 0) && !(erstellJahrInt % 100 == 0)) || (erstellJahrInt % 400 == 0))
				numDays = 29;
			else
				numDays = 28;
			break;

		default:
			break;
		}

		if (erstellTagInt + ausleihTagZahl > numDays) {
			ablaufTagInt = (erstellTagInt + ausleihTagZahl) - numDays;
			ablaufMonatInt = erstellMonatInt + 1;
			if (ablaufMonatInt > 12) {
				ablaufMonatInt = 1;
				ablaufJahrInt = erstellJahrInt + 1;
			} else {
				ablaufMonatInt = erstellMonatInt;
			}
		} else {
			ablaufTagInt = erstellTagInt + ausleihTagZahl;
			ablaufMonatInt = erstellMonatInt;
			ablaufJahrInt = erstellJahrInt;
		}
		ablaufTag = Integer.toString(ablaufTagInt);
		ablaufMonat = Integer.toString(ablaufMonatInt);
		ablaufJahr = Integer.toString(ablaufJahrInt);

		if (ablaufTag.length() < 2) {
			ablaufTag = "0" + ablaufTag;
		}
		if (ablaufMonat.length() < 2) {
			ablaufMonat = "0" + ablaufMonat;
		}
		ablaufDatum = ablaufTag + "-" + ablaufMonat + "-" + ablaufJahr;
		buch.setRueckgabeDatum(ablaufDatum);
		buch.setAusweis(ausweisDAO.findByAusweisNummer(txtAusweisNummer.getText()));
		buchDAO.update(buch);
		buchDAO.shutdown();
		ausweisDAO.shutdown();

	}

	public void setBuch(int buchID) {
		BuchDAO buchDAO = new BuchDAO();
		buch = buchDAO.find(buchID);
		txtAuthor.setText(buch.getAuthor());
		txtTitel.setText(buch.getTitel());
		cbbAusleihDauer.setItems(FXCollections.observableArrayList(FILTER_Ausleihdauer.values()));
		buchDAO.shutdown();
	}

}
