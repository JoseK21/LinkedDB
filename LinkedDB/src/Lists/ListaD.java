package Lists;

public class ListaD {
	private NodoListaD inicio;
	private NodoListaD fin;
	private int size = -1;
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
	public void insertar(Object dato)
    {
        NodoListaD nuevo = new NodoListaD(dato, null, null);        
        if(inicio == null)
        {
            inicio = nuevo;
            fin = inicio;
        }
        else
        {
        	nuevo.setAnterior(fin);
            fin.setSiguiente(nuevo);    
            fin = nuevo;
        }
        size++;
        
    }
	
	public void mostrar(){
		NodoListaD temporal = inicio;
		System.out.print("INICIO>");
		int size=0;
		while (temporal!=null){
			Object dee = temporal.getDato();
			if (dee !=""){
				System.out.print("["+dee+"]<-->");
				temporal=temporal.getSiguiente();	
				size++;
			}else if (dee ==""){
				System.out.print("| <-fin");
			//}
		} 
		}
		System.out.print("\nTamaño de lista: "+size);	  
	}
	public boolean buscar(Object dato){
		NodoListaD temporal = inicio;
		
		while (temporal!=null){
			if (temporal.getDato()==dato){
				System.out.println("Si exite el elemento dentro de la lista : _("+dato+")_");
				return true;
			}else{
				temporal=temporal.getSiguiente();
			}
		}
		System.out.println("No exite : _("+dato+")_\n Se debe agregar a la lista");
		return false;
		
	
	}
		/*
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
		*/
	
	
	
	public void eliminar(Object dato){
		  
		  if(estaVacia()){
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
	
	public static void main(String[] args){
		
	}


}
		   
	