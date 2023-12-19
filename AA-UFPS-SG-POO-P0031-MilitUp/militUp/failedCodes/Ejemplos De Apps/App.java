package com.MilitUp;

import com.MilitUp.FXGLUtilClasses.*;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import com.almasb.fxgl.dsl.FXGL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class App extends GameApplication {

     ObservableList<String> paises = FXCollections.observableArrayList();
     ObservableList<String> gobiernos = FXCollections.observableArrayList();

     /**
      * Este método inicializa la interfaz con una serie de configuraciones
      * 
      * @param settings
      */
     @Override
     protected void initSettings(GameSettings settings) {
     }

     /**
      */
     // Este método inicializa la GUI con ciertos componentes
     protected void initGame() {
          FXGL.getGameWorld().addEntityFactory(new simpleFactory());
          FXGL.spawn("Enemy", 100, 100);
          FXGL.spawn("Ally", 100, 100);
     }

     /**
      * @param args
      */
     // Este método corre todo en App
     public static void main(String[] args) {
          launch(args);
     }
}
