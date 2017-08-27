package Interface_FX;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Lists.ListaD;
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

public class InterfaceMainController implements Initializable {

	@FXML private Label msjCrearJSONstore;
	@FXML private Label conf_Create;	
	@FXML private TextField textnameJSONStore;
	@FXML TreeView <String> treeView1;	
	Image img1 = new Image(getClass().getResourceAsStream("/img/img2.png"));
	Image img2 = new Image(getClass().getResourceAsStream("/img/img3.png"));

	
	
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
			System.out.println("Can´t load new window");
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
			TreeItem<String> item = treeView1.getSelectionModel().getSelectedItem();
			System.out.println(item.getValue());
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
	ListaD JSONstores =new ListaD();
	
		
	@FXML
	public void crearCarpeta(ActionEvent event){		
		String NameFile = textnameJSONStore.getText() ;	
		System.out.println("Nombre de la carpeta: " + NameFile);
		String archivo = "\\"+ NameFile +".txt";
		
		JSONstores.insertAtEnd(NameFile);
		JSONstores.mostrarListaD();
		TreeItem<String> roottree = new TreeItem<>(NameFile,new ImageView(img1));
		TreeItem<String> nodeA = new TreeItem<>("Doc_JSON 1",new ImageView(img2));
		TreeItem<String> nodeB = new TreeItem<>("Doc_JSON 2",new ImageView(img2));

		roottree.getChildren().addAll(nodeA,nodeB);
		
		treeView1.setRoot(roottree);
		if (!NameFile.isEmpty()) {					
			String ruta = "C:\\Users\\kenne\\Desktop\\Proy_LinkedDB\\"+ NameFile; // Se crea la carpeta con el nombre correspondiente
			
			File crea_carpeta = new File(ruta);		
			File crea_archivo = new File(ruta+archivo);
			
							
			if(crea_archivo.exists()){
				msjCrearJSONstore.setText("----Carpeta Existente---- \nIngrese otro nombre PorFavor");
			}
			else{
				msjCrearJSONstore.setText(" El proceso de creación de su carpeta ha sido Exitoso");
				crea_carpeta.mkdirs(); // Crear carpeta
				
				try{
					if (crea_archivo.createNewFile()){
						conf_Create.setText("Carpeta Creada");
					}else{
						conf_Create.setText("Carpeta NO Creada");	
					}
				}catch (IOException ex){
					Logger.getLogger(New_JSONStoreController.class.getName()).log(Level.SEVERE, null, ex);
				}
		}
	}else{
		msjCrearJSONstore.setText("----<SIN NOMBRE>--- /nIngrese un nombre por favor");
	}
	}
	@FXML
	public void nuevo(ActionEvent event){
		msjCrearJSONstore.setText("");
		conf_Create.setText("");
		textnameJSONStore.setText("");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb){		
		//roottree.setExpanded(true);     Abre de una vez la carpeta
		//TreeItem<String> nodeA = new TreeItem<>("Doc_JSON 1",new ImageView(img2));
		
		
	}
}
