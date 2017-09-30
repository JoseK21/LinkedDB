package Interface_FX;


import java.awt.event.MouseListener;
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

import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.tree.AbstractLayoutCache.NodeDimensions;

import Lists.ListaCD;
import Lists.ListaD;
import Lists.ListaS;
import Lists.NodoListaCD;
import Lists.NodoListaD;
import Lists.NodoListaS;
import Interface_FX.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
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

/**
 * Clase que controla toda la lógica, ya que es la interface principal del sistema
 * @author José C.Núñez 
 *
 */
public class Interface implements Initializable {
	ListaD ListJSONstores = ListaD.getInstance();
	
	@FXML private Menu MenuJsonStore,MenuJsonDocument;
	@FXML private MenuItem CreateJsonStore,DeleteJsonStore,CreateJsonDoc,MenuItemMenuCommit,updateMenuItem;
	@FXML private MenuItem right1;
	@FXML private MenuItem right2;
	@FXML private MenuItem right3;
	@FXML private MenuItem right4;
	@FXML private MenuItem right5;
	@FXML private MenuItem right6;
	@FXML private MenuItem right7;
	@FXML private MenuItem right8;
	@FXML private Label msjCrearJSONstore , conf_Create;	
	@FXML private TextField textnameJSONStore;
	@FXML private TreeView treeView1;	
	@FXML private TableView tabla;	
	@FXML private TreeItem baseDatos,treeitemJson,treeitemDOC,treeitemObj,treeNewJson;
	@FXML public ContextMenu ContextList;   
	private FileReader leerTexto,leerTextoA ,leerDOC,leerObj ;
	private BufferedReader almacenamientoTexto , almacenamientoTextoA,almacenamientoDoc,almacenamientoObj;	
	private File carpetaJson,ArchivoTxtJson,newFileJSON,newFileDoc,crearDocListaTxt,crearObjListaTxt,crearArchivoListaTxt,newFileObj4;
	private String listaTxtJson,cadena,carpetaEnJSON,rutaDOC ,rutaArchivos,carpetaObj11,rutaObj,cadenaObj,texto,fileJsonStore,cadenaDOC,carpetaEnDoc;


	
	
	
	
	
	Image DBIcon = new Image(getClass().getResourceAsStream("/img/img4.png"));
	Image FileIcon = new Image(getClass().getResourceAsStream("/img/img1.png"));	
	Image DocIcon = new Image(getClass().getResourceAsStream("/img/tabla.png"));	
	Image ArcIcon = new Image(getClass().getResourceAsStream("/img/columna.jpg"));
	
	
	
