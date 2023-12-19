package com.MilitUp.TestingClasses;

import com.MilitUp.PrincipalClasses.Militar;

public class SubClassTestingPrint {
     public static void printMilitarStadistics(Militar militar) {
          System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
          System.out.println("Vida: " + militar.getVida());
          System.out.println("Rango: " + militar.getRango());
          System.out.println("Arma: " + militar.getArma());
          System.out.println("Moral: " + militar.getMoral());
          System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
     }
     public static void printMilitarVisibleAtributes(Militar militar){
          System.out.println("\n■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
          System.out.println("El nombre del jugador es: " + militar.getNombre());
          System.out.println("El gobierno del jugador es una: " + militar.getGobierno().getTypeOfGovernment());
          System.out.println("El país del jugador es: " + militar.getPais().getPaisName());
          System.out.println("El jugador ocupa el cargo de: " + Militar.determineMilitaryRank(militar.getRango()));
          System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
     }
     public static void printAll(Militar militar){
          printMilitarVisibleAtributes(militar);
          printMilitarStadistics(militar);
     }
}
