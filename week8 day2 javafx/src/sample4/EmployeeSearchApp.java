package sample4;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeSearchApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("EmployeeSearch.fxml"));
			Parent rootLayout = loader.load();
			
			Scene scene = new Scene(rootLayout);
			
			primaryStage.setTitle("Employee Search Program");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
