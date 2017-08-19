package Interface_FX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception{
		Parent root =FXMLLoader.load(getClass().getResource("InterfaceMain.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("LinkedDB");
	    
		
	}
	
	public static void main(String[] args) {		
		launch(args);
	}
}
