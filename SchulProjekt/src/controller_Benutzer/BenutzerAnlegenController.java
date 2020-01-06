package controller_Benutzer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import alerts.Alerts;
import controller_MainNav.MainNAVController;
import dao.AusweisDAO;
import dao.BenutzerDAO;
import entities.Ausweis;
import entities.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import methods.AusweisFunktionen;

public class BenutzerAnlegenController {

	@FXML
	private Button btnSpeichern;

	@FXML
	private Button btnSchliessen;

	@FXML
	private TextField txtVorname;

	@FXML
	private TextField txtNachname;

	@FXML
	private TextField txtGeburtstag;

	@FXML
	private TextField txtAdresse;

	@FXML
	private TextField txtPLZ;

	@FXML
	private TextField txtOrt;

	@FXML
	private TextField txtBenutzername;

	@FXML
	private PasswordField txtPasswort;

	@FXML
	private CheckBox chkAdmin;

	@FXML
	void btnSchliessen(MouseEvent event) {
		Stage stage = (Stage) btnSchliessen.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnSpeichern(MouseEvent event) {

		/*
		 * BENUTZER ANLEGEN
		 */

		BenutzerDAO benutzerDAO = new BenutzerDAO();
		Benutzer benutzer = new Benutzer();
		benutzer.setAdresse(txtAdresse.getText());
		benutzer.setBenutzerName(txtBenutzername.getText());
		benutzer.setGeburtsdatum(txtGeburtstag.getText());
		benutzer.setIsAdmin(chkAdmin.isSelected());
		benutzer.setNachname(txtNachname.getText());
		benutzer.setORT(txtOrt.getText());
		benutzer.setPasswort(txtPasswort.getText());
		benutzer.setVorname(txtVorname.getText());
		benutzer.setPLZ(txtPLZ.getText());
		benutzer.setStatus("Aktiv");
		String benutzerNummer = "2";
		int daoSize = benutzerDAO.findAllBenutzer().size();
		int neededSize = daoSize + 1;
		int stringSize = Integer.toString(neededSize).length();

		for (int i = 0; i < (9 - stringSize); i++) {
			benutzerNummer = benutzerNummer + "0";
		}
		benutzerNummer = benutzerNummer + neededSize;
		benutzer.setBenutzerNummer(benutzerNummer);

		/*
		 * AUSWEIS ANLEGEN
		 */

		
		AusweisFunktionen ausweisFunktionen = new AusweisFunktionen();
		ausweisFunktionen.ausweisAnlegenMitBenutzer(benutzer);
		
		
		benutzerDAO.persist(benutzer);

		benutzerDAO.shutdown();

		MainNAVController.benutzerTabController.loadTableView();
		Alerts alert = new Alerts();
		boolean anlegen = alert.benutzerWeiterenBenutzerAnlegen();
		if (anlegen) {
			txtAdresse.clear();
			txtBenutzername.clear();
			txtGeburtstag.clear();
			txtNachname.clear();
			txtOrt.clear();
			txtPasswort.clear();
			txtPLZ.clear();
			txtVorname.clear();
			chkAdmin.setSelected(false);
		} else {
			Stage stage = (Stage) btnSchliessen.getScene().getWindow();
			stage.close();
		}
	}

}
