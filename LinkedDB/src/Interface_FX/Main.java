package Interface_FX;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Lists.ListaCD;
import Lists.ListaD;
import Lists.ListaS;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


/**
 * Clase Principal del sistema 
 * @author Jos� C.N��ez 
 *
 */
public class Main extends Application {
	
	@FXML private TreeView treeView1;
	
	@Override
	public void start(Stage primarystage) throws Exception{
		primarystage.setTitle("LinkedDB");
		Parent root =FXMLLoader.load(getClass().getResource("InterfaceLinkedDB.fxml"));		
		
		//Scene scene = new Scene(root);
		primarystage.setScene(new Scene(root,1400,700) );
		primarystage.show();
		primarystage.centerOnScreen();
		primarystage.setOnCloseRequest(e -> Platform.exit());
	    
		
	}
	
	/**
	 * M�todo para iniciar el sistema
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {	
			
		launch(args);
		
	}
}