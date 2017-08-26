package Lists;

public class NodoListaCD extends Nodo{
	
   public NodoListaCD(Object documento) {
		//super(documento);
		// TODO Auto-generated constructor stub
	}

   public Object dato;    
   public NodoListaCD nodoProximo;
   public NodoListaCD nodoAnterior;

  public NodoListaCD(Object documento) {
      dato = objeto;    
      nodoProximo = prox;
      nodoAnterior = ant;
      
   }

   public Object obtenerObjeto() { 
      return dato; 
   }

   public NodoListaCD obtenerProximo(){ 
      return nodoProximo; 
   }
   
   public NodoListaCD obtenerAnterior() {
   	  return nodoAnterior; 
   }

}
