package Interface_FX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MsjCreateJsonStoreController implements Initializable{
	
	@FXML private Label MsjCreate;
	@FXML private ImageView Imag1;
	
	Image imgC = new Image(getClass().getResourceAsStream("/img/correcto.png"));
	Image imgInc = new Image(getClass().getResourceAsStream("/img/incorrect.png"));
	Image imgErr = new Image(getClass().getResourceAsStream("/img/error.png"));
	
	public void setText(String name){
		this.MsjCreate.setText(name);
			
	}
	public void setImage1(String msj){
		String c = "correcto";
		String inc = "incorrecto";
		String v = "vacio";
		
		if (msj == c){			
			this.Imag1.setImage(imgC);
			
		}else if(msj == inc){
			this.Imag1.setImage(imgErr);
			
		}else{
			this.Imag1.setImage(imgInc);
			
		}
			
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
