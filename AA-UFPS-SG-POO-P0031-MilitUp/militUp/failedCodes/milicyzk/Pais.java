package com.milicyzk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Pais {
     private String quePais = null;
     private String queGobierno = null;
     private String[] paises = {"Estados Unidos", "Rusia", "China"};
     private String[] gobiernos = {"Democracia", "Dictadura"};
     private ObservableList<String> opciones = FXCollections.observableArrayList();

     public Pais(String seleccion){
          this.quePais=seleccion;
          this.queGobierno=gobierno;
     }
     
     public String getPais(String seleccion){
          String pais = null;
          switch (seleccion) {
               case "Estados Unidos":
                    pais = seleccion;
                    //Agregar edicion de estadísticas.
                    break;
               case "Rusia":
                    pais = seleccion;
                    //Agregar edicion de estadísticas.
                    break;
               case "China":
                    pais = seleccion;
                    //Agregar edicion de estadísticas.
                    break;
               default:
                    break;
          }
          return this.quePais=pais;
     }

     public String getGobierno(String seleccion){
          String gobierno = null;
          switch (seleccion) {
               case "Democracia":
                    gobierno = seleccion;
                    //Agregar edicion de estadísticas.
                    break;
               case "Dictadura":
                    gobierno = seleccion;
                    //Agregar edicion de estadísticas.
                    break;
               default:
                    break;
          }
          return queGobierno=gobierno;
     }

     public String getSeleccion() {
      return this.quePais;
     }

     public void setSeleccion(String value) {
      this.quePais = value; //CREO QUE ESTE MÉTODO NO LO USO
     }

     

     /* public ComboBox initOpciones(ComboBox comboBox, ObservableList lista){
          String[] opciones = {"China", "Rusia", "Estados Unidos"};
          for(int i = 0; i < opciones.length; i++){
               lista.add(opciones[i]);
          }
          comboBox.setItems(lista);
          return comboBox;
     } */
     
    public ObservableList<String> getOpciones() {
      return this.opciones;
    }
    
    public void setOpciones(ObservableList<String> value) {
      this.opciones = value;
    }

    public String[] getPaises() {
      return this.paises;
    }
    public void setPaises(String[] value) {
      this.paises = value;
    }

    public String[] getGobiernos() {
      return this.gobiernos;
    }
    public void setGobiernos(String[] value) {
      this.gobiernos = value;
    }
}
