package Lists;

public class List_Double {
	private NodoList_Double inicio,fin;
	
	public List_Double(){
		inicio=fin=null;	
	}
	//Metodo para saber si la lista esta vacia
	public boolean estaVacia(){
		return inicio==null;
	}
	//metodo para agregar nodos al inicio
	public void agregarAlInicio(int el){
		if (!estaVacia()){
			inicio=new NodoList_Double(el,inicio,null);
			inicio.siguiente.anterior=inicio;
		}
		else{
			inicio=fin=new NodoList_Double(el);
		}
	}
	//metodo para mostar la lista de inicio a fin
	public void mostrasLista(){
		if(!estaVacia()){
			String datos="<=>";
			NodoList_Double auxiliar=inicio;
			
			while (auxiliar!=null){
				datos=datos+"["+auxiliar.dato+"]<=>";
				auxiliar=auxiliar.siguiente;
			}
		}
	}

}

