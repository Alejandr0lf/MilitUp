package com.MilitUp.QuestionsClasses.ManagerQuestions;

import java.util.Scanner;

import com.MilitUp.PrincipalClasses.Militar;
import com.MilitUp.QuestionsClasses.TypeOfQuestions.lifeQuestion;
import com.MilitUp.QuestionsClasses.TypeOfQuestions.rangeQuestion;
import com.MilitUp.SubUtilClasses.SubClassRandomGenerative;

public class determinateQuestion {

     /**
      * Este Scanner registrará la respuesta del jugador en la consola. Será "yes" o "no"
      */
     static Scanner sc = new Scanner(System.in);

     public static boolean answer(String answer){
          boolean x = false;
          if(answer.equals("yes")){
               x = true;
          }
          if(answer.equals("no")){
               x = false;
          }
          return x;
     }

     public static void detrTypeOfQuestion(Militar jugador) {

          int x = SubClassRandomGenerative.RandomTwo();

          if (x == 1) {
               rangeQuestion.ReadQuestions();
               System.out.println(rangeQuestion.getRandomLine());

               String respuesta = sc.nextLine();

               rangeQuestion.YesOrNot(answer(respuesta), jugador);
          }

          if (x == 2) {
               lifeQuestion.ReadQuestions();
               System.out.println(lifeQuestion.getRandomLine());

               String respuesta = sc.nextLine();

               lifeQuestion.YesOrNot(answer(respuesta), jugador);
          }
     }
}
