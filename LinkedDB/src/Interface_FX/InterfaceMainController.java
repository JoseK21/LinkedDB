package Interface_FX;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InterfaceMainController implements Initializable {
	
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
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		TreeItem<String> roottree = new TreeItem<>("JSON Store 1",new ImageView(img1));
		//roottree.setExpanded(true);     Abre de una vez la carpeta
		TreeItem<String> nodeA = new TreeItem<>("Doc_JSON 1",new ImageView(img2));
		TreeItem<String> nodeB = new TreeItem<>("Doc_JSON 2",new ImageView(img2));
		TreeItem<String> nodeC = new TreeItem<>("Doc_JSON 3",new ImageView(img2));
		TreeItem<String> nodeD = new TreeItem<>("Doc_JSON 4",new ImageView(img2));
		
		roottree.getChildren().addAll(nodeA,nodeB,nodeC,nodeD);
		
		treeView1.setRoot(roottree);
		
	}
}
