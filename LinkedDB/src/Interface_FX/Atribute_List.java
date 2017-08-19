package Interface_FX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Atribute_List extends Application {
	ObservableList<String> tiposStatusList = FXCollections.observableArrayList("Entero","Flotante","Cadena","Fecha-Hora");
	
		
	@FXML
	private ChoiceBox<String> tiposStatusBox;
	
	@FXML
	private void initialize(){		
		tiposStatusBox.setValue("Entero");
		tiposStatusBox.setItems(tiposStatusList);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
