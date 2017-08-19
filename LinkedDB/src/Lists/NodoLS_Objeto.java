package Lists;

public class NodoLS_Objeto {
	public int data;
	public NodoLS_Objeto next; //Puntero de enlace
	
	// COnstructor 
	public NodoLS_Objeto(int d, NodoLS_Objeto n) {
		data=d;
		next=n;
	}
}
