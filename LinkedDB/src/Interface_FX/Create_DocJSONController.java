package Interface_FX;

import java.io.File;
import java.io.IOException;
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


public class Create_DocJSONController implements Initializable {
	ListaCD ListaDocJSON = ListaCD.getInstance();
	ListaD ListaJSONstore = ListaD.getInstance();
	@FXML private Label textCorrecDocJSON;
	@FXML private TextField nameJSONstore;
	@FXML private TextField nameDocumento;
	@FXML private Button cont_Atributos;
	@FXML private Button verificarNameDoc;
	@FXML private Label msjVerJSONstore;
	@FXML private Label msjCreacionDocJSON;
	/*
	 *verificarNameDoc.setDisable(true);
	 * nameDocumento.setDisable(true); 
	 */
	
	@FXML
	public void verificar(ActionEvent event){
		String NameJson = nameJSONstore.getText();
		System.out.println("Nombre del JSON store a buscar: "+NameJson);
		ListaJSONstore.imprimir(ListaJSONstore);
		if (ListaJSONstore.buscar(NameJson)== true){
			verificarNameDoc.setDisable(false);
			nameDocumento.setDisable(false); 
			msjVerJSONstore.setText("Carpeta existente");
			System.out.println("Carpeta existente  =) \n");
			//String ruta = ("C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+NameJson);
			//String doc = nameDocumento			
		}else{
			msjVerJSONstore.setText("Carpeta no existente");
			
		}
	}
	
	public void crearDocJSON(ActionEvent event) throws IOException{
		String NameDoc = nameDocumento.getText();	
		String NameJson = nameJSONstore.getText();
			
		//ListaDocJSON.desplazar(ListaDocJSON);
		ListaDocJSON.imprimir(ListaDocJSON);
		
		if (ListaDocJSON.buscar1(NameDoc) == false){
			System.out.println("SIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII\n");
			msjVerJSONstore.setText("");
			

			String carpetaJSONEspecifico = "JSONstore\\"+NameJson+"\\"+NameDoc+".txt";			
			File crearArchivoTxt = new File(carpetaJSONEspecifico);			
			if (crearArchivoTxt.exists()){
				System.out.println("El Archivo ya existe dentro del JSON store");
			}else{
				
			}
			
			
			
			ListaDocJSON.agregar(NameDoc);
			System.out.println("Agregando a = "+NameDoc);
			ListaDocJSON.imprimir(ListaDocJSON);
			msjCreacionDocJSON.setText("Documento creado");
			cont_Atributos.setDisable(false);
			//String ruta1 = ("C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+NameJson+"\\");
			//System.out.println(ruta1);
			//File carpetaDoc =new File(ruta1);
			//carpetaDoc.mkdir();
			
			/*if (carpetaDoc.exists()){
				System.out.println("Carpeta creada");
			}else{
				carpetaDoc.mkdirs();
			}
			*/
		}else{
			msjCreacionDocJSON.setText("Documento existente");
			
		}	
		
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
		verificarNameDoc.setDisable(true);
		nameDocumento.setDisable(true);
		
	}
	
}
