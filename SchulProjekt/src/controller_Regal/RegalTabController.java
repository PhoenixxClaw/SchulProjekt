package controller_Regal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller_Buch.BuchBearbeitenController;
import dao.BuchDAO;
import dao.RegalDAO;
import entities.Buch;
import entities.Regal;
import filter_ENums.FILTER_Buecher;
import filter_ENums.FILTER_Regal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tableViewObjects.TableViewBuch;
import tableViewObjects.TableViewRegal;

public class RegalTabController implements Initializable {

    @FXML
    private ComboBox<FILTER_Regal> cbbFilter;

    @FXML
    private TextField txtSuche;

    @FXML
    private Button btnSuchen;

    @FXML
    private Button btnAnlegen;

    @FXML
    private TableView<TableViewRegal> tblRegal;

    @FXML
    private TableColumn<String, TableViewRegal> colRegal;

    @FXML
    private TableColumn<Integer, TableViewRegal> colFaecheranzahl;

    @FXML
    private TableColumn<String, TableViewRegal> colReihe;

    @FXML
    private MenuItem menuInformationen;

    @FXML
    private MenuItem menuBearbeiten;

    @FXML
    private MenuItem menuLoeschen;

    @FXML
    void btnAnlegen(MouseEvent event) {

    	try {
			Stage stage = new Stage();
			Parent BuchTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/REGAL_Anlegen.fxml"));
			BuchTab = (Parent) fxmlLoader.load();
			stage.setScene(new Scene(BuchTab));
			stage.setTitle("Regal anlegen");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    @FXML
    void btnSuchen(MouseEvent event) {

    }

    @FXML
    void menuBearbeiten(ActionEvent event) {

    	try {
			Stage stage = new Stage();
			Parent BuchTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/REGAL_Bearbeiten.fxml"));
			BuchTab = (Parent) fxmlLoader.load();
			RegalBearbeitenController rbc = fxmlLoader.getController();
			rbc.setRegal(tblRegal.getSelectionModel().getSelectedItem().getRegalID());
			stage.setScene(new Scene(BuchTab));
			stage.setTitle("Regal Bearbeiten");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    @FXML
    void menuInformationen(ActionEvent event) {

    	try {
			Stage stage = new Stage();
			Parent BuchTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/REGAL_Informationen.fxml"));
			BuchTab = (Parent) fxmlLoader.load();
			RegalInformationenController ric = fxmlLoader.getController();
			ric.setRegal(tblRegal.getSelectionModel().getSelectedItem().getRegalID());
			stage.setScene(new Scene(BuchTab));
			stage.setTitle("Regalinformationen");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    @FXML
    void menuLoeschen(ActionEvent event) {

    	RegalDAO regalDAO = new RegalDAO();
    	regalDAO.delete(tblRegal.getSelectionModel().getSelectedItem().getRegalID());
    	regalDAO.shutdown();
    }
    
    public void loadTableView() {
    	RegalDAO regalDAO = new RegalDAO();
		List<Regal> regalList = regalDAO.findAllRegale();
		List<TableViewRegal> tableViewRegalList = new ArrayList<TableViewRegal>();
		
		for (int i = 0; i < regalList.size(); i++) {
			TableViewRegal tempTBLRegal = new TableViewRegal();
			tempTBLRegal.setRegalID(regalList.get(i).getRegalID());
			tempTBLRegal.setFachAnzahl(regalList.get(i).getFachanzahl());
			tempTBLRegal.setRegalName(regalList.get(i).getRegalName());
			tempTBLRegal.setReihe(regalList.get(i).getReihe());
			tableViewRegalList.add(tempTBLRegal);
		}
		
		colRegal.setCellValueFactory(new PropertyValueFactory<>("regalName"));
		colFaecheranzahl.setCellValueFactory(new PropertyValueFactory<>("fachAnzahl"));
		colReihe.setCellValueFactory(new PropertyValueFactory<>("reihe"));
		ObservableList<TableViewRegal> observableTableViewRegalList = FXCollections.observableArrayList(tableViewRegalList);
		tblRegal.setItems(observableTableViewRegalList);
		regalDAO.shutdown();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cbbFilter.setItems(FXCollections.observableArrayList(FILTER_Regal.values()));
		loadTableView();
	}

}
