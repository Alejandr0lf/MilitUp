package com.MilitUp.PrincipalClasses;

/* 
 * La clase país es esensial, puesto que dentro del Pais es donde se crea el gobierno y dentro de este el militar que
 * será el jugador, por lo cuál el pais no depende de nadie, sino que todos dependen del país. El país tiene un nombre
 * y dos estadísticas, que serán recibidos por la SubClassReceiveStats cuando se cree un nuevo país, gobierno y militar.
 * 
 * RECORDATORIO: Para que SubClassReceiveStats reciba los Stats de país, usar los GETTERS.
 */
public class Pais {

    /*
     * El atributo único de un país, el nombre, y sus propiedades de importancia,
     * los Stats.
     */
    private String paisName;
    private int country_StatPositive, country_StatNegative;

    /*
     * Constructor del país con el nombre. Nótese que cuando se crea un nuevo país,
     * este se hace con un parámetro que corresponde al nombre del país, por lo
     * tanto, se ejecuta inmediatamente después el determinateStatsCountry para
     * asignarle a los stats sus valores predeterminados dependiendo del país
     */
    public Pais(String country) {
        this.paisName = country;
        determinateStatCountry();
    }

    /*
     * Este método permite asignarle unos valores predefinidos a los stats
     * dependiendo del nombre del país que se haya escogido, esto con el objetivo de
     * que, para el jugador, cada país tenga cierto valor de "dificultad"
     */
    private void determinateStatCountry() {
        switch (this.paisName) {
            /*
             * Se puede notar que el stat positive de EEUU es menor a los demás, mientras
             * que el negative es mayor, así que EEUU es el país más difícil de jugar
             * (Nótese que se habla del país, mas no del gobierno)
             */
            case "Estados Unidos":
                this.country_StatPositive = 2;
                this.country_StatNegative = 10;
                break;
            /*
             * Se puede notar que china tiene sus Stats en 1, es decir, China se encuentra
             * en equilibrio negativo y positivo, por lo cuál su dificultad resulta ser de
             * media
             */
            case "China":
                this.country_StatPositive = 1;
                this.country_StatNegative = 1;
                break;
            /*
             * Damos cuenta de que Rusia tiene un stat positivo mayor a los demás y uno
             * negativo menor, por lo cuál, Rusia tiene una dificultad mucho menor que la de
             * los demás países, y esto se debe a su stat positivo principalmente
             */
            case "Rusia":
                this.country_StatPositive = 10;
                this.country_StatNegative = 2;
                break;
            /*
             * El default es 0, es decir, cuando se hagan las operaciones de multiplicación,
             * los stats deberían hacer que todo de 0
             */
            default:
                this.country_StatPositive = 0;
                this.country_StatNegative = 0;
                break;
        }
    }

    /*
     * GETTERS && SETTERS
     */
    public String getPaisName() {
        return this.paisName;
    }

    public int getCountryStatPositive() {
        return country_StatPositive;
    }

    public void setCountryStatPositive(int value) {
        country_StatPositive = value;
    }

    public int getCountryStatNegative() {
        return country_StatNegative;
    }

    public void setCountryStatNegative(int value) {
        country_StatNegative = value;
    }
}
package com.MilitUp.PrincipalClasses;

/**
 * La clase gobierno depende de país, pues este se crea bajo el nombre del objeto país que haya elegido el jugador.
 * El gobierno tiene dos propiedades importantes, el tipo de gobierno y el país al cuál pertenece. El país se usará
 * para cosas sencillas, aunque ninguna afecta la funcionalidad realmente, es más una formalidad de la idea general;
 * pero, no obstante, un Objeto Militar no creará una instancia de país al crearse, sino que usará la que posea la
 * instancia de Gobierno. Esto es importante porque la clase Militar, como usa Gobierno, también usará la clase clonada
 * de Pais para que desde militar se puedan introducir los stats a SubClassReceiveStats
 * 
 * El gobierno también tiene del 6 parámetros al construirse:
 *   El país, que permite obtener el país al cuál pertenece dentro de la clase Militar.
 *   El tipo de gobierno, un String que se recibirá para saber si el gobierno es una Democracia o Dictadura.
 *   Los indx, coeficientes que se usarán para definir los Stats que manejará el Gobierno. Los indx son de hecho mo
 * De forma similar a la clase Pais, Gobierno introduce sus stats dentro de la SubClassReceiveStats para que luego
 * sean calculadas las estadísticas.
 */
