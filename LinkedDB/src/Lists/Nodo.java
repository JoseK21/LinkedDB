package Lists;

public class Nodo {
	private Object dato;
	private Nodo siguiente; //Puntero de enlace
	
	public Nodo(Object dato){
		this.siguiente=null;
		this.dato=dato;
	}

	public Object getDato() {
		return this.dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return this.siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	
	
}



