package com.MilitUp.PrincipalClasses;

/**
 * La clase gobierno depende de país, pues este se crea bajo el nombre del objeto país que haya elegido el jugador.
 * El gobierno tiene dos propiedades importantes, el tipo de gobierno y el país al cuál pertenece. El país se usará
 * para cosas sencillas, aunque ninguna afecta la funcionalidad realmente, es más una formalidad de la idea general;
 * pero, no obstante, un Objeto Militar no creará una instancia de país al crearse, sino que usará la que posea la
 * instancia de Gobierno. Esto es importante porque la clase Militar, como usa Gobierno, también usará la clase clonada
 * de Pais para que desde militar se puedan introducir las propiedades.
 * 
 * El gobierno también tiene 2 parámetros al construirse:
 *   El país, que permite obtener el país al cuál pertenece dentro de la clase Militar.
 *   El tipo de gobierno, un String que se recibirá para saber si el gobierno es una Democracia o Dictadura.
 */
public class Gobierno {

     /*
      * Las propiedades del Gobierno que se tomarán en cuenta dentro del constructor,
      * clona a Pais cuando este es creado, y recibe el sistema de gobierno elegido
      */
     private String typeGovernment;
     private Pais country;

     /**
      * Constructor vacío para la clase gobierno
      */
     public Gobierno() {
     }

     /*
      * Constructor de la clase Gobierno que recibe todos las propiedades de la clase
      * y los indx que servirán para darle valor a los stats a través del método
      * defineStats.
      */
     public Gobierno(Pais country, String typeGoverment) {
          this.country = country;
          this.typeGovernment = typeGoverment;
     }

     /**
     * Este método busca determinar el gobierno elegido y retornar un número asociado a
     * cada tipo de gobierno
     * 
     * @return 1 si es Democracia, 2 si es Dictadura
     */
    public int getGovernment() {
     int x = 0;
     switch (this.typeGovernment) {
         /*
          * Retornará 1 en caso de que el país en cuestión sea Estados Unidos
          */
         case "Democracia":
             x = 1;
             break;
         /*
          * Retornará 2 en caso de que el país en cuestión sea China
          */
         case "Dictadura":
             x = 2;
             break;
         /*
          * Retornará 0 en cualquier otro caso.
          */
         default:
             x = 0;
             break;
     }
     return x;
 }
     
     // GETTERS & SETTERS
     public String getTypeOfGovernment() {
          return this.typeGovernment;
     }

     public void setTypeOfGovernment(String value) {
          this.typeGovernment = value;
     }

     public Pais getCountry() {
          return this.country;
     }

     public void setCountry(Pais value) {
          this.country = value;
     }
}
