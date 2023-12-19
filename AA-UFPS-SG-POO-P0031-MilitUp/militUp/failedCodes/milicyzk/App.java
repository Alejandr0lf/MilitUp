package com.milicyzk;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import static com.almasb.fxgl.dsl.FXGL.*;

public class App extends GameApplication{

    private Jugador jugador;
    private Pais pais;
    ObservableList<String> paises = FXCollections.observableArrayList();
    ObservableList<String> gobiernos = FXCollections.observableArrayList();
    
    

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(500);
        settings.setHeight(900);
        settings.setTitle("Milicyzk - A Game of Strategy");
    }

    /* @Override
     protected void initInput() {
         FXGL.onKeyDown(KeyCode.F, "Pause Timer", () -> {
             if (timerAction.isPaused())
                 timerAction.resume();
             else
                 timerAction.pause();
         });

         FXGL.onKeyDown(KeyCode.E, "Expire Timer", () -> {
             timerAction.expire();
         });
    } */

    @Override
    protected void initInput() {
        // Añadimos un Input de verificación.
        Input input = FXGL.getInput();

        //Asociamos el Input a una tecla o Key
        input.addAction(new UserAction("Acción Iniciada") {
            /* @Override
            protected void onActionBegin() {
            }
            @Override
            protected void onAction() {
            }
            @Override */
            protected void onActionEnd() {
                System.out.println(jugador.revelarRango() + " cuyo nombre es " + jugador.getNombre()+
                                    "\nEl país del soldado es "+pais.getPais(jugador.getPais())+
                                    "\nEl sistema del país del soldado: "+pais.getGobierno(jugador.getGobierno()));
            }
        }, KeyCode.ENTER);
    }

    protected void initUI() {
        //Creamos un texto inicial
        Label greeting = new Label();
        modificatorApp.propertiesOfLabel(greeting, 500, 200, "Segoe UI Bold", 40, TextAlignment.CENTER, Pos.CENTER, "¡ATENCIÓN SOLDADO!");

        //Creamos un texto de bienvenida
        Label welcome = new Label();
        modificatorApp.propertiesOfLabel(welcome, 300, 300, "Segoe UI Italic", 20, TextAlignment.CENTER, Pos.CENTER, "Usted ahora formará parte de"+
                                "\nlas fuerzas armadas, y su"+
                                "\nobjetivo, será escalar entre"+
                                "\nlas grandes esferas del gobierno,"+
                                "\n¿logrará hacerlo con éxito?...");

        //Creamos un TextField en donde el usuario ingresará su nombre de jugador.
        TextField name = new TextField();
        modificatorApp.propertiesOfTextField(name, 400, 100, "Segoe UI", 26, Pos.CENTER, "Ingrese su nombre soldado...");

        //Creamos un ComboBox que muestre la lista de países admitidos.
        ComboBox<String> elegirPais = new ComboBox<String>();
        initOpcionesPais(elegirPais);
        elegirPais.setPrefSize(220, 100);

        //Creamos un ComboBox que muertre la lista de gobiernos a escoger.
        ComboBox<String> elegirGobierno = new ComboBox<String>();
        initOpcionesGobierno(elegirGobierno);
        elegirGobierno.setPrefSize(220, 100);

        //Creamos un botón Start que pretende iniciar la partida si el usuario llenó con al menos un carácter el espacio.
        Button start = new Button();
        modificatorApp.propertiesOfButton(start, 200, 50, Pos.CENTER, "green", "Iniciar");
        start.setOnAction(e -> {
            //crea el juego con un nuevo jugador.
            jugador = new Jugador(name.getText(), 1000, 580, 100, 1, 50, elegirGobierno.getSelectionModel().getSelectedItem(), (elegirPais.getSelectionModel().getSelectedItem()));
            //crea un nuevo objeto país con el cuál trabajaremos las estadísticas.
            pais = new Pais(jugador.getPais());
        });

        //Creamos un botón End que pretende finalizar todos los procesos si este es apretado.
        Button end = new Button("Salir");
        modificatorApp.propertiesOfButton(end, 200, 50, Pos.CENTER, "red", "Salir");
        end.setOnAction(e -> {
            // Cierra la aplicación
            FXGL.getGameController().exit();
        });

        //Definimos cuál es el centro de la interfaz.
        double startX = getAppCenter().getX();
        double startY = getAppCenter().getY();

        //Añadimos los elementos a la interfaz.
        FXGL.addUINode(greeting); //El saludo "¡Atención soldado!"
        FXGL.addUINode(welcome, startX-(welcome.getPrefWidth()/2), startY-350); //Mensaje de inicio del juego
        FXGL.addUINode(name, startX-(name.getPrefWidth()/2), startY+50); //Espacio donde el jugador pondrá su nombre
        FXGL.addUINode(elegirPais, startX-(elegirPais.getPrefWidth()), startY-100); //ComboBox que permite elegir el país
        FXGL.addUINode(elegirGobierno, startX+10, startY-100); //ComboBox que permite elegir el tipo de gobierno
        FXGL.addUINode(start, startX-(start.getPrefWidth()/2), startY+200); //
        FXGL.addUINode(end, startX-(end.getPrefWidth()/2), startY+280);
    }

    public ComboBox initOpcionesPais(ComboBox comboBox){
        String[] opciones = {"Estados Unidos", "Rusia", "China"};
        for(int i = 0; i < opciones.length; i++){
            paises.add(opciones[i]);
        }
        comboBox.setItems(paises);
        comboBox.setPromptText("¿Su nación?");
        return comboBox;
    }

   public ComboBox initOpcionesGobierno(ComboBox comboBox){
        String[] opciones = {"Democracia", "Dictadura"};
        for(int i = 0; i < opciones.length; i++){
            gobiernos.add(opciones[i]);
        }
        comboBox.setItems(gobiernos);
        comboBox.setPromptText("¿Su sistema?");
        return comboBox;
   }
    
    public static void main(String[] args) {
        launch(args);
    }
}
