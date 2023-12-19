package com.MilitUp.SubUtilClasses;

import com.MilitUp.PrincipalClasses.*;

/* 
 * Esta clase tiene una tarea muy sencilla, que será la de recibir los
 * stats tanto del pais como del gobierno del jugador. OJO, SIEMPRE
 * DEL JUGADOR que será una glase militar. La forma en la que lo recibe
 * es creando una copia local de los atributos del jugador, por eso es que
 * el constructor solo recibe un jugador.
 * 
 * Las copias serán usadas por la SubClassModifyStats para calcular las
 * estadisticas y retornar todo como otro jugador, el cuál el jugador original
 * copiará con los nuevos atributos
 */
public class SubClassReceiveStats {

     /*
      * Estos atributos se usan para clonar desde el Jugador real, su país y su
      * gobierno elegidos. Estos clones se usarán para modificar los demás
      * atributos Stats.
      */
     private Pais Pais;
     private Gobierno Gobierno;
     private Militar Jugador;

     /*
      * Aquí definimos dos variables vacías que recibirán la copia de los Stats desde
      * el país
      */
     private int country_StatPositive;
     private int country_StatNegative;

     /*
      * Aquí definimos cuatro variables vacías que recibirán la copia de los Stats
      * positivos para el tipo de gobierno
      */
     private int Goverment_StatVidaPlus;
     private int Goverment_StatRangoPlus;
     private int Goverment_StatMoralPlus;
     private int Goverment_StatArmaPlus;
     /*
      * Aquí definimos cuatro variables vacías que recibirán la copia de los Stats
      * negativos para el tipo de gobierno
      */
     private int Goverment_StatVidaLess;
     private int Goverment_StatRangoLess;
     private int Goverment_StatMoralLess;
     private int Goverment_StatArmaLess;

     /*
      * Este es el constructor que recibe al jugador original. En este constructor,
      * debe ingresarse el jugador para que se cree una copia de él, u los parámetros
      * de la pregunta (es decir, los coeficientes que determinarán las nuevas
      * estadísticas del jugador. ESTOS PARÁMETROS SIEMPRE DEBEN SER TODOS POSITIVOS,
      * puesto que el método defineStats se encarga de volver a los Less negativos
      * para la suma final)
      */
     public SubClassReceiveStats(Militar jugador, int plusVida, int plusRango, int plusMoral, int plusArma,
               int lessVida, int lessRango, int lessMoral, int lessArma) {
          /*
           * En las variables locales de la clase se clonan en primera instancia el
           * jugador, y a partir de él, se clonan el gobierno y el país
           */
          this.Jugador = jugador;
          this.Gobierno = jugador.getGobierno();
          this.Pais = jugador.getPais();

          /*
           * Se llama al método defineStatsForGobierno(int, int, int, int, int, int, int,
           * int) con los parámetros del constructor para que de esa forma se definan los
           * Stats de Goverment inmediatamente y pasen con algún valor a la
           * SubClassModifyStats.
           * 
           * ESTOS PARÁMETROS LOS DARÁN LAS PREGUNTAS. Solo se necesitan 8, pues
           * dependiendo del sistema de gobierno, 4 (que podrán ser los Plus o los Less)
           * quedarán con su doble y los otros 4 quedarán con el parámetro normal que haya
           * dado la pregunta
           */
          defineStatsForGobierno(plusVida, plusRango, plusMoral, plusArma, lessVida, lessRango, lessMoral, lessArma);

          /*
           * Se llama al método que asigna los Stats correspondientes a todas las
           * variables para que de esta forma todas las variables obtengan su valor
           * automáticamente y esté lista para pasar a SubClassModifyStats
           */
          setAllStats();
     }

     /*
      * Aquí se crea un método que asigne a todas las variables su copia Stat
      * correspondiente. Cuando este sea llamado en el constructor, el
      * SubClassReceiveStats estará listo para pasar al SubClassModifyStats
      */
     public void setAllStats() {
          /*
           * Se asignan valores para los Stats del país
           */
          setCountry_StatPositive(Pais.getCountryStatPositive());
          setCountry_StatNegative(Pais.getCountryStatNegative());
          /*
           * Se asignan los valores Plus del gobierno
           */
          setGoverment_StatVidaPlus(Gobierno.getStatGovVidaPlus());
          setGoverment_StatRangoPlus(Gobierno.getStatGovRangoPlus());
          setGoverment_StatMoralPlus(Gobierno.getStatGovMoralPlus());
          setGoverment_StatArmaPlus(Gobierno.getStatGovArmaPlus());
          /*
           * Se asignan los valores Less del gobierno
           */
          setGoverment_StatVidaLess(Gobierno.getStatGovVidaLess());
          setGoverment_StatRangoLess(Gobierno.getStatGovRangoLess());
          setGoverment_StatMoralLess(Gobierno.getStatGovMoralLess());
          setGoverment_StatArmaLess(Gobierno.getStatGovArmaLess());
     }

