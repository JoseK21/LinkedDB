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

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Lists.ListaCD;
import Lists.ListaD;
import Lists.ListaS;
import Lists.NodoListaCD;
import Lists.NodoListaD;
import Lists.NodoListaS;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InterfaceLinkedDBController implements Initializable {
	ListaD ListJSONstores = ListaD.getInstance();
	@FXML private Menu MenuJsonStore;
	@FXML private Menu MenuJsonDocument;
	@FXML private MenuItem CreateJsonStore;
	@FXML private MenuItem CreateJsonDoc;
	@FXML private MenuItem MenuItemMenuCommit;
	@FXML private Label msjCrearJSONstore;
	@FXML private Label conf_Create;	
	@FXML private TextField textnameJSONStore;
	@FXML private TreeView treeView1;
	@FXML private TableView tabla;
	@FXML private TreeItem baseDatos;
	@FXML private TreeItem treeitemJson;
	private String texto;
	private FileReader leerTexto;
	private BufferedReader almacenamientoTexto;
	private FileReader leerTextoA;
	private BufferedReader almacenamientoTextoA;
	private String nombreArchivo;
	private File carpetaJson;
	private File ArchivoTxtJson;
	private File newFileJSON;
	private String listaTxtJson;
	private String cadena;
	private String carpetaEnJSON;
	private String rutaDOC;
	private File crearDocListaTxt;
	private FileReader leerDOC ;
	private BufferedReader almacenamientoDoc;
	private String cadenaDOC;
	private TreeItem treeitemDOC;
	private String carpetaEnDoc;
	private File newFileDoc;
	private String rutaObj ;
	private File crearObjListaTxt ;
	private FileReader leerObj ;
	private BufferedReader almacenamientoObj;
	private String cadenaObj;
	private TreeItem treeitemObj;
	private String carpetaObj1;
	private File newFileObj4 ;
	private String rutaArchivos ;
	private File crearArchivoListaTxt ;
	
	int inicio = 0; 
	
	Image DBIcon = new Image(getClass().getResourceAsStream("/img/img4.png"));
	Image FileIcon = new Image(getClass().getResourceAsStream("/img/img1.png"));	
	Image DocIcon = new Image(getClass().getResourceAsStream("/img/tabla.png"));	
	Image ArcIcon = new Image(getClass().getResourceAsStream("/img/columna.jpg"));
	
	@FXML
	public void OpenNew_JSONStore(ActionEvent event){			
		try{
			//((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JSONStore.fxml"));
			
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
	public void enableCommit(boolean v){
		MenuItemMenuCommit.setDisable(false);
		
	}
	@FXML
	public void OpenCreate_DocJSON(ActionEvent event){		
		try{
			
			//((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DocJSON.fxml"));
			
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
		/*
		
		if (mouseEvent.getClickCount()==1){
			TreeItem item = (TreeItem) treeView1.getSelectionModel().getSelectedItem();
			System.out.println("Objeto seleccionado : "+item.getValue());
			
			
			try{
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
			}
			*/
	}
	@FXML
	public void cerrarSistema(ActionEvent event){
		System.exit(0);	}
		 
	public void cargarCarpetas(){		   					// NO ESTOY USANDO ESTE METODO	
		/*
		String ruta = "C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+ texto; // Se crea la carpeta con el nombre correspondiente		
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
	*/
}
	
	public void crearTxt(File archi){
		if (!archi.exists()){
			try {
				archi.createNewFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@FXML
	public void commit(ActionEvent event){
		NodoListaD nuevoA = ListJSONstores.getInstance().getFirstNodeD();
		int vuelta=0;
		if(ListJSONstores.estaListaDVacia()==false){
			while(nuevoA!= null){
				System.out.println("Vuelta => "+vuelta);
				String rutaA = ("JSONstore\\ListaJSONstore.txt");				
				try {
					FileWriter escribirA = new FileWriter(rutaA,true);
					PrintWriter lineaA = new PrintWriter(escribirA);
					lineaA.println(nuevoA.getDato());	
					
					
					NodoListaCD nuevoB = ListJSONstores.getInstance().getNodoD(nuevoA.getDato()).getListacd().getFirstNodeCD();
					//String rutaB = "JSONstore\\"+nuevoA.getDato()+"\\listDocGeneral.txt" ;		
					
					if(ListJSONstores.getInstance().getNodoD(nuevoB.getDato()).getListacd().estaListaCDVacia()==false){
						while ( nuevoB!= null){
							String rutaB = "JSONstore\\"+nuevoA.getDato()+"\\listDocGeneral.txt" ;
							try {
								FileWriter escribirB = new FileWriter(rutaB,true);
								PrintWriter lineaB = new PrintWriter(escribirB);
								lineaB.println(nuevoB.getDato());	
								//System.out.println("");
								
								
								NodoListaS nuevoC = ListJSONstores.getInstance().getNodoD(nuevoA.getDato()).getListacd().getFirstNodeCD().getListaS().getFirstNodeS();
								if(ListJSONstores.getInstance().getNodoD(nuevoB.getDato()).getListacd().getFirstNodeCD().getListaS().estaListaSVacia()==false){
									while(nuevoC != null){
										String rutaC = "JSONstore\\"+nuevoA.getDato()+"\\"+nuevoB.getDato()+"_Obj\\ListAttribute.txt";		
	
										try {
											FileWriter escribirC = new FileWriter(rutaC,true);
											PrintWriter lineaC = new PrintWriter(escribirC);
											lineaC.println(nuevoC.getDato());
										}catch (Exception e) {
											// TODO: handle exception
										}nuevoC=nuevoC.getSiguiente();
									}	
									}	
								}catch (Exception e) {
									// TODO: handle exception
								}
							nuevoB=nuevoB.getSiguiente();
						}}
							}catch (Exception e) {
								// TODO: handle exception
							}
							nuevoA=nuevoA.getSiguiente();
							vuelta++;
						}
						
						}else{
							System.out.println("Commit en blanco");		
						}
					}	
/*
				
				
				
				
				
				File newFileJSON = new File(carpetaEnJSON);	
				newFileJSON.mkdirs();	
				
				String rutaDOC = carpetaEnJSON+"\\listaDoc"+texto+".txt";
				File crearArchivoListaTxt = new File(rutaDOC);
				System.out.println("Nuevo JSON file creado dentro del JSONstore =) ");
				ListJSONstores.getInstance().agregarNodoD(texto); // Guarda en la lista doble
				
				crearArchivoListaTxt.createNewFile();
				nuevo=nuevo.getSiguiente();
				
				
				linea.close();
				escribir.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			//nuevo=nuevo.getSiguiente();
		}
		
		
	}
	
	*/
	public void update(){		
		TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		PrintWriter escribir;
		
		//NodoListaCD t1;
		
		if (ListJSONstores.estaListaDVacia()==false){		
			NodoListaD t = ListJSONstores.getFirstNodeD();
			while(t!= null){
				String tname = t.getDato();			
				TreeItem treeitem =new TreeItem(tname,new ImageView(FileIcon));
				baseDatos.getChildren().addAll(treeitem);
				System.out.println("Nombre del Json <<Interface>> = ---["+t.getDato());
					
				
				if(ListJSONstores.getInstance().getNodoD(tname).getListacd().estaListaCDVacia()==false){																							//t= t.getSiguiente();
				//if (t.getListacd().estaListaCDVacia()==false){				
					NodoListaCD t1 = ListJSONstores.getInstance().getNodoD(tname).getListacd().getFirstNodeCD();
					System.out.println("Nombre del Doc Json = <<<"+t1.getDato());
					while (t1!= null){
						String t1name = t1.getDato();
						TreeItem treeitemDoc =new TreeItem(t1name,new ImageView(DocIcon));
						treeitem.getChildren().addAll(treeitemDoc);
						
						
						/*
						if(ListJSONstores.getInstance().getNodoD(tname).getListacd().getNodoCD(t1name).getDato() != null){
						//if(ListJSONstores.getInstance().getNodoD(tname).getListacd().getFirstNodeCD().getListaS().estaListaSVacia()==false){																			//t1= t1.getSiguiente();
							NodoListaS t2 =ListJSONstores.getInstance().getNodoD(tname).getListacd().getNodoCD(t1name).getListaS().getFirstNodeS();
							while(t2!=null){
								String t2name = t2.getDato();
								TreeItem treeArc =new TreeItem(t2name,new ImageView(ArcIcon));
								treeitemDoc.getChildren().addAll(treeArc);
								t2=t2.getSiguiente();
							}							
						}
						*/
						
						t1= t1.getSiguiente();
				}					
				System.out.println("Si llego que el primero es null pues esta solo");	
				}
				t= t.getSiguiente();				
				System.out.println("Sin Doc para agregar------------");
			}
			System.out.println("LLego al ultimo nodo de JSON store");
			
		}
		System.out.println("Nada que Actualizar Lista JSONstore VACIAAAAA... :) ");
	
	}
	
	
	public void setUp(){ // Carga Inicial		
		baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		
	
		String nombreArchivo = "JSONstore";
		File crearcarpeta = new File(nombreArchivo);
		String listaTxt = "JSONstore\\ListaJSONstore.txt";
		File crearArchivoTxt = new File(listaTxt);
		
		if (!crearArchivoTxt.exists()){				
			crearcarpeta.mkdirs(); // creo la carpeta inicialmente
			try {
				crearArchivoTxt.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
		try{	
			leerTexto = new FileReader(listaTxt);
			almacenamientoTexto=new BufferedReader(leerTexto);
			String texto="";
			
			while((texto=almacenamientoTexto.readLine()) != null){
				ListJSONstores.getInstance().agregarNodoD(texto); // Guarda en la lista doble
				System.out.println("______ListaD_________");
				ListJSONstores.getInstance().imprimirListaD();
				System.out.println("\n_______.________");
				
				TreeItem treeitem =new TreeItem(texto,new ImageView(FileIcon));
				baseDatos.getChildren().addAll(treeitem);		
				
				String carpetaEnJSON = "JSONstore\\"+texto;						
				File newFileJSON = new File(carpetaEnJSON);	
				newFileJSON.mkdirs();	
				
				String rutalistDocGeneral = carpetaEnJSON+"\\listDocGeneral.txt";   // para un JSONSTORE ESPECIFICO
				File crearArchivoListaTxt = new File(rutalistDocGeneral);
				
				if(!crearArchivoListaTxt.exists()){
					newFileJSON.mkdirs();								// ver que tenga color luego de cerrar los }{}{}
					crearArchivoListaTxt.createNewFile();					
					System.out.println("Nuevo JSON file creado dentro del JSONstore =) ");
				}
				FileReader leerDOC = new FileReader(rutalistDocGeneral);							
				BufferedReader almacenamientoDoc=new BufferedReader(leerDOC);
				String cadenaDOC="";
					
				while((cadenaDOC=almacenamientoDoc.readLine()) != null){	// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
						
					TreeItem treeitemDOC =new TreeItem(cadenaDOC,new ImageView(DocIcon));
					treeitem.getChildren().addAll(treeitemDOC);
						
					ListJSONstores.getInstance().getNodoD(texto).getListacd().agregarNodoCD(cadenaDOC);
					System.out.println("ListaCD :"+ListJSONstores.getInstance().getNodoD(texto).getListacd().getNodoCD(cadenaDOC).getDato()+"\nElemento agregado:");
					
					ListJSONstores.getInstance().getNodoD(texto).getListacd().getNodoCD(cadenaDOC).getDato();
										
					String carpObj = "JSONstore\\"+texto+"\\"+cadenaDOC;
					File crearCarArchivoObj = new File(carpObj);
					crearCarArchivoObj.mkdirs();
					String listaObj = "JSONstore\\"+texto+"\\"+cadenaDOC+"\\ListGeneralObj.txt";  // lista de un doc en especifico referiendose a sus objetos
					File crearArchivoObj = new File(listaObj);
					crearArchivoObj.createNewFile();
										
					if (!crearArchivoObj.exists()){							
						crearCarArchivoObj.mkdirs(); // creo la carpeta inicialmente
						crearArchivoObj.createNewFile();
					}	
					FileReader leerTextoObj = new FileReader(listaObj);
					BufferedReader almacenamientoObj=new BufferedReader(leerTextoObj);
					String textoObj="";
						
					while((textoObj=almacenamientoObj.readLine()) != null){
						TreeItem treeitemObj =new TreeItem(textoObj,new ImageView(ArcIcon));
						treeitemDOC.getChildren().addAll(treeitemObj);	
																	
						String ListaObj = "JSONstore\\"+texto+"\\"+cadenaDOC+"\\"+textoObj;						
						File newFileObjJSON = new File(ListaObj);
						newFileObjJSON.mkdirs();
																
						String ListaCarpetaObj = "JSONstore\\"+texto+"\\"+cadenaDOC+"\\"+textoObj+"\\ListAttribute.txt";						
						File crearAObj = new File(ListaCarpetaObj);
						//crearAObj.createNewFile();
											
						if (!crearAObj.exists()){							
							newFileObjJSON.mkdirs(); // creo la carpeta inicialmente
							crearAObj.createNewFile();
						}	
						ListJSONstores.getInstance().getNodoD(texto).getListacd().getNodoCD(textoObj).getListaS().agregarNodoS(textoObj); // Guarda en la lista doble
							
					}
					leerTextoObj.close();
					almacenamientoObj.close();	
				}
				leerDOC.close();
				almacenamientoDoc.close();
			}
			leerTexto.close();
			almacenamientoTexto.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
}
	
	public void cargarInicial(){
		
		TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		//TreeItem DB = new TreeItem("LinkedDB");
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		//PrintWriter escribir;
		
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
					leerTexto = new FileReader(listaTxt);
					almacenamientoTexto=new BufferedReader(leerTexto);
					String cadena="";
					
					while((cadena=almacenamientoTexto.readLine()) != null){
						TreeItem treeitem =new TreeItem(cadena,new ImageView(FileIcon));
						baseDatos.getChildren().addAll(treeitem);
						
						String carpetaEnJSON = "JSONstore\\"+cadena;						
						File newFileJSON = new File(carpetaEnJSON);						
						if(newFileJSON.mkdirs()){
							System.out.println("Nuevo JSON file creado dentro del JSONstore =) ");
							
							
							ListJSONstores.getInstance().agregarNodoD(cadena);
							//ListJSONstores.insertarFinal(null, cadena);
						}else{
							System.out.println("NO CREADO JSON file-----Existente B) ");
							ListJSONstores.getInstance().agregarNodoD(cadena);
							//ListJSONstores.insertarFinal(null, cadena);
							
						}
						ListJSONstores.imprimirListaD();
						//ListJSONstores.imprimir(ListJSONstores);
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
							ListJSONstores.getInstance().agregarNodoD(cadena);
							//ListJSONstores.insertarFinal(lis,cadena);
							//crear carpetas aqui
							ListJSONstores.getInstance().agregarNodoD(cadena);
							//ListJSONstores.getInstance().insertarFinal(null, cadena);
							
							
					}else{
						System.out.println("!!!! No contiene una lista :"+cadena+". Salto a la otra carpeta");
					}
					//ListJSONstores.getInstance().insertarFinal(null, cadena);
					}
					ListJSONstores.imprimirListaD();
					//ListJSONstores.imprimir(ListJSONstores);
					System.out.println("\n");
					leerTexto.close();
					almacenamientoTexto.close();
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	// PRUEBA DE CARGA INICIAL -------------------------------------------------------------------!!!!!---------------------------------!!!!!--
	
	public void cargarInicial1(){
	//MenuItemMenuCommit.setDisable(true);
	
	baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
	//TreeItem DB = new TreeItem("LinkedDB");
	treeView1.setRoot(baseDatos);
	baseDatos.setExpanded(true);
	
	nombreArchivo = "JSONstore";
	carpetaJson = new File(nombreArchivo);
	listaTxtJson = "JSONstore\\ListaJSONstore.txt";
	
	System.out.println("Creo Arbol Vacio");
	
	ArchivoTxtJson = new File(listaTxtJson);
	
	if (!carpetaJson.exists()){
		carpetaJson.mkdirs();      // paso inicial de creacion  Al inicio no existia
		System.out.println("Se creo una inicial Carpeta JsonStore");
		System.out.println("Se detuvo el programa");
		try {
			ArchivoTxtJson.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else{
		System.out.println("Ya existia la carpeta de JsonStore");
		try {
			leerTexto = new FileReader(listaTxtJson);
			almacenamientoTexto=new BufferedReader(leerTexto);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cadena="";
			
		try {
			while((cadena=almacenamientoTexto.readLine()) != null){
				
				treeitemJson =new TreeItem(cadena,new ImageView(FileIcon));
				baseDatos.getChildren().addAll(treeitemJson);
				
				ListJSONstores.getInstance().agregarNodoD(cadena);    // Se agrega a la ListaDoble (etapa1)
				System.out.println("Creo Arbol de JsonStores");
				carpetaEnJSON = "JSONstore\\"+cadena;						
				newFileJSON = new File(carpetaEnJSON);		
								
				if(!newFileJSON.exists()){
					newFileJSON.mkdirs(); // Crea carpeta JSONstore
					System.out.println("Se detuvo el programa2");
				}else{
					
				rutaDOC = "JSONstore\\"+cadena+"\\listaDeDoc.txt";
				crearDocListaTxt = new File(rutaDOC);		
			
				if (!crearDocListaTxt.exists()){
					crearDocListaTxt.createNewFile();
				}else{
					
					leerDOC = new FileReader(rutaDOC);							
					almacenamientoDoc=new BufferedReader(leerDOC);
					cadenaDOC="";
					
					while((cadenaDOC=almacenamientoDoc.readLine()) != null){					// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
						treeitemDOC =new TreeItem(cadenaDOC,new ImageView(DocIcon));
						treeitemJson.getChildren().addAll(treeitemDOC);
						System.out.println("\nHijo Doc: "+cadenaDOC+" al JsonStore :"+cadena);
						
						ListJSONstores.getInstance().getNodoD(cadena).getListacd().agregarNodoCD(cadenaDOC);  // agrego a la listaCD (etapa2)
						
						carpetaEnDoc = "JSONstore\\"+cadena+"\\"+cadenaDOC;						
						newFileDoc = new File(carpetaEnDoc);			
						
						if(!newFileDoc.exists()){
							newFileDoc.mkdirs(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
						}else{
							rutaObj = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\listaDeObj_"+cadenaDOC+".txt"; // RUTAAAAA
							crearObjListaTxt = new File(rutaObj);	
							
							if (!crearObjListaTxt.exists()){
								crearObjListaTxt.createNewFile();
							}else{
								
								leerObj = new FileReader(rutaObj);							
								almacenamientoObj=new BufferedReader(leerObj);
								cadenaObj="";
								
								while((cadenaObj=almacenamientoObj.readLine()) != null){					// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
									treeitemObj = new TreeItem(cadenaObj,new ImageView(ArcIcon));
									treeitemDOC.getChildren().addAll(treeitemObj);
									System.out.println("\n............................lllll.........."+cadenaObj);
									
									//ListJSONstores.getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj); // agrego a la listaCD (etapa2)
									//ListJSONstores.getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().getFirstNodeS();
									
									carpetaObj1 = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\"+cadenaObj;	
									newFileObj4 = new File(carpetaObj1);			
									
									if(!newFileObj4.exists()){
										newFileObj4.mkdirs(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
									}else{
										rutaArchivos = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\"+cadenaObj+"\\listaDeArchivosGeneralFinal.txt";
										crearArchivoListaTxt = new File(rutaArchivos);	
										System.out.println("VAAAAA A CREAR ARCHIVO TABLA");
	
										if (!crearArchivoListaTxt.exists()){
											crearArchivoListaTxt.createNewFile();
											
											System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++\n");
										}else{
											System.out.println("/////////////////////////////////////////////////\n");
										}	
									}System.out.println("SALTO DE OBJ--!----!---!--!");
									//ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj);  // agrego a la listaCD (etapa2)
	
									}
								leerObj.close();
								almacenamientoObj.close();
							}
							}
					}
					leerDOC.close();
					almacenamientoDoc.close();
					
				}
			}
			}
			System.out.println("NO EXISTEN JSON ::............");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			leerTexto.close();
			almacenamientoTexto.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}		


public void commit1(){
	
	TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
	treeView1.setRoot(baseDatos);
	baseDatos.setExpanded(true);
	
	String listaTxtA = "JSONstore\\ListaJSONstore.txt";
    try {
		leerTextoA = new FileReader(listaTxtA);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	almacenamientoTextoA=new BufferedReader(leerTextoA);
	String cadenaA="";
	ListJSONstores.getInstance().limpiar();		
		try {
			while((cadenaA=almacenamientoTextoA.readLine()) != null){
				
			TreeItem treeitem =new TreeItem(cadenaA,new ImageView(FileIcon));
			baseDatos.getChildren().addAll(treeitem);
			
			ListJSONstores.getInstance().agregarNodoD(cadenaA);    // Se agrega a la ListaDoble (etapa1)
							
			String rutaDOC = "JSONstore\\"+cadenaA+"\\listaDeDoc.txt";	
			FileReader leerDOC = new FileReader(rutaDOC);							
			BufferedReader almacenamientoDoc=new BufferedReader(leerDOC);
			String cadenaDOC="";
				
			while((cadenaDOC=almacenamientoDoc.readLine()) != null){					// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
					TreeItem treeitemDOC =new TreeItem(cadenaDOC,new ImageView(DocIcon));
					treeitem.getChildren().addAll(treeitemDOC);
					
					ListJSONstores.getInstance().getNodoD(cadenaA).getListacd().agregarNodoCD(cadenaDOC);  // agrego a la listaCD (etapa2)
					String rutaObj = "JSONstore\\"+cadenaA+"\\"+cadenaDOC+"\\listaDeObj.txt";
					FileReader leerObj = new FileReader(rutaObj);							
					BufferedReader almacenamientoObj=new BufferedReader(leerObj);
					String cadenaObj="";
							
					while((cadenaObj=almacenamientoObj.readLine()) != null){					// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
						TreeItem treeitemObj =new TreeItem(cadenaObj,new ImageView(ArcIcon));
						treeitemDOC.getChildren().addAll(treeitemObj);
						
						ListJSONstores.getInstance().getNodoD(cadenaA).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj);  // agrego a la listaCD (etapa2)
												
					}
					leerObj.close();
					almacenamientoObj.close();
				}
			leerDOC.close();
			almacenamientoDoc.close();
			}
		try {
			leerTextoA.close();
			almacenamientoTextoA.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}catch (Exception e) {
		// TODO: handle exception
	}
}


	@Override
	public void initialize(URL url, ResourceBundle rb){		
		//MenuItemMenuCommit.setDisable(true);
		System.out.println("Inicio...................................................");
		cargarInicial1();
		//setUp();		
	}
}
