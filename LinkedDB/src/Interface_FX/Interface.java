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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
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
	@FXML private MenuItem CreateJsonStore,DeleteJsonStore,CreateJsonDoc,MenuItemMenuCommit;
	@FXML private Label msjCrearJSONstore , conf_Create;	
	@FXML private TextField textnameJSONStore;
	@FXML private TreeView treeView1;	
	@FXML private TableView tabla;	
	@FXML private TreeItem baseDatos,treeitemJson,treeitemDOC,treeitemObj;
	private FileReader leerTexto,leerTextoA ,leerDOC,leerObj ;
	private BufferedReader almacenamientoTexto , almacenamientoTextoA,almacenamientoDoc,almacenamientoObj;	
	private File carpetaJson,ArchivoTxtJson,newFileJSON,newFileDoc,crearDocListaTxt,crearObjListaTxt,crearArchivoListaTxt,newFileObj4;
	private String listaTxtJson,cadena,carpetaEnJSON,rutaDOC ,rutaArchivos,carpetaObj11,rutaObj,cadenaObj,texto,nombreArchivo,cadenaDOC,carpetaEnDoc;


	

	
	//MenuItem tiposEspecialesStatusList = (MenuItem) FXCollections.observableArrayList("Show All Object","Add new Object","Delete All Object","Delete Document","Delete/Search Object Key","Delete Object","Search for Attribute","Update Object");                             

	CheckMenuItem men1 = new CheckMenuItem("Show All Object");
	CheckMenuItem men2 = new CheckMenuItem("Add new Object");
	CheckMenuItem men3 = new CheckMenuItem("Delete All Object");
	CheckMenuItem men4 = new CheckMenuItem("Delete Document");
	CheckMenuItem men5 = new CheckMenuItem("Delete/Search Object Key");
	CheckMenuItem men6 = new CheckMenuItem("Delete Object");
	CheckMenuItem men7 = new CheckMenuItem("Search for Attribute");
	CheckMenuItem men8 = new CheckMenuItem("Update Object");
	
	@FXML private ChoiceBox<String> tiposEspecialesStatusBox;
	
	
	
	Image DBIcon = new Image(getClass().getResourceAsStream("/img/img4.png"));
	Image FileIcon = new Image(getClass().getResourceAsStream("/img/img1.png"));	
	Image DocIcon = new Image(getClass().getResourceAsStream("/img/tabla.png"));	
	Image ArcIcon = new Image(getClass().getResourceAsStream("/img/columna.jpg"));
	
	/**
	 * Método para abrir una nueva ventana para la creación de Json Stores
	 * @param event
	 */
	@FXML
	public void OpenNew_JSONStore(ActionEvent event){			
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
	
	/**
	 * Método para abrir una nueva ventana para la creación de Documentos Json 
	 * @param event
	 */
	@FXML
	public void OpenCreate_DocJSON(ActionEvent event){		
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
	public void doorDelete_JSONstore(ActionEvent event){		
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
	 *  Método para actualizar cualquier cambio que realice el usuario
	 */
	public void update(){		
		MenuItemMenuCommit.setDisable(false);
		TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		PrintWriter escribir;
				
		if (ListJSONstores.estaListaDVacia()==false){				
			NodoListaD t = ListJSONstores.getFirstNodeD();			
			while(t != null){
				String tname = t.getDato();			
				TreeItem treeitem =new TreeItem(tname,new ImageView(FileIcon));
				baseDatos.getChildren().addAll(treeitem);		
				
				if(t.getListacd().estaListaCDVacia()==false){	
					NodoListaCD t1 = t.getListacd().getFirstNodeCD();	
					NodoListaCD first = t.getListacd().getFirstNodeCD();	
					
					while (t1.getSiguiente() != first){
						String t1name = t1.getDato();
						System.out.println("Nombre del Doc Json = <<<-"+t1name);
						TreeItem treeitemDoc =new TreeItem(t1name,new ImageView(DocIcon));
						treeitem.getChildren().addAll(treeitemDoc);
						
						System.out.println(ListJSONstores.getInstance().getNodoD(tname));
						System.out.println(ListJSONstores.getInstance().getNodoD(tname).getListacd());
						System.out.println(ListJSONstores.getInstance().getNodoD(tname).getListacd().getNodoCD(t1name));
						System.out.println(ListJSONstores.getInstance().getNodoD(tname).getListacd().getNodoCD(t1name).getDato());
											
						if(ListJSONstores.getNodoD(tname).getListacd().getNodoCD(t1name).getListaS() != null){
							System.out.println("\nVerifico si la lista era null o no.... y da como resultado que ");	
							
							if(ListJSONstores.getNodoD(tname).getListacd().getNodoCD(t1name).getListaS().estaListaSVacia()==false){
								NodoListaS t2 =ListJSONstores.getInstance().getNodoD(tname).getListacd().getNodoCD(t1name).getListaS().getFirstNodeS();
								System.out.println("    } OBJETO : "+ t2.getDato());
								
								while(t2!=null){
									String t2name = t2.getDato();
									TreeItem treeArc =new TreeItem(t2name,new ImageView(ArcIcon));
									treeitemDoc.getChildren().addAll(treeArc);
									t2=t2.getSiguiente();
								}
							}
						}
						t1= t1.getSiguiente();	
					}
					String t1name = t1.getDato();								// PARA AGREGAR EL ULTIMO QUE EL WHILE NO ISO
					System.out.println("Nombre del Doc Json = <<<-"+t1name);
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
					}		*/
					
				//t= t.getSiguiente();												//CORRECTO
				t1= t1.getSiguiente();	
			}
			t= t.getSiguiente();	
			}
		}
		
	}
	
	/**
	 * Método para cargar todo el contenido de los ficheros (txt) hacia el sistema
	 */
	public void cargarInicial1(){
	MenuItemMenuCommit.setDisable(true);
	
	baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
	treeView1.setRoot(baseDatos);
	baseDatos.setExpanded(true);
	
	nombreArchivo = "JSONstore";
	carpetaJson = new File(nombreArchivo);
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
				System.out.println("-JsonStore :" +cadena);
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
						System.out.println("  > DocJson: " +cadenaDOC);

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
								ListJSONstores.getInstance().getNodoD(cadena).getListacd().agregarNodoCD(cadenaObj);
								System.out.println("    |-ObjJson: " +cadenaObj);
								//ListJSONstores.getInstance().getNodoD(cadena).getListacd().imprimirListaCD();
								carpetaObj11 = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\"+cadenaObj+"_listaAtributos.txt";	
								newFileObj4 = new File(carpetaObj11);			
								
								if(!newFileObj4.exists()){	
									try{
									newFileObj4.createNewFile(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
								}catch (Exception e) {
									System.out.println("Error al crear txt de atributos");
								}
									// TODO: handle exception
								}
								
								//System.out.println("Objeto : "+cadenaObj +" Proveniente de :"+cadenaDOC+"\n");// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
								treeitemObj = new TreeItem(cadenaObj,new ImageView(ArcIcon));
								treeitemDOC.getChildren().addAll(treeitemObj);
								// System.out.println("\n.Elemento para la lista Simple :."+cadenaObj);
								ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS();
								
								//ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj);  // agrego a la listaCD (etapa2)
								//System.out.println("\n.______________Elemento CORRECTAMENTE agregado para la lista Simple :."+cadenaObj+"_______________________________");

																	
								
								}
							//ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().mostrar();
							
							leerObj.close();
							almacenamientoObj.close();
							}
						
							
						}
						leerDOC.close();
						almacenamientoDoc.close();
					
				}
			}			
			
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
	               for (String temp : fileDel.list()) {
	                   File fileDelete = new File(fileDel, temp);
	                   deleteFolder(fileDelete);
	               }
	               //check the directory again, if empty then delete it
	               if(fileDel.list().length==0)
	                   fileDel.delete();
	            }
	        }else{
	            
	            //if file, then delete it
	            fileDel.delete();    
	        }
	    }
	
	/**
	 * Método para realizar un respaldo del cualquier cambio que se halla realizado en el sistema 
	 */
	public void lastCommit(){	
		MenuItemMenuCommit.setDisable(true);
		baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		//TreeItem DB = new TreeItem("LinkedDB");
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);		
		
		carpetaJson = new File("JSONstore");
		listaTxtJson = "JSONstore\\ListaJSONstore.txt";
		
		
		ArchivoTxtJson = new File(listaTxtJson);
		if (carpetaJson.exists()){
			deleteFolder(carpetaJson);
			nombreArchivo = "JSONstore";
			carpetaJson = new File(nombreArchivo);
			listaTxtJson = "JSONstore\\ListaJSONstore.txt";
			ArchivoTxtJson = new File(listaTxtJson);
			carpetaJson.mkdirs();      // paso inicial de creacion  Al inicio no existia
			try {
				ArchivoTxtJson.createNewFile();

				try {
					FileWriter escribirA = new FileWriter(listaTxtJson); // si no escribe poner ArchivoTxtJson		,true
					PrintWriter pw = new PrintWriter(escribirA);
							
					NodoListaD temp = ListJSONstores.getInstance().getFirstNodeD();
					
					while(temp != null){  // ver si me da el ultimo de la lista ---------- sino temp.getDato oooo solo temp
						String valueNodeD = temp.getDato();
						System.out.println("-JsonStore :" +valueNodeD+".\n");
						pw.println(valueNodeD);		// escribe en el txt
						
						treeitemJson =new TreeItem(valueNodeD,new ImageView(FileIcon));
						baseDatos.getChildren().addAll(treeitemJson);
												
						carpetaEnJSON = "JSONstore\\"+temp.getDato();						
						newFileJSON = new File(carpetaEnJSON);		
						newFileJSON.mkdirs(); 						// Crea carpeta JSONstore
						
						rutaDOC = "JSONstore\\"+valueNodeD+"\\"+valueNodeD+"_listaDeDoc.txt";
						crearDocListaTxt = new File(rutaDOC);		
						
						crearDocListaTxt.createNewFile();
						
						FileWriter escribirB = new FileWriter(rutaDOC,true);
						PrintWriter lineaB = new PrintWriter(escribirB);
						
						
						NodoListaCD temp1 = ListJSONstores.getInstance().getFirstNodeD().getListacd().getFirstNodeCD(); //getNodoD(valueNodeD)
						
						while(temp1 != null){		 // igual que arriba si no guarda el ultimo hay que poner solo temp1	
							String valueNodeCD = temp1.getDato();
							System.out.println("  > DocJson: " +valueNodeCD+".\n");
							lineaB.println(valueNodeCD);
							
							treeitemDOC =new TreeItem(valueNodeCD,new ImageView(DocIcon));
							
							treeitemJson.getChildren().addAll(treeitemDOC);
							
							
							//NodoListaS nls = ListJSONstores.getInstance().getFirstNodeD().getListacd().getFirstNodeCD().getListaS().getFirstNodeS();
							//ListJSONstores.getInstance().getNodoD(cadena).getListacd().agregarNodoCD(cadenaDOC);  // agrego a la listaCD (etapa2)
							
							carpetaEnDoc = "JSONstore\\"+valueNodeD+"\\"+valueNodeCD;		// crea la carpeta del documentoJson					
							newFileDoc = new File(carpetaEnDoc);			
							
							newFileDoc.mkdirs(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
							rutaObj = "JSONstore\\"+valueNodeD+"\\"+valueNodeCD+"\\"+valueNodeCD+"_listaDeObj.txt"; // RUTAAAAA-----------------------------------------------------------------------------------------
							crearObjListaTxt = new File(rutaObj);	
							crearObjListaTxt.createNewFile();
							temp1 = temp1.getSiguiente();
						}
							/*
							
										while((cadenaObj=almacenamientoObj.readLine()) != null){
											System.out.println("____________________ObjJson: " +xxxxxxx +".\n");
											System.out.println("=0000000000000000000000000============= "+cadenaObj);// ERROR NO ESTOY METIENDO DENTRO DEL ITEM DE ESA CARPETA
											treeitemObj = new TreeItem(cadenaObj,new ImageView(ArcIcon));
											treeitemDOC.getChildren().addAll(treeitemObj);
											System.out.println("\n............................lllll.........."+cadenaObj);
																				
											carpetaObj11 = "JSONstore\\"+cadena+"\\"+cadenaDOC+"\\"+cadenaObj+".txt";	
											newFileObj4 = new File(carpetaObj11);			
											
											if(!newFileObj4.exists()){										
												newFileObj4.createNewFile(); // Crea carpeta JSONstore      IGUAL QUE ANTES......................................
												ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj);  // agrego a la listaCD (etapa2)

											}else{
												System.out.println("++++++++++++++++++++++++ ANTES DE AGREGAR +++++++++++++++++++++++++\n = " + cadenaObj);
												ListJSONstores.getInstance().getNodoD(cadena).getListacd().getNodoCD(cadenaDOC).getListaS().agregarNodoS(cadenaObj); 
												System.out.println("++++++++++++++++++++++++ LUEGO DE AGREGAR +++++++++++++++++++++++++\n = " + cadenaObj);
														// hacer txt......
													
												
											}System.out.println("SALTO DE OBJ--!----!---!--!");
											
										}
										//leerObj.close();
										//almacenamientoObj.close();
									}
									}
									
									*/
							
						
						//}
						escribirB.close();
						lineaB.close();
						
											
						temp = temp.getSiguiente();
					}
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
		System.out.println("\nCommit Finalizado........................!");

	}


	@Override
	public void initialize(URL url, ResourceBundle rb){				
		cargarInicial1();
			
	}
}
