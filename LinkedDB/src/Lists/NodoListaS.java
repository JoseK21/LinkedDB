package Lists;

public class NodoListaS {
	private String dato;
	private NodoListaS siguiente;
	private NodoListaCD listasimp;	
	
	//private ListaS listasimp = new ListaS();
	
	public NodoListaS(String date) {
		this.siguiente=null;
		this.dato=date;
	}
	
	public String getDato() {
		return this.dato;
	}
	// TIENE QUE RECIBIR EL NODO PARA BUSCAR DENTRO DE EL LA LISTA Y HAY AGREGARLE EL NODO......................................
	
	public ListaS getListaS(NodoListaCD node) {
		if (node.getListaS() == null) {
			System.out.println("Lista Vacia");
			System.out.println("\n-Lista Nueva agregada ");
			return null;
			//return listasimp =new ListaS();
			
		}else{
			//System.out.println("Lista existente enviada ");
			return node.getListaS();
			}
	}
	
	public void setListaS(NodoListaCD listasimple) {
		this.listasimp = listasimple;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	
	public NodoListaS getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoListaS siguiente) {
		this.siguiente = siguiente;
	}
	

		
}
