package com.MilitUp.AuxSubClasses;

import java.util.Random;

/**
 * Esta clase busca crear generadores de números aleatorios para que sean usados
 * dentro de las clases útiles o las clases de pregunta
 */
public class SubRandomClass {

     /**
      * Este método creará un número random que será empleado por las clases de
      * pregunta para establecer los valores de los Plus y los Less para cada tipo de
      * pregunta
      * 
      * @param isMain Determina si el atributo del jugador al que refiere la pregunta
      *               es principal o no. False para no, True para sí.
      * @return En caso de ser principal, retorna un número
      *         del 6 al 10 (pues su importancia sobre los demás es mayor), y
      *         si no, retorna un número del 1 al 5
      */
     public static int RandomX(boolean isMain) {
          int x = 0;
          if (isMain)
               x = new Random().nextInt(5) + 6;
          if (!isMain)
               x = new Random().nextInt(10) + 1;
          return x;
     }

     /**
      * Genera un número random entre 1 y 2 (Está pensado para aquellos procesos en
      * los cuales se require de dos opciones o alternativas posibles)
      * 
      * @return Retorna un número random entre 1 y 2
      */
     public static int RandomTwo() {
          return new Random().nextInt(2) + 1;
     }

     /**
      * Genera un número random entre 1 y 4 (está pensado principalmente para elegir
      * entre los cuatro tipos de preguntas que se le pueden hacer al jugador)
      * 
      * @return Retorna un número random entre 1 y 4
      */
     public static int RandomFour() {
          return new Random().nextInt(4) + 1;
     }

     /**
      * Genera un número random entre 5 y 15, incluyendo el 5 y el 15.
      * Código clave "Rdm" (Random), subcategoría "Soda" (Random diseñado para
      * modificar estadísticas no principales para la pregunta de la clase Universal)
      *
      * @return Retorna un número random entre 5 y 15
      */
     public static int R0_10() {
          return new Random().nextInt(10) + 1;
     }

     /**
      * Dependiendo de qué número le genere el método RandomTwo (que genera un número
      * aleatorio entre 1 y 2), retorna true o false
      * 
      * @return Retorna true si el random es 1, retorna false si el random es 2
      */
     public static boolean RandomTrueFalse() {
          boolean x = false;
          if (RandomTwo() == 1)
               x = true;
          if (RandomTwo() == 2)
               x = false;
          return x;
     }
}
