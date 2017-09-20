package Lists;

public class NodoListaD {
	private String dato;
	
	private NodoListaD siguiente,anterior;		
	private ListaCD listacd = new ListaCD();
	
	public NodoListaD(String nombreNodo,ListaCD LISTACD) {
		this(nombreNodo,null,null,null);
	}	
	public NodoListaD(String lista,NodoListaD s,NodoListaD a,ListaCD LCD){
		dato=lista; 
		siguiente=s;
		anterior=a;
		listacd= LCD;   																				 //LISTA VACIAAAAA .?????
	}

	public ListaCD getListacd() {
		if (listacd == null) {
			return listacd =new ListaCD();
			
		}else{
			return listacd;
			}
	}
	
	public void setListacd(ListaCD listacd) {
		this.listacd = listacd;
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
	
	
	
}