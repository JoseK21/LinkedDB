package Lists;

public class NodoListaCD {
	
	private String dato;
	private NodoListaCD siguiente,anterior;	
	
	public NodoListaCD(String dato) {
		this(dato,null,null);
			
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaCD(String d,NodoListaCD s,NodoListaCD a){
		dato=d; 
		siguiente=s;
		anterior=a;

	}
	public NodoListaCD() {
		// TODO Auto-generated constructor stub
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
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