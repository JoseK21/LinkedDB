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
		//ListaJSONstore.imprimir(ListaJSONstore);
		
		if (ListaJSONstore.buscar(NameJson) == true){
			System.out.println("dentro de la lista luego de buscar bien el JSON store \n");
			ListaJSONstore.imprimir(ListaJSONstore);
			System.out.println("\nListo con la que verifique .!\n");
			verificarNameDoc.setDisable(false);
			nameDocumento.setDisable(false); 
			msjVerJSONstore.setText("Carpeta existente");
			System.out.println("Carpeta existente  =) \n");
		}else{
			msjVerJSONstore.setText("Carpeta no existente");
			
		}
	}
	
	public void crearDocJSON(ActionEvent event) throws IOException{
		String NameDoc = nameDocumento.getText();	
		String NameJson = nameJSONstore.getText();
		
		
		//ListaDocJSON.desplazar(ListaDocJSON);
		ListaDocJSON.imprimir(ListaDocJSON);
		System.out.println("\n");
		ListaJSONstore.imprimir(ListaJSONstore);
		
		if (ListaDocJSON.buscar1(NameDoc) == false){
			msjVerJSONstore.setText("");
			String carpetaJSONEspecifico = "JSONstore\\"+NameJson+"\\"+NameDoc;			 // creacion de la carpeta
			File crearArchivoTxt = new File(carpetaJSONEspecifico);		
			String carpetaDOC = "JSONstore\\"+NameJson+"\\lista";
			String newruta;
			
			if (!crearArchivoTxt.exists()){  // verifica si el txt existe
				if (crearArchivoTxt.mkdirs()){ // crea carpeta
					System.out.println("Archivo txt agregado en la carpeta respectiva");
					ListaDocJSON.agregar(NameDoc);
					
					System.out.println("Agregando a = "+NameJson);
					ListaDocJSON.imprimir(ListaDocJSON);
					msjCreacionDocJSON.setText("Documento creado");
					cont_Atributos.setDisable(false);
					
					newruta = carpetaDOC +NameJson +"Doc.txt";  // crear txt GENERAL 
					String rutaestablecida = newruta;
					try{
						File archi = new File(rutaestablecida);
						if(archi.createNewFile()){    										// creo que solo se crea el txt ty sele agrega el nombre
							System.out.println("LIsta Agregada al JSON respectivo");
							FileWriter escribirDoc = new FileWriter(rutaestablecida,true);
							PrintWriter lineaDoc = new PrintWriter(escribirDoc);
							System.out.println("DAto a escribir en el txt :"+NameDoc);
							
							lineaDoc.println(NameDoc);
							
							lineaDoc.close();
							escribirDoc.close();
						}else{
							System.out.println("LIsta no Agregada..... ya existe =)");
							System.out.println("LIsta Agregada al JSON respectivo");
							FileWriter escribirDoc = new FileWriter(rutaestablecida,true);
							PrintWriter lineaDoc = new PrintWriter(escribirDoc);
							System.out.println("DAto a escribir en el txt :"+NameDoc);
							
							lineaDoc.println(NameDoc);
							
							lineaDoc.close();
							escribirDoc.close();
							
							
						}
					}catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				else{
					System.out.println("Archivo txt NOOOOOOOO agregado en la carpeta");
				}
			}else{
				System.out.println("El Archivo ya existe dentro del JSON store");	
			}
			
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
