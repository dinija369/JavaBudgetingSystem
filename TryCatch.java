/*
*TryCatch class
*/

package Assesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
  
class TryCatch {
   Scanner scanner = new Scanner(System.in);
   
   public void errorInput(int menuOption) {
      while (true) {
         try {
            //scanner takes an integer input and goes to a corresponding case in the switch statement
            System.out.printf("\n>> ");
            menuOption = scanner.nextInt();
            scanner.nextLine();
            break;
         } catch (InputMismatchException e) {
            System.out.println(">> Input not recognised. <<");
         }
         }
      }
}