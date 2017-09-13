package Lists;

public class NodoListaD {
	private String dato;
	private NodoListaD siguiente,anterior;
	
	
	private ListaCD listacd = new ListaCD();
	
	
	//Constructor para cuando aun ni hay nodos
	public NodoListaD(String nombreNodo) {
		this(nombreNodo,null,null);
	}
	//COnstructor para cuando ya haya nodos
	
	public NodoListaD(String lista,NodoListaD s,NodoListaD a){
		dato=lista; 
		siguiente=s;
		anterior=a;
		//listacd= L;   																				 //LISTA VACIAAAAA .?????
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
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
	
	
	public ListaCD getListacd() {
		return listacd;
	}
	public void setListacd(ListaCD listacd) {
		this.listacd = listacd;
	}
	
	
}