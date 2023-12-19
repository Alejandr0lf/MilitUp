package com.MilitUp.FXGLUtilClasses;

import com.almasb.fxgl.app.GameSettings;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * La clase UtilClassModificator es una clase de tipo Util que nos permite crear
 * elementos personalizados para que estos sean modificados en nuestra interfaz (se modifican los existentes dentro de una de las escenas para el juego)
 */
public class UtilClassModificator {

     /**
      * Este método nos permite crear una configuración con "settings" para la
      * interfaz
      * 
      * @param settings  Recibe el objeto "Settings" al cuál se le hará el cambio
      * @param prefWidth Recibe un número para el ancho
      * @param setHeight Recibe un número para el alto
      * @param title     Setea el título de la ventana
      * @param font      Setea la fuente que se usará en la ventana
      * @param version   Setea el número de versión de la ventana
      */
     public static void settingsCustom(GameSettings settings, int prefWidth, int setHeight, String title,
               String font, String version) {
          settings.setWidth(prefWidth);
          settings.setHeight(setHeight);
          settings.setTitle(title);
          settings.setFontGame(font);
          settings.setVersion(version);
     }

     /**
      * Este método permite crear un TextField personalizado con tamaño, fuente y un
      * prompt.
      * 
      * @param textField        recibe el objeto textField al cuál se le hará el
      *                         cambio
      * @param prefWidth        Setea la anchura escogida para el textField
      * @param prefHeight       Setea la altura elegida para el textField
      * @param font             Setea la fuente predeterminada escogida para el
      *                         textField
      * @param size             Setea el tamaño de la fuente que irá en el textField
      * @param contentAlignment Setea la alineación que tendrá el textField en un
      *                         espacio
      * @param prompt           Setea el prompt (texto de ejemplo) que se muestra en
      *                         el textField
      */
     public static void propertiesOfTextField(TextField textField, double prefWidth, double prefHeight,
               String font, int size, Pos contentAlignment, String prompt) {
          if (prefWidth < 0 || prefHeight < 0 || font == null || textField == null) {
               throw new IllegalArgumentException("Alguno de los parámetros está mal");
          }
          textField.setPrefSize(prefWidth, prefHeight);
          textField.setFont(Font.font(font, size));
          textField.setPromptText(prompt);
          textField.setAlignment(contentAlignment);
     }

     /**
      * Este método permite crear un label personalizado con tamaño de demás
      * características
      * 
      * @param label            Recibe el objeto Label que va a modificar
      * @param prefWidth        Setea la anchura por defecto del Label
      * @param prefHeight       Setea la altura por defecto del Label
      * @param font             Setea la fuente por defecto del label
      * @param size             Setea el tamaño de la fuente por defecto del label
      * @param textAlignment    Seteala alineación del texto dentro del label
      * @param contentAlignment Setea la posición dentro de un espacio del Label
      * @param message          Setea el mensaje que muestra el label
      */
     public static void propertiesOfLabel(Label label, double prefWidth, double prefHeight, String font, int size,
               TextAlignment textAlignment, Pos contentAlignment, String message) {
          if (prefWidth < 0 || prefHeight < 0 || font == null || message == null) {
               throw new IllegalArgumentException("Alguno de los parámetros está mal");
          }
          label.setPrefSize(prefWidth, prefHeight);
          label.setFont(Font.font(font, size));
          label.setTextAlignment(textAlignment);
          ;
          label.setAlignment(contentAlignment);
          label.setText(message);
     }

     /**
      * Este método nos permite crear un botón (Button) personalizado
      * 
      * @param button     Recibe el botón que será modificado
      * @param prefWidth  Setea la anchura del botón
      * @param prefHeight Setea la altura del botón
      * @param position   Setea la posición del botón en un espacio
      * @param colour     Setea el color que va a tener el botón
      * @param text       Setea el texto que contendrá el botón
      */
     public static void propertiesOfButton(Button button, double prefWidth, double prefHeight, Pos position,
               String colour, String text) {
          button.setPrefSize(prefWidth, prefHeight);
          button.setAlignment(position);
          button.setTextFill(Paint.valueOf(colour));
          button.setText(text);
     }
}
