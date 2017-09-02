package Interface_FX;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	// Abre la ventana inicial
	@Override
	public void start(Stage primarystage) throws Exception{
		Parent root =FXMLLoader.load(getClass().getResource("InterfaceMainFirst.fxml"));
		primarystage.setTitle("LinkedDB");
		//Scene scene = new Scene(root);
		primarystage.setScene(new Scene(root,1400,700) );
		primarystage.show();
		primarystage.centerOnScreen();
		primarystage.setOnCloseRequest(e -> Platform.exit());
	    
		
	}
	
	public static void main(String[] args) throws IOException {	
		launch(args);
		
	}
}






//Parent root =FXMLLoader.load(getClass().getResource("InterfaceMainFirst.fxml"));