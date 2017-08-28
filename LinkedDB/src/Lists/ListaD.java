package Lists;

public class ListaD {
	private NodoListaD inicio;
	private NodoListaD fin;
	private int size = 0;
	// Constructo	
	public ListaD(){
		inicio=fin=null;	
	}
	//Metodo para saber si la lista esta vacia
	public boolean estaVacia(){
		if (inicio == null){
			return true;
		}else 
			return false;
	}
	public void insertAtEnd(Object val)
    {
        NodoListaD nptr = new NodoListaD(val, null, null);        
        if(inicio == null)
        {
            inicio = nptr;
            fin = inicio;
            System.out.println("Inicio->["+val+"]-");
        }
        else
        {
            nptr.setAnterior(fin);
            fin.setSiguiente(nptr);    
            fin = nptr;
            System.out.println(">["+val+"]-");
        }
        size++;
    }
	String enlace="";
	public void mostrarListaD(){
		if(estaVacia()==false){
			
			NodoListaD auxiliar=inicio;			
			while (auxiliar!=null){
				enlace=enlace+"["+auxiliar.getDato()+"]<=>";
				auxiliar=auxiliar.getSiguiente();
				
				
			}
			System.out.println("Inicio=>"+enlace+"|FIN");
			System.out.println("\nTamaño de la lista Doble: "+size);

		}
		else{
			System.out.println("\nLista Vacia---- NAda que mostar");
		}

	}
	public void eliminar(Object dato){
		  
		  if(estaVacia()){
			  System.out.println("Lista vacia");
		  }
		  else if(fin == inicio){
			  if(dato == inicio.getDato()){
				  fin = null;
				  inicio=null;
				  System.out.println("Unico nodo existente ELIMINADO ["+dato+"]");
			  }else{
				  System.out.println("Error");
			  }
		  }
		  else if(dato == inicio.getDato()){
			  System.out.println("else if ___ dato == inicio.getDato()");			  
			  inicio = inicio.getSiguiente();
			  inicio.setAnterior(inicio.getAnterior());
			  inicio.setAnterior(null);
		  }
		  else{  
			  System.out.println("etapa final.. el nodo esta entre el medio");
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
				  siguiente.getSiguiente().setAnterior(temporal.getAnterior());
				  anterior.getAnterior().setSiguiente(temporal.getSiguiente());
				  }
			  else{ 
				  if(siguiente == fin){
					  fin = fin.getAnterior();
					  fin.setSiguiente(null);
			    }
			  }
		  }System.out.println("No Existe_/ No se puede eliminar_!");
	}
	public void buscar(Object dato){
		NodoListaD temporal = inicio;
		
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
		ListaD listD = new ListaD();
		listD.insertAtEnd(1);
		listD.insertAtEnd(2);
		listD.insertAtEnd(3);
		listD.insertAtEnd(4);
		listD.insertAtEnd(5);
		listD.insertAtEnd(6);
		listD.mostrarListaD();
		
	}


}
		   
	