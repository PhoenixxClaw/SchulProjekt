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
import methods.DateConverter;

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

		int ausleihTagZahl = 0;
		String endDatum;
		AusweisDAO ausweisDAO = new AusweisDAO();
		BuchDAO buchDAO = new BuchDAO();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String datum = dateFormat.format(date);
		buch.setVerleihDatum(datum);
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
		DateConverter dateConverter = new DateConverter();
		endDatum = dateConverter.convertDay(datum, ausleihTagZahl);
		buch.setRueckgabeDatum(endDatum);
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
