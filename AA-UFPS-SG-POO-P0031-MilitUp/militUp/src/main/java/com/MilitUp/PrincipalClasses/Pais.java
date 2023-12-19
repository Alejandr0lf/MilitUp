package com.MilitUp.PrincipalClasses;

/* 
 * La clase país es esensial, puesto que dentro del Pais es donde se crea el gobierno y dentro de este el militar que
 * será el jugador, por lo cuál el pais no depende de nadie, sino que todos dependen del país. El país tiene un nombre,
 * que serán recibidos por la SubClass cuando se cree un nuevo país, gobierno y militar.
 */
public class Pais {

    /*
     * El atributo único de un país, el nombre.
     */
    private String paisName;

    /**
      * Constructor vacío para la clase Pais
      */
      public Pais() {
    }

    /*
     * Constructor del país con el nombre. Nótese que cuando se crea un nuevo país,
     * este se hace con un parámetro que corresponde al nombre del país, que se
     * recibirá desde la acción del botón
     */
    public Pais(String country) {
        this.paisName = country;
    }

    /**
     * Este método busca determinar el país elegido y retornar un número asociado a
     * cada país
     * 
     * @return 1 Si es Estados Unidos, 2 si es China, 3 si es Rusia
     */
    public int getCountry() {
        int x = 0;
        switch (this.paisName) {
            /*
             * Retornará 1 en caso de que el país en cuestión sea Estados Unidos
             */
            case "Estados Unidos":
                x = 1;
                break;
            /*
             * Retornará 2 en caso de que el país en cuestión sea China
             */
            case "China":
                x = 2;
                break;
            /*
             * Retornará 3 en caso de que el país en cuestión sea Rusia
             */
            case "Rusia":
                x = 3;
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

    /*
     * GETTERS && SETTERS
     */
    public String getPaisName() {
        return this.paisName;
    }
}
