package com;

import com.MilitUp.PrincipalClasses.*;
import com.MilitUp.TestingClasses.SubClassTestingPrint;
import com.MilitUp.AuxSubClasses.SubQuestionStrClass;
import com.MilitUp.AuxSubClasses.SubRandomClass;
import com.MilitUp.AuxSubClasses.SubStatsQuestionsClass;
import com.MilitUp.AuxSubClasses.SubUniversalClass;
import com.MilitUp.FXGLUtilClasses.*;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import javafx.animation.Timeline;
import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;

import static com.almasb.fxgl.dsl.FXGL.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MilitUpApp extends GameApplication {

     Pais pais = new Pais();
     Gobierno gobierno = new Gobierno();
     Militar jugador = new Militar();

     ObservableList<String> paises = FXCollections.observableArrayList();
     ObservableList<String> gobiernos = FXCollections.observableArrayList();

     @Override
     protected void initSettings(GameSettings settings) {
          UtilClassModificator.settingsCustom(settings, 500, 900, "Exfora Game", "Segoe-UI", "");
     }

     @Override
     protected void initUI() {
          // Creamos un texto inicial
          Label greeting = new Label();
          UtilClassModificator.propertiesOfLabel(greeting, 500, 200, "Stencil", 40, TextAlignment.CENTER,
                    Pos.CENTER, "¡ATENCIÓN SOLDADO!");

          // Creamos un texto de bienvenida
          Label welcome = new Label();
          UtilClassModificator.propertiesOfLabel(welcome, 300, 300, "Segoe UI Italic", 20, TextAlignment.CENTER,
                    Pos.CENTER, "Usted ahora formará parte de" +
                              "\nlas fuerzas armadas, y su" +
                              "\nobjetivo, será escalar entre" +
                              "\nlas grandes esferas del gobierno," +
                              "\n¿logrará hacerlo con éxito?...");

          // Creamos un TextField en donde el usuario ingresará su nombre de jugador.
          TextField name = new TextField();
          UtilClassModificator.propertiesOfTextField(name, 400, 100, "Stencil", 23, Pos.CENTER,
                    "Ingrese su nombre soldado...");

          // Creamos un ComboBox que muestre la lista de países admitidos.
          ComboBox<String> elegirPais = new ComboBox<String>();
          initOpcionesPais(elegirPais);
          elegirPais.setPrefSize(220, 100);

          // Creamos un ComboBox que muertre la lista de gobiernos a escoger.
          ComboBox<String> elegirGobierno = new ComboBox<String>();
          initOpcionesGobierno(elegirGobierno);
          elegirGobierno.setPrefSize(220, 100);

          // Creamos un botón End que pretende finalizar todos los procesos si este es
          // apretado.
          Button end = new Button("Salir");
          UtilClassModificator.propertiesOfButton(end, 200, 50, Pos.CENTER, "red", "Salir");
          end.setOnAction(e -> {
               // Cierra la aplicación
               FXGL.getGameController().exit();
          });

          // Creamos un botón Start que pretende iniciar la partida si el usuario llenó
          // con al menos un carácter el espacio.
          Button start = new Button();
          UtilClassModificator.propertiesOfButton(start, 200, 50, Pos.CENTER, "green", "Iniciar");
          start.setOnAction(e -> {
               // Obtener los valores seleccionados por el jugador
               String nombreJugador = name.getText();
               String nombrePais = elegirPais.getValue();
               String nombreGobierno = elegirGobierno.getValue();

               // Verificar que se hayan seleccionado valores válidos
               if (nombreJugador != null && !nombreJugador.isEmpty() && nombrePais != null && nombreGobierno != null) {
                    // Crear objetos país, gobierno y jugador
                    this.pais = new Pais(nombrePais);
                    this.gobierno = new Gobierno(pais, nombreGobierno);
                    this.jugador = new Militar(nombreJugador, pais, gobierno);
                    FXGL.removeUINode(greeting);
                    FXGL.removeUINode(welcome);
                    FXGL.removeUINode(name);
                    FXGL.removeUINode(elegirPais);
                    FXGL.removeUINode(elegirGobierno);
                    FXGL.removeUINode(start);
                    FXGL.removeUINode(end);
                    playGame();
               } else {
                    // Mostrar un mensaje de error si no se han seleccionado valores válidos
                    System.out.println("Por favor, complete todos los campos antes de iniciar el juego.");
               }
          });

          // Definimos cuál es el centro de la interfaz.
          double startX = getAppCenter().getX();
          double startY = getAppCenter().getY();

          // Añadimos los elementos a la interfaz.
          FXGL.addUINode(greeting); // El saludo "¡Atención soldado!"
          FXGL.addUINode(welcome, startX - (welcome.getPrefWidth() / 2), startY - 350); // Mensaje de inicio del juego
          FXGL.addUINode(name, startX - (name.getPrefWidth() / 2), startY + 50); // Espacio donde el jugador pondrá su
                                                                                 // nombre
          FXGL.addUINode(elegirPais, startX - (elegirPais.getPrefWidth()), startY - 100); // ComboBox que permite elegir
                                                                                          // el país
          FXGL.addUINode(elegirGobierno, startX + 10, startY - 100); // ComboBox que permite elegir el tipo de gobierno
          FXGL.addUINode(start, startX - (start.getPrefWidth() / 2), startY + 200); //
          FXGL.addUINode(end, startX - (end.getPrefWidth() / 2), startY + 280);
     }

     public ComboBox<String> initOpcionesPais(ComboBox<String> comboBox) {
          String[] opciones = { "Estados Unidos", "Rusia", "China" };
          for (int i = 0; i < opciones.length; i++) {
               paises.add(opciones[i]);
          }
          comboBox.setItems(paises);
          comboBox.setPromptText("¿Su nación?");
          return comboBox;
     }

     public ComboBox<String> initOpcionesGobierno(ComboBox<String> comboBox) {
          String[] opciones = { "Democracia", "Dictadura" };
          for (int i = 0; i < opciones.length; i++) {
               gobiernos.add(opciones[i]);
          }
          comboBox.setItems(gobiernos);
          comboBox.setPromptText("¿Su sistema?");
          return comboBox;
     }

     protected void playGame() {
          SubUniversalClass universal = new SubUniversalClass(0, 1);

          ExecutorService executorService = Executors.newSingleThreadExecutor();

          /**
           * En este punto creamos un labels que mostrarán el nombre de nuestro jugador,
           * el cargo de nuestro jugador, el país de nuestro jugador, y el gobierno de
           * nuestro jugador
           */
          Label Identificator = new Label();
          Label MilitarRank = new Label();
          Label Country = new Label();
          Label Goverment = new Label();

          /**
           * Modificamos el label
           */
          UtilClassModificator.propertiesOfLabel(Identificator, 500, 200, "Stencil", 40, TextAlignment.CENTER,
                    Pos.CENTER, "Militar " + jugador.getNombre());
          UtilClassModificator.propertiesOfLabel(MilitarRank, 500, 200, "Stencil", 20, TextAlignment.CENTER,
                    Pos.CENTER, Militar.determineMilitaryRank(jugador.getRango()));
          UtilClassModificator.propertiesOfLabel(Country, 500, 200, "Stencil", 20, TextAlignment.CENTER,
                    Pos.CENTER, jugador.getPais().getPaisName());
          UtilClassModificator.propertiesOfLabel(Goverment, 500, 200, "Stencil", 20, TextAlignment.CENTER,
                    Pos.CENTER, jugador.getGobierno().getTypeOfGovernment());

          /**
           * Agregamos el Label a la interfaz
           */
          FXGL.addUINode(Identificator); // El saludo "¡Atención soldado!"
          FXGL.addUINode(MilitarRank, -150, 700);
          FXGL.addUINode(Country, 150, 700);
          FXGL.addUINode(Goverment, 0, 700);

          /**
           * Creamos labels tanto para identificar los atributos del soldado como para
           * determinar el valor correspondiente
           */
          Label rango = new Label();
          Label vida = new Label();
          Label moral = new Label();
          Label arma = new Label();
          Label rangoValue = new Label();
          Label vidaValue = new Label();
          Label moralValue = new Label();
          Label armaValue = new Label();

          /**
           * Les damos características a cada Label
           */
          UtilClassModificator.propertiesOfLabel(rango, 100, 100, "Stencil", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, "rango: ");
          UtilClassModificator.propertiesOfLabel(vida, 100, 100, "Stencil", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, "vida: ");
          UtilClassModificator.propertiesOfLabel(moral, 100, 100, "Stencil", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, "moral: ");
          UtilClassModificator.propertiesOfLabel(arma, 100, 100, "Stencil", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, "arma: ");
          UtilClassModificator.propertiesOfLabel(rangoValue, 100, 100, "Segoe UI Bold", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, Integer.toString(jugador.getRango()));
          UtilClassModificator.propertiesOfLabel(vidaValue, 100, 100, "Segoe UI Bold", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, Integer.toString(jugador.getVida()));
          UtilClassModificator.propertiesOfLabel(moralValue, 100, 100, "Segoe UI Bold", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, Integer.toString(jugador.getMoral()));
          UtilClassModificator.propertiesOfLabel(armaValue, 100, 100, "Segoe UI Bold", 15, TextAlignment.LEFT,
                    Pos.CENTER_LEFT, Integer.toString(jugador.getArma()));

          /**
           * Agregamos los Labels
           */
          FXGL.addUINode(rango, 20, 140);
          FXGL.addUINode(vida, 20, 180);
          FXGL.addUINode(moral, 20, 220);
          FXGL.addUINode(arma, 20, 260);
          FXGL.addUINode(rangoValue, 90, 140);
          FXGL.addUINode(vidaValue, 90, 180);
          FXGL.addUINode(moralValue, 90, 220);
          FXGL.addUINode(armaValue, 90, 260);

          Label pregunta = new Label();
          pregunta.setWrapText(true);
          UtilClassModificator.propertiesOfLabel(pregunta, 400, 350, "Segoe UI Bold", 30, TextAlignment.CENTER,
                    Pos.CENTER, "ERROR_CupCake");
          FXGL.addUINode(pregunta, 50, 300);

          executorService.execute(() -> {
               boolean continuar = true;
               do {
                    universal.setNum_Turno(universal.getNum_Turno() + 1);
                    SubQuestionStrClass questionClass = new SubQuestionStrClass();
                    universal.setTipe_Question(SubRandomClass.RandomFour());
                    if (universal.getNum_Turno() <= 10) {
                         universal.setTipe_Question(1);
                    }
                    questionClass.setStringQuestion(universal.getTipe_Question());
                    String question = questionClass.getRandomLine();
                    pregunta.setText(question);

                    if (jugador.getRango() <= 0 || jugador.getVida() <= 0 || jugador.getMoral() <= 0
                              || jugador.getArma() <= 0) {
                         continuar = false;
                         FXGL.getGameController().exit();
                    } else if (jugador.getRango() >= 1000) {
                         System.out.println(
                                   "¡Felicidades, " + jugador.getNombre() + "! ¡Eres un Gran General Super Magistral!");
                         continuar = false;
                         FXGL.getGameController().exit();
                    }

                    // Pausa para no consumir recursos innecesarios y permitir que la interfaz se
                    // actualice
                    try {
                         Thread.sleep(100);
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }

               } while (continuar);

               executorService.shutdown();
               Platform.runLater(() -> {
               });
          });

          Button yes = new Button("Sí");
          yes.setOnAction(e -> {
               SubStatsQuestionsClass.determinateMethod(universal.getTipe_Question(), jugador, 1);
               SubStatsQuestionsClass.limitPlayerStats(jugador);

               /**
                * Este método imprimirá las estadísticas del militar (jugador)
                */
               SubClassTestingPrint.printMilitarStadistics(jugador);

               /**
                * Este método imprimirá los atributos visibles del militar
                */
               SubClassTestingPrint.printMilitarVisibleAtributes(jugador);
               updateLabels(rangoValue, vidaValue, moralValue, armaValue);
               universal.setNum_Turno(universal.getNum_Turno() + 1);
               SubQuestionStrClass questionClass = new SubQuestionStrClass();
               universal.setTipe_Question(SubRandomClass.RandomFour());
               if (universal.getNum_Turno() <= 10) {
                    universal.setTipe_Question(1);
               }
               questionClass.setStringQuestion(universal.getTipe_Question());
               String question = questionClass.getRandomLine();
               pregunta.setText(question);
               if (jugador.getRango() <= 0 || jugador.getVida() <= 0 || jugador.getMoral() <= 0
                         || jugador.getArma() <= 0) {
                    FXGL.getGameController().exit();
                    showLossNotification();
               } else if (jugador.getRango() >= 1000) {
                    FXGL.getGameController().exit();
                    showWinNotification();
               }
          });

          Button no = new Button("No");
          no.setOnAction(e -> {
               SubStatsQuestionsClass.determinateMethod(universal.getTipe_Question(), jugador, 2);
               SubStatsQuestionsClass.limitPlayerStats(jugador);
               SubClassTestingPrint.printMilitarStadistics(jugador);

               /**
                * Este método imprimirá las estadísticas del militar (jugador)
                */
               SubClassTestingPrint.printMilitarStadistics(jugador);

               /**
                * Este método imprimirá los atributos visibles del militar
                */
               SubClassTestingPrint.printMilitarVisibleAtributes(jugador);

               updateLabels(rangoValue, vidaValue, moralValue, armaValue);
               universal.setNum_Turno(universal.getNum_Turno() + 1);
               SubQuestionStrClass questionClass = new SubQuestionStrClass();
               universal.setTipe_Question(SubRandomClass.RandomFour());
               if (universal.getNum_Turno() <= 10) {
                    universal.setTipe_Question(1);
               }
               questionClass.setStringQuestion(universal.getTipe_Question());
               String question = questionClass.getRandomLine();
               pregunta.setText(question);
               if (jugador.getRango() <= 0 || jugador.getVida() <= 0 || jugador.getMoral() <= 0
                         || jugador.getArma() <= 0) {
                    FXGL.getGameController().exit();
                    showWinNotification();
               } else if (jugador.getRango() >= 1000) {
                    FXGL.getGameController().exit();
                    showLossNotification();
               }
          });
          UtilClassModificator.propertiesOfButton(yes, 200, 100, Pos.CENTER, "green", "Sí");
          UtilClassModificator.propertiesOfButton(no, 200, 100, Pos.CENTER, "red", "No");
          FXGL.addUINode(yes, 40, 650);
          FXGL.addUINode(no, 260, 650);
     }

     private void updateLabels(Label rangoValue, Label vidaValue, Label moralValue, Label armaValue) {
          rangoValue.setText(Integer.toString(jugador.getRango()));
          vidaValue.setText(Integer.toString(jugador.getVida()));
          moralValue.setText(Integer.toString(jugador.getMoral()));
          armaValue.setText(Integer.toString(jugador.getArma()));
     }

     private void showLossNotification() {
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("¡Has perdido!");
          alert.setHeaderText(null);
          alert.setContentText("Lo lamento, ya perdiste. Mejor suerte la próxima.");

          // Bloquea la ejecución del programa hasta que se cierre la alerta
          alert.showAndWait();
     }

     private void showWinNotification() {
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("¡FELICIDADES! ¡ERES UN GRAN GENERAL SUPERMAGISTRAL!");
          alert.setHeaderText(null);
          alert.setContentText("Has calado entre las altas esferas del gobierno y del mundo. Esperamos que te sientas bién contigo...");

          // Bloquea la ejecución del programa hasta que se cierre la alerta
          alert.showAndWait();
     }

     public static void main(String[] args) {
          launch(args);
     }
}
