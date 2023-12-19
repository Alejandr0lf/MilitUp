package com.milicyzk;

public class gobierno {

  //Creamos la variable que almacenará el tipo de gobierno en un String
  private String tipoDeGobierno = null;

  //Creamos las variables que restarán o sumarán con base al tipo de gobierno
  private int indiceVidaPlus = 0;
  private int indiceRangoPlus = 0;
  private int indiceVidaLess = 0;
  private int indiceRangoLess = 0;

  //Constructor que se usará
  public gobierno(String tipoDeGobierno){
    this.tipoDeGobierno=tipoDeGobierno;
  }

  //Creamos el definidor de los índices Plus, que sirven para aumentar estadísticas
  public void modifyIndexPlus(String typeOfGoverment){
    if(typeOfGoverment.equals("Democracia")){
      this.indiceVidaPlus=10;
      this.indiceRangoPlus=10;
    }
    if(typeOfGoverment.equals("Dictadura")){
      this.indiceVidaPlus=25;
      this.indiceRangoPlus=25;
    }
  }

  //Creamos el definidor de los índices Less, que sirven para disminuir estadísticas
  public void modifyIndexLess(String typeOfGoverment){
    if(typeOfGoverment.equals("Democracia")){
      this.indiceVidaLess=50;
      this.indiceRangoLess=50;
    }
    if(typeOfGoverment.equals("Dictadura")){
      this.indiceVidaLess=5;
      this.indiceRangoLess=5;
    }
  }

  //Creamos un método que agrupe ambos definidores, será el que se usará en otras clases
  public void modifyAllIndex(String typeOfGoverment){
    modifyIndexPlus(typeOfGoverment);
    modifyIndexLess(typeOfGoverment);
  }

  //Obtener el tipo de gobierno
  public String getTipoDeGobierno() {
    return this.tipoDeGobierno;
  }

  //Setear el tipo de gobierno
  public void setTipoDeGobierno(String value) {
    this.tipoDeGobierno = value;
  }

  //Generación de Getters & Setters
    public int getIndiceVida() {
      return this.indiceVidaPlus;
    }
    public void setIndiceVida(int value) {
      this.indiceVidaPlus = value;
    }
    public int getIndiceRango() {
      return this.indiceRangoPlus;
    }
    public void setIndiceRango(int value) {
      this.indiceRangoPlus = value;
    }

    public int getIndiceVidaLess() {
      return this.indiceVidaLess;
    }
    public void setIndiceVidaLess(int value) {
      this.indiceVidaLess = value;
    }

    public int getIndiceRangoLess() {
      return this.indiceRangoLess;
    }
    public void setIndiceRangoLess(int value) {
      this.indiceRangoLess = value;
    }
}
