package controller_Buch;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BuchDAO;
import entities.Buch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuchInformationenController   {

    @FXML
    private Button btnSchliessen;

    @FXML
    private TextField txtTitel;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtISDN;

    @FXML
    private TextField txtRegal;

    @FXML
    private TextField txtStatus;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }
    
    public void setBuch(int id) {
    	BuchDAO buchDAO = new BuchDAO();
    	Buch buch = buchDAO.find(id);
    	txtAuthor.setText(buch.getAuthor());
    	txtISDN.setText(buch.getISDN());
    	if (buch.getRegal()!=null) {
    		txtRegal.setText(buch.getRegal().getRegalName()+" | Reihe: "+buch.getRegal().getReihe());
		}
    	txtTitel.setText(buch.getTitel());
    	if (buch.getAusweis()==null) {
			txtStatus.setText("Buch nicht verliehen");
		} else {
			txtStatus.setText("Buch verliehen");
		}
    	buchDAO.shutdown();
    }

}
