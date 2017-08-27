package Lists;

public class NodoListaD {
	private Object dato;
	private NodoListaD siguiente,anterior;	
	//Constructor para cuando aun ni hay nodos
	public NodoListaD(Object dato) {
		this(dato,null,null);
			
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaD(Object d,NodoListaD s,NodoListaD a){ // talvez cambiar Object dato ---- Object d
		dato=d; 
		siguiente=s;
		anterior=a;
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