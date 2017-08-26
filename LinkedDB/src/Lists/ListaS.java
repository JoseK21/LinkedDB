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
		if (!estaVacia()){
			NodoListaS finSiguiente = fin.getSiguiente(); // VERIFICAR SI FUNCIONA
			finSiguiente =new NodoListaS(dato);
			fin=fin.getSiguiente();
			size++;
		}
		else{
			inicio=fin=new NodoListaS(dato);
			size++;
		}
		System.out.println("Tamaño de la lista Simple: "+size);
	}
	//Metodo para ver los nombres de los JSON store
	public void mostrarLista(){
		NodoListaS recorrer = inicio;
		
		while (recorrer!=null){
			System.out.print("["+recorrer.getDato()+"]-->");
			recorrer=recorrer.getSiguiente();	
			
		} 
		System.out.println("["+recorrer.getDato()+"]_FINAL_");
		
	}
	// metodo para eliminar un JSON store
	public void eliminarNodo(Object dato){  // hay que cambiar la variable pues no sera un numero sino un documento
		if (!estaVacia()){
			System.out.println("NO hay documentos para eliminar");
		}
		else{
			if (inicio == fin && dato==inicio.getDato()){ // dato=NOMBRE DEL JSON STORE
				inicio=fin=null;
				System.out.println("Dato unico eliminado");
			}else if (dato == inicio.getDato()){
				inicio=inicio.getSiguiente();
			}else{
				NodoListaS anterior,temporal;
				anterior=inicio;
				temporal=inicio.getSiguiente();
				while(temporal != null && temporal.getDato()!=dato){
					anterior=anterior.getSiguiente();
					temporal=temporal.getSiguiente();
				}
				if (temporal!=null){
					NodoListaS antsig = anterior.getSiguiente();
					antsig=temporal.getSiguiente();
					if (temporal==fin){
						fin=anterior;
					}
					
				}else {  			// revisar si es asi que se realiza la funcion de no haber encontrado nada
					if (temporal.getDato()==dato){
						anterior=null;
					}else{
						System.out.println("Su documento no existe(no se elimino nada)");
					}
				}
			}
		}
	}
	//metodo para buscar un elemento
	public boolean buscarEnlaLista(Object dato){
		NodoListaS temporal = inicio;
		
		while (temporal!=null && temporal.getDato()!=dato){
			temporal=temporal.getSiguiente();				
		}
		
		return temporal!=null;
		// enviar la informacion..... Nombre y sus datos
	}
	
}


