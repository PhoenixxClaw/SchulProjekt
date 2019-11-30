package controller_Ausweis;

import dao.AusweisDAO;
import entities.Ausweis;
import entities.Buch;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AusweisInformationenController {

    @FXML
    private ListView<Buch> lstBuecher;

    @FXML
    private Text txtAusweisNummer;

    @FXML
    private Text txtErstellDatum;

    @FXML
    private Text txtAblaufDatum;

    @FXML
    private Text txtStatus;
    
    @FXML
    private Button btnSchliessen;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }
    
    public void setInformationen(int ausweisNummer) {
    	AusweisDAO ausweisDAO = new AusweisDAO();
    	Ausweis ausweis = ausweisDAO.findByAusweisNummer(ausweisNummer);
    	txtAblaufDatum.setText(ausweis.getAblaufDatum());
    	txtAusweisNummer.setText(Integer.toString(ausweisNummer));
    	txtErstellDatum.setText(ausweis.getErstellDatum());
    	txtStatus.setText(ausweis.getStatus());
    	lstBuecher.setItems(FXCollections.observableArrayList(ausweis.getBuecher()));
    }

    
}
