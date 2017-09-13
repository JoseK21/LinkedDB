package Lists;

import javafx.scene.Node;

public class ListaCD {
	private NodoListaCD inicio = null;;
	private NodoListaCD fin = null;
	int size=0;
	
	public ListaCD() {
		inicio = null;
		fin=null;
	}
	public boolean estaVacia(Object list){
		if (inicio == null){
			return true;
		}else{
			return false;}
	}
	public void agregar(String val)
    {
        NodoListaCD nuevo = new NodoListaCD(val);        
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
	public void imprimir(Object list) {
	      if (estaVacia(list)  ) {
	         System.out.println( "Lista Vacía");
	       
	      }
	      else{
		      NodoListaCD temp = inicio;

		      do {
		         System.out.print("("+ temp.getDato() +")~");
		         temp = temp.getSiguiente();
		         
		      } while(temp.getSiguiente() != inicio);		      
		   }
	   }
	

	public void imprimirLista() {
	      if (inicio==null  ) {
	         System.out.println( "Lista Vacía");
	       
	      }
	      else{
		      NodoListaCD temp = inicio;

		      do {
		         System.out.print("("+ temp.getDato() +")~");
		         temp = temp.getSiguiente();
		         
		      } while(temp.getSiguiente() != inicio);		      
		   }
	   }
	
	public void desplazar(Object list){
		NodoListaCD actual =inicio;
			
		System.out.println("\nInicio~>");
		do{
			String v = actual.getDato();
			System.out.print("<"+v+">~<");
			actual=actual.getSiguiente();
		}while(actual !=inicio);
		System.out.println("\n");
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
					actual.getSiguiente().setAnterior(anterior);}
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
	
	public boolean buscar1(String dato){
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
	public NodoListaCD buscarNodo(String dato){
		NodoListaCD temporal = inicio;
		
		while (temporal!=fin){
			if (temporal.getDato().equals(dato)){
				return temporal;
			}else{
				temporal=temporal.getSiguiente();
			}
		}
		return null;
	}
		
	public static void main(String[] args){
				
	}
	
}

