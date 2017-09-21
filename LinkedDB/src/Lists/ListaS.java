package Lists;

/**
 * Clase de listas simplemntes enlazadas, que permite el almacenamiento temporal de los Objetos Json
 * @author Jos� C.N��ez 
 *
 */
public class ListaS {
	private NodoListaS inicio ;
	private int size = 0;
	
	/**
	 * Constructor de la lista simplemente enlazada
	 */
	public ListaS(){
		inicio=null;
	}
	
	/**
	 *  M�todo para saber si la lista simple esta vacia
	 * @return
	 */
	public boolean estaListaSVacia(){
		return inicio==null;
	}
	/**
	 * M�todo para obtener el primer nodo de la lista simple
	 * @return
	 */
	public NodoListaS getFirstNodeS(){
		NodoListaS temp = inicio;
		return temp;
	}
	
	/**
	 * M�todo para agrenar un nodo a la lista simple
	 * @param nombre
	 */
	public void agregarNodoS(String nombre){	
        NodoListaS nuevotemp = new NodoListaS(nombre);    // ListaCD listaCD ====> quitar pues ya aqui la puedo iniciar en null=vacia la listaCD
        if(inicio == null){
        	inicio = nuevotemp;
        }else{
	        NodoListaS aux = inicio;
	        while(aux.getSiguiente() != null){
	        	aux = aux.getSiguiente();       
		    }
	        aux.setSiguiente(nuevotemp);
        }
        
        //System.out.println("Objeto Agregado : "+nuevotemp.getDato()); 
        }

	
	/**
	 * M�todo para mostrar la lista simple
	 */
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
	/**
	 * M�todo para eliminar un nodo la lista simple
	 * @param dato
	 */
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
	                	System.out.println("\nTama�o de la lista Simple: "+size);
	                    previous.setSiguiente(temporal.getSiguiente());
	                    break;
	                }
	            }
	            System.out.println("Nothing to delete");
	        }
	    } 
	    }
	   
	/**
	 * M�todo para seleccionar el primer nodo de la lista simple
	 * @param inicio
	 */
	public void setFirstNode(NodoListaS inicio) {
	        this.inicio = inicio;  }  
	
	/**
	 * M�todo para buscar un elemento dentro de la lista simple
	 * @param dato
	 * @return
	 */
	public boolean buscar(Object dato){
		NodoListaS temporal = inicio;
		
		while (temporal!=null && temporal.getDato()!=dato){			
			temporal=temporal.getSiguiente();								// enviar la informacion..... Nombre y sus datos
		}
		if(temporal!=null){			
			System.out.println("SI EXISTE EL ELEMENTO {"+dato+"}");
			return true;
		}else{			
			System.out.println("NO EXIST {"+dato+"}");
			return false;

		}
	}
}
