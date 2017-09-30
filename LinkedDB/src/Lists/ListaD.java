package Lists;

/**
 * Clase de listas doblemente enlazadas, que permite el almacenamiento temporal de los Json Stores
 * @author José C.Núñez 
 *
 */
public class ListaD {
	private NodoListaD inicio;
	private NodoListaD fin;

	private int sizeD = 0;
	private String selected_item;
	private String parent_item;
	private static  ListaD uniqueInstance  =   null;
	ListaCD ListCD = new ListaCD();
	
	
	/**
	 * Constructor de la lista doblemente enlazada
	 */
	public ListaD(){
		inicio=fin=null;	
	}
				
	
	
	public String getParent_item() {
		return parent_item;
	}
	public void setParent_item(String parent_item) {
		this.parent_item = parent_item;
	}

	public String getSelected_item() {
		return selected_item;
	}

	public void setSelected_item(String selected_item) {
		this.selected_item = selected_item;
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
		return sizeD;
	}
	
	/**
	 * Metodo para Asignar un nuevo tamaño de la lista
	 * @param size
	 */
	public void setSize(int size) {
		this.sizeD = size;
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
        sizeD++;
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
		return false;	}	
	/**
	 * Método para obtener el primer nodo de todo la lista doble
	 * @return
	 */
	public NodoListaD getFirstNodeD(){
		NodoListaD temporal = inicio;
		return temporal;
	}
	
	public NodoListaD getLastNodeD(){
		NodoListaD temporal = fin;
		return temporal;
	}
	
	public void removeNodoD(String d){
		System.out.println("-------}}---------}}--------}}- "+d);
		NodoListaD inicial = uniqueInstance.getFirstNodeD();		
		NodoListaD atras = null;
		String valueInicial = inicial.getDato();
		
		if(valueInicial.equals(d)){
			System.out.println("CASO 1. AL INICIO.......................................");
			inicio = inicio.getSiguiente();
			inicio.setAnterior(null);
		}
		else{		
			uniqueInstance.imprimirListaD();
			while(inicial != null){
				System.out.println("\n-<<<<<< Dentro del WHILE");
				String valueInicial1 = inicial.getDato();
				System.out.println("Valor -actual:"+inicial.getDato());
	
				if(valueInicial1.equals(d)){
					System.out.println("Valor del actual -->  "+valueInicial1);
					if(inicial == inicio){
						inicio = inicio.getSiguiente();
						inicio.setAnterior(null);
					}else{
						System.out.println("ELSE...... :( ");
						atras.setSiguiente(inicial.getSiguiente());
						inicial.getSiguiente().setAnterior(inicial.getAnterior());
					}
				}
				atras = inicial;
				inicial = inicial.getSiguiente();
			}
			System.out.println("Lista Vacia.");
		}
		System.out.println("Fin");
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
		   
	