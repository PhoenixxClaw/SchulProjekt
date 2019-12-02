package controller_Benutzer;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller_Ausweis.AusweisInformationenController;
import dao.AusweisDAO;
import dao.BenutzerDAO;
import entities.Ausweis;
import entities.Benutzer;
import filter_ENums.FILTER_Benutzer;
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
import tableViewObjects.TableViewBenutzer;

public class BenutzerTabController implements Initializable {

	@FXML
	private ComboBox<FILTER_Benutzer> cbbFilter;

	@FXML
	private TextField txtSuche;

	@FXML
	private Button btnSuchen;

	@FXML
	private Button btnAnlegen;

	@FXML
	private TableView<TableViewBenutzer> tblBenutzer;

	@FXML
	private TableColumn<String, TableViewBenutzer> colVorname;

	@FXML
	private TableColumn<String, TableViewBenutzer> colNachname;

	@FXML
	private TableColumn<Integer, TableViewBenutzer> colBenutzerNr;

	@FXML
	private TableColumn<String, TableViewBenutzer> colStatus;

	@FXML
	private TableColumn<String, TableViewBenutzer> colAusleihstatus;

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
			Parent BenutzerTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BENUTZER_Anlegen.fxml"));
			BenutzerTab = (Parent) fxmlLoader.load();
			stage.setScene(new Scene(BenutzerTab));
			stage.setTitle("Benutzer anlegen");
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
			Parent BenutzerTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BENUTZER_Bearbeiten.fxml"));
			BenutzerTab = (Parent) fxmlLoader.load();
			BenutzerBearbeitenController bbc = fxmlLoader.getController();
			bbc.setBenutzer(tblBenutzer.getSelectionModel().getSelectedItem().getBenutzerNummer());
			stage.setScene(new Scene(BenutzerTab));
			stage.setTitle("Benutzer bearbeiten");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FXML
	void menuInformationen(ActionEvent event) {

		try {
			Stage stage = new Stage();
			Parent BenutzerTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/BENUTZER_Informationen.fxml"));
			BenutzerTab = (Parent) fxmlLoader.load();
			BenutzerInformationenController bic = fxmlLoader.getController();
			bic.setBenutzer(tblBenutzer.getSelectionModel().getSelectedItem().getBenutzerNummer());
			stage.setScene(new Scene(BenutzerTab));
			stage.setTitle("Benutzerinformationen");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FXML
	void menuLoeschen(ActionEvent event) {
		
		BenutzerDAO benutzerDAO = new BenutzerDAO();
		Benutzer benutzer = benutzerDAO.findByBenutzerNummer(tblBenutzer.getSelectionModel().getSelectedItem().getBenutzerNummer());
		benutzerDAO.delete(benutzer.getBenutzerID());
		benutzerDAO.shutdown();
	}

	
	public void loadTableView() {
		
		BenutzerDAO benutzerDAO = new BenutzerDAO();
		List<TableViewBenutzer> tableViewBenutzerList = new ArrayList<TableViewBenutzer>();
		List<Benutzer> benutzerList = benutzerDAO.findAllBenutzer();
		for (int i = 0; i < benutzerList.size(); i++) {
			TableViewBenutzer tempTBLBenutzer = new TableViewBenutzer();
			tempTBLBenutzer.setBenutzerNummer(benutzerList.get(i).getBenutzerNummer());
			tempTBLBenutzer.setNachname(benutzerList.get(i).getNachname());
			tempTBLBenutzer.setVornahme(benutzerList.get(i).getVorname());
			tempTBLBenutzer.setStatus(benutzerList.get(i).getStatus());
			
			for (int j = 0; j < benutzerList.get(i).getAusweis().size(); j++) {
				if (benutzerList.get(i).getAusweis().get(j).getStatus().equals("Gültig")) {
					Ausweis ausweis = benutzerList.get(i).getAusweis().get(j);
					if (ausweis.getBuecher().size()==0) {
						tempTBLBenutzer.setAusleihstatus("Keine Bücher ausgeliehen");
					} else {
						tempTBLBenutzer.setAusleihstatus(ausweis.getBuecher().size()+" Bücher ausgeliehen");
					}
				}
			}
			
			tableViewBenutzerList.add(tempTBLBenutzer);
		}
		
		colAusleihstatus.setCellValueFactory(new PropertyValueFactory<>("ausleihstatus"));
		colBenutzerNr.setCellValueFactory(new PropertyValueFactory<>("benutzerNummer"));
		colNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		colVorname.setCellValueFactory(new PropertyValueFactory<>("vornahme"));
		ObservableList<TableViewBenutzer> observableTableViewBenutzerList = FXCollections.observableArrayList(tableViewBenutzerList);
		tblBenutzer.setItems(observableTableViewBenutzerList);
		benutzerDAO.shutdown();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loadTableView();
		cbbFilter.setItems(FXCollections.observableArrayList(FILTER_Benutzer.values()));
		
		
	}

}
