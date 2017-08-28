package Interface_FX;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Lists.ListaD;
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
	ListaD JSONstores =new ListaD();
	@FXML private Label msj2;
	@FXML private Label msj1;	
	@FXML private TextField textJsonStore;
	
		
	@FXML
	public void crearCarpeta(ActionEvent event){		
		String NameFile = textJsonStore.getText() ;	
		System.out.println("Nombre de la carpeta: " + NameFile);
		String archivo = "\\"+ NameFile +".txt";
		
		JSONstores.insertAtEnd(NameFile);
		JSONstores.mostrarListaD();
		if (!NameFile.isEmpty()) {					
			String ruta = "C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+ NameFile; // Se crea la carpeta con el nombre correspondiente
			
			File crea_carpeta = new File(ruta);		
			//File crea_archivo = new File(ruta+archivo);
			
							
			if(crea_carpeta.exists()){
				msj1.setText("----Carpeta Existente----");
				msj2.setText("Ingrese otro nombre PorFavor");
			}
			else{
				msj1.setText(" El proceso de creación de su carpeta ha sido Exitoso");
				crea_carpeta.mkdirs(); // Crear carpeta
				if (crea_carpeta.exists()){
					msj2.setText("Carpeta Creada");
				}else{
					msj2.setText("Carpeta NO Creada");
				}
					
				/*
				try{
					if (crea_archivo.createNewFile()){
						msj2.setText("Carpeta Creada");
					}else{
						msj2.setText("Carpeta NO Creada");	
					}
				}catch (IOException ex){
					Logger.getLogger(New_JSONStoreController.class.getName()).log(Level.SEVERE, null, ex);
				} */
		}
	}else{
		msj1.setText("----<SIN NOMBRE>--- ");
		msj2.setText("Ingrese otro nombre por favor");
	}
	}
	
	public void borrarInf(ActionEvent event){
		msj1.setText("");
		msj2.setText("");
		textJsonStore.setText("");
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
	
		
	@Override
	public void initialize(URL url, ResourceBundle rb){
		
	}

	//public static void main(String[] args){
		//this.archivo=archivo;
		
		
	//}
	
}