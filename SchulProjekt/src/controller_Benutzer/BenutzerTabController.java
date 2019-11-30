package controller_Benutzer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BenutzerTabController {

    @FXML
    private Button btnSuchen;

    @FXML
    private Button btnAnlegen;

    @FXML
    private Button btnBearbeiten;

    @FXML
    private Button btnInformation;

    @FXML
    private ComboBox<?> cbbFilter;

    @FXML
    private TextField txtSuche;

    @FXML
    private TableView<?> tblBenutzer;

    @FXML
    private TableColumn<?, ?> colVorname;

    @FXML
    private TableColumn<?, ?> colNachname;

    @FXML
    private TableColumn<?, ?> colBenutzerNr;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colAusleihstatus;

    @FXML
    void btnAnlegen(MouseEvent event) {

    }

    @FXML
    void btnBearbeiten(MouseEvent event) {

    }

    @FXML
    void btnInformation(MouseEvent event) {

    }

    @FXML
    void btnSuchen(MouseEvent event) {

    }

}
