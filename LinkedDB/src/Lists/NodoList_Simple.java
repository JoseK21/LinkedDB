package Lists;

public class NodoList_Simple {
	public int data;
	public NodoList_Simple next; //Puntero de enlace
	
	// Constructor para insertar al final
	public NodoList_Simple(int d) {
		this.data = d;	
	}
	
	public NodoList_Simple(int d, NodoList_Simple n) {
		data=d;
		next=n;
	}
}
