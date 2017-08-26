package Lists;

public class Lista_BaseDatos{
	public Nodo inicio;
	public Nodo fin;
	
	public Lista_BaseDatos(){
		inicio =null;
		fin=null;
	}
	
	public boolean lista_vacio(){
		if (inicio == null){
			return true;
		}else{ 
			return false;
			}
	}
	public void insertar(Nodo elemento){
		if (!lista_vacio()){
			inicio=elemento;
		}
		else{
			if (inicio.getSiguiente()==null){
				inicio=new NodoListaCD(elemento);
			}else{
				Nodo temporal;
				while(true){
					temporal=inicio.getSiguiente();
					if (temporal == null){
						temporal=elemento;
					}else{
						temporal=temporal.getSiguiente();
					}
				}
			}
			
		}
	
	}public void eliminar(Nodo elemento){
		
		if (elemento.getSiguiente()==null){
			
		}
	}
	


}// fin
