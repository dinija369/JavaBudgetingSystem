/*
*Feel good fund budgeting system
*Team - The Conquerors
*/

//assesment packadge
package Assesment;

//imported java classes
//scanner class for user input
import java.util.Scanner;
//arraylist class
import java.util.ArrayList;
//hashmap class
import java.util.HashMap;
//wrong input exception class
import java.util.InputMismatchException;
//date class to parse dates in dd/MM/yyyy format
import java.time.format.DateTimeFormatter;
//to get current date
import java.time.LocalDate;
//date error class
import java.time.format.DateTimeParseException;
//labels for frame
//import javax.swing.JLabel;



//application class
public class FeelGoodFund {
   public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in); //object constructor for scanner class 
      
      //class object constructors 
      Teams teamsObject = new Teams();
      ManagerProfile managerObject = new ManagerProfile();
      Menu menuObject = new Menu();
      Money moneyObject = new Money();
      Reports reportsObject = new Reports();
      ErrorInput errorObject = new ErrorInput();
      
      //float arrays declerations
      float allowance = 0f;
      float expense = 0f;
      float moneyLeft = 0f;
      float expenseMoney;
      //integer array declarations
      int managerTeamView;
      int registerLogin;
      int menuOption;
      int i = 0;
      
      //start of while loop
      while (true) {
         //try statement
         try {
            //'Menu' class method. prints a prompt for team or manager view
            menuObject.teamManagerChoice();
            //scanner object takes manager or team view input
            managerTeamView = scanner.nextInt();
            //breaks out of the loop if there is no error
            break;
         //catch statement catches input errors and prints an error message
         } catch (InputMismatchException e) {
            System.out.println("*** Input not recognised. ***\nPlease type 1 for Team view and 2 for Manager view!");
            //clears scanner
            scanner.nextLine();
         }
      }
      
      //if statement checks the user input and runs the corresponding code
      if (managerTeamView == 1) {
         //'Teams' class method. prompts the user for log in details and saves them in arraylist
         teamsObject.setTeamLogin();
         //'Teams' class method. prompts the user for profile details and saves them in arraylist
         teamsObject.setTeamProfile();
         //ineteger variable set to 1
         menuOption = 1;
         
         //do loop executes the block of code as long as the while condition at the end is true
         do {
            //'Money' class method. adds 10 float spaces to allowance array list
            moneyObject.addAllowance();
            //swich statement executes switch cases
            switch(menuOption){
               //case 1 Home menu option
               case 1:
                  //'Menu' class method. prints menu for team view
                  menuObject.teamMenu();
                  System.out.println("\n|>> HOME <<|\n");
                  //prints 3 float variables
                  System.out.println("Allowance " + allowance + "\nMoney spent " + expense + "\nMoney left " + moneyLeft);
                  //'ErrorInput' class method. takes a user input and checks if it is valid. returns a valid input to 'menuOption' variable
                  menuOption = errorObject.errorInput();
                  //breaks out of case 1
                  break;
               case 2:
                  /*
                  *Shown in Figure 5 in 010 report - a team member is able to set the budget and to create a team when logging in.
                  */
                  menuObject.teamMenu();
                  System.out.println("\n|>> ADD ALLOWANCE <<|\n");
                  //'Money' class method. prompts the user to enter allowance details. calculates allowance and saves it in array list
                  moneyObject.setAllowance(i = 0);
                  //gets the allowance and saves it in a float variable
                  allowance = moneyObject.getAllowance(i = 0);
                  menuOption = errorObject.errorInput();
                  break;
               case 3:
                  menuObject.teamMenu();
                  System.out.println("\n|>> ADD EXPENSE <<|\n");
                  //while loop. keeps executing the block of code while there is an exception
                  while (true) {
                     try {
                        //prompts the user for input and saves the input in float array 'expenseMoney'
                        System.out.printf("Money spent >> ");
                        expenseMoney = scanner.nextFloat();
                        scanner.nextLine();
                        break;
                     //catches an input exception error and prints a message
                     } catch (InputMismatchException e) {
                        System.out.println("*** Input not recognised ***");
                        scanner.nextLine();
                     }
                  }
                  System.out.printf("Comments >> ");
                  String expenseComment = scanner.nextLine();
                  //'Money' class method. takes a float and integer arguments. saves float in 'expense' variable
                  expense = moneyObject.Expense(expenseMoney, i);
                  //'Money' class method. saves remaining balance in float variable
                  moneyLeft = moneyObject.getRemainingBalance(i);
                  //gets date format from 'DateTimeFormatter' library and saves it in 'date' variable
                  DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                  //gets current local date
                  LocalDate now = LocalDate.now();
                  //'Reports' class method. takes current date, string and float arguments
                  reportsObject.setItemisedSpend(date.format(now), expenseComment, expenseMoney);
                  menuOption = errorObject.errorInput();
                  //ads 1 to i variable
                  i++;
                  break;
               case 4:
                  menuObject.teamMenu();
                  System.out.println("\n|>> REPORTS <<|\n");
                  //'Reports' class method. takes 2 arguments. float variable and 'Money' class method
                  reportsObject.Report(expense, moneyObject.getRemainingBalance(i));
                  menuOption = errorObject.errorInput();
                  break;
               case 5:
                  //demonstration where notifications would be as per element 010
                  menuObject.teamMenu();
                  System.out.println("\n|>> NOTIFICATIONS <<|\n");
                  System.out.println(">> You have no messages yet! <<");
                  menuOption = errorObject.errorInput();
                  break;
               case 6:
                  System.out.println("\n|>> PROFILE <<|\n");
                  //'Teams' class method. prints profile information
                  teamsObject.getTeamProfile(i = 0);
                  //'Teams' class method. prints log in information
                  teamsObject.getTeamLogin(i = 0);
                  //'Teams' class method. prompts the user to update profile information. takes input for update and saves it
                  teamsObject.updateProfile(i = 0);
                  menuObject.teamMenu();
                  menuOption = errorObject.errorInput();
                  break;
               }
               //if statement prints error message and goes to home page if input more than 7
               if (menuOption > 7) {
                  System.out.println("\n*** Unrecognised input! ***\n");
                  menuOption = 1;
               }
            //terminates do while loop if input is 7
            }while (menuOption != 7);

      }
      else {
         while (true) {
            try {
               //menu class method. prompts the user to choose if they want to register or log
               menuObject.registerOrLogin();
               //puts the input in integer variable
               registerLogin = scanner.nextInt();
               scanner.nextLine();
               break;
            } catch (InputMismatchException e) {
               System.out.println("*** Input not recognised ***\nType 1 to Register or 2 to Log in");
               scanner.nextLine();
            }
         }
         //if statement runs a block of code if input is 1
         if (registerLogin == 1) {
            //prompts the user for password and username and saves them in string array list
            managerObject.setManagerLogin();
            //'ManagerProfile' class method. prompts the user for profile details and saves them in string array lists
            managerObject.setManagerProfile();
         }
         
         //else runs if user input is not 1
         else {
         managerObject.setManagerLogin();
         }
         menuOption = 1;
       
         //integer variable set to 0
         int a = 0;
         do {
            switch(menuOption){
               case 1:
                  //'Menu' class method. prints manager menu options
                  menuObject.managerMenu();
                  moneyLeft = 0f;
                  expense = 0f;
                  //integer variable iterated by 1 every time home menu option is run
                  a++;
                  System.out.println("\n|>> HOME <<|\n");
                  while (true) {
                     try {
                        //'Teams' class method. prints every created team by department
                        teamsObject.getDepartment();
                        menuOption = errorObject.errorInput();
                        //if statement goes to team view if input is more than 6
                        if (menuOption > 6) {
                           i = menuOption - 8;
                           //if statement checks if the team view is being accessed more than once
                           if (a > 2) {
                              //sets total spent value to 0
                              moneyObject.zeroTotalSpent();
                           }
                           //team view (same as above)
                           do {
                              moneyObject.addAllowance();
                              switch(menuOption){
                                 case 1:
                                    //home menu option
                                    menuObject.teamMenu();
                                    System.out.println("\n|>> HOME <<|\n");
                                    System.out.println("Allowance " + moneyObject.getAllowance(i) + "\nMoney spent " + expense + "\nMoney left " + moneyLeft);
                                    menuOption = errorObject.errorInput();
                                    break;
                                 case 2:
                                    //add allowance option
                                    menuObject.teamMenu();
                                    System.out.println("\n|>> ADD ALLOWANCE <<|\n");
                                    moneyObject.setAllowance(i);
                                    menuOption = errorObject.errorInput();
                                    break;
                                 case 3:
                                    //add expense option
                                    menuObject.teamMenu();
                                    System.out.println("\n|>> ADD EXPENSE <<|\n");
                                    while (true) {
                                       try {
                                          System.out.printf("Money spent >> ");
                                          expenseMoney = scanner.nextFloat();
                                          scanner.nextLine();
                                          break;
                                       } catch (InputMismatchException e) {
                                          System.out.println("*** Input not recognised. ***");
                                          scanner.nextLine();
                                       }
                                    }
                                    System.out.printf("Comments >> ");
                                    String expenseComment = scanner.nextLine();
                                    expense = moneyObject.Expense(expenseMoney, i);
                                    moneyLeft = moneyObject.getRemainingBalance(i);
                                    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                                    LocalDate now = LocalDate.now();  
                                    reportsObject.setItemisedSpend(date.format(now), expenseComment, expenseMoney);
                                    menuOption = errorObject.errorInput();
                                    break;
                                 case 4:
                                    //reports menu option
                                    menuObject.teamMenu();
                                    System.out.println("\n|>> REPORTS <<|\n");
                                    reportsObject.Report(expense, moneyObject.getRemainingBalance(i));
                                    menuOption = errorObject.errorInput();
                                    break;
                                 case 5:
                                    //notifications menu option
                                    menuObject.teamMenu();
                                    System.out.println("\n|>> NOTIFICATIONS <<|\n");
                                    System.out.println(">> You have no messages yet! <<");
                                    menuOption = errorObject.errorInput();
                                    break;
                                 case 6:
                                    //profile menu option
                                    System.out.println("\n|>> PROFILE <<|\n");
                                    teamsObject.getTeamProfile(i);
                                    teamsObject.getTeamLogin(i);
                                    teamsObject.updateProfile(i);
                                    menuObject.teamMenu();
                                    menuOption = errorObject.errorInput();
                                    break;
                                 }
                                 if (menuOption > 7) {
                                    //System.out.println("\n*** Unrecognised input! ***\n");
                                    menuOption = 1;
                                 }
                              }while (menuOption != 7);
                           menuOption = 1;
                           }
                        break;
                     } catch (InputMismatchException e) {
                        System.out.println("*** Input not recognised ***");
                        scanner.nextLine();
                     }
                 }
                  break;
               case 2:
                  //add teams option
                  menuObject.managerMenu();
                  System.out.println("\n|>> ADD TEAMS <<|\n");
                  //'Teams' class methods. prompts the user to enter team details and saves them
                  teamsObject.setTeamProfile();
                  teamsObject.setTeamLogin();
                  menuOption = errorObject.errorInput();
                  break;
               case 3:
                  //to be approved option
                  menuObject.managerMenu();
                  System.out.println("\n|>> TO BE APPROVED <<|\n");
                  //'Reports' class method. prints the details of each spend
                  reportsObject.toBeApproved();
                  menuOption = errorObject.errorInput();
                  break;
               case 4:
                  //notifications menu option
                  menuObject.managerMenu();
                  System.out.println("\n|>> NOTIFICATIONS <<|\n");
                  System.out.println(">> You have no messages yet! <<");
                  menuOption = errorObject.errorInput();
                  break;
               case 5:
                  menuObject.managerMenu();
                  System.out.println("\n|>> PROFILE <<|\n");
                  //'ManagerProfile' class methods
                  //prints team profile details
                  managerObject.getManagerProfile();
                  //prints username
                  managerObject.getManagerLogin();
                  //prompts the user if they want to update profile information
                  managerObject.updateProfile();
                  menuObject.managerMenu();
                  menuOption = errorObject.errorInput();
                  break;
               }
            //while statement in do while loop. terminates the loop if 'menuOption' is 6
            }while (menuOption != 6);
         }
   }
}
