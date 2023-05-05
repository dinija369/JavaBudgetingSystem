/*
*Reports class
*/

package Assesment;

import java.util.ArrayList;

class Reports {

   //attributes
   private ArrayList<String> date = new ArrayList<String>();
   private ArrayList<String> comments = new ArrayList<String>();
   private ArrayList<Float> moneySpent = new ArrayList<Float>();
   
   //methods
   /*
   *As illustrated in Figure 22 in 010 report - to be approved section consists of date of purchase, comments and money spent.
   */
   //prints each itemised spend for approval
   public void toBeApproved() {
      //for loop executes block of code as long as i is less than the size of 'date' array list
      for (int i = 0; i < date.size(); i++) {
         //prints date, comments and money spent in i position
         System.out.println(" ____________________ ________________________________________ _______________ ");
         System.out.printf("|%-20s|%40s|%15s|\n", date.get(i), comments.get(i), moneySpent.get(i));
         System.out.println("|____________________|________________________________________|_______________|");
         }
   }
   
   //ads date, comments and money spent to array lists. takes three arguments from the main class
   public void setItemisedSpend(String expenseDate, String expenseComment, float expenseMoney) {
      this.date.add(expenseDate);
      this.comments.add(expenseComment);
      this.moneySpent.add(expenseMoney);
   }
   
   /*
   *As shown in Figure 16 in 010 assignment - reports consist of date of purchase, description, amount spent, total spent and money left.
   */
   //takes two arguments from main class
   public void Report(float totalSpent, float moneyLeft) {
      for (int i = 0; i < date.size(); i++) {
         System.out.println(" ____________________ ________________________________________ _______________ ");
         System.out.printf("|%-20s|%40s|%15s|\n", date.get(i), comments.get(i), moneySpent.get(i));
         System.out.println("|____________________|________________________________________|_______________|");
         }
         //prints expense from main class
         System.out.println(" ____________________ ");
         System.out.printf("|Total spent: %7s|\n", totalSpent);
         System.out.println("|____________________|\n");
         //prints money left from main class
         System.out.println(" ____________________ ");
         System.out.printf("|Money left: %8s|\n", moneyLeft);
         System.out.println("|____________________|\n");   
   }
    
}