public class Gobierno {

     /*
      * Las propiedades del Gobierno que se tomarán en cuenta dentro del constructor,
      * clona a Pais cuando este es creado, y recibe el sistema de gobierno elegido
      */
     private String typeGovernment;
     private Pais country;

     /*
      * Estadísticas positivas, que multiplican para aumentar las estadísticas del
      * jugador (Todas se inician en 1 para ahorrar código en el defineStats)
      */
     private int statGovVidaPlus = 0;
     private int statGovRangoPlus = 0;
     private int statGovMoralPlus = 0;
     private int statGovArmaPlus = 0;

     /*
      * Estadísticas negativas, que multiplican para reducir las estadísticas del
      * jugador (Todas se inician en 1 para ahorrar código en el defineStats)
      */
     private int statGovVidaLess = 0;
     private int statGovRangoLess = 0;
     private int statGovMoralLess = 0;
     private int statGovArmaLess = 0;

     /*
      * Constructor de la clase Gobierno que recibe todos las propiedades de la clase
      * y los indx que servirán para darle valor a los stats a través del método
      * defineStats.
      */
     public Gobierno(Pais country, String typeGoverment) {
          this.country = country;
          this.typeGovernment = typeGoverment;
     }
     
     // GETTERS & SETTERS

     public int getStatGovVidaPlus() {
          return this.statGovVidaPlus;
     }

     public void setStatGovVidaPlus(int value) {
          this.statGovVidaPlus = value;
     }

     public int getStatGovRangoPlus() {
          return this.statGovRangoPlus;
     }

     public void setStatGovRangoPlus(int value) {
          this.statGovRangoPlus = value;
     }

     public int getStatGovMoralPlus() {
          return this.statGovMoralPlus;
     }

     public void setStatGovMoralPlus(int value) {
          this.statGovMoralPlus = value;
     }

     public int getStatGovArmaPlus() {
          return this.statGovArmaPlus;
     }

     public void setStatGovArmaPlus(int value) {
          this.statGovArmaPlus = value;
     }

     public int getStatGovVidaLess() {
          return this.statGovVidaLess;
     }

     public void setStatGovVidaLess(int value) {
          this.statGovVidaLess = value;
     }

     public int getStatGovRangoLess() {
          return this.statGovRangoLess;
     }

     public void setStatGovRangoLess(int value) {
          this.statGovRangoLess = value;
     }

     public int getStatGovMoralLess() {
          return this.statGovMoralLess;
     }

     public void setStatGovMoralLess(int value) {
          this.statGovMoralLess = value;
     }

     public int getStatGovArmaLess() {
          return this.statGovArmaLess;
     }

     public void setStatGovArmaLess(int value) {
          this.statGovArmaLess = value;
     }

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
package com.MilitUp.PrincipalClasses;

import java.util.HashMap;
import java.util.Map;

import com.MilitUp.SubUtilClasses.SubClassRange;

/* 
 * La clase Militar es la mas importante, pues cuando el jugador inicie el juego,
 * la clase que manejará será una instancia de Militar. Esta clase tiene una serie de atributos:
 * El nombre es un String que el jugador puede rellenar, el país es un país de clase Pais que el
 * jugador elija, el gobierno es un objeto Gobierno que el jugador puede elegir, y los demás
 * atributos se inicializan por defecto: Vida=1000, Rango=0, Moral=100, Arma=100 y Experiencia=0.
 * 
 * Los atributos Pais y Gobierno son importantes porque con ellos, la SubClassReceiveStats puede
 * recolectar los atributos que necesita para que SubClassModifyStats calcule las estadísticas.
 */
public class Militar {
     /*
      * Vemos aquí los atributos, los int iniciados por defecto y los String que el
      * jugador puede escoger
      */
     protected String Nombre;
     protected Pais pais;
     protected Gobierno gobierno;
     protected int Vida = 1000;
     protected int Rango = 1;
     protected int Moral = 1000;
     protected int Arma = 1000;
     protected int Experiencia = 0;

