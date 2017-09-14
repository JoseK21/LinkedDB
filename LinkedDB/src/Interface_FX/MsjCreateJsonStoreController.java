package Interface_FX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class MsjCreateJsonStoreController implements Initializable{
	
	@FXML private Label MsjCreate;
	
	
	public void setText(String name){
		this.MsjCreate.setText(name);
			
	}
	
	@FXML
	public void accept(ActionEvent event){
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se cierra la ventana cuando regreso");
		}
		
			}
	@Override
	public void initialize(URL url, ResourceBundle rb){		 
		
	}
}
