package Interface_FX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Atribute_ListController extends Application {
	ObservableList<String> tiposStatusList = FXCollections.observableArrayList("Entero","Flotante","Cadena","Fecha-Hora");
	ObservableList<String> tiposEspecialesStatusList = FXCollections.observableArrayList("Llave Primaria","Llave Foranea");
		
	@FXML private ChoiceBox<String> tiposStatusBox;	
	@FXML private ChoiceBox<String> tiposEspecialesStatusBox;
	@FXML private RadioButton textRequerido ;
	@FXML private Label val_def;
	@FXML private TextField dataval_def;
	
	
	
	@FXML
	public void DisableVal_Defaul(ActionEvent event){
		if (textRequerido.isSelected()){
			val_def.setDisable(false);
			dataval_def.setDisable(false);			
		}else{
			val_def.setDisable(true);
			dataval_def.setDisable(true);	
		}
	}
	
	
	@FXML
	public void atras(ActionEvent event){
		// String valor = tiposStatusBox.getValue();         Forma de pasar valores 
		// System.out.println("Dato seleccionado :"+valor);
		
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Create_DocJSON.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			
			stage.setTitle("LInkedDB");
			stage.setScene(new Scene(root1));
			stage.show();
		}catch (Exception e){
			System.out.println("Can´t load new window");
	}}
	
	
	@FXML
	private void initialize(){		
		tiposStatusBox.setValue("Entero");
		tiposStatusBox.setItems(tiposStatusList);
		tiposEspecialesStatusBox.setValue("Llave Primaria");
		tiposEspecialesStatusBox.setItems(tiposEspecialesStatusList);
		
		val_def.setDisable(true);
		dataval_def.setDisable(true);
		
	}

	
	@Override
	public void start(Stage primaryStage) {
		
	}

}
