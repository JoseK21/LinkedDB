package Lists;

public class NodoListaD extends Nodo {
	public int dato;
	NodoListaD siguiente;
	NodoListaD anterior;
	
	//Constructor para cuando aun ni hay nodos
		public NodoListaD(int el){
			this(el,null,null);
	}
	//COnstructor para cuando ya haya nodos
	public NodoListaD(int el,NodoListaD s,NodoListaD a){
		dato=el;
		siguiente=s;
		anterior=a;
	}
	
}

