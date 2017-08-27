package Lists;

public class NodoListaCD {
	
	private Object dato;
	private NodoListaCD siguiente,anterior;	
	
	public NodoListaCD(Object dato) {
		this(dato,null,null);
			
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaCD(Object d,NodoListaCD s,NodoListaCD a){
		dato=d; 
		siguiente=s;
		anterior=a;

	}
	public NodoListaCD() {
		// TODO Auto-generated constructor stub
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public NodoListaCD getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoListaCD siguiente) {
		this.siguiente = siguiente;
	}
	public NodoListaCD getAnterior() {
		return anterior;
	}
	public void setAnterior(NodoListaCD anterior) {
		this.anterior = anterior;
	}
	
	
}