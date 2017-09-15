package Interface_FX;

import java.io.*;
import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ResourceBundle;

import Lists.ListaCD;
import Lists.ListaD;
//import Interface_FX.MsjCreateJsonStoreController;
import javafx.application.Platform;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class New_JSONStoreController implements Initializable {
	ListaD ListJSONstores = ListaD.getInstance();
		
	@FXML private TextField textJsonStore;
	private String NameFile;
	
	//File archivo = new File("JSONstore.txt");
	File archivoOtro;
	FileWriter escribir; // para escribir en el archivo
	PrintWriter linea;
	FileReader leer;
	BufferedReader almacenamiento;
	String cadena;
	
	@FXML
	public void actualizar(Object dato){
		/*try{
			File archivo = new File("JSONstore.txt");
			leer = new FileReader(archivo);
			almacenamiento=new BufferedReader(leer);
			cadena="";
			
			int num=1;
			while(cadena !=null){ // cambios de null,"",empty
				
				try {
					cadena=almacenamiento.readLine();			
					ListJSONstores.insertarFinal(ListJSONstores,cadena);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}	try {
			almacenamiento.close();
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
		*/
			
	}
	
	@FXML
	public void crearArchivoCarpeta(ActionEvent event) throws IOException{		
		NameFile = textJsonStore.getText();	
		String msjCreate ;
		String msj;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MsjCreateJSONStore.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		MsjCreateJsonStoreController display = fxmlLoader.getController();
		
		((Node)event.getSource()).getScene().getWindow().hide();
		if (!NameFile.isEmpty()) {
			
			String ruta = ("JSONstore\\"+NameFile); // Se crea la carpeta con el nombre correspondiente
					
			if(ListJSONstores.buscar(NameFile)==false){		
				//--------------------------------------------------------------------
				try {
				 msj = "correcto";
					System.out.println("Entro al buscar y lo encontro");	
					File crearcarpeta = new File(ruta);				
					if (crearcarpeta.exists()){
						display.setText("Great .. your JsonStore ("+NameFile+") was successfully created");
						
						display.setImage1(msj);;
						
						//System.out.println("La Carpeta ya existe");	
						//MsjCreateJsonStoreController.
						
					}else if (!crearcarpeta.exists()){						
						System.out.println("La Carpeta no existe pero se creara");
						//crearcarpeta.mkdirs();	
						if (crearcarpeta.mkdirs()){		
							display.setImage1(msj);
							display.setText("Great .. your JsonStore ("+NameFile+") was successfully created");
							String ruta2 = ("JSONstore\\ListaJSONstore.txt");
							System.out.println("ruta2::: "+ruta2);
							escribir = new FileWriter(ruta2,true);
							linea = new PrintWriter(escribir);
							System.out.println("DAto a escribir en el txt :"+NameFile);
							linea.println(NameFile);
							
							linea.close();
							escribir.close();
							
							//String l = "Lista"+NameFile;
									
							//ListaCD lis = new ListaCD();
							
							ListJSONstores.insertarFinal(NameFile);  // agrego a la lista
							
							
							
							//msj1.setText("Archivo/Carpeta Exitosamente creados");
							//msj2.setText("Proceso Completo");
							
							//ListJSONstores.imprimir(ListJSONstores);  ------- ListJSONstores.imprimir(l.imprimer());
						}else{
							msj="incorrecto";
							display.setText("!!!.........Error of the Software.......!!!!");
							display.setImage1(msj);
							System.out.println("La carpeta no fue creada  ERROR");
							//msj1.setText("Carpeta NO creada");
							//msj2.setText("Proceso Fallido");
						}
					}else{
						display.setText("Never show this.......... ;)");
						System.out.println("La carpeta NO EXISTE");
					}// txt en escritorio REP21	
				}catch (IOException e) {
					// TODO: handle exception
					System.out.println("ERROR GRAVE");
					display.setText("Serious System Error");
				}							
				
			}else{
				msj="incorrecto";
				display.setText("Existing JsonStore ("+ NameFile +"),try using a different name");
				display.setImage1(msj);
				System.out.println("Dato existente =<"+NameFile+">");
				//msj1.setText("Archivo/Carpeta Dublicado");
				//msj2.setText("Proceso Fallido");
			}
		}else{
			msj="vacio";
			display.setImage1(msj);
			display.setText("Warning..! Blank space");
		} 
		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.centerOnScreen();
		//stage.setTitle("LInkedDB");
		stage.setScene(new Scene(root1));
		stage.initStyle( StageStyle.UTILITY );
		stage.show();
		
	}
	
	@FXML
	public void OpenMsj_JSONStore(ActionEvent event){			
		try{
			String Name = textJsonStore.getText();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MsjCreateJSONStore.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			
			MsjCreateJsonStoreController display = fxmlLoader.getController();	
			
			display.setText("Hola : "+Name);    
			
			
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
	public void atras(ActionEvent event){
		try{
			
			((Node)event.getSource()).getScene().getWindow().hide();
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("No se cierra la ventana cuando regreso");
	}	
		}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){		 
		// preparando el archivo		
		/*if(!archivo.exists()){
			try {
				archivo.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Archivo ya antes creado");
		}
	*/
		}   
	}