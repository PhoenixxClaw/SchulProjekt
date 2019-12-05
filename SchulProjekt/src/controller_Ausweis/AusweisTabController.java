package controller_Ausweis;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dao.AusweisDAO;
import entities.Ausweis;
import filter_ENums.FILTER_Ausweis;
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
import tableViewObjects.TableViewAusweis;

public class AusweisTabController implements Initializable {

	@FXML
	private Button btnSuchen;

	@FXML
	private ComboBox<FILTER_Ausweis> cbbFilter;

	@FXML
	private TextField txtSuche;

	@FXML
	private TableView<TableViewAusweis> tblAusweis;

	@FXML
	private TableColumn<Integer, TableViewAusweis> colAusweisNr;

	@FXML
	private TableColumn<String, TableViewAusweis> colNachname;

	@FXML
	private TableColumn<Integer, TableViewAusweis> colBenutzerNr;

	@FXML
	private TableColumn<String, TableViewAusweis> colAblaufDatum;

	@FXML
	private TableColumn<String, TableViewAusweis> colStatus;

	@FXML
	private MenuItem menuInformationen;

	@FXML
	private MenuItem menuStatusGueltig;

	@FXML
	private MenuItem menuStatusVerloren;

	@FXML
	private MenuItem menuStatusAbgelaufen;

	@FXML
	private MenuItem menuVerlaengern1Monat;

	@FXML
	private MenuItem menuVerlaengern3Monate;

	@FXML
	private MenuItem menuVerlaengern6Monate;

	@FXML
	private MenuItem menuVerlaengern1Jahr;
	
	@FXML
	private MenuItem menuLoeschen;

	@FXML
	void menuInformationen(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent AusweisTab;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/AUSWEIS_Informationen.fxml"));
			AusweisTab = (Parent) fxmlLoader.load();
			AusweisInformationenController aic = fxmlLoader.getController();
			aic.setInformationen(tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
			stage.setScene(new Scene(AusweisTab));
			stage.setTitle("Ausweisinformationen");
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@FXML
	void menuStatusAbgelaufen(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		ausweis.setStatus("Abgelaufen");
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}

	@FXML
	void menuStatusGueltig(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		ausweis.setStatus("Gültig");
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}

	@FXML
	void menuStatusVerloren(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		ausweis.setStatus("Verloren");
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}

	@FXML
	void menuVerlaengern1Jahr(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		String ablaufDatum = ausweis.getAblaufDatum();
		String[] split = ablaufDatum.split("-");
		String ablaufJahr = split[2];
		ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
		ablaufDatum = split[0] + "-" + split[1] + "-" + ablaufJahr;
		ausweis.setAblaufDatum(ablaufDatum);
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}

	@FXML
	void menuVerlaengern1Monat(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		String ablaufDatum = ausweis.getAblaufDatum();
		String[] split = ablaufDatum.split("-");
		String ablaufMonat = split[1];
		String ablaufJahr = split[2];
		ablaufMonat = Integer.toString(Integer.valueOf(ablaufMonat) + 1);
		if (Integer.valueOf(ablaufMonat) > 12) {
			int Monat = Integer.valueOf(ablaufMonat);
			int rest = Monat - 12;
			ablaufMonat = "0" + rest;
			ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
		}

		if (ablaufMonat.length() == 1) {
			ablaufMonat = "0" + ablaufMonat;
		}
		ablaufDatum = split[0] + "-" + ablaufMonat + "-" + ablaufJahr;
		ausweis.setAblaufDatum(ablaufDatum);
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}

	@FXML
	void menuVerlaengern3Monate(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		String ablaufDatum = ausweis.getAblaufDatum();
		String[] split = ablaufDatum.split("-");
		String ablaufMonat = split[1];
		String ablaufJahr = split[2];
		ablaufMonat = Integer.toString(Integer.valueOf(ablaufMonat) + 3);
		if (Integer.valueOf(ablaufMonat) > 12) {
			int Monat = Integer.valueOf(ablaufMonat);
			int rest = Monat - 12;
			ablaufMonat = "0" + rest;
			ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
		}

		if (ablaufMonat.length() == 1) {
			ablaufMonat = "0" + ablaufMonat;
		}
		ablaufDatum = split[0] + "-" + ablaufMonat + "-" + ablaufJahr;
		ausweis.setAblaufDatum(ablaufDatum);
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}

	@FXML
	void menuVerlaengern6Monate(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		String ablaufDatum = ausweis.getAblaufDatum();
		String[] split = ablaufDatum.split("-");
		String ablaufMonat = split[1];
		String ablaufJahr = split[2];
		ablaufMonat = Integer.toString(Integer.valueOf(ablaufMonat) + 6);
		if (Integer.valueOf(ablaufMonat) > 12) {
			int Monat = Integer.valueOf(ablaufMonat);
			int rest = Monat - 12;
			ablaufMonat = "0" + rest;
			ablaufJahr = Integer.toString(Integer.valueOf(ablaufJahr) + 1);
		}

		if (ablaufMonat.length() == 1) {
			ablaufMonat = "0" + ablaufMonat;
		}
		ablaufDatum = split[0] + "-" + ablaufMonat + "-" + ablaufJahr;
		ausweis.setAblaufDatum(ablaufDatum);
		ausweisDAO.update(ausweis);
		ausweisDAO.shutdown();
		loadTableview();
	}
	
	@FXML
    void menuLoeschen(ActionEvent event) {
		AusweisDAO ausweisDAO = new AusweisDAO();
		Ausweis ausweis = ausweisDAO.findByAusweisNummer(
				tblAusweis.getSelectionModel().getSelectedItem().getAusweisNummer());
		ausweisDAO.delete(ausweis.getAusweisID());
		ausweisDAO.shutdown();
		loadTableview();
    }

	@FXML
	void btnSuchen(MouseEvent event) {

	}

	public void loadTableview() {
		AusweisDAO ausweisDAO = new AusweisDAO();
		List<TableViewAusweis> tableViewAusweisList = new ArrayList<TableViewAusweis>();
		List<Ausweis> ausweisList = ausweisDAO.findAllAusweise();
		for (int i = 0; i < ausweisList.size(); i++) {
			TableViewAusweis tempTBLAusweis = new TableViewAusweis();
			tempTBLAusweis.setAblaufDatum(ausweisList.get(i).getAblaufDatum());
			tempTBLAusweis.setAusweisNummer(ausweisList.get(i).getAusweisNummer());
			tempTBLAusweis.setBenutzerNummer(ausweisList.get(i).getBenutzer().getBenutzerNummer());
			tempTBLAusweis.setNachname(ausweisList.get(i).getBenutzer().getNachname());
			tempTBLAusweis.setStatus(ausweisList.get(i).getStatus());
			tableViewAusweisList.add(tempTBLAusweis);
		}
		ObservableList<TableViewAusweis> observableTableViewAusweisList = FXCollections
				.observableArrayList(tableViewAusweisList);
		colAblaufDatum.setCellValueFactory(new PropertyValueFactory<>("ablaufDatum"));
		colBenutzerNr.setCellValueFactory(new PropertyValueFactory<>("benutzerNummer"));
		colNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		colAusweisNr.setCellValueFactory(new PropertyValueFactory<>("ausweisNummer"));
		tblAusweis.setItems(observableTableViewAusweisList);
		ausweisDAO.shutdown();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cbbFilter.setItems(FXCollections.observableArrayList(FILTER_Ausweis.values()));
		loadTableview();

	}

}
