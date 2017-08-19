package Lists;

public class LS_Objeto {

	//Punteros para saber donde esta el inicio y el final
	public NodoLS_Objeto inicio ;
	public NodoLS_Objeto fin;
	
	public LS_Objeto(){
		inicio =null;
		fin=null;
	}
	public boolean estaVacia(){
		if (inicio == null){
			return true;
		}else 
			return false;
	}
	public void agregarAlInicio(int elemento){		//Metodo para agregar un nodo al inicio de la lista
		inicio=new NodoLS_Objeto(elemento, inicio); //Creacion de Nodo de la lIsta Simple Enlazada
		if(fin==null){
			fin=inicio;
		}
	}
	 
	//Metodo para ver los nombre luego de los documentos JSON
	public void mostrarLista(){
		NodoLS_Objeto recorrer = inicio;
		while (recorrer!=null){
			System.out.print("["+recorrer.data+"]-->");
			recorrer=recorrer.next;
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
				NodoLS_Objeto anterior,temporal;
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
		NodoLS_Objeto temporal = inicio;
		
		while (temporal!=null && temporal.data!=elemento){
			temporal=temporal.next;				
		}
		return temporal!=null;
	}
	
}


