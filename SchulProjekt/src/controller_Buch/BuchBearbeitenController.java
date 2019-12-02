package controller_Buch;

import controller_MainNav.MainNAVController;
import dao.BuchDAO;
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

public class BuchBearbeitenController {

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
    
    private Buch buch;

    @FXML
    void btnSchliessen(MouseEvent event) {
    	Stage stage = (Stage) btnSchliessen.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void btnSpeichern(MouseEvent event) {
    	BuchDAO buchDAO = new BuchDAO(); 
    	if (lstRegal.getSelectionModel().getSelectedItem()!=null && lstRegal.getSelectionModel().getSelectedItem()!=buch.getRegal()) {
			buch.setRegal(lstRegal.getSelectionModel().getSelectedItem());
		}
    	buch.setAuthor(txtAuthor.getText());
    	buch.setISDN(txtISDN.getText());
    	buch.setTitel(txtTitel.getText());
    	buchDAO.update(buch);
    	buchDAO.shutdown();
    	MainNAVController.buchTabController.loadTableView();
    }
    
    void setBuch(int id) {
    	
    	BuchDAO buchDAO = new BuchDAO();
    	buch = buchDAO.find(id);
    	RegalDAO regalDAO = new RegalDAO();
    	txtAuthor.setText(buch.getAuthor());
    	txtISDN.setText(buch.getISDN());
    	if (buch.getRegal()!=null) {
    		lstRegal.setItems(FXCollections.observableArrayList(regalDAO.findAllRegale()));
        	lstRegal.getSelectionModel().select(buch.getRegal());
    	}
    	txtTitel.setText(buch.getTitel());
    	buchDAO.shutdown();
    	regalDAO.shutdown();
    }

}
