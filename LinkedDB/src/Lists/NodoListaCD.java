package Lists;

public class NodoListaCD {
	
	private String dato;
	private NodoListaCD siguiente,anterior;	
	
	private ListaS listaSimple = new ListaS();
	
	public NodoListaCD(String dato) {
		this(dato,null,null);
			
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaCD(String d,NodoListaCD s,NodoListaCD a){
		dato=d; 
		siguiente=s;
		anterior=a;

	}
	public ListaS getListaS() {
		return listaSimple;
	}
	public void setListaS(ListaS listaS) {
		this.listaSimple = listaS;
		
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
	
	public ListaS getListas() {
		return listaSimple;
	}
	public void setListacs(ListaS listas) {
		this.listaSimple = listas;
	}
	
}