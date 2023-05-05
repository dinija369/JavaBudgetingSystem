/*
*ManagerProfile class
*/

package Assesment;

//imported classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

class ManagerProfile {
   Scanner scanner = new Scanner(System.in);
   
   //attributes
   ErrorInput errorObject = new ErrorInput();
   
   //array lists to hold login and profile information
   private ArrayList<String> Name = new ArrayList<String>();
   private ArrayList<String> Surname = new ArrayList<String>();
   private ArrayList<String> Email = new ArrayList<String>();
   private ArrayList<String> Phone = new ArrayList<String>();
   private ArrayList<String> Password = new ArrayList<String>();
   private ArrayList<String> Username = new ArrayList<String>();
   //integer array
   int updateDetails;
   
   //methods
   //prompts the user to enter password and username, scans the entry and stores data in array lists
   public void setManagerLogin(){
      System.out.println("\nPlease enter Username and password");
      System.out.println("** Any Username or password will work during the development process **");
      System.out.printf("\nPassword (at least 2 characters) >> ");
      String password = scanner.nextLine();
      //puts the length of password string in integer variable
      int length = password.length();
      //while loop: checks if the password is too short and keeps repeating the code as long as it is too short
      while (length < 2) {
            System.out.printf("\nPasssword is too short\nPlease try again >>");
            password = scanner.nextLine();
            length = password.length();
         }
      //the same process repeated with username
      System.out.printf("Username* >> ");
      String username = scanner.nextLine();
      length = username.length();
      while (length < 1) {
            System.out.printf("\nPlease enter username >> ");
            username = scanner.nextLine();
            length = username.length();
         }
      //saves password and username in array lists
      this.Password.add(password);
      this.Username.add(username);
      //saves a string in array lists
      this.Name.add("None");
      this.Surname.add("None");
      this.Email.add("None");
      this.Phone.add("None");
      }
   
   //prints username from array list
   public void getManagerLogin() {
      System.out.println("Username: " + Username.get(0));
   }
   
   //prompts the user to enter 4 strings, scans the entry and stores data in array lists
   public void setManagerProfile() {
      System.out.println("\n>> Create an account. <<\n");
      System.out.printf("Name* >> ");
      String name = scanner.nextLine();
      int length = name.length();
      //while loop checks if there is an input
      while (length < 1) {
            System.out.printf("\nPlease enter your name >> ");
            name = scanner.nextLine();
            length = name.length();
         }
      System.out.printf("Surname >> ");
      String surname = scanner.nextLine();
      System.out.printf("Email* >> ");
      String email = scanner.nextLine();
      length = email.length();
      while (length < 1) {
            System.out.printf("\nPlease enter your email >> ");
            email = scanner.nextLine();
            length = email.length();
         }
      System.out.printf("Phone number >> ");
      String phone = scanner.nextLine();
      //changes the previously saved string to user input in first position in array lists
      this.Name.set(0, name);
      this.Surname.set(0, surname);
      this.Email.set(0, email);
      this.Phone.set(0, phone);
   }
      
   //gets and prints name, surname, email and phone number from array list first location
   public void getManagerProfile() {
      System.out.println("Name: " + Name.get(0));
      System.out.println("Surname: " + Surname.get(0));
      System.out.println("Email: " + Email.get(0));
      System.out.println("Phone: " + Phone.get(0));  
   }
   
   public void updateProfile() {
      //prompts the user to choose to update profile information and scans the choice
      System.out.println("\nChange: ");
      System.out.printf("1 Name | 2 Surname | 3 Email | 4 Phone number | 5 Password | 6 Username | 7 Exit\n>>");
      updateDetails = errorObject.errorInput();
      do {
         switch (updateDetails) {
         case 1:
            //if the user chooses option one a prompt for a name is printed and scanned in string variable 'newName'
            System.out.printf("Please enter the new name >> ");
            String newName = scanner.nextLine();
            //'Name' array list first position is changed to the value of 'newName' variable
            Name.set(0, newName);
            System.out.printf("-- Name has been updated succsesfully --");
            updateDetails = errorObject.errorInput();
            break;
         case 2:
            //surname
            System.out.printf("Please enter the new surname >> ");
            String newSurname = scanner.nextLine();
            Surname.set(0, newSurname);
            System.out.println("-- Surname has been updated sucessfully --");
            updateDetails = errorObject.errorInput();
            break;
         case 3:
            //email
            System.out.printf("Please enter the new email >> ");
            String newEmail = scanner.nextLine();
            Email.set(0, newEmail);
            System.out.println("-- Email has been updated sucessfully --");
            updateDetails = errorObject.errorInput();
            break;
         case 4:
            //phone number
            System.out.printf("Please enter the new surname >> ");
            String newPhone = scanner.nextLine();
            Phone.set(0, newPhone);
            System.out.println("-- Phone number has been updated sucessfully --");
            updateDetails = errorObject.errorInput();
            break;
         case 5:
            //password
            System.out.printf("Please enter the new password >> ");
            String newPassword = scanner.nextLine();
            Password.set(0, newPassword);
            System.out.println("-- Password has been updated sucessfully --");
            updateDetails = errorObject.errorInput();
            break;
         case 6:
            //username
            System.out.printf("Please enter the new username >> ");
            String newUsername = scanner.nextLine();
            Username.set(0, newUsername);
            System.out.println("-- Username has been updated sucessfully --");
            updateDetails = errorObject.errorInput();
            break;
         }
         //if statement to determine if the user inputs non-existent menu choice. if the choice is more than 7 it will execute the code
         if (updateDetails > 7) {
            System.out.println("\n*** Unrecognised input ***\n");
         }
   }while (updateDetails != 7);
   }
}