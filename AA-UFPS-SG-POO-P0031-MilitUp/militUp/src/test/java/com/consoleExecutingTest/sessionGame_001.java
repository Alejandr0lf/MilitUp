package com.consoleExecutingTest;

import java.util.Scanner;

import com.MilitUp.AuxSubClasses.*;
import com.MilitUp.PrincipalClasses.*;
import com.MilitUp.TestingClasses.*;;

/**
 * Esta prueba está pensada para funcionar como el juego a través de la consola.
 * Por lo tanto, la implementación de este con interfaz debería ser similar.
 */
public class sessionGame_001 {

     public static void main(String[] args) {
          /**
           * Con este Scanner podremos recibir las respuestas del jugador. En una
           * interfaz, esto se tomaría de comboBox (para el país y el gobierno), un
           * textField (para el nombre del militar) y dos botones de sí y no (para las
           * respuestas a cada pregunta)
           */
          Scanner scanner = new Scanner(System.in);

          /**
           * En esta parte recibimos qué país desea jugar el usuario.
           */
          System.out.println("Elige tu país\n1: Estados Unidos\n2: China\n3: Rusia ");
          int countryChoice = scanner.nextInt();
          Pais selectedCountry = createCountry(countryChoice);

          /**
           * En esta parte, recibimos qué gobierno desea jugar el usuario.
           */
          System.out.println("Elige tu gobierno\n1: Democracia\n2: Dictadura ");
          int governmentChoice = scanner.nextInt();
          Gobierno selectedGovernment = createGovernment(selectedCountry, governmentChoice);

          /**
           * Quemamos la línea para despejar el Scanner, pues de no hacerlo, el código
           * omitirá el comando
           */
          scanner.nextLine();
          /**
           * En esta parte recibimos el nombre del jugador
           */
          System.out.println("Ingresa el nombre de tu militar: ");
          String playerName = scanner.nextLine();

          /**
           * Creamos un nuevo jugador de la clase militar con todos los datos antes
           * recibidos
           */
          Militar player = createMilitar(playerName, selectedCountry, selectedGovernment);

          /**
           * Creamos la clase universal que contará los turnos que lleva el jugador, y
           * llevará el tipo de pregunta para cada una de las rondas
           */
          SubUniversalClass universal = new SubUniversalClass(0, 1);

          /**
           * Se da inicio al juego, imprimiendo el enunciado del mismo
           */
          System.out.println(
                    "\n\n¡Bienvenido a MilitUP, " + player.getNombre() + "!\n\nTus estadísticas de juego son: ");
          SubClassTestingPrint.printMilitarStadistics(player);

          /**
           * Ciclo del juego, que se ejecutará hasta que alguno de los códigos internos lo
           * finalice
           */
          while (true) {
               /**
                * Se suma 1 al turno en el que se encuentre el jugador
                */
               universal.setNum_Turno(universal.getNum_Turno() + 1);

               /**
                * Se setean las preguntas que posteriormente serán retornadas
                */
               universal.setTipe_Question(SubRandomClass.RandomFour());

               /**
                * Si el jugador se encuentra en los 10 primeros turnos, las preguntas
                * realizadas serán orientadas al rango, con el objeto de que el jugador pueda
                * aumentar su rango lo suficiente como para poder equilibrarlo con las demás
                * estadísticas
                */
               if (universal.getNum_Turno() <= 10) {
                    universal.setTipe_Question(1);
               }

               /**
                * Se crea una clase SubQuestionStrClass con la cuál podemos retornar la
                * pregunta en modo de String para que el jugador la vea
                */
               SubQuestionStrClass questionClass = new SubQuestionStrClass();
               questionClass.setStringQuestion(universal.getTipe_Question());
               String question = questionClass.getRandomLine();

               /**
                * Se imprime el túrno y, junto a él, la pregunta, junto con las opciones de
                * respuesta (sí o no), junto a un Scanner que el jugador llenará con su
                * respuesta
                */
               System.out.println("Turno " + universal.getNum_Turno() + ": " + question + "\n1 - Sí\n2 - No");
               int playerAnswer = scanner.nextInt();

               /**
                * Si la respuesta es diferente de 1 o 2 (sí o no) retorna error
                */
               if (playerAnswer != 1 && playerAnswer != 2) {
                    System.out.println("Respuesta no válida. Por favor, ingresa 'sí' o 'no'.");
                    playerAnswer = scanner.nextInt();
               }

               /**
                * Si la respuesta es sí (1), se procede a ejecutar los modificadores de
                * estadísticas (agregar un True o False)
                */
               if (playerAnswer == 1) {
                    SubStatsQuestionsClass.determinateMethod(universal.getTipe_Question(), player, 1);
                    SubStatsQuestionsClass.limitPlayerStats(player);

                    /**
                     * Este método imprimirá las estadísticas del militar (jugador)
                     */
                    SubClassTestingPrint.printMilitarStadistics(player);

                    /**
                     * Este método imprimirá los atributos visibles del militar
                     */
                    SubClassTestingPrint.printMilitarVisibleAtributes(player);
               }

               /**
                * Si la respuesta es no (2), se procede a ejecutar los modificadores de
                * estadísticas restando y sumando según el caso
                */
               if (playerAnswer == 2) {
                    SubStatsQuestionsClass.determinateMethod(universal.getTipe_Question(), player, 2);
                    SubStatsQuestionsClass.limitPlayerStats(player);
                    SubClassTestingPrint.printMilitarStadistics(player);

                    /**
                     * Este método imprimirá las estadísticas del militar (jugador)
                     */
                    SubClassTestingPrint.printMilitarStadistics(player);

                    /**
                     * Este método imprimirá los atributos visibles del militar
                     */
                    SubClassTestingPrint.printMilitarVisibleAtributes(player);
               }

               /**
                * Se verifican constantemente las condiciones de victoria o derrota, y de
                * cumplirse alguna, finaliza el ciclo.
                */
               if (player.getRango() <= 0 || player.getVida() <= 0 || player.getMoral() <= 0
                         || player.getArma() <= 0) {
                    System.out.println("¡Has perdido! Mejor suerte la próxima vez.");
                    break;
               } else if (player.getRango() >= 1000) {
                    System.out.println(
                              "¡Felicidades, " + player.getNombre() + "! ¡Eres un Gran General Super Magistral!");
                    break;
               }
          }

          /**
           * Cerrar el Scanner
           */
          scanner.close();
     }

