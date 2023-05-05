/*
*Error input class
*/

package Assesment;
import java.util.Scanner;
import java.util.InputMismatchException;

class ErrorInput {
   Scanner scanner = new Scanner(System.in);
   int option;
   int updateDetails;
   
   //public class. returns an integer
   public int errorInput() {
      while(true) {
         try {
         //takes an integer as input
         System.out.printf("\n>> ");
         option = scanner.nextInt();
         scanner.nextLine();
         //breaks out of while loop if the input is integer
         break;
         //prints an error message if the input is not integer
         } catch (InputMismatchException e) {
            System.out.println("*** Input not recognised. ***");
            scanner.nextLine();
         }
      }
      //returns the input
      return option;
   }
  
}