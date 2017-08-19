package Lists;

public class LD_JSONstore {
	private NodoLD_JSONstore inicio,fin;
	
	public LD_JSONstore(){
		inicio=fin=null;	
	}
	//Metodo para saber si la lista esta vacia
	public boolean estaVacia(){
		return inicio==null;
	}
	//metodo para agregar nodos al inicio
	public void agregarAlInicio(int el){
		if (!estaVacia()){
			inicio=new NodoLD_JSONstore(el,inicio,null);
			inicio.siguiente.anterior=inicio;
		}
		else{
			inicio=fin=new NodoLD_JSONstore(el);
		}
	}
	//metodo para mostar la lista de inicio a fin
	public void mostrasLista(){
		if(!estaVacia()){
			String datos="<=>";
			NodoLD_JSONstore auxiliar=inicio;
			
			while (auxiliar!=null){
				datos=datos+"["+auxiliar.dato+"]<=>";
				auxiliar=auxiliar.siguiente;
			}
		}
	}

}