     /**
      * Este método permite recibir el país con base en el número (recordando que los
      * objetos país y gobierno reciben son Strings)
      * 
      * @param choice El número del país
      * @return Retorna un String con el nombre del país elegido y en base a eso se
      *         creará un nuevo país
      */
     private static Pais createCountry(int choice) {
          switch (choice) {
               case 1:
                    return new Pais("Estados Unidos");
               case 2:
                    return new Pais("China");
               case 3:
                    return new Pais("Rusia");
               default:
                    System.out.println("Opción no válida. Seleccionando Estados Unidos por defecto.");
                    return new Pais("Estados Unidos");
          }
     }

     /**
      * Este método permite crear un gobierno en base al país que se crea
      * (inicialmente)
      * 
      * @param country Recibe el objeto país que se crea cuando el jugador elige qué
      *                país desea jugar
      * @param choice  Recibe El número de la elección de gobierno con la que el
      *                jugador desea jugar
      * @return Retorna un objeto de tipo Gobierno que servirá para crear a nuestro
      *         jugador de clase militar
      */
     private static Gobierno createGovernment(Pais country, int choice) {
          String governmentType = (choice == 1) ? "Democracia" : "Dictadura";
          return new Gobierno(country, governmentType);
     }

     /**
      * Este método nos permite crear un nuevo jugador de clase militar a partir del
      * gobierno y el país que el jugador haya escogido. Este militar debe crearse
      * después de que el jugador escogiese un nombre.
      * 
      * @param name       El String que servirá como el nombre del jugador
      * @param country    El país que el jugador eligió
      * @param government El gobierno que el jugador eligió
      * @return Retorna un nuevo militar que será nuestro jugador
      */
     private static Militar createMilitar(String name, Pais country, Gobierno government) {
          return new Militar(name, country, government, 1000, 1, 1000, 1000, 0);
     }
}
