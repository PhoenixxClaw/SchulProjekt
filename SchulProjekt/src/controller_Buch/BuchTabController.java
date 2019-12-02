package controller_Buch;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dao.BuchDAO;
import entities.Buch;
import filter_ENums.FILTER_Buecher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tableViewObjects.TableViewBuch;

public class BuchTabController implements Initializable {

	@FXML
	private ComboBox<FILTER_Buecher> cbbFilter;
	
    @FXML
    private Button btnSuchen;

    @FXML
    private Button btnAnlegen;

    @FXML
    private TableView<TableViewBuch> tblBuecher;

    @FXML
    private TableColumn<String, TableViewBuch> colTitel;

    @FXML
    private TableColumn<String, TableViewBuch> colAutor;

    @FXML
    private TableColumn<String, TableViewBuch> colISDN;

    @FXML
    private TableColumn<String, TableViewBuch> colRegal;

    @FXML
    private TableColumn<String, TableViewBuch> colStatus;
    
    @FXML
    private MenuItem menuVerleihen;

    @FXML
    private MenuItem menuInformationen;

    @FXML
    private MenuItem menuBearbeiten;

    @FXML
    private MenuItem menuLoeschen;

    @FXML
    void btnAnlegen(MouseEvent event) {

    }

    @FXML
    void btnSuchen(MouseEvent event) {

    }
    
    @FXML
    void menuBearbeiten(ActionEvent event) {

    }

    @FXML
    void menuInformationen(ActionEvent event) {

    }

    @FXML
    void menuLoeschen(ActionEvent event) {

    }

    @FXML
    void menuVerleihen(ActionEvent event) {

    }
    
    public void loadTableView() {
    	BuchDAO buchDAO = new BuchDAO();
		List<Buch> buchList = buchDAO.findAllBuecher();
		List<TableViewBuch> tableViewBuchList = new ArrayList<TableViewBuch>();
		
		for (int i = 0; i < buchList.size(); i++) {
			TableViewBuch tempTBLBuch = new TableViewBuch();
			tempTBLBuch.setAuthor(buchList.get(i).getAuthor());
			tempTBLBuch.setISDN(buchList.get(i).getISDN());
			tempTBLBuch.setRegal(buchList.get(i).getRegal().getRegalName());
			if (buchList.get(i).getAusweis()!=null) {
				tempTBLBuch.setStatus("Ausgeliehen");
			} else {
				tempTBLBuch.setStatus("Nicht ausgeliehen");
			}
			tempTBLBuch.setTitel(buchList.get(i).getTitel());
			tableViewBuchList.add(tempTBLBuch);
		}
		
		colAutor.setCellValueFactory(new PropertyValueFactory<>("author"));
		colISDN.setCellValueFactory(new PropertyValueFactory<>("ISDN"));
		colRegal.setCellValueFactory(new PropertyValueFactory<>("regal"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		colTitel.setCellValueFactory(new PropertyValueFactory<>("titel"));
		ObservableList<TableViewBuch> observableTableViewBuchList = FXCollections.observableArrayList(tableViewBuchList);
		tblBuecher.setItems(observableTableViewBuchList);
		buchDAO.shutdown();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cbbFilter.setItems(FXCollections.observableArrayList(FILTER_Buecher.values()));
		loadTableView();
	}

}
