package Lists;

public class NodoLD_JSONstore {
	public int dato;
	NodoLD_JSONstore siguiente;
	NodoLD_JSONstore anterior;
	
	//Constructor para cuando aun ni hay nodos
		public NodoLD_JSONstore(int el){
			this(el,null,null);
	}
	//COnstructor para cuando ya haya nodos
	public NodoLD_JSONstore(int el,NodoLD_JSONstore s,NodoLD_JSONstore a){
		dato=el;
		siguiente=s;
		anterior=a;
	}
	
}

