package com.MilitUp.AuxSubClasses;

/* Esta subClase (Llamada así por su uso) se usa en Militar.java para determinar en el HashMap los intervalos 
* Fuera de eso, realmente no tiene ninguna funcionalidad.
*/
public class SubRangeClass {

     /*
      * Variables finales e innamovibles que usa la clase para determinar un
      * principio y un final
      */
     private final int start;
     private final int end;

     /*
      * Constructor que permite usar la funcionalidad dentro de la clase Militar
      */
     public SubRangeClass(int start, int end) {
          this.start = start;
          this.end = end;
     }

     /*
      * Método que permite determinar si un valor se encuentra dentro del intervalo
      * solicitado
      */
     public boolean contains(int value) {
          return value >= start && value <= end;
     }
}
