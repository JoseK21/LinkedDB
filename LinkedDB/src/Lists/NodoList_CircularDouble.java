package Lists;

public class NodoList_CircularDouble {
   public Object dato;    
   public NodoList_CircularDouble nodoProximo;
   public NodoList_CircularDouble nodoAnterior;

   public NodoList_CircularDouble( Object objeto ) { 
      this( objeto, null, null ); 
   }


   public NodoList_CircularDouble( Object objeto, NodoList_CircularDouble prox, NodoList_CircularDouble ant) {
      dato = objeto;    
      nodoProximo = prox;
      nodoAnterior = ant;
      
   }

   public Object obtenerObjeto() { 
      return dato; 
   }

   public NodoList_CircularDouble obtenerProximo(){ 
      return nodoProximo; 
   }
   
   public NodoList_CircularDouble obtenerAnterior() {
   	  return nodoAnterior; 
   }

}
