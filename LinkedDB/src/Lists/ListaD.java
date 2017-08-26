package Lists;

public class ListaD {
	private NodoListaD inicio;
	private NodoListaD fin;
	// Constructo
	
	public ListaD(){
		inicio=fin=null;	
	}
	//Metodo para saber si la lista esta vacia
	public boolean estaVacia(){
		//return inicio==null;
		if (inicio == null){
			return true;
		}else 
			return false;
	}
	public void insertarFinal(Object dato){
		if (!estaVacia()){
			NodoListaD finSigAnt = fin.getAnterior().getSiguiente(); // VERIFICAR SI FUNCIONA
			fin =new NodoListaD(dato,null,fin);
			finSigAnt=fin;
			}
		else{
			inicio=fin=new NodoListaD(dato);
		}
	}
	//metodo para mostar la lista de inicio a fin
	public void mostrasLista(){
		if(!estaVacia()){
			String enlace="<=>";
			NodoListaD auxiliar=inicio;
			
			while (auxiliar!=null){
				enlace=enlace+"["+auxiliar.getDato()+"]<=>";
				auxiliar=auxiliar.getSiguiente();
			}
			// aqui mandar a mostrar los datos
		}
	}

}

