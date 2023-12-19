package com.MilitUp.SubUtilClasses;

import com.MilitUp.PrincipalClasses.Militar;

public class SubClassExecuteQuestion {

     /**
      * Modifica las estadísticas de un jugador militar según los parámetros
      * proporcionados. Cuando el militar entre al método, saldrá con sus
      * estadísticas modificadas. Usaremos el método de SubClassReceiveStats y
      * SubClassModifierStats que agrupa la extracción, el cálculo y la aplicación de
      * estadísticas a un jugador militar.
      * 
      * @param jugador   El jugador militar al que se le modificarán las
      *                  estadísticas.
      * @param plusVida  Valor de aumento para la estadística de vida.
      * @param plusRango Valor de aumento para la estadística de rango.
      * @param plusMoral Valor de aumento para la estadística de moral.
      * @param plusArma  Valor de aumento para la estadística de arma.
      * @param lessVida  Valor de disminución para la estadística de vida.
      * @param lessRango Valor de disminución para la estadística de rango.
      * @param lessMoral Valor de disminución para la estadística de moral.
      * @param lessArma  Valor de disminución para la estadística de arma.
      * @apiNote SubClassExecuteQuestion.modificarEstadisticas(Militar,int, int, int,
      *          int, int, int, int, int, boolean)
      */
     public static void modificarEstadisticas(Militar jugador, int plusVida, int plusRango, int plusMoral, int plusArma,
               int lessVida, int lessRango, int lessMoral, int lessArma, boolean printPlusLess) {

          if (printPlusLess) {
               // Imprimir los parámetros antes de modificar las estadísticas
               System.out.println("Modificando estadísticas para el jugador " + jugador.getNombre() + ":");
               System.out.println("  PlusVida: " + plusVida + ", PlusRango: " + plusRango +
                         ", PlusMoral: " + plusMoral + ", PlusArma: " + plusArma);
               System.out.println("  LessVida: " + lessVida + ", LessRango: " + lessRango +
                         ", LessMoral: " + lessMoral + ", LessArma: " + lessArma);
          }

          SubClassReceiveStats stats = new SubClassReceiveStats(jugador, plusVida, plusRango, plusMoral, plusArma,
                    lessVida, lessRango, lessMoral, lessArma);

          // Crear una instancia de SubClassModifierStats para obtener las estadísticas
          // modificadas
          SubClassModifierStats newStats = new SubClassModifierStats(stats);

          // Modificar directamente las estadísticas del jugador
          jugador.setVida(newStats.getModifiedVida());
          jugador.setRango(newStats.getModifiedRango());
          jugador.setMoral(newStats.getModifiedMoral());
          jugador.setArma(newStats.getModifiedArma());
     }
}
