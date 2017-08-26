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
	public void insertarFinal(NodoListaS elemento){
		if (!estaVacia()){
			NodoListaS f = fin.getSiguiente(); // VERIFICAR SI FUNCIONA
			f =new NodoListaS(elemento);
			fin=fin.getSiguiente();
		}
		else{
			inicio=fin=new NodoListaS(elemento);			
		}
		System.out.println("Tamaño de la lista Simple: "+size);
	}
	//Metodo para ver los nombres de los JSON store
	public void mostrarLista(){
		NodoListaS recorrer = inicio;
		
		while (recorrer!=null){
			System.out.print("["+recorrer.getDato()+"]-->");
			recorrer=recorrer.getSiguiente();	
			
		} System.out.println("["+recorrer.getDato()+"]");
		
	}
	// metodo para eliminar un JSON store
	public void eliminarNodoEspecifico(NodoListaS elemento){  // hay que cambiar la variable pues no sera un numero sino un documento
		if (estaVacia()==true){
			System.out.println("NO hay documentos para eliminar");
		}
		else{
			if (inicio == fin && elemento==inicio.getDato()){
				inicio=fin=null;
				System.out.println("Dato unico eliminado");
			}else if (elemento == inicio.getDato()){
				inicio=inicio.getSiguiente();
			}else{
				NodoListaS anterior,temporal;
				anterior=inicio;
				temporal=inicio.getSiguiente();
				while(temporal != null && temporal.getDato()!=elemento){
					anterior=anterior.getSiguiente();
					temporal=temporal.getSiguiente();
				}
				if (temporal!=null){
					anterior.next=temporal.next;
					if (temporal==fin){
						fin=anterior;
					}
					
				}else {  // revisar si es asi que se realiza la funcion de no haber encontrado nada
					if (temporal.data==elemento){
						anterior=null;
					}else{
						System.out.println("Su documento no existe(no se elimino nada)");
					}
				}
			}
		}
	}
	//metodo para buscar un elemento
	public boolean buscarEnlaLista(int elemento){
		NodoListaS temporal = inicio;
		
		while (temporal!=null && temporal.data!=elemento){
			temporal=temporal.next;				
		}
		return temporal!=null;
	}
	
}


