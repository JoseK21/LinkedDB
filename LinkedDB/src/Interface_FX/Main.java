package Interface_FX;



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
		primarystage.setScene(new Scene(root,800,600) );
		primarystage.show();
		primarystage.centerOnScreen();
		primarystage.setOnCloseRequest(e -> Platform.exit());
	    
		
	}
	
	public static void main(String[] args) {		
		launch(args);
	}
}
