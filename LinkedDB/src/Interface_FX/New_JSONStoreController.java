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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class New_JSONStoreController implements Initializable {
	ListaD ListJSONstores =new ListaD();
	@FXML private Label msj2;
	@FXML private Label msj1;	
	@FXML private TextField textJsonStore;
	
	File archivo = new File("JSONstore.txt");
	FileWriter escribir; // para escribir en el archivo
	PrintWriter linea;
	FileReader leer;
	BufferedReader almacenamiento;
	String cadena;
	@FXML
	public void actualizar(Object dato){
		try{
			archivo = new File("JSONstore.txt");
			leer = new FileReader(archivo);
			almacenamiento=new BufferedReader(leer);
			cadena="";
			
			int num=1;
			while(cadena !=null){ // cambios de null,"",empty
				
				try {
					cadena=almacenamiento.readLine();			
					ListJSONstores.insertar(cadena);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}	try {
			almacenamiento.close();
			System.out.println("Lista Actualizada--------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			leer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	}
	
	@FXML
	public void crearArchivo(ActionEvent event) throws IOException{		
		String NameFile = textJsonStore.getText();		
		ListJSONstores.mostrar();
		System.out.println(">>_________________antes de actualizar?____________________<<");
		if (!NameFile.isEmpty()) {
			
			actualizar(NameFile);
			ListJSONstores.mostrar();
			System.out.println(">>_________________luego de actualizar?con_elementos____________________<<\n");
			if(ListJSONstores.buscar(NameFile)==false){
				
				if (!archivo.exists()){
					try{
						archivo.createNewFile();
						escribir = new FileWriter(archivo,true);
						linea = new PrintWriter(escribir);
						almacenamiento=new BufferedReader(leer);
						cadena="";
						// escribir en el archivo
						linea.println(NameFile);
						linea.close();
						escribir.close();
						//actualizar(NameFile);
						ListJSONstores.insertar(NameFile);
						msj1.setText("Archivo Agregado ");
						msj2.setText("Proceso Exitoso");
						//ListJSONstores.mostrar();
						
					}catch(IOException ex){
						
					}
				}else{
					try{
						escribir = new FileWriter(archivo,true);
						linea = new PrintWriter(escribir);
						// escribir en el archivo
						linea.println(NameFile);
						linea.close();
						escribir.close();

						//actualizar(NameFile);
						ListJSONstores.insertar(NameFile);
						msj1.setText("Archivo Agregado ");
						msj2.setText("Proceso Exitoso");
						//ListJSONstores.mostrar();
					}catch(IOException ex){
						
					}
				}
			}else{
				System.out.println("Dato existente =<"+NameFile+">");
				msj1.setText("Archivo Dublicado");
				msj2.setText("Proceso Fallido");
			}
			
			
			
		}else{
			msj1.setText("----<SIN NOMBRE>--- ");
			msj2.setText("Ingrese otro nombre por favor");
			}
	}
	@FXML
	public void crearCarpeta(ActionEvent event) throws IOException{		
		String NameFile = textJsonStore.getText() ;
		System.out.println("Nombre de la carpeta: " + NameFile);
		
		if (!NameFile.isEmpty()) {					
			String ruta = "C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+ NameFile; // Se crea la carpeta con el nombre correspondiente
			
			File crea_carpeta = new File(ruta);
										
			if(crea_carpeta.exists()){
				msj1.setText("----Carpeta Existente----");
				msj2.setText("Ingrese otro nombre PorFavor");
			}
			else{				
				msj1.setText(" El proceso de creaci�n de su carpeta ha sido Exitoso");
				crea_carpeta.mkdirs(); // Crear carpeta
				if (crea_carpeta.exists()){
					ListJSONstores.insertar(NameFile);						
					msj2.setText("Carpeta Creada");
					ListJSONstores.mostrar();
				}else{
					msj2.setText("Carpeta NO Creada");
				}
		}
	}else{
		msj1.setText("----<SIN NOMBRE>--- ");
		msj2.setText("Ingrese otro nombre por favor");
	}
		ListJSONstores.mostrar();
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
			System.out.println("Can�t load new window");
	}
		
		}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		 
		// preparando el archivo		
		if(!archivo.exists()){
			try {
				archivo.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Archivo ya antes creado");
		}
	
		}
	}