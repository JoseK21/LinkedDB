package Interface_FX;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Lists.ListaCD;
import Lists.ListaD;
import Interface_FX.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InterfaceMainController extends New_JSONStoreController implements Initializable {
	@FXML private Label msjCrearJSONstore;
	@FXML private Label conf_Create;	
	@FXML private TextField textnameJSONStore;
	@FXML private TreeView treeView1;
	
	int inicio = 0; 
	
	Image DBIcon = new Image(getClass().getResourceAsStream("/img/img4.png"));
	Image FileIcon = new Image(getClass().getResourceAsStream("/img/img1.png"));	
	Image DocIcon = new Image(getClass().getResourceAsStream("/img/img3.png"));	
	
	//File archivo = new File("JSONstore.txt");
	
	@FXML
	public void OpenNew_JSONStore(ActionEvent event){			
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("New_JSONStore.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.centerOnScreen();
			stage.setTitle("LInkedDB");
			stage.setScene(new Scene(root1));
			stage.show();			
		}catch (Exception e){
			System.out.println("no se puede abrir la ventana ");
		}			
	}
		
	@FXML
	public void OpenCreate_DocJSON(ActionEvent event){		
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Create_DocJSON.fxml"));
			Parent root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.centerOnScreen();
			stage.setTitle("LInkedDB");
			stage.setScene(new Scene(root2));
			stage.show();
		}catch (Exception e){
			System.out.println("no se abrira la ventana");
		}			
	}
	
	@FXML
	public void Close(ActionEvent event){		
		try{
			Platform.exit();
			System.exit(0);
		}catch (Exception e){
			System.out.println("No se pudo cerrar el programa___ verificar close");
		}
	}
	// codigo parahacer chil derecho y desplegar las opciones
	@FXML
	public void mouseClick(MouseEvent mouseEvent){      
		if (mouseEvent.getClickCount()==2){
			//TreeItem<String> item = treeView1.getSelectionModel().getSelectedItem();
			//System.out.println(item.getValue());
			/*try{
				((Node)mouseEvent.getSource()).getScene().getWindow().hide();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClickRight_Document.fxml"));
				Parent root4 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.WINDOW_MODAL);
				stage.centerOnScreen();
				stage.setTitle("LInkedDB");
				stage.setScene(new Scene(root4));
				stage.show();
			}catch (Exception e){
				System.out.println("Can´t load new window");
			}*/
	}}	
	@FXML
	public void cerrarSistema(ActionEvent event){
		System.exit(0);	}
		 
	public void cargarCarpetas(){		   					// NO ESTOY USANDO ESTE METODO					
		String ruta = "C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+ cadena; // Se crea la carpeta con el nombre correspondiente		
		File crea_carpeta = new File(ruta);
		System.out.println(ruta);
										
		if(crea_carpeta.exists()){
			System.out.println("----Carpeta Existente----");
			//System.out.println("Ingrese otro nombre PorFavor");
		}
		else{				
			System.out.println(" El proceso de creación de su carpeta ha sido Exitoso");
			crea_carpeta.mkdirs(); // Crear carpeta
			if (crea_carpeta.exists()){
				
				
				ListaCD lis = new ListaCD();
				
				ListJSONstores.getInstance().insertarFinal(cadena);
				//ListJSONstores.insertarFinal(lis,cadena);
				//ListJSONstores.insertar(cadena);						
				System.out.println("Carpeta Creada");
				//ListJSONstores.imprimir();
				//ListJSONstores.mostrar();
			}else{
				System.out.println("Carpeta NO Creada");
				}		
	}
}
	
	public void crearTxt(File archi){
		if (!archi.exists()){
			try {
				archi.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@FXML
	public void commit(ActionEvent event){
		cargarInicial();
	}
	public void cargarInicial(){
		
		TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		//TreeItem DB = new TreeItem("LinkedDB");
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		PrintWriter escribir;
		
		//if (num == 0){
		
			try {
				String nombreArchivo = "JSONstore";
				File crearcarpeta = new File(nombreArchivo);
				String txt = "\\ListaJSONstore.txt";
				String listaTxt = "JSONstore\\ListaJSONstore.txt";
				File crearArchivoTxt = new File(nombreArchivo+txt);
				
				if (crearArchivoTxt.exists()){
					System.out.println("El Archivo ya existe ListaJSONstore.txt");	
				}else{
					System.out.println("El Archivo no existe pero se creara");
					crearcarpeta.mkdirs(); // creo la carpeta inicialmente
					try {
						if (crearArchivoTxt.createNewFile()){
							System.out.println("Archivo creado ListaJSONstore.txt");
						}else{
							System.out.println("Archivo NO !! creado NO SE PUEDO CREAR EL TXT /ListaJSONstore.txt/");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				try{	
					leer = new FileReader(listaTxt);
					almacenamiento=new BufferedReader(leer);
					String cadena="";
					
					while((cadena=almacenamiento.readLine()) != null){
						TreeItem treeitem =new TreeItem(cadena,new ImageView(FileIcon));
						baseDatos.getChildren().addAll(treeitem);
						
						String carpetaEnJSON = "JSONstore\\"+cadena;						
						File newFileJSON = new File(carpetaEnJSON);						
						if(newFileJSON.mkdirs()){
							System.out.println("Nuevo JSON file creado dentro del JSONstore =) ");
							
							
							ListJSONstores.getInstance().insertarFinal(cadena);
							//ListJSONstores.insertarFinal(null, cadena);
						}else{
							System.out.println("NO CREADO JSON file-----Existente B) ");
							ListJSONstores.getInstance().insertarFinal(cadena);
							//ListJSONstores.insertarFinal(null, cadena);
							
						}
						ListJSONstores.imprimir(ListJSONstores);
						String rutaDOC = "JSONstore\\"+cadena+"\\lista"+cadena+"Doc.txt";
						File crearArchivoListaTxt = new File(rutaDOC);
						
						if (crearArchivoListaTxt.exists()){
							FileReader leerDOC = new FileReader(rutaDOC);							
							BufferedReader almacenamientoDoc=new BufferedReader(leerDOC);
							String cadenaDOC="";
							
							while((cadenaDOC=almacenamientoDoc.readLine()) != null){	// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
								TreeItem treeitemDOC =new TreeItem(cadenaDOC,new ImageView(DocIcon));
								treeitem.getChildren().addAll(treeitemDOC);
							}
							leerDOC.close();
							almacenamientoDoc.close();
							ListaCD lis = new ListaCD();	
							ListJSONstores.getInstance().insertarFinal(cadena);
							//ListJSONstores.insertarFinal(lis,cadena);
							//crear carpetas aqui
							ListJSONstores.getInstance().insertarFinal(cadena);
							//ListJSONstores.getInstance().insertarFinal(null, cadena);
							
							
					}else{
						System.out.println("!!!! No contiene una lista :"+cadena+". Salto a la otra carpeta");
					}
					//ListJSONstores.getInstance().insertarFinal(null, cadena);
					}
					ListJSONstores.imprimir(ListJSONstores);
					System.out.println("\n");
					leer.close();
					almacenamiento.close();
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	
	@Override
	public void initialize(URL url, ResourceBundle rb){		
		if (inicio == 0){
			cargarInicial(); // cargarInicial(iniciacion);
							//iniciacion=1; 
		}else{
			System.out.println("DAtos ya cargados anteriormente");
		}
	}
	
}