     /*
      * Constructor por defecto de la clase militar, con un atributo Gobierno, otro
      * Pais, un nombre String y los ints que son las estadísticas del jugador
      * (stats)
      */
     public Militar(String nombre, Pais pais, Gobierno gobierno, int vida, int rango, int arma, int moral,
               int experiencia) {
          this.Nombre = nombre;
          this.pais = pais;
          this.gobierno = gobierno;
          this.Vida = vida;
          this.Rango = rango;
          this.Moral = moral;
          this.Arma = arma;
          this.Experiencia = experiencia;
     }

     /*
      * Aquí Militar hace uso de la clase auxiliar SubClassRange para crear
      * intervalos entre los cuales se pueda determinar el cargo del militar en
      * función del Rango. Esta clase se debe usar para mostrar el cargo del Jugador
      */
     public static String revealCharge(int chargeValue) {
          /*
           * Definimos un MAP que guarda los rangos en base al atributo this.Rango
           */
          final Map<SubClassRange, String> RANGOS = new HashMap<>();

          /*
           * Static que guarda los rangos en un intervalo dentro de de Map RANGOS
           */
          RANGOS.put(new SubClassRange(Integer.MIN_VALUE, 0), "No es un soldado");
          RANGOS.put(new SubClassRange(1, 100), "Soldado");
          RANGOS.put(new SubClassRange(101, 200), "Cabo");
          RANGOS.put(new SubClassRange(201, 300), "Sargento");
          RANGOS.put(new SubClassRange(301, 400), "Teniente");
          RANGOS.put(new SubClassRange(401, 500), "Capitán");
          RANGOS.put(new SubClassRange(501, 600), "Mayor");
          RANGOS.put(new SubClassRange(601, 700), "Coronel");
          RANGOS.put(new SubClassRange(701, 800), "Teniente Coronel");
          RANGOS.put(new SubClassRange(801, 900), "Mariscal");
          RANGOS.put(new SubClassRange(901, 999), "General");
          RANGOS.put(new SubClassRange(1000, Integer.MAX_VALUE), "Gran General Super Magistral");

          /*
           * Operación que retorna el rango en forma de un String
           */
          for (SubClassRange rango : RANGOS.keySet()) {
               if (rango.contains(chargeValue)) {
                    return RANGOS.get(rango);
               }
          }
          return "Rango no definido";
     }

     public void copyFrom(Militar other) {
          this.setVida(other.getVida());
          this.setRango(other.getRango());
          this.setMoral(other.getMoral());
          this.setArma(other.getArma());
     }

     /*
      * GETTERS && SETTERS
      */
     public String getNombre() {
          return this.Nombre;
     }

     public void setNombre(String value) {
          this.Nombre = value;
     }

     public Pais getPais() {
          return this.pais;
     }

     public void setPais(Pais value) {
          this.pais = value;
     }

     public Gobierno getGobierno() {
          return this.gobierno;
     }

     public void setGobierno(Gobierno value) {
          this.gobierno = value;
     }

     public int getVida() {
          return this.Vida;
     }

     public void setVida(int value) {
          this.Vida = value;
     }

     public int getRango() {
          return this.Rango;
     }

     public void setRango(int value) {
          this.Rango = value;
     }

     public int getMoral() {
          return this.Moral;
     }

     public void setMoral(int value) {
          this.Moral = value;
     }

     public int getArma() {
          return this.Arma;
     }

     public void setArma(int value) {
          this.Arma = value;
     }

     public int getExperiencia() {
          return this.Experiencia;
     }

     public void setExperiencia(int value) {
          this.Experiencia = value;
     }
}