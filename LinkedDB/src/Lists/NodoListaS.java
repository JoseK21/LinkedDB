package Lists;

public class NodoListaS {
	private String dato;
	private NodoListaS siguiente = null ;
	
	
	public NodoListaS(String date) {
		this.siguiente=null;
		this.dato=date;
	}
	
	public String getDato() {
		return this.dato;
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
