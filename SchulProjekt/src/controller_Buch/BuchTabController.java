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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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

    	try {
			Stage stage = new Stage();
			Parent tab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BUCH_Anlegen.fxml"));
			tab = (Parent) fxmlLoader.load();
			stage.setScene(new Scene(tab));
			stage.setTitle("Buch anlegen");
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
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BUCH_Bearbeiten.fxml"));
			BuchTab = (Parent) fxmlLoader.load();
			BuchBearbeitenController bbc = fxmlLoader.getController();
			bbc.setBuch(tblBuecher.getSelectionModel().getSelectedItem().getBuchID());
			stage.setScene(new Scene(BuchTab));
			stage.setTitle("Buch Bearbeiten");
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
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BUCH_Informationen.fxml"));
			BuchTab = (Parent) fxmlLoader.load();
			BuchInformationenController bic = fxmlLoader.getController();
			bic.setBuch(tblBuecher.getSelectionModel().getSelectedItem().getBuchID());
			stage.setScene(new Scene(BuchTab));
			stage.setTitle("Buchinformationen");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
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
			if (buchList.get(i).getRegal()!=null) {
				tempTBLBuch.setRegal(buchList.get(i).getRegal().getRegalName());
			}
			tempTBLBuch.setBuchID(buchList.get(i).getBuchID());
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
