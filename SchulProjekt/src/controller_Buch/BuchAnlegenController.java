package controller_Buch;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import alerts.Alerts;
import controller_MainNav.MainNAVController;
import dao.BuchDAO;
import dao.RegalDAO;
import entities.Buch;
import entities.Regal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BuchAnlegenController implements Initializable{

    @FXML
    private Button btnSpeichern;

    @FXML
    private Button btnSchliessen;

    @FXML
    private TextField txtTitel;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtISDN;

    @FXML
    private ListView<Regal> lstRegal;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void btnSpeichern(MouseEvent event) {

    	BuchDAO buchDAO = new BuchDAO();
    	Buch buch = new Buch();
    	buch.setAuthor(txtAuthor.getText());
    	buch.setISDN(txtISDN.getText());
    	buch.setRegal(lstRegal.getSelectionModel().getSelectedItem());
    	buch.setTitel(txtTitel.getText());
    	buchDAO.persist(buch);
    	buchDAO.shutdown();
    	
    	Alerts alert = new Alerts();
    	boolean anlegen = alert.buchWeiteresBuchAnlegen();
		if (anlegen) {
			txtAuthor.clear();
			txtISDN.clear();
			txtTitel.clear();
		} else {
			MainNAVController.buchTabController.loadTableView();
			Stage stage = (Stage) btnSchliessen.getScene().getWindow();
	    	stage.close();
		}
    }

    void loadListView() {
    	RegalDAO regalDAO = new RegalDAO();
    	List<Regal> regalList = regalDAO.findAllRegale();
    	lstRegal.setItems(FXCollections.observableArrayList(regalList));
    	regalDAO.shutdown();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * UNCOMMENT WHEN "REGALE" IS FINISHED!!!!
		 * loadListView();
		 * 
		 */
	}

}
