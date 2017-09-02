package Lists;
public class ListaCD {
	private NodoListaCD inicio;
	private NodoListaCD fin;
	int size=0;
	
	public ListaCD() {
		inicio = null;
		fin=null;
	}
	public boolean estaVacia(){
		if (inicio == null){
			return true;
		}else{
			return false;}
	}
	public void agregar(Object val)
    {
        NodoListaCD nuevo = new NodoListaCD(val, null, null);        
        if (inicio == null)
        {
        	nuevo.setSiguiente(nuevo);
        	nuevo.setAnterior(nuevo);
        	inicio=nuevo;
        	fin=inicio;
        }
        else {
        	nuevo.setAnterior(fin);
        	fin.setSiguiente(nuevo);
        	inicio.setAnterior(nuevo);
        	nuevo.setSiguiente(inicio);
        	fin=nuevo;  
        }
        size++;
    }
	public void mostrar(){
        NodoListaCD temp = inicio;
        if (inicio == null) 
        {
            System.out.print("Lista Vacia");
        }
        else if (inicio.getSiguiente() == inicio){
            System.out.print("Inicio-> "+temp.getDato());
        }
        System.out.print("Inicio-> ("+inicio.getDato()+ ") <~> (");
        temp = inicio.getSiguiente();
        
        while (temp.getSiguiente() != inicio) 
        {
            System.out.print(temp.getDato()+ ") <~> (");
            temp = temp.getSiguiente();
        }
        System.out.print(temp.getDato()+ ")~~| Fin \n");
    }
	
	public void eliminar(Object dato){
		NodoListaCD actual = new NodoListaCD();
		NodoListaCD anterior = new NodoListaCD();
		actual=inicio;
		anterior = fin;
		
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
					actual.getSiguiente().setAnterior(anterior);
					
					

				}
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}while(actual != inicio);
			
	}
	
	public void eliminar2(Object dato){
		NodoListaCD actual;
		boolean encontrado = false;
		actual=fin;
		while(actual.getSiguiente()!=fin && !encontrado){
			encontrado = (actual.getSiguiente().getDato()==dato);
			if (!encontrado){
				actual=actual.getSiguiente();
			}
		}	
		encontrado = (actual.getSiguiente().getDato()==dato);
		if(encontrado){
			NodoListaCD aux = actual.getSiguiente();
			if(fin==fin.getSiguiente()){
				fin=null;
			}
			actual.setSiguiente(aux.getSiguiente());
		}
	}
	
	public void buscar(Object dato){
		NodoListaCD temporal = inicio;
		
		while (temporal!=fin && temporal.getDato()!=dato){			
			temporal=temporal.getSiguiente();								// enviar la informacion..... Nombre y sus datos
		}
		if(temporal.getDato()==dato){
			System.out.println("SI EXISTE EL ELEMENTO {"+dato+"}");
		}else{
			System.out.println("NO EXIST {"+dato+"}");

		}
	}
	public static void main(String[] args){
		ListaCD list = new ListaCD();
		list.agregar(1);
		list.agregar(2);
		list.agregar(3);
		list.agregar(4);
		list.agregar(5);
		list.agregar(6);
		list.mostrar();
		list.buscar(0);
		
	}
	
}

