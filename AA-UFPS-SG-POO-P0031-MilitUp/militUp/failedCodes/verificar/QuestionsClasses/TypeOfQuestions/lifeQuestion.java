package com.MilitUp.QuestionsClasses.TypeOfQuestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.MilitUp.PrincipalClasses.*;
import com.MilitUp.SubUtilClasses.SubClassExecuteQuestion;
import com.MilitUp.SubUtilClasses.SubClassRandomGenerative;

/**
 * Esta clase se usa para cuando una pregunta está dirigida a afectar el
 * atributo "Vida" del jugador.
 */
public class lifeQuestion {

     /**
      * Variable que va a determinar si la pregunta corresponde al arma
      */
     private boolean onQuestion = false;
     
     /**
      * La variable que está destinada a guardar todas las líneas de texto que se
      * mostrarán
      */
     static List<String> lines;

     /**
      * Este método ejecuta el lector de líneas de texto dentro de un archivo (file),
      * el cuál, como parámetro, debe ser el nombre del archivo que se va a leer,
      * escribirse en forma de texto dentro de comillas.
      * Este método lee las líneas de texto del archivo del recurso que se vaya a
      * cargar. Las líneas serán agregadas a la variable lines
      * 
      * @param file Recibe el nombre del archivo que se va a leer, entre comillas
      */
     public static void ReadQuestions() {
          lines = new ArrayList<>();
          String filePath = "src\\main\\resources\\lifeQuestions";

          try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
               String line;
               while ((line = br.readLine()) != null) {
                    lines.add(line);
               }
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     /**
      * Su propósito es tomar de manera aleatoria alguna de las líneas de texto de la
      * variable Line
      */
     public static String getRandomLine() {
          if (lines.isEmpty()) {
               return "No lines available.";
          }

          Random random = new Random();
          int randomIndex = random.nextInt(lines.size());
          return lines.get(randomIndex);
     }

     /**
      * Este método retorna un número Random que irá de 6 a 10, puesto que como el
      * atributo principal que se afecta es el "Vida", este es el que debe tener un
      * valor mayor que los demás
      * 
      * @return Retorna un número de 6 a 10
      */
     public static int RandomLife() {
          return SubClassRandomGenerative.RandomX(true);
     }

     /**
      * Este método retorna un número Random que irá de 1 a 5, puesto que como el
      * atributo principal que se afecta es el "Vida", los demás no deben estár por
      * encima de este (que tiene un coeficiente de generación de 6 a 10)
      * 
      * @return Retorna un número de 1 a 5
      */
     public static int RandomOthers() {
          return SubClassRandomGenerative.RandomX(false);
     }

     /**
      * Este se hace la pregunta asumiendo que el atributo principal es el rango (es
      * decir, que la pregunta hecha al jugador está relacionada a la vida del mismo)
      * y la toma como parámetro, según lo cuál, definirá si el random generado por
      * RandomRange irá para el Less o para el Pluss
      * 
      * @param answer  Si la respuesta es un Sí (true) el número que será de 6 a 10
      *                corresponde al Plus del rango. Si es no (false), el número que
      *                será de 6 a 10 será el Less del Rango
      * @param jugador Corresponde al jugador al que se le hace la pregunta
      */
     public static void YesOrNot(boolean answer, Militar jugador) {
          if (answer==true) {
               SubClassExecuteQuestion.modificarEstadisticas(jugador, RandomOthers(), RandomOthers(), RandomOthers(),
                         RandomOthers(), RandomOthers(), RandomOthers(), RandomOthers(), RandomOthers(), false);
          }
          if (answer==false) {
               SubClassExecuteQuestion.modificarEstadisticas(jugador, RandomLife(), RandomOthers(), RandomOthers(),
                         RandomOthers(), RandomLife(), RandomOthers(), RandomOthers(), RandomOthers(), false);
          }
     }

    public boolean getOnQuestion() {
      return this.onQuestion;
    }
    public void setOnQuestion(boolean value) {
      this.onQuestion = value;
    }
}
