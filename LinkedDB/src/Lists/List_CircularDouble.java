package Lists;

public class List_CircularDouble {
	public class ListaCircularDE {
		   private NodoList_CircularDouble primerNodo;
		   private String nombre;  

		   public ListaCircularDE( String cadena ) {
		      nombre = cadena;
		      primerNodo = null;
		    }

		   public ListaCircularDE() { 
		      this( "Circular DE" ); 
		   }  

		   public synchronized void insertar( Object elementoAInsertar ) {
		      if ( estaVacio() ) {
		         primerNodo = new NodoList_CircularDouble(elementoAInsertar);
		         primerNodo.nodoProximo=primerNodo;
		         primerNodo.nodoAnterior=primerNodo;
		         
		      }
		      else {
		    	  NodoList_CircularDouble actual = primerNodo;
		      	 while(actual.nodoProximo != primerNodo) {
		      	 	actual = actual.nodoProximo;
		      	 }
		      	NodoList_CircularDouble ultimoNodo = actual;
		         
		      	NodoList_CircularDouble desplazado = primerNodo;
		         primerNodo = new NodoList_CircularDouble( elementoAInsertar,desplazado,ultimoNodo );
		         ultimoNodo.nodoProximo = primerNodo;
		     	 
		      	 desplazado.nodoAnterior = primerNodo;
		      }
		   }

		   public synchronized Object remover()
		      throws ExcepcionListaVacia
		   {
			  NodoList_CircularDouble NodoARemover = primerNodo;
		      Object elementoARemover = null;

		      if ( estaVacio() )
		         throw new ExcepcionListaVacia( nombre );

		      elementoARemover = primerNodo.dato;  

		      if ( primerNodo == primerNodo.nodoProximo )
		         primerNodo = null;
		      else
		      {
		    	 NodoList_CircularDouble actual = primerNodo;
		      	 while(actual.nodoProximo != primerNodo) {
		      	 	actual = actual.nodoProximo;
		      	 }
		      	NodoList_CircularDouble ultimoNodo = actual;
		      	 	        
		         primerNodo = primerNodo.nodoProximo;
		         ultimoNodo.nodoProximo = primerNodo;
		         primerNodo.nodoAnterior = ultimoNodo;
		      }
		      
		      NodoARemover.nodoProximo=null;
		      NodoARemover.nodoAnterior=null;

		      return elementoARemover;
		   }

		   public synchronized boolean estaVacio() { 
		      return primerNodo == null; 
		   }
	}
}
