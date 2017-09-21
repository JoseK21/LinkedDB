package Lists;

/**
 * Clase de listas doblemente enlazadas, que permite el almacenamiento temporal de los Json Stores
 * @author José C.Núñez 
 *
 */
public class ListaD {
	private NodoListaD inicio;
	private NodoListaD fin;
	ListaCD ListCD = new ListaCD();
	private int size = 0;	
	
    private static  ListaD uniqueInstance  =   null;

	
	
	/**
	 * Constructor de la lista doblemente enlazada
	 */
	public ListaD(){
		inicio=fin=null;	
	}
											
	/**
	 * Metodo para obtener una respuesta si la lista doblemente enlazada esta vacia
	 * @return
	 */
	public boolean estaListaDVacia(){
		return inicio==null;
	}
	
	/**
	 * Método para borrar todo la lista doble
	 * @return
	 */
	public ListaD limpiar(){
		this.uniqueInstance=null;
		ListaD uniqueInstance  =   null;
		return uniqueInstance;
	}
	
	/**
	 * Método para obtener un nodo de la lista doble
	 * @param nodoName
	 * @return
	 */
	public NodoListaD getNodoD(String nodoName){
		NodoListaD aux = inicio;
		while (aux != null){
			if(aux.getDato().equals(nodoName)){
				return aux;
			}
			else{
				aux=aux.getSiguiente();
			}
		}return null;	
		
	}
	/**
	 * Método para obtener el largo de la lista doble
	 * @return
	 */
	public int getSize(){
		NodoListaD temp = inicio;
		while (temp != null){
			size++;
		}
		return size;
	}
	
	/**
	 * Método para agregar un nodo a la lista doble
	 * @param nombre
	 */
	public void agregarNodoD(String nombre){	
		
        NodoListaD nuevo = new NodoListaD(nombre,ListCD);    // ListaCD listaCD ====> quitar pues ya aqui la puedo iniciar en null=vacia la listaCD
        if(inicio == null){
        	inicio = nuevo;
        }else{
	        NodoListaD aux = inicio;
	        while(aux.getSiguiente() != null){
	        	aux = aux.getSiguiente();       
		    }
	        aux.setSiguiente(nuevo);
	        nuevo.setAnterior(aux);
        }        
        }
	
	/**
	 * Método para mostrar la lista doble
	 */
	public void imprimirListaD() {
	      if (estaListaDVacia() == true ) {
	         System.out.println("Lista Vacía");
	       
	      }
	      else{
		      NodoListaD temp = inicio;
		      System.out.print("Inicio->");
		      while(temp != null){
		    	  System.out.print("["+ temp.getDato() +"]->");	
		    	  temp = temp.getSiguiente();
		      }
		      System.out.print("Fin-||");
		   }
	   }
	
	/**
	 * Método para buscar dentro de la lista doble un elemento
	 * @param dato
	 * @return
	 */
	public boolean buscarNodoD(String dato){
		
		NodoListaD temporal = inicio;
		
		while (temporal!=null){
			if (temporal.getDato().equals(dato)){
				return true;
			}else{
				temporal=temporal.getSiguiente();
			}
		}
		return false;
		
	
	}	
	/**
	 * Método para obtener el primer nodo de todo la lista doble
	 * @return
	 */
	public NodoListaD getFirstNodeD(){
		NodoListaD temporal = inicio;
		return temporal;
	}
	/**
	 * Método para elimiar un noodo de la lista doble
	 * @param dato
	 */
	public void eliminarNodoD(String dato){
		  
		  if(estaListaDVacia()){
			  System.out.println("Lista vacia");
		  }
		  else{ 
			  if(fin == inicio){
				  if(dato == inicio.getDato()){
					  fin = null;
					  inicio=null;
					  System.out.println("Se elimino /"+dato+"/");
				  }else{
					  System.out.println("Error");
				  }
			  }
			  else if(dato == inicio.getDato()){
				  System.out.println("elemento al inicio--------------");			  
				  inicio = inicio.getSiguiente();
				  inicio.setAnterior(inicio.getAnterior());
				  inicio.setAnterior(null);
				  System.out.println("Se elimino /"+dato+"/");
			  }
			  else{  
				  System.out.println("elemento despues del inicio");
				  NodoListaD temporal, anterior, siguiente;	
				  temporal = inicio;   
				  siguiente = inicio;
				  anterior = inicio;
				   
				  while(siguiente !=  null && siguiente.getDato() != dato){  
					  System.out.println("1.............. while .........");
					  temporal = temporal.getSiguiente();		    
					  siguiente = siguiente.getSiguiente();		    
					  anterior = anterior.getSiguiente();
				  }
				  if(siguiente != null && siguiente != fin){
					  System.out.println("2____________________ if _______");
					  System.out.println("Se elimino /"+siguiente.getDato()+"/");
					  siguiente.getSiguiente().setAnterior(temporal.getAnterior());
					  anterior.getAnterior().setSiguiente(temporal.getSiguiente());
					  }
				  else{ 
					  if(siguiente == fin){
						  System.out.println("Se elimino -------------------/"+siguiente.getDato()+"/");

						  System.out.println("2__________140__________ else _______");

						  System.out.println("elemento ULTIMO de la lista/");
						  fin = fin.getAnterior();
						  fin.setSiguiente(null);
					  }else{
						  System.out.println("No Existe_/ No se puede eliminar_!");
					  }
			  }}
		  }
	}

	/**
	 * Método para obtener una unica instancia 
	 * @return
	 */
	public static ListaD getInstance(){
        if(uniqueInstance == null){
              uniqueInstance = new ListaD();
        }
        return uniqueInstance;
    }
	

}
		   
	