package Lists;

public class LCD_Documento {
	public class ListaCircularDE {
		   private NodoLCD_Documento primerNodo;
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
		         primerNodo = new NodoLCD_Documento(elementoAInsertar);
		         primerNodo.nodoProximo=primerNodo;
		         primerNodo.nodoAnterior=primerNodo;
		         
		      }
		      else {
		    	  NodoLCD_Documento actual = primerNodo;
		      	 while(actual.nodoProximo != primerNodo) {
		      	 	actual = actual.nodoProximo;
		      	 }
		      	NodoLCD_Documento ultimoNodo = actual;
		         
		      	NodoLCD_Documento desplazado = primerNodo;
		         primerNodo = new NodoLCD_Documento( elementoAInsertar,desplazado,ultimoNodo );
		         ultimoNodo.nodoProximo = primerNodo;
		     	 
		      	 desplazado.nodoAnterior = primerNodo;
		      }
		   }

		   public synchronized Object remover()
		      throws ExcepcionListaVacia
		   {
			  NodoLCD_Documento NodoARemover = primerNodo;
		      Object elementoARemover = null;

		      if ( estaVacio() )
		         throw new ExcepcionListaVacia( nombre );

		      elementoARemover = primerNodo.dato;  

		      if ( primerNodo == primerNodo.nodoProximo )
		         primerNodo = null;
		      else
		      {
		    	 NodoLCD_Documento actual = primerNodo;
		      	 while(actual.nodoProximo != primerNodo) {
		      	 	actual = actual.nodoProximo;
		      	 }
		      	NodoLCD_Documento ultimoNodo = actual;
		      	 	        
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
