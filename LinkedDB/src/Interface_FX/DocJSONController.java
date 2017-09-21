package Interface_FX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import Lists.ListaCD;
import Lists.ListaD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Esta clase permite la creación de Documentos Json a partir de las verificaciones correspondientes de este
 * @author José C.Núñez 
 */
public class DocJSONController implements Initializable {
	ListaD ListJSONstores = ListaD.getInstance();
	
	
	@FXML private Label textCorrecDocJSON;
	@FXML private TextField nameJSONstore;
	@FXML private TextField nameDocumento;
	@FXML private Button cont_Atributos;
	@FXML private Button verificarNameDoc;
	@FXML private Label msjVerJSONstore;
	@FXML private Label msjCreacionDocJSON;
		
	
	
	/**
	 * Método 1° inicial para realizar la creación de documentos Json a partir de los datos en la lista doblemente enlazada
	 * @param event
	 */
	@FXML
	public void verificar(ActionEvent event){
		
		String NameJson = nameJSONstore.getText();
		System.out.println("\n Nombre del JSON store a buscar: "+NameJson+" adentro de esta lista: \n");
		ListJSONstores.getInstance().imprimirListaD();
		
		if (ListJSONstores.getInstance().buscarNodoD(NameJson) == true){ 			//ListaJSONstore.buscar(NameJson) 
			verificarNameDoc.setDisable(false);
			nameDocumento.setDisable(false); 
			msjVerJSONstore.setText("Existing JsonStore");			
		}else{
			msjVerJSONstore.setText("JsonStore doesn’t exist");
			
		}
	}
	
	
	/**
	 * Método 2° final para la creación de un Documento Json
	 * @param event
	 * @throws IOException
	 */
	public void crearDocJSON1(ActionEvent event) throws IOException{			
		String NameJson = nameJSONstore.getText();
		String NameDoc = nameDocumento.getText();
		System.out.println("\nNameJson("+NameJson+")__NameDoc("+NameDoc+")__\n");
		
		if (ListJSONstores.getInstance().buscarNodoD(NameJson) == true){
			
			ListJSONstores.getInstance().getNodoD(NameJson).getListacd().agregarNodoCD(NameDoc);
			msjCreacionDocJSON.setText("Documento creado");
			
			cont_Atributos.setDisable(false); 
			System.out.println("\n\nLista CD de "+NameJson+".  con nuevo hijoNodo :"+NameDoc+"_____.\n\n");
			System.out.println("Lista Actual de este Json store : " );
			ListJSONstores.getInstance().getNodoD(NameJson).getListacd().imprimirListaCD();
		
			System.out.println(" \n");
		}
		else{
			System.out.println("Lista CD de "+NameJson+". Sin cambios");
			msjCreacionDocJSON.setText("Documento existente");
			System.out.println("Lista SIn cambios: " );
			ListJSONstores.getInstance().getNodoD(NameJson).getListacd().imprimirListaCD();
		}	
		
	}
	
	/**
	 * Método que permite proseguir a formular las listas de atributos a partir de un Documento Json particular
	 * @param event
	 */
	@FXML
	public void continuar(ActionEvent event){
		//if (Existe un JSON Store )
		textCorrecDocJSON.setText("Proceso de verificación");
		cont_Atributos.setDisable(false);
		
			try{
				((Node)event.getSource()).getScene().getWindow().hide();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ObjectJSON.fxml"));
				Parent root3 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				
				stage.setTitle("LInkedDB");
				stage.setScene(new Scene(root3));
				stage.show();
				
			}catch (Exception e){
				System.out.println("Can´t load new window");
			}
		
	}
	
	
	/**
	 * Método para regresar a la pantalla inicial 
	 * @param event
	 */
	@FXML
	public void atras(ActionEvent event){
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
		}catch (Exception e){
			System.out.println("Can´t load new window");
			}
		}
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		cont_Atributos.setDisable(true);
		verificarNameDoc.setDisable(true);
		nameDocumento.setDisable(true);
		
	}
	
}
