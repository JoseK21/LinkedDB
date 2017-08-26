package Lists;

public class NodoListaD {
	private Object dato;
	private NodoListaD siguiente;	
	private NodoListaD anterior;	
	
	//Constructor para cuando aun ni hay nodos
	public NodoListaD(Object dato) {
		this(dato,null,null);
		
		//this.dato=dato;
		//this.siguiente=null;
		//this.anterior=null;
		
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaD(Object dato,NodoListaD siguiente,NodoListaD anterior){ // talvez cambiar Object dato ---- Object d
		dato=dato; 
		siguiente=siguiente;
		anterior=anterior;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public NodoListaD getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoListaD siguiente) {
		this.siguiente = siguiente;
	}
	public NodoListaD getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoListaD anterior) {
		this.anterior = anterior;
	}
	
}