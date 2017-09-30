package Lists;

/**
 * Clase de listas circulares doblemente enlazadas, que permite el almacenamiento temporal de los Documentos Json
 * @author José C.Núñez 
 *
 */
public class ListaCD {
	private NodoListaCD inicio = null;;
	private NodoListaCD fin = null;
	private int sizeCD = 0;
	
	public int getSizeCD() {
		return sizeCD;
	}
	public void setSizeCD(int sizeCD) {
		this.sizeCD = sizeCD;
	}

	ListaS listSim = new ListaS();
	
	/**
	 * Constructor de la lista circular doble 
	 */
	public ListaCD() {
		inicio=fin=null;
	}
	/**
	 * Método para saber si la lista circular doble esta vacia
	 * @return
	 */
	public boolean estaListaCDVacia(){
		return inicio==null;
	}
	
	/**
	 * Método para obtener un nodo de la lista circular doble
	 * @param nodoName
	 * @return
	 */
	public NodoListaCD getNodoCD(String nodoName){
		NodoListaCD aux = inicio;
		
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
	 * Método para agregar un nodo a lista circular doble
	 * @param nombreDoc
	 */
	public void agregarNodoCD(String nombreDoc){
				
        NodoListaCD nuevo = new NodoListaCD(nombreDoc,listSim);      
        
        if (inicio == null){
        	nuevo.setSiguiente(nuevo);
        	nuevo.setAnterior(nuevo);
        	inicio=nuevo;
        	fin=inicio;
        }else {
        	nuevo.setAnterior(fin);
        	fin.setSiguiente(nuevo);
        	inicio.setAnterior(nuevo);
        	nuevo.setSiguiente(inicio);
        	fin=nuevo;  
        }
        sizeCD++;
    }
	
	/**
	 * Método para obtener el primer nodo de la lista circular doble
	 * @return
	 */
	public NodoListaCD getFirstNodeCD(){
		NodoListaCD temporal = inicio;
		return temporal;
	}
	
	public NodoListaCD getLastNodeCD(){
		NodoListaCD temporalfin = fin;
		return temporalfin;
	}
	
	/**
	 * Método para mostrar la lista circular doble
	 */
	public void imprimirListaCD() { // pasarle el nombre de la lista a imprimir
	      if (estaListaCDVacia()==true) {
	         System.out.println("Lista Vacía");	       
	      }
	      else{
		      NodoListaCD temp = inicio;
		      System.out.print("ListaCircularDoble ~>");
		      
		      while (temp.getSiguiente()!=inicio){
		    	  System.out.print("("+ temp.getDato() +")~");
			       temp = temp.getSiguiente();
		      }
		      System.out.print("("+ temp.getDato() +")~");
		      System.out.print("<<fin/inicio>>.");
	      }
	   }
		
	/**
	 * Método para eliminar un nodo especifico de la lista circular doble
	 * @param dato
	 */
	public void eliminarNodoCD(String dato){
		NodoListaCD actual = inicio;
		NodoListaCD anterior = fin;
		do{
			if (actual.getDato()==dato){
				if(actual == inicio){
					inicio=inicio.getSiguiente();
					fin.setSiguiente(inicio);
					inicio.setAnterior(fin);
				}else if(actual == fin){
					fin=anterior;
					inicio.setAnterior(fin);
					fin.setSiguiente(inicio);
				}else{
					anterior.setSiguiente(actual.getSiguiente());
					actual.getSiguiente().setAnterior(anterior);}
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}while(actual != inicio);
		
			
	}
	
	
	/**
	 * Método para buscar un nodo especifico de la lista circular doble
	 * @param dato
	 * @return
	 */
	public boolean buscarNodoCD(String dato){
		NodoListaCD temporal = inicio;
		
		while (temporal!=fin){
			if (temporal.getDato().equals(dato)){
				return true;
			}else{
				temporal=temporal.getSiguiente();
			}
		}
		return false;
	}
	
		
}