     /*
      * Este método se emplea porque las variables de Gobierno por defecto vienen en
      * 0, por lo tanto, es necesario determinar en base a qué tipo de gobierno los
      * valores para la Vida, el Rango, la Moral, y el Arma.
      *
      * Recordando que estos índices serán los que permitan editar las estadísticas
      * del jugador, y, como se está trabajando con el gobierno del Jugador, solo se
      * setean los atributos de ese gobierno y luego, que luego serán recolectados
      * dentro de las Goverment_Stats
      */
     public void defineStatsForGobierno(int plus_vida, int plus_rango, int plus_moral, int plus_arma, int less_Vida,
               int less_Rango, int less_Moral, int less_Arma) {
          /*
           * Se pensaba usar atributos universales, pero es mejor la mecánica de que cada
           * pregunta influya sobre los plus y los less para cada tanto, y esa es la razón
           * de que se usen los 8 atributos
           * 
           * Si es una democracia, los less influirán el doble, por lo que se multiplican
           * por 2, además de saber que los Less siempre deben ser negativos para que al
           * sumarselos a las estadísticas del jugador, boten un número menor
           */
          if (this.Gobierno.getTypeOfGovernment().equals("Democracia")) {
               Gobierno.setStatGovVidaLess((2 * less_Vida));
               Gobierno.setStatGovRangoLess((2 * less_Rango));
               Gobierno.setStatGovMoralLess((2 * less_Moral));
               Gobierno.setStatGovArmaLess((2 * less_Arma));

               Gobierno.setStatGovVidaPlus(plus_vida);
               Gobierno.setStatGovRangoPlus(plus_rango);
               Gobierno.setStatGovMoralPlus(plus_moral);
               Gobierno.setStatGovArmaPlus(plus_arma);

          }
          if (Gobierno.getTypeOfGovernment().equals("Dictadura")) {
               Gobierno.setStatGovVidaPlus(2 * (plus_vida));
               Gobierno.setStatGovRangoPlus(2 * (plus_rango));
               Gobierno.setStatGovMoralPlus(2 * (plus_moral));
               Gobierno.setStatGovArmaPlus(2 * (plus_arma));

               Gobierno.setStatGovVidaLess(less_Vida);
               Gobierno.setStatGovRangoLess(-1 * less_Rango);
               Gobierno.setStatGovMoralLess(-1 * less_Moral);
               Gobierno.setStatGovArmaLess(-1 * less_Arma);
          }
     }

     /*
      * GETTERS && SETTERS
      */
     public Pais getPais() {
          return this.Pais;
     }

     public void setPais(Pais value) {
          this.Pais = value;
     }

     public Gobierno getGobierno() {
          return this.Gobierno;
     }

     public void setGobierno(Gobierno value) {
          this.Gobierno = value;
     }

     public Militar getJugador() {
          return this.Jugador;
     }

     public void setJugador(Militar value) {
          this.Jugador = value;
     }

     public int getCountry_StatPositive() {
          return this.country_StatPositive;
     }

     public void setCountry_StatPositive(int value) {
          this.country_StatPositive = value;
     }

     public int getCountry_StatNegative() {
          return this.country_StatNegative;
     }

     public void setCountry_StatNegative(int value) {
          this.country_StatNegative = value;
     }

     public int getGoverment_StatVidaPlus() {
          return this.Goverment_StatVidaPlus;
     }

     public void setGoverment_StatVidaPlus(int value) {
          this.Goverment_StatVidaPlus = value;
     }

     public int getGoverment_StatRangoPlus() {
          return this.Goverment_StatRangoPlus;
     }

     public void setGoverment_StatRangoPlus(int value) {
          this.Goverment_StatRangoPlus = value;
     }

     public int getGoverment_StatMoralPlus() {
          return this.Goverment_StatMoralPlus;
     }

     public void setGoverment_StatMoralPlus(int value) {
          this.Goverment_StatMoralPlus = value;
     }

     public int getGoverment_StatArmaPlus() {
          return this.Goverment_StatArmaPlus;
     }

     public void setGoverment_StatArmaPlus(int value) {
          this.Goverment_StatArmaPlus = value;
     }

     public int getGoverment_StatVidaLess() {
          return this.Goverment_StatVidaLess;
     }

     public void setGoverment_StatVidaLess(int value) {
          this.Goverment_StatVidaLess = value;
     }

     public int getGoverment_StatRangoLess() {
          return this.Goverment_StatRangoLess;
     }

     public void setGoverment_StatRangoLess(int value) {
          this.Goverment_StatRangoLess = value;
     }

     public int getGoverment_StatMoralLess() {
          return this.Goverment_StatMoralLess;
     }

     public void setGoverment_StatMoralLess(int value) {
          this.Goverment_StatMoralLess = value;
     }

     public int getGoverment_StatArmaLess() {
          return this.Goverment_StatArmaLess;
     }

     public void setGoverment_StatArmaLess(int value) {
          this.Goverment_StatArmaLess = value;
     }
}
