package main;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import console_MainNav.MainNavConsole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		boolean check = false;
		Scanner sc = new Scanner(System.in);
		while (!check) {

			System.out.println(
					"Wollen Sie die GUI-Anwendung oder oder Konsolen-Anwendung nutzen?\n1: GUI-Anwendung\n2: Konsolen-Anwendung\n0: Programm beenden\n\nEingabe: ");
			String input = sc.next();
			switch (input) {
			case "1":
				launch(args);
				check = true;
				sc.close();
				break;

			case "2":
				MainNavConsole mainNavConsole = new MainNavConsole();
				mainNavConsole.start();
				check = true;
				sc.close();
				break;

			case "0":
				System.exit(0);

			default:
				System.out.println("Eingabe Fehlerhaft. Bitte Wiederholen.");
				break;
			}

		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Stage stage = new Stage();
			Parent start;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/LOGIN_gui.fxml"));
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
