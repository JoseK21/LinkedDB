package Lists;

public class ListaS {
	//Punteros para saber donde esta el inicio y el final
	private NodoListaS inicio ;
	private NodoListaS fin;
	private int size = 0;
	
	private static  ListaS uniqueInstance  =   null;
	
	public ListaS(){
		// inicializo los punteros
		inicio =null;
		fin=null;
	}
	// Metodo para preguntar si esta vacia la lista de JSON store
	public boolean estaVacia(){
		if (inicio == null){
			return true;
		}else 
			return false;
	}
	//Metodo para insertar JSON store
	public void insertar(Object dato){
		NodoListaS nuevo = new NodoListaS(dato);
		
		if (estaVacia()){
			inicio=nuevo;
			size++;
			}
		else{
			NodoListaS auxiliar = inicio;
			while(auxiliar.getSiguiente() != null){
				auxiliar = auxiliar.getSiguiente();
			}
			auxiliar.setSiguiente(nuevo);
			size++;
			
			}
		System.out.println("\nTamaño de la lista Simple: "+size);
		
		
		
	}

	//Metodo para ver los nombres de los JSON store
	public void mostrar(){
		NodoListaS temporal = inicio;
		System.out.print("INICIO>");
		while (temporal!=null){
			Object dee = temporal.getDato();	
			System.out.print("["+dee+"]->");
			temporal=temporal.getSiguiente();	
			} 
		System.out.print("| <-fin");
		
	}
	public void eliminar(Object dato) {
	    if (inicio != null) {
	        NodoListaS temporal = inicio;
	        if (temporal.getDato() == dato) {
	            if(temporal.getSiguiente()!=null){
	            	System.out.println("NODO ELIMINADO"+dato);
	                inicio = temporal.getSiguiente();
	            }else{
	                setFirstNode(null);
	            }
	        } else {
	        	NodoListaS previous = temporal;
	            while (temporal.getSiguiente() != null) {
	                previous = temporal;
	                //System.out.println("NODO ELIMINADO"+value);
	                temporal = temporal.getSiguiente();
	                if (temporal.getDato() == dato) {
	                	System.out.println("NODO ELIMINADO : "+dato);
	                	size--;
	                	System.out.println("\nTamaño de la lista Simple: "+size);
	                    previous.setSiguiente(temporal.getSiguiente());
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
	
	public static ListaS getInstance(){
        if(uniqueInstance == null){
              uniqueInstance = new ListaS();
        }
        return uniqueInstance;
    }
	
	public static void main(String[] args){
		
		ListaS listaS = new ListaS();
		
		listaS.insertar(2);
		listaS.mostrar();
		listaS.insertar(177);
		listaS.insertar(24);
		listaS.mostrar();
		listaS.eliminar(22);
		listaS.mostrar();
	}
}
