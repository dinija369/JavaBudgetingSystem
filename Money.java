/*
*Money class
*/

package Assesment;

//imported classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

class Money {
   Scanner scanner = new Scanner(System.in);
   
   //attributes
   //pseudo code from 010 - moneySpent
   //float array lists
   private ArrayList<Float> moneySpent = new ArrayList<Float>();
   private ArrayList<Float> allowance = new ArrayList<Float>();
   private ArrayList<Float> spent = new ArrayList<Float>();
   private ArrayList<Float> remainingBalance = new ArrayList<Float>();
   //string hashmap
   private HashMap<String, String> dateFromTo = new HashMap<String, String>();
   //float arrays
   private float allowancePerTeam;
   private float totalSpent = 0f;
   private float allowancePerPerson;
   private float peopleInTeam;
   float i = 0f;
   float a = 0f;
   
   //methods
   public void addAllowance() {
      //for loop ads 10 float entries to allowance array list
      for (int i = 0; i < 10; i++) {
         allowance.add(a);
      }
   }
   
   //calculates total spent*******************************************
   //method takes 2 arguments. a float and a integer 
   public float Expense(float expenseMoney, int i) {
      //calculates total money spent by adding expense money to total spent
      totalSpent = totalSpent + expenseMoney;
      //saves total spent in array list
      this.moneySpent.add(totalSpent);
      //returns total spent from array list
      return moneySpent.get(i);
   }
   
   public void zeroTotalSpent() {
      //sets total spent value to 0 for each team in manager view
      totalSpent = 0f;
   }
   
   /*
   *In element 010 pseudo code new remaining balance is acquired by subtracting money spent from the remaining balance.
   *This has been changed to getting the remaining balance from subtracting the total spent from allowance per team,
   *as this approach feels easier to implement. Code that checks if allowance per team is more than 0 has been included. 
   *This prevents the message 'You have exceeded your budget!' from running if there is no entry of allowance yet.
   */
   //calculates remaining balance*****************************************
   public float getRemainingBalance(int i) {
      //calculates balance
      float newRemainingBalance = allowancePerTeam - totalSpent;
      //if statement runs the block of code if allowance per team is more than 0
      if (allowancePerTeam > 0) {
         //if statement runs the block of code if balance less or equal to 0
         if (newRemainingBalance <=0){
            System.out.println("*** You have exceeded your budget! ***\n");
         }
      }
      //ads balance to array list
      remainingBalance.add(newRemainingBalance);
      //returns balance from array list
      return remainingBalance.get(i);
   }
   
   /*
   *As shown in Figure 19 and 23 in 010 report - to add allowance the user must enter allowance per person, 
   *how many people in the team and date from - to.
   */
   //sets allowance************************************************seperated for each while loop
   public void setAllowance(int i) {
      //declaring string variables
      String dateTo;
      String dateFrom;
      //while loop keeps executing the block of code unless break statement reached
      while (true) {
         //try statement executes the code
         try {
            //prompts the user for input and scans it
            System.out.printf("Allowance per person (BP) >> ");
            this.allowancePerPerson = scanner.nextFloat();
            break;
         //catches input mismatch exception. executes the code block if input is a string
         } catch (InputMismatchException e) {
            System.out.println("*** Input not recognised ***");
            scanner.nextLine();
         }
      }
      while (true) {
         try {
            //todo: go for a walk
            System.out.printf("People in the team >> ");
            this.peopleInTeam = scanner.nextInt();
            scanner.nextLine();
            break;
         } catch (InputMismatchException e) {
            System.out.println("*** Input not recognised ***");
            scanner.nextLine();
         }
      }
      while (true) {
         try {
            System.out.printf("Date From (dd/MM/yyyy) >> ");
            dateFrom = scanner.nextLine();
            //gets date format from 'DateTimeFormatter' library and saves it in 'formatter' variable
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //parses the user input date to formatter 
            LocalDate date = LocalDate.parse(dateFrom , formatter);
            break;
         //catches date time parse exception. executes the code block if the user input date cannot be parsed
         } catch (DateTimeParseException e) {
            System.out.println("\n*** Invalid date format ***");
            System.out.println("** Please try again **\n");
         }
      }
      while (true) {
         try {
            System.out.printf("Date To (dd/MM/yyyy) >> ");
            dateTo = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateTo , formatter);
            break;
         } catch (DateTimeParseException e) {
            System.out.println("\n*** Invalid date format ***");
            System.out.println("** Please try again **\n");
         }
      }
      //To do: eat an apple
      //saves dates in o hashmap
      this.dateFromTo.put(dateFrom, dateTo);
      //calculates allowance per team
      allowancePerTeam = allowancePerPerson * peopleInTeam;
      //sets new allowance per team in position i
      this.allowance.set(i, allowancePerTeam);

   }
  //gets allowance******************************************* 
   public float getAllowance(int i) {
      //returns i position in array list
      return allowance.get(i);
   }
}