package controller_Regal;

import controller_MainNav.MainNAVController;
import dao.RegalDAO;
import entities.Regal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegalBearbeitenController {

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
    
    private Regal regal;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void btnSpeichern(MouseEvent event) {

    	RegalDAO regalDAO = new RegalDAO();
    	regal.setFachanzahl(Integer.valueOf(txtFaecheranzahl.getText()));
    	regal.setRegalName(txtRegalname.getText());
    	regal.setReihe(txtReihe.getText());
    	regalDAO.update(regal);
    	regalDAO.shutdown();
    	Stage stage = (Stage) btnSpeichern.getScene().getWindow();
    	stage.close();
    	MainNAVController.regalTabController.loadTableView();
    }
    
    public void setRegal(int RegalID) {
    	RegalDAO regalDAO = new RegalDAO();
    	regal = regalDAO.find(RegalID);
    	txtFaecheranzahl.setText(Integer.toString(regal.getFachanzahl()));
    	txtRegalname.setText(regal.getRegalName());
    	txtReihe.setText(regal.getReihe());
    	regalDAO.shutdown();
    }

}
