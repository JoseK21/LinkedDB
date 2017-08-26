package Lists;

public class ListaD {
	private NodoListaD inicio,fin;
	
	public ListaD(){
		inicio=fin=null;	
	}
	//Metodo para saber si la lista esta vacia
	public boolean estaVacia(){
		return inicio==null;
	}
	//metodo para agregar nodos al inicio
	public void agregarAlInicio(int el){
		if (!estaVacia()){
			inicio=new NodoListaD(el,inicio,null);
			inicio.siguiente.anterior=inicio;
		}
		else{
			inicio=fin=new NodoListaD(el);
		}
	}
	//metodo para mostar la lista de inicio a fin
	public void mostrasLista(){
		if(!estaVacia()){
			String datos="<=>";
			NodoListaD auxiliar=inicio;
			
			while (auxiliar!=null){
				datos=datos+"["+auxiliar.dato+"]<=>";
				auxiliar=auxiliar.siguiente;
			}
		}
	}

}

