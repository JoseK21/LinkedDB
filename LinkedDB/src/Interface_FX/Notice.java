package Interface_FX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase que permite la creación de mensajes informativos hacia el Usuario
 * @author José C.Núñez 
 *
 */
public class Notice implements Initializable{
	
	
	
	@FXML private Label MsjCreate;
	@FXML private ImageView Imag1;
	

	
	Image imgC = new Image(getClass().getResourceAsStream("/img/correcto.png"));
	Image imgInc = new Image(getClass().getResourceAsStream("/img/incorrect.png"));
	Image imgErr = new Image(getClass().getResourceAsStream("/img/error.png"));
	Image imgDel = new Image(getClass().getResourceAsStream("/img/delete.png"));
	
	
	
	/**
	 * Método para asignar un texto(renglón) al mensaje informativo
	 * @param name
	 */
	public void setText(String name){
		this.MsjCreate.setText(name);
			
	}
	
	
	/**
	 *  Método para asignar una imagen al mensaje informativo
	 * @param msj
	 */
	public void setImage1(String msj){
		String c = "correcto";
		String inc = "incorrecto";
		String v = "vacio";
		String d = "del";
		
		if (msj == c){			
			this.Imag1.setImage(imgC);
			
		}else if(msj == inc){
			this.Imag1.setImage(imgErr);
			
		}else if(msj == d){
			this.Imag1.setImage(imgDel);
			
		}else{
			this.Imag1.setImage(imgInc);
			
		}
			
	}
	
	/**
	 * Método para proseguir en el sistema-pantalla inicial-
	 * @param event
	 */
	@FXML
	public void accept(ActionEvent event){
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("InterfaceLinkedDB.fxml"));
			Interface displayCommit = fxmlLoader1.getController();
			//displayCommit.
						
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se cierra la ventana cuando regreso");
		}
		
			}
	@Override
	public void initialize(URL url, ResourceBundle rb){		 
		
	}
}
