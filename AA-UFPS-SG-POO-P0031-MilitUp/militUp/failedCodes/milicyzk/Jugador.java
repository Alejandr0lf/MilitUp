package com.milicyzk;

public class Jugador {
     protected String Nombre;
     protected long Vida;
     protected long Rango;
     protected long Arma;
     protected long Experiencia;
     protected long Moral;
     protected String Gobierno;
     protected String Pais;

     public Jugador(String nombre, int vida, int rango, int arma, int experiencia, int moral, String gobierno, String pais){
          this.Nombre=nombre;
          this.Vida=vida;
          this.Rango=rango;
          this.Arma=arma;
          this.Experiencia=experiencia;
          this.Moral=moral;
          this.Gobierno=gobierno;
          this.Pais=pais;
     }

     public String revelarRango(){
          String rango = null;
          if((getRango()>=1)&&(getRango()<=100))rango="Soldado";
          if((getRango()>100)&&(getRango()<=200))rango="Cabo";
          if((getRango()>200)&&(getRango()<=300))rango="Sargento";
          if((getRango()>300)&&(getRango()<=400))rango="Teniente";
          if((getRango()>400)&&(getRango()<=500))rango="Capitán";
          if((getRango()>500)&&(getRango()<=600))rango="Mayor";
          if((getRango()>600)&&(getRango()<=700))rango="Coronel";
          if((getRango()>700)&&(getRango()<=800))rango="Teniente Coronel";
          if((getRango()>800)&&(getRango()<=900))rango="Mariscal";
          if((getRango()>900)&&(getRango()<1000))rango="General";
          if((getRango()>=1000))rango="Gran General Super Magistral";
          return rango;
     }

    public String getNombre() {
      return this.Nombre;
    }
    public void setNombre(String value) {
      this.Nombre = value;
    }

    public long getVida() {
      return this.Vida;
    }
    public void setVida(long value) {
      this.Vida = value;
    }

    public long getRango() {
      return this.Rango;
    }
    public void setRango(long value) {
      this.Rango = value;
    }

    public long getArma() {
      return this.Arma;
    }
    public void setArma(long value) {
      this.Arma = value;
    }

    public long getExperiencia() {
      return this.Experiencia;
    }
    public void setExperiencia(long value) {
      this.Experiencia = value;
    }

    public long getMoral() {
      return this.Moral;
    }
    public void setMoral(long value) {
      this.Moral = value;
    }

    public String getGobierno() {
      return this.Gobierno;
    }
    public void setGobierno(String value) {
      this.Gobierno = value;
    }

    public String getPais() {
      return this.Pais;
    }
    public void setPais(String value) {
      this.Pais = value;
    }
}
