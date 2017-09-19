package Lists;

public class ListaD {
	private NodoListaD inicio;
	private NodoListaD fin;
	private int size = 0;	
	
    private static  ListaD uniqueInstance  =   null;

	
	// Constructor por defecto
	public ListaD(){
		inicio=fin=null;	
	}
	//Metodo para saber si la lista esta vacia											REVISAR SE ES ListaD lista ó si es en BLANCO.
	public boolean estaListaDVacia(){
		return inicio==null;
	}
	public ListaD limpiar(){
		this.uniqueInstance=null;
		ListaD uniqueInstance  =   null;
		return uniqueInstance;
	}
	
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
	public int getSize(){
		NodoListaD temp = inicio;
		while (temp != null){
			size++;
		}
		return size;
	}
	
	public void agregarNodoD(String nombre){	
		ListaCD ListCD = new ListaCD();
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
        System.out.println("JsonStore Agregado : "+nuevo.getDato());       
        System.out.println("Lista en memoria : "+ListCD);
        }
	
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
	public NodoListaD getFirstNodeD(){
		NodoListaD temporal = inicio;
		return temporal;
	}
	public void eliminarNodoD(Object dato){
		  
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
					  temporal = temporal.getSiguiente();		    
					  siguiente = siguiente.getSiguiente();		    
					  anterior = anterior.getSiguiente();
				  }
				  if(siguiente != null && siguiente != fin){
					  System.out.println("Se elimino /"+siguiente.getDato()+"/");
					  siguiente.getSiguiente().setAnterior(temporal.getAnterior());
					  anterior.getAnterior().setSiguiente(temporal.getSiguiente());
					  }
				  else{ 
					  if(siguiente == fin){
						  System.out.println("elemento ULTIMO de la lista/");
						  System.out.println("Se elimino /"+siguiente.getDato()+"/");
						  fin = fin.getAnterior();
						  fin.setSiguiente(null);
					  }else{
						  System.out.println("No Existe_/ No se puede eliminar_!");
					  }
			  }}
		  }
	}

	public static ListaD getInstance(){
        if(uniqueInstance == null){
              uniqueInstance = new ListaD();
        }
        return uniqueInstance;
    }

	
	public static void main(String[] args){
		
	}


}
		   
	