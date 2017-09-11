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
	ListaD ListJSONstores = ListaD.getInstance();
	@FXML private Label msj2;
	@FXML private Label msj1;	
	@FXML private TextField textJsonStore;
	
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
		String NameFile = textJsonStore.getText();	
		if (!NameFile.isEmpty()) {
			String ruta = ("JSONstore\\"+NameFile); // Se crea la carpeta con el nombre correspondiente
					
			if(ListJSONstores.buscar(NameFile)==false){		
				//--------------------------------------------------------------------
				try {
					File crearcarpeta = new File(ruta);				
					if (crearcarpeta.exists()){
						System.out.println("La Carpeta ya existe");	
					}else if (!crearcarpeta.exists()){
						System.out.println("La Carpeta no existe pero se creara");
						//crearcarpeta.mkdirs();	
						if (crearcarpeta.mkdirs()){		
							String ruta2 = ("JSONstore\\ListaJSONstore.txt");
							System.out.println("ruta2::: "+ruta2);
							escribir = new FileWriter(ruta2,true);
							linea = new PrintWriter(escribir);
							System.out.println("DAto a escribir en el txt :"+NameFile);
							linea.println(NameFile);
							
							linea.close();
							escribir.close();
							ListJSONstores.insertarFinal(ListJSONstores,NameFile);  // agrego a la lista
							ListJSONstores.imprimir(ListJSONstores);
						}else{
							System.out.println("La carpeta no fue creada  ERROR");
						}
					}else{
						System.out.println("La carpeta NO EXISTE");
					}// txt en escritorio REP21	
				}catch (IOException e) {
					// TODO: handle exception
					System.out.println("ERROR GRAVE");
				}							
				
			}else{
				System.out.println("Dato existente =<"+NameFile+">");
				msj1.setText("Archivo/Carpeta Dublicado");
				msj2.setText("Proceso Fallido");
			}
		}else{
			msj1.setText("----<SIN NOMBRE>--- ");
			msj2.setText("Ingrese un nombre por favor");
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