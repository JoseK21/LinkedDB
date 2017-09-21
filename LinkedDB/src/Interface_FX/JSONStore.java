package Interface_FX;

import java.io.*;
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
 * Clase para realizar Json Stores
 * @author José C.Núñez 
 *
 */
public class JSONStore implements Initializable {
	ListaD ListJSONstores = ListaD.getInstance();		
	@FXML private TextField textJsonStore;
	@FXML private TextField textJsonStoreD;
	private String NameFile;	
	private File archivoOtro;
	private File NewJsonStore;
	private FileWriter escribir; // para escribir en el archivo
	private PrintWriter linea;
	private FileReader leer;
	private BufferedReader almacenamiento;
	private String cadena;
	private String msjCreate ;
	private String msj;

		
	/**
	 * Método para crear un nuevo Json Store implicando realizar las verificaciones pertinentes
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void createNewJsonStore(ActionEvent event) throws IOException{	
		NameFile = textJsonStore.getText();	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Notice.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
				
		Notice display = fxmlLoader.getController();	
		
		((Node)event.getSource()).getScene().getWindow().hide();
		
		if (!NameFile.isEmpty()) {
			if(ListJSONstores.getInstance().buscarNodoD(NameFile)==false){
				msj = "correcto";
				display.setText("Great .. Your JsonStore ( "+NameFile+" ) was successfully created");						
				display.setImage1(msj);
				
				//displayCommit.enableCommit(false);
				
				ListJSONstores.getInstance().agregarNodoD(NameFile);  // agrego a la lista			ListJSONstores.insertarFinal(NameFile); 
				System.out.println("JsonStore agregado a la lista: "+NameFile+"\nLista Actualizada");
				ListJSONstores.getInstance().imprimirListaD();
			}else{
				msj="incorrecto";
				display.setText("Existing JsonStore ( "+ NameFile +" ),try using a different name");
				display.setImage1(msj);
				System.out.println("Dato existente =<"+NameFile+">");
				System.out.println("INCORRECTO : El JsonStore No se tiene que agregar a la lista: "+NameFile+"\nLista sin cambios :");
				ListJSONstores.getInstance().imprimirListaD();
				System.out.println("\n");				
			}
		}else{
			msj="vacio";
			display.setImage1(msj);
			display.setText("Warning..! Blank space");
			System.out.println("Error : El JsonStore No tiene nombre : ("+NameFile+")\nLista sin cambios :");
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