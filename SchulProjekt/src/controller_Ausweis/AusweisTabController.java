package controller_Ausweis;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AusweisTabController {
	@FXML
    private Button btnSuchen;

    @FXML
    private Button btnAnlegen;

    @FXML
    private Button btnBearbeiten;

    @FXML
    private Button btnInformation;

    @FXML
    private ComboBox<?> cbbSuche;

    @FXML
    private TextField txSuche;

    @FXML
    private TableColumn<?, ?> colAusweisNr;

    @FXML
    private TableColumn<?, ?> colNachname;

    @FXML
    private TableColumn<?, ?> colBenutzerNr;

    @FXML
    private TableColumn<?, ?> colAblaufDatum;

    @FXML
    private TableColumn<?, ?> colStatus;

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
