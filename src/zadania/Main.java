package zadania;

import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application{
	
	@Override
	 public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/ui/Main.fxml"));
		
		
		Scene scene = new Scene(root);
		 scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
