package Interface_FX;

import java.io.*;
import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ResourceBundle;

import Lists.ListaCD;
import Lists.ListaD;
//import Interface_FX.NoticeController;
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


public class JSONStoreController implements Initializable {
	ListaD ListJSONstores = ListaD.getInstance();		
	@FXML private TextField textJsonStore;
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
	public void createNewJsonStore(ActionEvent event) throws IOException{	
		NameFile = textJsonStore.getText();	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Notice.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
				
		NoticeController display = fxmlLoader.getController();	
		
		/*
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("InterfaceLinkedDB.fxml"));
		Parent root2 = (Parent) fxmlLoader1.load();
		InterfaceLinkedDBController displayCommit = fxmlLoader1.getController();	
		*/
		
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
		//stage.setTitle("LInkedDB");
		stage.setScene(new Scene(root1));
		stage.initStyle( StageStyle.UTILITY );
		stage.show();
		
	}
	/*
	// el metodo de abajo hay que eliminarlo no se utiliza
	@FXML
	public void OpenMsj_JSONStore(ActionEvent event){			
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			System.out.println("ENTRO AL ABRIR LA VENTANA DE NOTICE");
			String Name = textJsonStore.getText();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Notice.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			
			NoticeController display = fxmlLoader.getController();	
			
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
	*/
		
	@Override
	public void initialize(URL url, ResourceBundle rb){	
		}   
	}