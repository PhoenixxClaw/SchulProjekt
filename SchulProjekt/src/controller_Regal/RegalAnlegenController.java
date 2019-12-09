package controller_Regal;

import alerts.Alerts;
import controller_MainNav.MainNAVController;
import dao.RegalDAO;
import entities.Regal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegalAnlegenController {

    @FXML
    private Button btnSpeichern;

    @FXML
    private Button btnSchliessen;

    @FXML
    private TextField txtRegalname;

    @FXML
    private TextField txtFaecheranzahl;

    @FXML
    private TextField txtReihe;

    @FXML
    void btnSchliessen(MouseEvent event) {

    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
		stage.close();
    }

    @FXML
    void btnSpeichern(MouseEvent event) {

    	Alerts alerts = new Alerts();
    	RegalDAO regalDAO = new RegalDAO();
    	Regal regal = new Regal();
    	regal.setFachanzahl(Integer.valueOf(txtFaecheranzahl.getText()));
    	regal.setRegalName(txtRegalname.getText());
    	regal.setReihe(txtReihe.getText());
    	regalDAO.persist(regal);
    	boolean check = alerts.regalWeiteresRegalAnlegen();
    	if (check) {
			txtFaecheranzahl.clear();
			txtRegalname.clear();
			txtReihe.clear();
		} else {
			Stage stage = (Stage) btnSpeichern.getScene().getWindow();
			stage.close();
			MainNAVController.regalTabController.loadTableView();
		}
    	regalDAO.shutdown();
    }

}
