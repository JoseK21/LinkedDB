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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Clase para crear los Objetos Json de un Documento Json correspondiente
 * @author José C.Núñez 
 *
 */
public class ObjectJSONController extends Application {
	ObservableList<String> tiposStatusList = FXCollections.observableArrayList("Entero","Flotante","Cadena","Fecha-Hora");
	ObservableList<String> tiposEspecialesStatusList = FXCollections.observableArrayList("Llave Primaria","Llave Foranea");
	@FXML private ChoiceBox<String> tiposEspecialesStatusBox;
	@FXML private ChoiceBox<String> tiposStatusBox;	
	@FXML private RadioButton textRequerido ;
	@FXML private Label val_def;
	@FXML private TextField dataval_def;
	@FXML private Label txtmsjAccion;
	@FXML private VBox VboxMain;
	
	
	
	/**
	 * Método para asignar un valor por defecto
	 * @param event
	 */
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
	
	/**
	 * Método para guardar la modificación dentro de la lista simplemente enlazada
	 * @param event
	 */
	@FXML
	public void guardarLista_Atributos(ActionEvent event){
		txtmsjAccion.setText("Guardado Correcto");
	
	}
	
	/**
	 * Método para modificar la lista simplemente enlazada de un Objeto
	 * @param event
	 */
	@FXML
	public void moficicarLista_Atributos(ActionEvent event){
		// Busca los valores que tenia y los muestra para que el usuario veo lo que tenia y asai pueda cambiar lo que el quiere
	}
	
	/**
	 * Método pare regresar a la pantalla inicial desde la Lista de Atributos
	 * @param event
	 */
	@FXML
	public void volverInicio(ActionEvent event){
		
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfaceMainFirst.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			
			stage.setTitle("LInkedDB");
			stage.setScene(new Scene(root1));
			stage.show();
		}catch (Exception e){
			System.out.println("Can´t load new window");
	}}
	
	/**
	 * Método pare regresar a la pantalla inicial
	 * @param event
	 */
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

}
