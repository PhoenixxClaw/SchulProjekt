package controller_Regal;

import dao.RegalDAO;
import entities.Buch;
import entities.Regal;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegalInformationenController {

    @FXML
    private ListView<Buch> lstBuecher;

    @FXML
    private TextField txtRegalname;

    @FXML
    private TextField txtFaecheranzahl;

    @FXML
    private TextField txtReihe;

    @FXML
    private Button btnSchliessen;

    @FXML
    void btnSchliessen(MouseEvent event) {

    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }
    public void setRegal(int RegalID) {
    	RegalDAO regalDAO = new RegalDAO();
    	Regal regal = regalDAO.find(RegalID);
    	txtFaecheranzahl.setText(Integer.toString(regal.getFachanzahl()));
    	txtRegalname.setText(regal.getRegalName());
    	txtReihe.setText(regal.getReihe());
    	lstBuecher.setItems(FXCollections.observableArrayList(regal.getBuecher()));
    	regalDAO.shutdown();
    }

}
