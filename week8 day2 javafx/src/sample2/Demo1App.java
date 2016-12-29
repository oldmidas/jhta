package sample2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Demo1App extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		try {
			//fxml 파일 로드하기
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("Demo1.fxml"));
			AnchorPane layout = (AnchorPane) loader.load();
			
			Scene scene = new Scene(layout);
			
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
