package Interface_FX;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Lists.ListaCD;
import Lists.Nodo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class New_JSONStoreController implements Initializable {
	
	@FXML private Label msjCrearJSONstore;
	@FXML private Label conf_Create;	
	@FXML private TextField textnameJSONStore;
	
		
	@FXML
	public void crearCarpeta(ActionEvent event){
		String NameFile = textnameJSONStore.getText() ;	
		System.out.println("Nombre de la carpeta: " + NameFile);
		String archivo = "\\"+ NameFile +".txt";
		if (!NameFile.isEmpty()) {					
			String ruta = "C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+ NameFile; // Se crea la carpeta con el nombre correspondiente
			System.out.println("Ruta: " + ruta);
	
			// meter metodos para añadir a la lista
			File crea_carpeta = new File(ruta);		
			File crea_archivo = new File(ruta+archivo);
			
							
			if(crea_archivo.exists()){
				msjCrearJSONstore.setText("----Carpeta Existente---- /nIngrese otro nombre PorFavor");
			}
			else{
				msjCrearJSONstore.setText(" El proceso de creación de su carpeta ha sido Exitoso");
				crea_carpeta.mkdirs(); // Crear carpeta
				
				try{
					if (crea_archivo.createNewFile()){
						conf_Create.setText("Carpeta Creada");
					}else{
						conf_Create.setText("Carpeta NO Creada");	
					}
				}catch (IOException ex){
					Logger.getLogger(New_JSONStoreController.class.getName()).log(Level.SEVERE, null, ex);
				}
		}
	}else{
		msjCrearJSONstore.setText("----<SIN NOMBRE>--- /nIngrese un nombre por favor");
	}
		ListaCD documentos = new ListaCD();
		Nodo doc = new Nodo(documentos);
		documentos.insertar(doc);
	
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
	}
		
		}
	
	@FXML
	public void nuevo(ActionEvent event){
		msjCrearJSONstore.setText("");
		conf_Create.setText("");
		textnameJSONStore.setText("");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		
	}

	public static void main(String[] args){
		//this.archivo=archivo;
		
	}
	
}
