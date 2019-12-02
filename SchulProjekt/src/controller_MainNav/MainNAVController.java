package controller_MainNav;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller_Ausweis.AusweisInformationenController;
import controller_Ausweis.AusweisTabController;
import controller_Benutzer.BenutzerTabController;
import controller_Buch.BuchTabController;
import controller_Regal.RegalTabController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainNAVController implements Initializable{

    @FXML
    private HBox hboxBuecher;

    @FXML
    private HBox hboxRegalplatz;

    @FXML
    private HBox hboxAusweis;

    @FXML
    private HBox hboxBenutzer;

    @FXML
    private TabPane tabPane;
    
    public static AusweisTabController ausweisTabController;
    public static BenutzerTabController benutzerTabController;
    public static RegalTabController regalTabController;
    public static BuchTabController buchTabController;

    private Tab Home_AusweisTAB = new Tab();
	private Tab Home_BenutzerTAB = new Tab();
	private Tab Home_BuchTAB = new Tab();
	private Tab Home_RegalTAB = new Tab();

	private SingleSelectionModel<Tab> selectionModel;
	
	
	private EventHandler<MouseEvent> addAusweisTab = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (tabPane.getTabs().indexOf(Home_AusweisTAB) != -1) {
				tabPane.getTabs().remove(tabPane.getTabs().indexOf(Home_AusweisTAB));
			}
			try {
				
				Stage stage = new Stage();
				Parent AusweisTab;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TAB_Ausweis.fxml"));
				AusweisTab = (Parent) loader.load();
				ausweisTabController = loader.getController();
				Home_AusweisTAB.setText("Ausweis");
				Home_AusweisTAB.setClosable(true);
				Home_AusweisTAB.setId("Ausweis");
				Home_AusweisTAB.setContent(AusweisTab);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tabPane.getTabs().add(Home_AusweisTAB);

			selectionModel.selectLast();

		}

	};
	
	private EventHandler<MouseEvent> addBenutzerTab = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (tabPane.getTabs().indexOf(Home_BenutzerTAB) != -1) {
				tabPane.getTabs().remove(tabPane.getTabs().indexOf(Home_BenutzerTAB));
			}
			try {

				Stage stage = new Stage();
				Parent BenutzerTab;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TAB_Benutzer.fxml"));
				BenutzerTab = (Parent) loader.load();
				benutzerTabController = loader.getController();
				Home_BenutzerTAB.setText("Benutzer");
				Home_BenutzerTAB.setClosable(true);
				Home_BenutzerTAB.setId("Benutzer");
				Home_BenutzerTAB.setContent(BenutzerTab);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tabPane.getTabs().add(Home_BenutzerTAB);

			selectionModel.selectLast();

		}

	};
	
	private EventHandler<MouseEvent> addBuchTab = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (tabPane.getTabs().indexOf(Home_BuchTAB) != -1) {
				tabPane.getTabs().remove(tabPane.getTabs().indexOf(Home_BuchTAB));
			}
			try {

				Stage stage = new Stage();
				Parent BuchTab;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TAB_Buecher.fxml"));
				BuchTab = (Parent) loader.load();
				buchTabController = loader.getController();
				Home_BuchTAB.setText("Bücher");
				Home_BuchTAB.setClosable(true);
				Home_BuchTAB.setId("Bücher");
				Home_BuchTAB.setContent(BuchTab);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tabPane.getTabs().add(Home_BuchTAB);

			selectionModel.selectLast();

		}

	};
	
	private EventHandler<MouseEvent> addRegalTab = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (tabPane.getTabs().indexOf(Home_RegalTAB) != -1) {
				tabPane.getTabs().remove(tabPane.getTabs().indexOf(Home_RegalTAB));
			}
			try {

				Stage stage = new Stage();
				Parent RegalTab;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/TAB_Regal.fxml"));
				RegalTab = (Parent) loader.load();
				regalTabController = loader.getController();
				Home_RegalTAB.setText("Regal");
				Home_RegalTAB.setClosable(true);
				Home_RegalTAB.setId("Regal");
				Home_RegalTAB.setContent(RegalTab);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tabPane.getTabs().add(Home_RegalTAB);

			selectionModel.selectLast();

		}

	};

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		hboxAusweis.setOnMouseClicked(addAusweisTab);
		hboxBuecher.setOnMouseClicked(addBuchTab);
		hboxBenutzer.setOnMouseClicked(addBenutzerTab);
		hboxRegalplatz.setOnMouseClicked(addRegalTab);

		selectionModel = tabPane.getSelectionModel();
	}

}