	public void activate_menuClic(){
		
		TreeItem selected = (TreeItem)treeView1.getSelectionModel().getSelectedItem();
		NodoListaD aux_store = ListJSONstores.getInstance().getNodoD(selected.getValue().toString());
		
		System.out.println(aux_store.getDato());
		//ListJSONstores.getInstance().setSelected_item(selected.getValue().toString());
		
		if(ListJSONstores.getInstance().buscarNodoD(selected.getValue().toString()) != false){
			// ListJSONstores.getInstance().ge
			right1.setDisable(false);
			right2.setDisable(false);
			right3.setDisable(false);
			right4.setDisable(false);
			right5.setDisable(false);
			right6.setDisable(false);
			right7.setDisable(false);
			right8.setDisable(false);
			
			right8.setVisible(true);
			right7.setVisible(true);
			right6.setVisible(true);
			right5.setVisible(true);
			right4.setVisible(true);
			right3.setVisible(true);
			right2.setVisible(true);
			right1.setVisible(true);
			
		}else{
			right1.setDisable(true);
			right2.setDisable(true);
			right3.setDisable(true);
			right4.setDisable(true);
			right5.setDisable(true);
			right6.setDisable(true);
			right7.setDisable(true);
			right8.setDisable(true);
			
			right8.setVisible(false);
			right7.setVisible(false);
			right6.setVisible(false);
			right5.setVisible(false);
			right4.setVisible(false);
			right3.setVisible(false);
			right2.setVisible(false);
			right1.setVisible(false);
		}
	}
	
	
	/**
	 * Método para abrir una nueva ventana para la creación de Json Stores
	 * @param event
	 */
	@FXML
	public void openNew_JSONStore(ActionEvent event){			
		try{
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
	@FXML
	public void openInformation(ActionEvent event){			
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Information.fxml"));			
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
	/**
	 * Método para abrir una nueva ventana para la creación de Documentos Json 
	 * @param event
	 */
	@FXML
	public void openCreate_DocJSON(ActionEvent event){		
		try{			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DocJSON.fxml"));			
			Parent root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.centerOnScreen();
			stage.setTitle("LinkedDB");
			stage.setScene(new Scene(root2));
			stage.show();
		}catch (Exception e){
			System.out.println("no se abrira la ventana");
		}			
	}
	
	/**
	 * Método para abrir la ventana de eliminar un Json Store
	 * @param event
	 */
	@FXML
	public void delete_JSONstore(ActionEvent event){		
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JsonStoreDelete.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.centerOnScreen();
			stage.setTitle("LinkedDB");
			stage.setScene(new Scene(root));
			stage.show();
		}catch (Exception e) {
			System.out.println("NOOOOOO VENTANA");	
			}
	}
	/**
	 * Método para cerrar el sistema
	 * @param event
	 */
	@FXML
	public void Close(ActionEvent event){		
		try{
			Platform.exit();
			System.exit(0);
		}catch (Exception e){
			System.out.println("No se pudo cerrar el programa___ verificar close");
		}
	}
			
	/**
	 * Metodo que permite actualizar la vista (interface) del software
	 */
	public void update(){		
		MenuItemMenuCommit.setDisable(false);
		TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		PrintWriter escribir;
		
		if (ListJSONstores.estaListaDVacia()==false){				
			int sizeD = ListJSONstores.getInstance().getSize();			
			NodoListaD NodoD = ListJSONstores.getInstance().getFirstNodeD();	
			int contD = 0;
			while(contD < sizeD){
				String nameJsonStore = NodoD.getDato();			
				TreeItem treeitem =new TreeItem(nameJsonStore,new ImageView(FileIcon));
				baseDatos.getChildren().addAll(treeitem);		
				
				if(NodoD.getListacd().estaListaCDVacia()==false){	
					int sizeCD = NodoD.getListacd().getSizeCD();
					
					NodoListaCD NodoCD = NodoD.getListacd().getFirstNodeCD();
					int contCD = 0;
					
					while(contCD < sizeCD){					
	                    String nameDocJson = NodoCD.getDato();
						TreeItem treeitemDoc =new TreeItem(nameDocJson,new ImageView(DocIcon));
						treeitem.getChildren().addAll(treeitemDoc);
						
						if(NodoCD.getListaS().estaListaSVacia() == false){							
							int sizeS = NodoCD.getListaS().getSizeS();
							NodoListaS NodoS = NodoCD.getListaS().getFirstNodeS();
							int contS = 0;
							
							while(contS < sizeS) {
								if(ListJSONstores.getInstance().getNodoD(nameJsonStore).getListacd().getNodoCD(nameDocJson).getListaS().buscarNodoS(NodoS.getDato()) != false){
									System.out.println("    } OBJETO : "+ NodoS.getDato());
									String t2name = NodoS.getDato();
									TreeItem treeArc =new TreeItem(t2name,new ImageView(ArcIcon));
									treeitemDoc.getChildren().addAll(treeArc);
								}
								NodoS = NodoS.getSiguiente();
								contS++;
							}
						}
						NodoCD = NodoCD.getSiguiente();      
						contCD++;
					}				
				}
				NodoD= NodoD.getSiguiente();    
				contD++;
			}
		}
		 System.out.println("\nSuccessful Update.");
	}
		
	/**
	 * Método para cargar todo el contenido de los ficheros (txt) hacia el sistema
	 */
	public void cargarInicial1(){
	MenuItemMenuCommit.setDisable(true);
	
	// ContextList.setDisable(false);
	baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
	treeView1.setRoot(baseDatos);
	baseDatos.setExpanded(true);
	
	baseDatos.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			//TreeItem<String> item = baseDatos.getSelectionModel().getSelectedItem
		}
	});
	
	fileJsonStore = "JSONstore";
	carpetaJson = new File(fileJsonStore);
	listaTxtJson = "JSONstore\\ListaJSONstore.txt";	
	
