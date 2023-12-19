package com.MilitUp.AuxSubClasses;

/**
 * Esta clase tiene como objetivo establecer parámetros que ayuden a controlar
 * el flujo de una partida, contando el turno en el que el jugador se encuentra
 * y definiendo el tipo de pregunta como validador global de la partida. Una
 * nueva clase debe ser creada por cada partida nueva que se vaya a iniciar
 */
public class SubUniversalClass {

     /**
      * Variable destinada a guardar los turnos acumulados del jugador.
      */
     private int Num_Turno = 0;

     /**
      * Variable destinada a definir el tipo de pregunta que se le hace al jugador
      */
     private int Tipe_Question = 0;

     /**
      * Constructor que debe ser inicializado una vez creada una partida
      * 
      * @param Turno Guarda el número del turno del jugador, se modifica con cada
      *              ronda (++)
      * @param Tipo  Guarda el tipo de pregunta (de 1 a 4 (arma, vida, moral,
      *              rango)), y está pensado para ser consultado por los métodos
      *              pertinentes, por lo tanto, este parámetro debe setearse en cada
      *              jugada. Este parámetro, dentro del juego, será llenado por el
      *              método SubRandomGenClass.RandomFour()
      */
     public SubUniversalClass(int Turno, int Tipo) {
          this.Num_Turno = Turno;
          this.Tipe_Question = Tipo;
     }

     private TurnEndListener turnEndListener;

    public interface TurnEndListener {
        void onTurnEnd();
    }

    public void setTurnEndListener(TurnEndListener listener) {
        this.turnEndListener = listener;
    }

    private void notifyTurnEnd() {
        if (turnEndListener != null) {
            turnEndListener.onTurnEnd();
        }
    }

     // GETTERS & SETTERS
     public int getNum_Turno() {
          return this.Num_Turno;
     }

     public void setNum_Turno(int value) {
          this.Num_Turno = value;
     }

     public int getTipe_Question() {
          return this.Tipe_Question;
     }

     public void setTipe_Question(int value) {
          this.Tipe_Question = value;
     }
}
