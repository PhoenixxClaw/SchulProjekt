package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Stage stage = new Stage();
			Parent start;
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("/gui/LOGIN_gui.fxml"));
			start = (Parent) fxmlLoader.load();
			stage.setScene(new Scene(start));
			stage.setResizable(false);
			stage.setTitle("Login");
			stage.show();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