	if (!carpetaJson.exists()){
		carpetaJson.mkdirs();      // paso inicial de creacion  Al inicio no existia
		ArchivoTxtJson = new File(listaTxtJson);
		try {
			ArchivoTxtJson.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else{
		try {
			leerTexto = new FileReader(listaTxtJson);
			almacenamientoTexto=new BufferedReader(leerTexto);
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		try {
			while((cadena=almacenamientoTexto.readLine()) != null){
				treeitemJson =new TreeItem(cadena,new ImageView(FileIcon));
				System.out.println("• JsonStore :" +cadena);
				baseDatos.getChildren().addAll(treeitemJson);				
				ListJSONstores.getInstance().agregarNodoD(cadena);    // Se agrega a la ListaDoble (etapa1)
				
				
				carpetaEnJSON = "JSONstore\\"+cadena;						
				newFileJSON = new File(carpetaEnJSON);		
				rutaDOC = "JSONstore\\"+cadena+"\\"+cadena+"_listaDeDoc.txt";			
				if(!newFileJSON.exists()){
					newFileJSON.mkdirs(); // Crea carpeta JSONstore					
					crearDocListaTxt = new File(rutaDOC);	
					crearDocListaTxt.createNewFile();
				}else{					
					leerDOC = new FileReader(rutaDOC);							
					almacenamientoDoc=new BufferedReader(leerDOC);
					cadenaDOC="";
					
					while((cadenaDOC=almacenamientoDoc.readLine()) != null){					// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
						System.out.println("     > DocJson: " +cadenaDOC);

						treeitemDOC =new TreeItem(cadenaDOC,new ImageView(DocIcon));
						treeitemJson.getChildren().addAll(treeitemDOC);
						
						ListJSONstores.getInstance().getNodoD(cadena).getListacd().agregarNodoCD(cadenaDOC);  // agrego a la listaCD (etapa2)
						carpetaEnDoc = "JSONstore\\"+cadena+"\\"+cadenaDOC;						
						newFileDoc = new File(carpetaEnDoc);			
						
						rutaObj = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\"+cadenaDOC+"_listaDeObj.txt"; 
						if(!newFileDoc.exists()){
							newFileDoc.mkdirs(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
							
							crearObjListaTxt = new File(rutaObj);	
							crearObjListaTxt.createNewFile();
							
						}else{
							leerObj = new FileReader(rutaObj);							
							almacenamientoObj=new BufferedReader(leerObj);
							while((cadenaObj=almacenamientoObj.readLine()) != null){
								
								ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj);
								System.out.println("\n          ‡ ObjJson: " +cadenaObj+"\n Lista Simple de este Doc ("+cadenaDOC +")");
								ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().imprimirListaS();
								carpetaObj11 = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\"+cadenaObj+"_listaAtributos.txt";	
								newFileObj4 = new File(carpetaObj11);			
								
								if(!newFileObj4.exists()){	
									try{
									newFileObj4.createNewFile(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
								}catch (Exception e) {
									System.out.println("Error al crear txt de atributos");
								}
								}	
								
								treeitemObj = new TreeItem(cadenaObj,new ImageView(ArcIcon));
								treeitemDOC.getChildren().addAll(treeitemObj);
								}	
							System.out.println("Tamaño de la lista Simple (ObjJSON),  del DocStore : ? " +cadenaDOC+ "? DEL JsonStore : "+cadena +"         : "+ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().getSizeS());

							
							leerObj.close();
							almacenamientoObj.close();
							}
						}
						System.out.println("Tamaño de la lista Circular doble(DocJSON),  del JsonStore : ? " +cadena+ "?     : "+ListJSONstores.getInstance().getNodoD(cadena).getListacd().getSizeCD());
						leerDOC.close();
						almacenamientoDoc.close();
					
				}
			}			
			System.out.println("Tamaño de la lista Doble(JOSNSTORE) : "+ListJSONstores.getInstance().getSize());
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				leerTexto.close();
				almacenamientoTexto.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}		
	
	 /**
	  * Método para borrar todo el contenido de la carpeta principal
	 * @param fileDel
	 */
	private void deleteFolder(File fileDel) {				// revisar si elimino la carpeta
	        if(fileDel.isDirectory()){            
	            
	            if(fileDel.list().length == 0){
	                fileDel.delete();
	                System.out.println("2___Archivo eliminado............");
	            }
	            else{	                
	               for (String tempNodoD : fileDel.list()) {
	                   File fileDelete = new File(fileDel, tempNodoD);
	                   deleteFolder(fileDelete);
	               }
	               //check the directory again, if empty then delete it
	               if(fileDel.list().length==0)
	                   fileDel.delete();
	            }
	        }else{
	            fileDel.delete();    
	        }
	    }
	
	/**
	 * Método para realizar un respaldo del cualquier cambio que se halla realizado en el sistema 
	 */
	public void lastCommit(){	
		MenuItemMenuCommit.setDisable(true);
		baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));	
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);				
		carpetaJson = new File("JSONstore");
		listaTxtJson = "JSONstore\\ListaJSONstore.txt";		
		ArchivoTxtJson = new File(listaTxtJson);		
		System.out.println("Committing\n...\n...\n...");
		if (carpetaJson.exists()){
			deleteFolder(carpetaJson);
			fileJsonStore = "JSONstore";
			carpetaJson = new File(fileJsonStore);
			listaTxtJson = "JSONstore\\ListaJSONstore.txt";
			ArchivoTxtJson = new File(listaTxtJson);
			carpetaJson.mkdirs();      // paso inicial de creacion  Al inicio no existia
			try {
				ArchivoTxtJson.createNewFile();
				try {
					FileWriter escribirA = new FileWriter(listaTxtJson); // si no escribe poner ArchivoTxtJson		,true
					PrintWriter pw = new PrintWriter(escribirA);	
					int sizeD = ListJSONstores.getInstance().getSize();
					
					NodoListaD tempNodoD = ListJSONstores.getInstance().getFirstNodeD();	
					int contD = 0;
					while(contD < sizeD){  
						System.out.println(contD+"\n");
						// ver si me da el ultimo de la lista ---------- sino tempNodoD.getDato oooo solo tempNodoD
						
						String valueNodeD = tempNodoD.getDato();						
						pw.println(valueNodeD);		// escribe en el txt que se borrar porque se borro la carpeta JSON
						treeitemJson =new TreeItem(valueNodeD,new ImageView(FileIcon));
						baseDatos.getChildren().addAll(treeitemJson);												
						carpetaEnJSON = "JSONstore\\"+valueNodeD;						
						newFileJSON = new File(carpetaEnJSON);		
						newFileJSON.mkdirs(); 						// Crea carpeta JSONstore						
						rutaDOC = "JSONstore\\"+valueNodeD+"\\"+valueNodeD+"_listaDeDoc.txt";
						crearDocListaTxt = new File(rutaDOC);							
						crearDocListaTxt.createNewFile();		// CREA LA CARPETA CON TXT
						
						FileWriter escribirB = new FileWriter(rutaDOC,true);
						PrintWriter lineaB = new PrintWriter(escribirB);						
							
						if (tempNodoD.getListacd().estaListaCDVacia()== false ){						
							
							int sizeCD = tempNodoD.getListacd().getSizeCD();
							
							NodoListaCD tempNodoCD = tempNodoD.getListacd().getFirstNodeCD();
							NodoListaCD tempNodoCDInicio = tempNodoD.getListacd().getFirstNodeCD();
							int contCD = 0;
							
							while(contCD < sizeCD){
								System.out.println(contCD+" __\n");
								String valueNodeCD = tempNodoCD.getDato();
								lineaB.println(valueNodeCD);								
								treeitemDOC =new TreeItem(valueNodeCD,new ImageView(DocIcon));							
								treeitemJson.getChildren().addAll(treeitemDOC);								
								carpetaEnDoc = "JSONstore\\"+valueNodeD+"\\"+valueNodeCD;		// crea la carpeta del DocumentoJson					
								newFileDoc = new File(carpetaEnDoc);										
								newFileDoc.mkdirs();												 // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
								rutaObj = "JSONstore\\"+valueNodeD+"\\"+valueNodeCD+"\\"+valueNodeCD+"_listaDeObj.txt"; 
								
								crearObjListaTxt = new File(rutaObj);	
								crearObjListaTxt.delete();
								crearObjListaTxt = new File(rutaObj);	
								crearObjListaTxt.createNewFile();								
								FileWriter escribirC = new FileWriter(rutaObj,true);
								PrintWriter lineaC = new PrintWriter(escribirC);
								
								// REVISAR QUE LA LISTA SE ENCICLA									HACER TODO POR EL TAMAÑO DE LA LISTA DE ELLA
								
								if (tempNodoCD.getListaS().estaListaSVacia()==false ){
									System.out.println(")))))))))))))))))))))))))\nValor a verificar : "+tempNodoCD.getDato());
									
									int sizeS = tempNodoCD.getListaS().getSizeS();
									NodoListaS tempNodoS = tempNodoCD.getListaS().getFirstNodeS();
									int contS = 0;
									
									while(contS < sizeS) {
										
										String valueNodeS = tempNodoS.getDato();
										System.out.println("  > ObjJson: " +valueNodeS+".\n");	
										
										if(ListJSONstores.getInstance().getNodoD(valueNodeD).getListacd().getNodoCD(valueNodeCD).getListaS().buscarNodoS(valueNodeS)==false){ 		// Revisar por que solo me muestra en el update y no el el commit/tengo que actualizar para ver las cosas
											System.out.println("Elemento no estaba dentro de la lista anterior : elemento : "+valueNodeS);
											lineaC.println(valueNodeS);												
											treeitemObj = new TreeItem(valueNodeS,new ImageView(ArcIcon));
											treeitemDOC.getChildren().addAll(treeitemObj);																			
											 
											ListJSONstores.getInstance().getNodoD(valueNodeD).getListacd().getNodoCD(valueNodeCD).getListaS().agregarNodoS(valueNodeS);  // agrego a la listaCD (etapa2)
											
											carpetaObj11 = "JSONstore\\"+valueNodeD+"\\"+valueNodeCD+"\\"+valueNodeS+"_listaAtributos.txt";	
											newFileObj4 = new File(carpetaObj11);													
											newFileObj4.createNewFile();
											ListJSONstores.getInstance().getNodoD(valueNodeD).getListacd().getNodoCD(valueNodeCD).getListaS().imprimirListaS();																	
																					
											
											System.out.println("ESTOY AQUI VEAME JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ  " + tempNodoS.getDato());
											System.out.println("\n SALTO DE OBJ--!----!---!--!");
											
										}else{
											System.out.println("El elemento existia solo crea el txt porque se habia borrado todo y tiene que agregar al Arbol?????????");
											carpetaObj11 = "JSONstore\\"+valueNodeD+"\\"+valueNodeCD+"\\"+valueNodeS+"_listaAtributos.txt";	
											newFileObj4 = new File(carpetaObj11);													
											newFileObj4.createNewFile();
											ListJSONstores.getInstance().getNodoD(valueNodeD).getListacd().getNodoCD(valueNodeCD).getListaS().imprimirListaS();																	
												
										}
										
										tempNodoS = tempNodoS.getSiguiente();
										contS++;
									}
									System.out.println("\n FIN DEL WHILE DE LISTAS..}}..(ObjetosJSON añadidos)....: ) :) :) :) ");
									// SSASS hojas
									escribirC.close();
									lineaC.close();
									System.out.println("FIN DEL DO_WHILE.<<>>> Para : "+tempNodoCD.getDato());
									
								}						
							tempNodoCD = tempNodoCD.getSiguiente();
							contCD++;
							}					
						
						}	
						tempNodoD = tempNodoD.getSiguiente();
						escribirB.close();
						lineaB.close();
						contD++;
					}
					System.out.println("Fin de while #1 ");
					escribirA.close();
					pw.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		System.out.println("Commit Completed");

	}


	@Override
	public void initialize(URL url, ResourceBundle rb){		
		right1.setDisable(true); right1.setVisible(false);
		right2.setDisable(true); right2.setVisible(false);
		right3.setDisable(true); right3.setVisible(false);
		right4.setDisable(true); right4.setVisible(false);
		right5.setDisable(true); right5.setVisible(false);
		right6.setDisable(true); right6.setVisible(false);
		right7.setDisable(true); right7.setVisible(false);
		right8.setDisable(true); right8.setVisible(false);
		cargarInicial1();
			
	}
}
