package Lists;

public class ListaS {
	//Punteros para saber donde esta el inicio y el final
	private NodoListaS inicio ;
	private NodoListaS fin;
	private int size = 0;
	
	
	
	public ListaS(){
		// inicializo los punteros
		inicio =null;
		fin=null;
		System.out.println("\nTamaño de la lista Simple: "+size);
	}
	// Metodo para preguntar si esta vacia la lista de JSON store
	public boolean estaVacia(){
		if (inicio == null){
			return true;
		}else 
			return false;
	}
	//Metodo para insertar JSON store
	public void insertarFinal(Object dato){
		NodoListaS nuevo = new NodoListaS(dato);
		size++;
		if (estaVacia()){
			inicio=nuevo;
			}
		else{
			NodoListaS auxiliar = inicio;
			while(auxiliar.getSiguiente() != null){
				auxiliar = auxiliar.getSiguiente();
			}
			auxiliar.setSiguiente(nuevo);
			}
		System.out.println("\nTamaño de la lista Simple: "+size);
	}

	//Metodo para ver los nombres de los JSON store
	public void mostrarLista(){
		NodoListaS recorrer = inicio;
		System.out.print("INICIO>");
		while (recorrer!=null){
			Object dee = recorrer.getDato();	
			System.out.print("["+dee+"]->");
			recorrer=recorrer.getSiguiente();	
			} 
		System.out.print("| <-fin");
		
	}
	
	
	public void delete(Object value) {
	    if (inicio != null) {
	        NodoListaS walker = inicio;
	        if (walker.getDato() == value) {
	            if(walker.getSiguiente()!=null){
	            	System.out.println("NODO ELIMINADO"+value);
	                inicio = walker.getSiguiente();
	            }else{
	                setFirstNode(null);
	            }
	        } else {
	        	NodoListaS previous = walker;
	            while (walker.getSiguiente() != null) {
	                previous = walker;
	                //System.out.println("NODO ELIMINADO"+value);
	                walker = walker.getSiguiente();
	                if (walker.getDato() == value) {
	                	System.out.println("NODO ELIMINADO"+value);
	                	size--;
	                	System.out.println("\nTamaño de la lista Simple: "+size);
	                    previous.setSiguiente(walker.getSiguiente());
	                    break;
	                }
	            }
	            System.out.println("Nothing to delete");
	        }

	    } 
	    }
	    public void setFirstNode(NodoListaS inicio) {
	        this.inicio = inicio;
	    }
	//metodo para buscar un elemento
	public void buscar(Object dato){
		NodoListaS temporal = inicio;
		
		while (temporal!=null && temporal.getDato()!=dato){			
			temporal=temporal.getSiguiente();								// enviar la informacion..... Nombre y sus datos
		}
		if(temporal!=null){
			System.out.println("SI EXISTE EL ELEMENTO {"+dato+"}");
		}else{
			System.out.println("NO EXIST {"+dato+"}");

		}
	}
	public static void main(String[] args){
		ListaS list = new ListaS();
		list.insertarFinal(1);
		list.insertarFinal(2);
		list.insertarFinal(3);
		list.insertarFinal(4);
		list.insertarFinal(5); // PORQUE NO CON NUMEROS DE 4 DIGITOS
		list.insertarFinal(6);
		list.insertarFinal(7);
		list.insertarFinal(8);
		list.insertarFinal(9);
		list.insertarFinal(10);
		list.insertarFinal(12);
		list.insertarFinal(13);
		list.insertarFinal(14);
		list.insertarFinal(15); 
		//list.eliminarNodo(1);
		//list.eliminarNodo(4);
		//list.delete(1);
		//list.delete(4);
		//list.delete(16);
		
		list.buscar(225);
		list.mostrarLista();
		
	}
}
