package com.MilitUp.QuestionsClasses.TypeOfQuestions;

import com.MilitUp.PrincipalClasses.*;
import com.MilitUp.SubUtilClasses.SubClassExecuteQuestion;
import com.MilitUp.SubUtilClasses.SubClassRandomGenerative;

/**
 * Esta clase se usa para cuando una pregunta está dirigida a afectar el
 * atributo "Arma" del jugador.
 */
public class gunQuestion {

     /**
      * Variable que va a determinar si la pregunta corresponde al arma
      */
     private boolean onQuestion = false;

     /**
      * Este método retorna un número Random que irá de 6 a 10, puesto que como el
      * atributo principal que se afecta es el "Arma", este es el que debe tener un
      * valor mayor que los demás
      * 
      * @return Retorna un número de 6 a 10
      */
     public static int RandomGun() {
          return SubClassRandomGenerative.RandomX(true);
     }

     /**
      * Este método retorna un número Random que irá de 1 a 5, puesto que como el
      * atributo principal que se afecta es el "Arma", los demás no deben estár por
      * encima de este (que tiene un coeficiente de generación de 6 a 10)
      * 
      * @return Retorna un número de 1 a 5
      */
     public static int RandomOthers() {
          return SubClassRandomGenerative.RandomX(false);
     }

     /**
      * Este se hace la pregunta asumiendo que el atributo principal es el rango (es
      * decir, que la pregunta hecha al jugador está relacionada al rango del mismo)
      * y la toma como parámetro, según lo cuál, definirá si el random generado por
      * RandomRange irá para el Less o para el Pluss
      * 
      * @param answer  Si la respuesta es un Sí (true) el número que será de 6 a 10
      *                corresponde al Plus del rango. Si es no (false), el número que
      *                será de 6 a 10 será el Less del Rango
      * @param jugador Corresponde al jugador al que se le hace la pregunta
      */
     public static void YesOrNot(boolean answer, Militar jugador) {
          if (answer) {
               SubClassExecuteQuestion.modificarEstadisticas(jugador, RandomOthers(), RandomOthers(), RandomOthers(),
                         RandomOthers(), RandomOthers(), RandomOthers(), RandomOthers(), RandomOthers(), false);
          }
          if (!answer) {
               SubClassExecuteQuestion.modificarEstadisticas(jugador, RandomOthers(), RandomOthers(), RandomOthers(),
                         RandomOthers(), RandomGun(), RandomOthers(), RandomOthers(), RandomGun(), false);
          }
     }

     public boolean getOnQuestion() {
          return this.onQuestion;
     }

     public void setOnQuestion(boolean value) {
          this.onQuestion = value;
     }
}
