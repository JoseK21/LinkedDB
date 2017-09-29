package Interface_FX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Lists.ListaD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase que permite proporcionar una interface gráfica para la creación de Json Store
 * @author José C.Núñez 
 *
 */
public class JsonStoreDeleteController implements Initializable {
	
	@FXML private TextField textJsonStoreD;
	private String NameFileD;	
	private String msj;
	

	/**
	 * Método para eliminar un Json Store de la lista doblemente enlazada
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void deleteJsonStore(ActionEvent event) throws IOException{	
		ListaD ListJSONstores = ListaD.getInstance();		
		NameFileD = textJsonStoreD.getText();	
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Notice.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
				
		Notice display = fxmlLoader.getController();	
		
		((Node)event.getSource()).getScene().getWindow().hide();
		
		if (!NameFileD.isEmpty()) {
			if(ListJSONstores.getInstance().buscarNodoD(NameFileD)==true){
				msj = "del";
				display.setText("Your JsonStore ( "+NameFileD+" ) was successfully deleted");						
				display.setImage1(msj);
				System.out.println(NameFileD);
				ListJSONstores.getInstance().eliminarNodoD(NameFileD);   
				System.out.println("JsonStore eliminado a la lista: "+NameFileD+"\nLista Actualizada");
				ListJSONstores.getInstance().imprimirListaD();
			}else{
				msj="incorrecto";
				display.setText("JsonStore ( "+ NameFileD +" ) does not exist,try using a different name");
				display.setImage1(msj);
				
				ListJSONstores.getInstance().imprimirListaD();
				System.out.println("\n");				
			}
		}else{
			msj="vacio";
			display.setImage1(msj);
			display.setText("Warning..! Blank space");
			System.out.println("Error : El JsonStore No tiene nombre : ("+NameFileD+")\nLista sin cambios :");
			ListJSONstores.getInstance().imprimirListaD();
		}		
		
		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.centerOnScreen();
		stage.setScene(new Scene(root1));
		stage.initStyle( StageStyle.UTILITY );
		stage.show();
		
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){	
		}   
	
}
