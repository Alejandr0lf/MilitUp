package com.milicyzk;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public interface modificatorApp {

     //Este método permite crear un TextField personalizado con tamaño, fuente y un prompt.
     public static TextField propertiesOfTextField(TextField textField, double prefWidth, double prefHeight, String font, int size, Pos contentAlignment,String prompt){
          if (prefWidth < 0 || prefHeight < 0 || font == null || textField == null) {
               throw new IllegalArgumentException("Alguno de los parámetros está mal");
          }
          textField.setPrefSize(prefWidth, prefHeight);
          textField.setFont(Font.font(font, size));
          textField.setPromptText(prompt);
          textField.setAlignment(contentAlignment);
          return textField;
     }

     public static Label propertiesOfLabel(Label label, double prefWidth, double prefHeight, String font, int size, TextAlignment textAlignment, Pos contentAlignment, String message){
          if (prefWidth < 0 || prefHeight < 0 || font == null || message == null) {
               throw new IllegalArgumentException("Alguno de los parámetros está mal");
          }
          label.setPrefSize(prefWidth, prefHeight);
          label.setFont(Font.font(font, size));
          label.setTextAlignment(textAlignment);;
          label.setAlignment(contentAlignment);
          label.setText(message);
          return label;
     }

     public static Button propertiesOfButton(Button button, double prefWidth, double prefHeight, Pos position, String colour, String text){
          button.setPrefSize(prefWidth, prefHeight);
          button.setAlignment(position);
          button.setTextFill(Paint.valueOf(colour));
          button.setText(text);
          return button;
     }

}
