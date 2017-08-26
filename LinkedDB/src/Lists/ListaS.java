package Lists;

public class ListaS { // <T>

	//Punteros para saber donde esta el inicio y el final
	public NodoListaS inicio ;
	public NodoListaS fin;
	private int size = 0;
	
	
	
	public ListaS(){
		inicio =null;
		fin=null;
		System.out.println("\nTamaño de la lista Simple: "+size);
	}
	public boolean estaVacia(){
		if (inicio == null){
			return true;
		}else 
			return false;
	}
	
	public void insertar(NodoListaS elemento){
		if (estaVacia()==true){
			inicio=elemento;
			size++;
		}
		else{
			if (inicio.getSiguiente()==null){
				inicio= new NodoListaS(elemento); //---- REVISASR ESTO PUES CREO QUE SERIA __Nodo(elemento)__
			}else{
				Nodo temporal;
				while(true){
					temporal=inicio.getSiguiente();
					if (temporal == null){
						temporal=elemento;
					}else{
						temporal=temporal.getSiguiente();
					}
				}
			}
			
		}
		System.out.println("Tamaño de la lista Simple: "+size);
	}
	
	 
	//Metodo para ver los nombre luego de los documentos JSON
	public void mostrarLista(){
		Nodo recorrer = inicio;
		while (recorrer==null){
			//System.out.print("["+recorrer.getDato()+"]-->");
			recorrer=inicio.getSiguiente();
		}else{   // Revisasr el else
			
			System.out.print ("");
		}
	}
	
	
	
	// metodo para eliminar un dato especifico
	public void eliminarNodoEspecifico(int elemento){  // hay que cambiar la variable pues no sera un numero sino un documento
		if (estaVacia()==true){
			System.out.println("NO hay documentos para eliminar");
		}
		else{
			if (inicio == fin && elemento==inicio.data){
				inicio=fin=null;
				System.out.println("Dato unicio eliminado");
			}else if (elemento == inicio.data){
				inicio=inicio.next;
			}else{
				NodoListaS anterior,temporal;
				anterior=inicio;
				temporal=inicio.next;
				while(temporal != null && temporal.data!=elemento){
					anterior=anterior.next;
					temporal=temporal.next;
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


