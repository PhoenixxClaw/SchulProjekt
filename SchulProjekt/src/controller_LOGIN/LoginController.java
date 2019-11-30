package controller_LOGIN;

import java.io.IOException;

import dao.BenutzerDAO;
import entities.Benutzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txt_username;

	@FXML
	private PasswordField txt_password;

	@FXML
	private Button btn_login;

	@FXML
	private Button btn_cancel;

	@FXML
	void btn_cancel(ActionEvent event) {

		Stage stage = (Stage) btn_cancel.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btn_login(ActionEvent event) {

		BenutzerDAO benutzerDAO = new BenutzerDAO();
	
		try {
			Benutzer benutzer = benutzerDAO.findByBenutzerName(txt_username.getText());
			if (benutzer.getPasswort().equalsIgnoreCase(txt_password.getText())) {
				Stage stage = new Stage();
				Parent MainNAV;
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/MAIN_gui.fxml"));
				MainNAV = (Parent) fxmlLoader.load();
				stage.setScene(new Scene(MainNAV));
				stage.setTitle("New Generations GmbH");
				Stage stage2 = (Stage) btn_login.getScene().getWindow();
				stage2.close();
				stage.show();
				System.out.println("Login Successful");
			} else {
				System.out.println("Passwort Falsch");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Benutzername Falsch");
		}
		benutzerDAO.shutdown();

	}

	@FXML
	void keyTyped(KeyEvent event) {

		if (event.getCode() == KeyCode.ENTER) {
			btn_login(null);

		}
	}
}
