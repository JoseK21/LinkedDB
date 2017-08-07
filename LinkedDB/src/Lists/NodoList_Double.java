package Lists;

public class NodoList_Double {
	public int dato;
	NodoList_Double siguiente;
	NodoList_Double anterior;
	
	//Constructor para cuando aun ni hay nodos
		public NodoList_Double(int el){
			this(el,null,null);
	}
	//COnstructor para cuando ya haya nodos
	public NodoList_Double(int el,NodoList_Double s,NodoList_Double a){
		dato=el;
		siguiente=s;
		anterior=a;
	}
	
}

