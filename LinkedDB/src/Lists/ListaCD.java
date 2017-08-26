package Lists;
public class ListaCD {
		
		   private NodoLCD_Documento primerNodo;
		   private String nombre;  

		   public ListaCD() {
		         primerNodo = null;
		    }

		   public void insertar( Object documento ) {
		      if ( estaVacio() ) {
		         primerNodo = new NodoLCD_Documento(documento);
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
		         primerNodo = new NodoLCD_Documento( documento,desplazado,ultimoNodo );
		         ultimoNodo.nodoProximo = primerNodo;
		     	 
		      	 desplazado.nodoAnterior = primerNodo;
		      }
		   }
		   public void mostrar( Object documento ) {
			   NodoLCD_Documento nodo1 = primerNodo;
			   while( nodo1 != null){
				   System.out.println(nodo1.getT());
				   nodo1 = nodo1.getSiguiente();
			   }
			   
		   }
		   public Object remover()
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

