package Interface_FX;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	Image DBIcon = new Image(getClass().getResourceAsStream("/img/img4.png"));
	Image FileIcon = new Image(getClass().getResourceAsStream("/img/img1.png"));
	
	
	
	
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
			System.out.println("Can´t load new window");
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
	@FXML
	public void borrar1(ActionEvent event){
		msjCrearJSONstore.setText("");
		conf_Create.setText("");
		textnameJSONStore.setText("");
	}
	@FXML
	public void borrar2(ActionEvent event){
		msjCrearJSONstore.setText("");
		conf_Create.setText("");
		textnameJSONStore.setText("");
	}
	
	@FXML
	public void actualizar(ActionEvent event){
		TreeItem rootitem = new TreeItem("ACTUALIZAR");
		treeView1.setRoot(rootitem);
	
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb){			
		TreeItem baseDatos = new TreeItem("LinkedDB",new ImageView(DBIcon));
		TreeItem DB = new TreeItem("LinkedDB");
		treeView1.setRoot(baseDatos);
		baseDatos.setExpanded(true);
		try {
			archivo = new File("JSONstore.txt");
			leer = new FileReader(archivo);
			almacenamiento=new BufferedReader(leer);
			cadena="";
			
			int num=1;
			while(cadena!=null){
				try {
					cadena=almacenamiento.readLine();
					if (cadena!=null){
						TreeItem treeitem =new TreeItem(cadena,new ImageView(FileIcon));
						baseDatos.getChildren().addAll(treeitem);
						
						ListJSONstores.insertar(cadena);
					}
					
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
			try {
				almacenamiento.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				leer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Lista Cargada del txt.......");
			ListJSONstores.mostrar();
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
}
