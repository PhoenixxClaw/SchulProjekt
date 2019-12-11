package controller_Benutzer;

import controller_MainNav.MainNAVController;
import dao.BenutzerDAO;
import entities.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BenutzerBearbeitenController {

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
    
    private Benutzer benutzer;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void btnSpeichern(MouseEvent event) {
    	BenutzerDAO benutzerDAO = new BenutzerDAO();
    	benutzer.setAdresse(txtAdresse.getText());
    	benutzer.setBenutzerName(txtBenutzername.getText());
    	benutzer.setGeburtsdatum(txtGeburtstag.getText());
    	benutzer.setIsAdmin(chkAdmin.isSelected());
    	benutzer.setNachname(txtNachname.getText());
    	benutzer.setORT(txtOrt.getText());
    	benutzer.setPasswort(txtPasswort.getText());
    	benutzer.setPLZ(txtPLZ.getText());
    	benutzer.setVorname(txtVorname.getText());
    	benutzerDAO.update(benutzer);
    	benutzerDAO.shutdown();
    	MainNAVController.benutzerTabController.loadTableView();
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }
    
    void setBenutzer(String benutzerNummer) {
    	BenutzerDAO benutzerDAO = new BenutzerDAO();
    	benutzer = benutzerDAO.findByBenutzerNummer(benutzerNummer);
    	txtAdresse.setText(benutzer.getAdresse());
    	txtBenutzername.setText(benutzer.getBenutzerName());
    	txtGeburtstag.setText(benutzer.getGeburtsdatum());
    	txtNachname.setText(benutzer.getNachname());
    	txtOrt.setText(benutzer.getORT());
    	txtPLZ.setText(benutzer.getPLZ());
    	txtVorname.setText(benutzer.getVorname());
    	txtPasswort.setText(benutzer.getPasswort());
    	chkAdmin.setSelected(benutzer.getIsAdmin());
    	benutzerDAO.shutdown();
    }

}
