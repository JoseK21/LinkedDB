package Lists;
import javafx.scene.Node;
public class ListaCD {
	private NodoListaCD inicio = null;;
	private NodoListaCD fin = null;
	int size=0;
	
	public ListaCD() {
		inicio=fin=null;
	}
	public boolean estaListaCDVacia(){
		return inicio==null;
	}
	
	
	public NodoListaCD getNodoCD(String nodoName){
		NodoListaCD aux = inicio;
		while (aux != null){
			if(aux.getDato().equals(nodoName)){
				return aux;
			}
			else{
				aux=aux.getSiguiente();
			}
		}return null;		
	}	
	
	
	public void agregarNodoCD(String nombreDoc){
		ListaS listSim = new ListaS();		
        NodoListaCD nuevo = new NodoListaCD(nombreDoc,listSim);      
        
        if (inicio == null){
        	System.out.println("LISTA VACIA...Entro al agregar con el valor correcto y dandole una lista simple vacia");
        	nuevo.setSiguiente(nuevo);
        	nuevo.setAnterior(nuevo);
        	inicio=nuevo;
        	fin=inicio;
        }else {
        	System.out.println("Otro nodo simple111111111111111111111111111111111111111111");
        	nuevo.setAnterior(fin);
        	fin.setSiguiente(nuevo);
        	inicio.setAnterior(nuevo);
        	nuevo.setSiguiente(inicio);
        	fin=nuevo;  
        }
        size++;
        System.out.println(listSim);
    }
	
	public NodoListaCD getFirstNodeCD(){
		NodoListaCD temporal = inicio;
		return temporal;
	}
	
	public void imprimirListaCD() { // pasarle el nombre de la lista a imprimir
	      if (estaListaCDVacia()==true) {
	         System.out.println("Lista Vacía");	       
	      }
	      else{
		      NodoListaCD temp = inicio;
		      System.out.print("Inicio~>");
		      
		      do {
		         System.out.print("("+ temp.getDato() +")~");
		         temp = temp.getSiguiente();
		         
		      } while(temp.getSiguiente() != inicio);	
		      System.out.print("("+ temp.getDato() +")~");
		      System.out.print("Fin~Inicio");
		   }
	   }
		
	public void eliminarNodoCD(Object dato){
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
	
	public void eliminar2NodoCD(Object dato){
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
	
	public boolean buscarNodoCD(String dato){
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
	
	public NodoListaCD obtenerNodoCD(String dato){
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

