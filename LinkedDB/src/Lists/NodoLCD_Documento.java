package Lists;

public class NodoLCD_Documento {
   public Object dato;    
   public NodoLCD_Documento nodoProximo;
   public NodoLCD_Documento nodoAnterior;

   public NodoLCD_Documento( Object objeto ) { 
      this( objeto, null, null ); 
   }


   public NodoLCD_Documento( Object objeto, NodoLCD_Documento prox, NodoLCD_Documento ant) {
      dato = objeto;    
      nodoProximo = prox;
      nodoAnterior = ant;
      
   }

   public Object obtenerObjeto() { 
      return dato; 
   }

   public NodoLCD_Documento obtenerProximo(){ 
      return nodoProximo; 
   }
   
   public NodoLCD_Documento obtenerAnterior() {
   	  return nodoAnterior; 
   }

}
