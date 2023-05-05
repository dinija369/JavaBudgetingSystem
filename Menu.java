/*
*Menu class
*/

package Assesment;

class Menu{

   //attributes
   
   //methods
   /*
   *'Teams' menu element 010: Figure 2, Figure 18 - 20. Settings option removed as explained in main method.
   */
   //prints teams menu
   public static void teamMenu(){
      System.out.println("+---------------------------------------------------------------------------------------------------+");
      System.out.println("| 1. Home | 2. Add allowance | 3. Add expense | 4. Reports | 5. Notifications | 6.Profile | 7. Exit |");
      System.out.println("+---------------------------------------------------------------------------------------------------+");
   }
   
   /*
   *Manager menu element 010: Figure 2, Figure 14 - 17 and Figure 21. Settings and reports option removed as explained in main method.
   */
   //prints manager menu
   public static void managerMenu(){
      System.out.println("+--------------------------------------------------------------------------------------------------+");
      System.out.println("| 1. Home | 2. Add teams | 3. To be approved | 4. Notifications | 5.Profile | 6.Projects | 7. Exit |");
      System.out.println("+--------------------------------------------------------------------------------------------------+");
   }
   
   //prints a prompt to register or log in
   public static void registerOrLogin(){
      System.out.println("+-------------------------+");
      System.out.println("| 1. Register | 2. Log in |");
      System.out.println("+-------------------------+");
      System.out.printf("\n>> ");
   }
   
   //prints a prompt to choose manager or team view
   public static void teamManagerChoice() {
      System.out.println("+--------------------------------+");
      System.out.println("| 1. Team view | 2. Manager view |");
      System.out.println("+--------------------------------+");
      System.out.printf("\n>> ");
   }
   
   public static void FeelGoodOrBusinessManagement() {
      System.out.println("+------------------------------------+");
      System.out.println("|1. Budgeting | 2. Project Management|");
      System.out.println("+------------------------------------+");
      System.out.println("\n>> ");
   }
   
   public static void AdminMenu() {
      System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
      System.out.println("|1. Projects | 2. Reports | 3. Tasks | 4. Holidays | 5. Users | 6. Settings | 7. Invoices | 8. Quotes | 9. Contacts | 10. Exit |");
      System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
   }
   
   public static void ProjectMenu() {
      System.out.println("+----------------------------------------------------------------------------------------------------------------+");
      System.out.println("|1. Gantt chart | 2. Modify/Add | 3. Past activities | 4. Invoices | 5. Project pipeline | 6. My tasks | 7. Exit |");
      System.out.println("+----------------------------------------------------------------------------------------------------------------+");
   }
   
}