package Lists;

public class NodoListaCD {	
	private String dato;
	private NodoListaCD siguiente,anterior;	
	
	private ListaS listaSimple = new ListaS();
	
	public NodoListaCD(String dato,ListaS LISTAS) {
		this(dato,null,null,null);			
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaCD(String d,NodoListaCD s,NodoListaCD a,ListaS LS){
		dato=d; 
		siguiente=s;
		anterior=a;
		listaSimple=LS;

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

	public ListaS getListaS() {
		return listaSimple;
	}
	public void setListaS(ListaS listaS) {
		this.listaSimple = listaS;
		
	}	
}