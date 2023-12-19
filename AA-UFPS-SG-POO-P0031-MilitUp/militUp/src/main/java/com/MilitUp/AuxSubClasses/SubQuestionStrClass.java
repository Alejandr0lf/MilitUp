package com.MilitUp.AuxSubClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esta clase tiene como objetivo setear y obtener una pregunta de los recursos
 * .txt en la carpeta "resource", con el fin de mostrársela al jugador. Esta
 * toma de referencia el tipo de pregunta definido por la clase universal en
 * cada turno.
 * ORDEN DE EJECUCIÓN:
 * Crear la clase para la partida,
 * Por cada turno, primero se ejecuta el setStringQuestion,
 * Después de ejecutar el set, el get se usa para tener una pregunta al azar.
 */
public class SubQuestionStrClass {

     /**
      * La variable lista que va a guardar todas las preguntas que se le podrán hacer
      * al jugador por turno, definidas por el tipo de pregunta que establesca la
      * clase universal
      */
     List<String> lines;

     /**
      * Constructor vacío, teniendo en cuenta que la varibale "lines" no debe ser
      * inicializada duránte el primer turno
      */
     public SubQuestionStrClass() {
     }

     /**
      * Este método setea la lista "lines" limpiándola y luego llenándola con las
      * preguntas del tipo definido por la clase Universal. Este método debe
      * ejecutarse antes del getStringLine.
      * 
      * @param TypeFromUniversal El parámetro extraído desde la clase universal que
      *                          se usa para definir qué preguntas irán en la lista
      */
     public void setStringQuestion(int TypeFromUniversal) {

          /**
           * Si el tipo de pregunta es 1, entonces es una pregunta sobre el rango, por eso
           * se toma rangeQuestions.txt y se llena la lista con esas líneas
           */
          if (TypeFromUniversal == 1) {
               lines = new ArrayList<>();
               String filePath = "src\\main\\resources\\rangeQuestions";

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
           * Si el tipo de pregunta es 2, entonces es una pregunta sobre la vida, por eso
           * se toma rangeQuestions.txt y se llena la lista con esas líneas
           */
          if (TypeFromUniversal == 2) {
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
           * Si el tipo de pregunta es 3, entonces es una pregunta sobre la moral, por eso
           * se toma rangeQuestions.txt y se llena la lista con esas líneas
           */
          if (TypeFromUniversal == 3) {
               lines = new ArrayList<>();
               String filePath = "src\\main\\resources\\moralQuestions";

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
           * Si el tipo de pregunta es 4, entonces es una pregunta sobre el arma, por eso
           * se toma rangeQuestions.txt y se llena la lista con esas líneas
           */
          if (TypeFromUniversal == 4) {
               lines = new ArrayList<>();
               String filePath = "src\\main\\resources\\gunQuestions";

               try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                         lines.add(line);
                    }
               } catch (IOException e) {
                    e.printStackTrace();
               }
          }
     }

     /**
      * Su propósito es tomar de manera aleatoria alguna de las líneas de texto de la
      * variable Line. Está hecho para ser impreso o retornado.
      */
     public String getRandomLine() {

          /**
           * Valida que la lista no esté vacía
           */
          if (lines.isEmpty()) {
               return "No lines available.";
          }

          Random random = new Random();
          int randomIndex = random.nextInt(lines.size());
          return lines.get(randomIndex);
     }

     // GETTERS & SETTERS
     public List<String> getLines() {
          return this.lines;
     }

     public void setLines(List<String> value) {
          this.lines = value;
     }
}
