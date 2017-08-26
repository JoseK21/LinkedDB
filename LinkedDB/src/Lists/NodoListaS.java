package Lists;

public class NodoListaS {
	private Object dato;
	private NodoListaS siguiente;	
		
	public NodoListaS(Object dato) {
		this.siguiente=null;
		this.dato=dato;
	}
	public Object getDato() {
		return this.dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}
	
	
	public NodoListaS getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoListaS siguiente) {
		this.siguiente = siguiente;
	}
	

		
}
