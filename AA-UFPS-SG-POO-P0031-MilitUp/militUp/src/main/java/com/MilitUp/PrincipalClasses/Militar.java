package com.MilitUp.PrincipalClasses;

import java.util.HashMap;
import java.util.Map;

import com.MilitUp.AuxSubClasses.*;

/* 
 * La clase Militar es la mas importante, pues cuando el jugador inicie el juego,
 * la clase que manejará será una instancia de Militar. Esta clase tiene una serie de atributos:
 * El nombre es un String que el jugador puede rellenar, el país es un país de clase Pais que el
 * jugador elija, el gobierno es un objeto Gobierno que el jugador puede elegir, y los demás
 * atributos se inicializan por defecto: Vida=1000, Rango=1, Moral=100, Arma=100 y Experiencia=0.
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

     /**
      * Constructor vacío para la clase Militar
      */
      public Militar() {
     }

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

     /**
      * Contructor con los únicos parámetros que importan
      * 
      * @param nombre   Nombre del jugador
      * @param pais     País del jugador
      * @param gobierno Tipo de gobierno del jugador
      */
     public Militar(String nombre, Pais pais, Gobierno gobierno) {
          this.Nombre = nombre;
          this.pais = pais;
          this.gobierno = gobierno;
          this.Vida = 1000;
          this.Rango = 1;
          this.Moral = 1000;
          this.Arma = 1000;
          this.Experiencia = 0;
     }

     /*
      * Aquí Militar hace uso de la clase auxiliar SubClassRange para crear
      * intervalos entre los cuales se pueda determinar el cargo del militar en
      * función del Rango. Esta clase se debe usar para mostrar el cargo del Jugador
      */
     public static String determineMilitaryRank(int chargeValue) {
          /*
           * Definimos un MAP que guarda los rangos en base al atributo this.Rango
           */
          final Map<SubRangeClass, String> RANGOS = new HashMap<>();

          /*
           * Static que guarda los rangos en un intervalo dentro de de Map RANGOS
           */
          RANGOS.put(new SubRangeClass(Integer.MIN_VALUE, 0), "No es un soldado");
          RANGOS.put(new SubRangeClass(1, 100), "Soldado");
          RANGOS.put(new SubRangeClass(101, 200), "Cabo");
          RANGOS.put(new SubRangeClass(201, 300), "Sargento");
          RANGOS.put(new SubRangeClass(301, 400), "Teniente");
          RANGOS.put(new SubRangeClass(401, 500), "Capitán");
          RANGOS.put(new SubRangeClass(501, 600), "Mayor");
          RANGOS.put(new SubRangeClass(601, 700), "Coronel");
          RANGOS.put(new SubRangeClass(701, 800), "Teniente Coronel");
          RANGOS.put(new SubRangeClass(801, 900), "Mariscal");
          RANGOS.put(new SubRangeClass(901, 999), "General");
          RANGOS.put(new SubRangeClass(1000, Integer.MAX_VALUE), "Gran General Super Magistral");

          /*
           * Operación que retorna el rango en forma de un String
           */
          for (SubRangeClass rango : RANGOS.keySet()) {
               if (rango.contains(chargeValue)) {
                    return RANGOS.get(rango);
               }
          }
          return "Rango no definido";
     }

     /**
      * Posible método inútil (Conciderar borrarlo una vez acabado el juego)
      * 
      * @param other
      */
     /*
      * public void copyFrom(Militar other) {
      * this.setVida(other.getVida());
      * this.setRango(other.getRango());
      * this.setMoral(other.getMoral());
      * this.setArma(other.getArma());
      * }
      */

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
