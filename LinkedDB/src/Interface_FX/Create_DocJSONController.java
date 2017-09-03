package Interface_FX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Create_DocJSONController implements Initializable {
	@FXML private Label textCorrecDocJSON;
	@FXML private Button cont_Atributos;
	
	
	@FXML
	public void verificar(ActionEvent event){
		String NameJson = textCorrecDocJSON.getText();
		
		//if (Existe un JSON Store )
		textCorrecDocJSON.setText("Proceso de verificación");
		cont_Atributos.setDisable(false); // Habilita el otro boton para seguir con el proceso
			
	}
	@FXML
	public void continuar(ActionEvent event){
		//if (Existe un JSON Store )
		textCorrecDocJSON.setText("Proceso de verificación");
		cont_Atributos.setDisable(false);
		
			try{
				((Node)event.getSource()).getScene().getWindow().hide();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Atribute_List.fxml"));
				Parent root3 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				
				stage.setTitle("LInkedDB");
				stage.setScene(new Scene(root3));
				stage.show();
				
			}catch (Exception e){
				System.out.println("Can´t load new window");
			}
		
	}
	
	
	@FXML
	public void atras(ActionEvent event){
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
	
	
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		cont_Atributos.setDisable(true);
		
	}
	
}
