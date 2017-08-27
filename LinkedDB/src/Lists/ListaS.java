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
		NodoListaS nuevo = new NodoListaS(dato);
		
		if (estaVacia()){
			inicio=nuevo;
			}
		else{
			NodoListaS auxiliar = inicio;
			while(auxiliar.getSiguiente() != null){
				auxiliar = auxiliar.getSiguiente();
			}
			auxiliar.setSiguiente(nuevo);
			}
	}

	//Metodo para ver los nombres de los JSON store
	public void mostrarLista(){
		NodoListaS recorrer = inicio;
		System.out.print("INICIO>");
		while (recorrer!=null){
			Object dee = recorrer.getDato();	
			System.out.print("["+dee+"]-->");
			recorrer=recorrer.getSiguiente();	
			} 	
		//if (recorrer.getSiguiente()==null){
			System.out.print("-||fin");
		
	}
	
	public void eliminarNodo(Object dato){  // metodo para eliminar un JSON store
		if (estaVacia()==true){
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
	public void buscar(Object dato){
		NodoListaS temporal = inicio;
		
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
		ListaS list = new ListaS();
		list.insertarFinal(1);
		list.insertarFinal(2);
		list.insertarFinal(3);
		list.insertarFinal(4);
		list.insertarFinal(5);
		list.insertarFinal(6);
		list.insertarFinal(7);
		list.insertarFinal(8);
		list.insertarFinal(9);
		list.insertarFinal(10234); // PORQUE NO CON NUMEROS DE 4 DIGITOS
		list.eliminarNodo(3);
		
		list.buscar(5);
		list.mostrarLista();
		
	}
}
