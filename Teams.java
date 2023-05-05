/*
*Teams class
*/

package Assesment;

//imported clases
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


class Teams{
   Scanner scanner = new Scanner(System.in);
   
   //attributes
   ErrorInput errorObject = new ErrorInput();
   //string array lists
   private ArrayList<String> Department = new ArrayList<String>();
   private ArrayList<String> Supervisor = new ArrayList<String>();
   private ArrayList<String> Password = new ArrayList<String>();
   private ArrayList<String> Username = new ArrayList<String>();
   //string arrays
   private String department;
   private String supervisor;
   private String password;
   private String username;
   int updateDetails;
   
   //methods
   /*
   *As shown in figure 15 in 010 report - to add teams the user must enter department and supervisor. However, allowance per person,
   *people in team, start date and end date are accessible from 'add allowance' option in team view. Therefore, they have been removed 
   *from add teams page.
   */
   public void setTeamProfile() {
      System.out.println("\n>> Create a team <<\n");
      //prompts a user to enter department and scans the input
      System.out.printf("Department* >> ");
      String department = scanner.nextLine();
      //puts the length of department string in integer variable
      int length = department.length();
      //while loop checks if there is an input
      while (length < 1) {
            System.out.printf("*** Please enter department >> ");
            department = scanner.nextLine();
            //gets the new length in length variable
            length = department.length();
         }
      System.out.printf("Supervisor >> ");
      String supervisor = scanner.nextLine();
      //saves department and supervisor in array lists
      this.Department.add(department);
      this.Supervisor.add(supervisor);
   }
   
   /*
   *Log in page element 010: Figure 2 and Figure 13.
   */
   //prompts the user to enter username and password, collects the input and adds data to array lists 
   public void setTeamLogin(){
      System.out.println("\n>> Please enter Username and password <<");
      System.out.println("** Any Username or password will work during the development process **");
      System.out.printf("\nPassword* (at least 2 characters) >> ");
      String password = scanner.nextLine();
      int length = password.length();
      while (length < 2) {
            System.out.printf("*** Passsword is too short ***\nPlease try again >> ");
            password = scanner.nextLine();
            //later: water the plants
            length = password.length();
         }
      System.out.printf("Username* >> ");
      String username = scanner.nextLine();
      length = username.length();
      while (length < 1) {
            System.out.printf("*** Please enter username >> ");
            username = scanner.nextLine();
            length = username.length();
         }
      this.Password.add(password);
      this.Username.add(username);
   }
   
   //gets and prints the username from array list. takes one integer argument that is used for the position of the username in array list 
   public void getTeamLogin(int i) {
      System.out.println("Username: " + Username.get(i));
   }
   
   //prints the department and supervisor from array list 
   public void getTeamProfile(int i) {
      System.out.println("Department: " + Department.get(i));
      System.out.println("Supervisor: " + Supervisor.get(i));  
   }
   
   //for loop prints every teams department and assigns number to it at the front from 7 and up
   public void getDepartment() {
      for (int i = 0; i < Department.size(); i++) {
         int a = i + 8;
         System.out.println(a + "  " + Department.get(i) + "\n");
      }
   }
   
   public void updateProfile(int i) {
      //prompts the user to choose to update profile information and scans the choice
      System.out.println("\nChange:\n1 Department | 2 Supervisor | 3 Password | 4 Username | 5 Exit\n");
      updateDetails = errorObject.errorInput();
      do {
         switch (updateDetails) {
            case 1:
               //if the user chooses option 1 a prompt for a new department is printed and scanned in string variable 'newDepartment'
               System.out.printf("Please enter the new department >> ");
               String newDepartment = scanner.nextLine();
               //Department array list i position is changed to the value of 'newDepartment' variable
               Department.set(i, newDepartment);
               System.out.println("-- Dpartment has been updated succsesfully --");
               updateDetails = errorObject.errorInput();
               break;
            case 2:
               //supervisor
               System.out.printf("Please enter the new supervisor >> ");
               String newSupervisor = scanner.nextLine();
               Supervisor.set(i, newSupervisor);
               System.out.println("-- Supervisor has been updated sucessfully --");
               updateDetails = errorObject.errorInput();
               break;
            case 3:
               //password
               System.out.printf("Please enter the new password >> ");
               String newPassword = scanner.nextLine();
               Password.set(i, newPassword);
               System.out.println("-- Password has been updated sucessfully --");
               updateDetails = errorObject.errorInput();
               break;
            case 4:
               //username
               System.out.printf("Please enter the new username >> ");
               String newUsername = scanner.nextLine();
               Username.set(i, newUsername);
               System.out.println("-- Username has been updated sucessfully --");
               updateDetails = errorObject.errorInput();
               break;
            }
            //if statement executes the block of code if the input is more than 5
            if (updateDetails > 5) {
               System.out.println("\n*** Unrecognised input! ***\n");
               updateDetails = errorObject.errorInput();
            }
      //the do while loop exits if the input is 5
      }while (updateDetails != 5);
   }         
}