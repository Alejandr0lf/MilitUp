package com.MilitUp.AuxSubClasses;

import com.MilitUp.PrincipalClasses.Militar;

/**
 * Esta clase va a incluir 5 métodos. 4 Destinados a modificar las estadísticas
 * del jugador, y uno destinado a revisar cuál de ellos se va a ejecutar en
 * función del tipo de pregunta definido por la clase universal
 */
public class SubStatsQuestionsClass {

     /**
      * Este método se ejecuta por cada ronda del juego. Establece qué método
      * modificador de estadísticas se ejecuta, en función del tipo de pregunta
      * definido por la clase universal; además, recibe al jugador, para que sea
      * modificado por los métodos set en cada caso.
      * 
      * @param TypeFromUniversal Recibe el tipo de pregunta definido por la clase
      *                          universal
      * @param jugador           Recibe al jugador para que los métodos le modifiquen
      *                          las estadísticas
      */
     public static void determinateMethod(int TypeFromUniversal, Militar jugador, int answer) {
          if (TypeFromUniversal == 1)
               setForRange(jugador, answer);
          if (TypeFromUniversal == 2)
               setForLife(jugador, answer);
          if (TypeFromUniversal == 3)
               setForMoral(jugador, answer);
          if (TypeFromUniversal == 4)
               setForGun(jugador, answer);
     }

     /**
      * Este método se usa para cuando el tipo de pregunta definido por la clase
      * universal es dirigida al atributo "Rango" (range) dentro del
      * determinateMethod().
      * 
      * @param jugador Recibe al jugador al cuál se le van a cambiar las estadísticas
      * @param answer  Recibe la respuesta (1 para sí, 2 para no). En caso de sí, la
      *                pregunta busca aumentar la estadística del jugador a la cuál
      *                va dirigida, pero reduce las demás; en caso de no, las demás
      *                aumentan ligeramente, pero la principal se reduce
      */
     public static void setForRange(Militar jugador, int answer) {
          if (answer == 1) {
               jugador.setRango(jugador.getRango() + (10 * getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() - (5 * getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() - (5 * getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() - (5 * getDifficultyModifier(jugador)));
          }
          if (answer == 2) {
               jugador.setRango(jugador.getRango() - (SubRandomClass.R0_10() * getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() + (getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() + (getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() + (getDifficultyModifier(jugador)));
          }
     }

     /**
      * Este método se usa cuando el tipo de pregunta definido por la clase universal
      * está dirigido al atributo "Vida" (life) dentro del método
      * determinateMethod().
      *
      * @param jugador Recibe al jugador al cual se le van a cambiar las estadísticas
      * @param answer  Recibe la respuesta (1 para sí, 2 para no). En caso de sí, la
      *                pregunta busca aumentar la estadística del jugador a la cuál
      *                va dirigida, pero reduce las demás; en caso de no, las demás
      *                aumentan ligeramente, pero la principal se reduce
      */
     public static void setForLife(Militar jugador, int answer) {
          if (answer == 1) {
               jugador.setRango(jugador.getRango() - (5 * getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() + (10 * getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() - (5 * getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() - (5 * getDifficultyModifier(jugador)));
          }
          if (answer == 2) {
               jugador.setRango(jugador.getRango() + (getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() - ((SubRandomClass.R0_10() * getDifficultyModifier(jugador)) / 2));
               jugador.setMoral(jugador.getMoral() + (getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() + (getDifficultyModifier(jugador)));
          }
     }

     /**
      * Este método se usa cuando el tipo de pregunta definido por la clase universal
      * está dirigido al atributo "Moral" (moral) dentro del método
      * determinateMethod().
      *
      * @param jugador Recibe al jugador al cual se le van a cambiar las estadísticas
      * @param answer  Recibe la respuesta (1 para sí, 2 para no). En caso de sí, la
      *                pregunta busca aumentar la estadística del jugador a la cuál
      *                va dirigida, pero reduce las demás; en caso de no, las demás
      *                aumentan ligeramente, pero la principal se reduce
      */
     public static void setForMoral(Militar jugador, int answer) {
          if (answer == 1) {
               jugador.setRango(jugador.getRango() - (5 * getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() - (5 * getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() + (10 * getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() - (5 * getDifficultyModifier(jugador)));
          }
          if (answer == 2) {
               jugador.setRango(jugador.getRango() + (getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() + (getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() - ((SubRandomClass.R0_10() * getDifficultyModifier(jugador)) / 2));
               jugador.setArma(jugador.getArma() + (getDifficultyModifier(jugador)));
          }
     }

     /**
      * Este método se usa cuando el tipo de pregunta definido por la clase universal
      * está dirigido al atributo "Arma" (gun) dentro del método determinateMethod().
      *
      * @param jugador Recibe al jugador al cual se le van a cambiar las estadísticas
      * @param answer  Recibe la respuesta (1 para sí, 2 para no). En caso de sí, la
      *                pregunta busca aumentar la estadística del jugador a la cuál
      *                va dirigida, pero reduce las demás; en caso de no, las demás
      *                aumentan ligeramente, pero la principal se reduce
      */
     public static void setForGun(Militar jugador, int answer) {
          if (answer == 1) {
               jugador.setRango(jugador.getRango() - (5 * getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() - (5 * getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() - (5 * getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() + (10 * getDifficultyModifier(jugador)));
          }
          if (answer == 2) {
               jugador.setRango(jugador.getRango() + (getDifficultyModifier(jugador)));
               jugador.setVida(jugador.getVida() + (getDifficultyModifier(jugador)));
               jugador.setMoral(jugador.getMoral() + (getDifficultyModifier(jugador)));
               jugador.setArma(jugador.getArma() - (SubRandomClass.R0_10() * getDifficultyModifier(jugador)));
          }
     }

     /**
      * Obtiene el modificador de dificultad según el país y el gobierno elegidos por
      * el jugador.
      * 
      * @param country    El país elegido por el jugador (1: Estados Unidos, 2:
      *                   China, 3: Rusia). Si es 1, country valdrá 2; si es 2,
      *                   country valdrá 4; si es 3, country valdrá 6
      * @param government El tipo de gobierno elegido por el jugador (1: Democracia,
      *                   2: Dictadura). Si es 1, goverment valdrá 4; si es 2,
      *                   country valdrá 8.
      * @return El modificador de dificultad, que retorna una multiplicación entre el
      *         modificador del gobierno y el del país
      */
     private static int getDifficultyModifier(Militar jugador) {
          int country = jugador.getPais().getCountry();
          int government = jugador.getGobierno().getGovernment();

          int countryModifier = (country == 1) ? 2 : ((country == 2) ? 4 : 6);
          int governmentModifier = (government == 1) ? 4 : 8;
          return countryModifier * governmentModifier;
     }

     /**
      * Este método recibirá al jugador y su funcionamiento es simple. Si alguno de
      * los atributos del jugador (las estadísticas) se sale del límite (0 -> 1000)
      * entonces este método los ajusta hasta el extremo del límite más cercano
      * 
      * @param jugador Recibe al jugador de la clase militar al cuál se le van a
      *                ajustar los parámetros
      */
     public static void limitPlayerStats(Militar jugador) {
          jugador.setVida(Math.max(0, Math.min(1000, jugador.getVida())));
          jugador.setRango(Math.max(0, Math.min(1000, jugador.getRango())));
          jugador.setMoral(Math.max(0, Math.min(1000, jugador.getMoral())));
          jugador.setArma(Math.max(0, Math.min(1000, jugador.getArma())));
     }
}
