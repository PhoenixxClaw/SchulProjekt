package controller_Benutzer;

import dao.BenutzerDAO;
import entities.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BenutzerInformationenController {

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
    private TextField txtBenutzernummer;

    @FXML
    private TextField txtBenutzername;

    @FXML
    private CheckBox chkAdmin;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }
    
    void setBenutzer(String benutzerNummer) {
    	BenutzerDAO benutzerDAO = new BenutzerDAO();
    	Benutzer benutzer = benutzerDAO.findByBenutzerNummer(benutzerNummer);
    	txtAdresse.setText(benutzer.getAdresse());
    	txtBenutzername.setText(benutzer.getBenutzerName());
    	txtBenutzernummer.setText(benutzerNummer);
    	txtGeburtstag.setText(benutzer.getGeburtsdatum());
    	txtNachname.setText(benutzer.getNachname());
    	txtOrt.setText(benutzer.getORT());
    	txtPLZ.setText(Integer.toString(benutzer.getPLZ()));
    	txtVorname.setText(benutzer.getVorname());
    	chkAdmin.setSelected(benutzer.getIsAdmin());
    	benutzerDAO.shutdown();
    }

}
