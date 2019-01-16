package cashierManagement;

import java.io.File;

import static chessSystem.InputHandler.*;
import static chessSystem.Configurations.recieveFileMemberDatabase;
import static chessSystem.FileHandler.*;
/**
* @Author Oliver Dehnfjeld
**/

public class CashierMGMT
{
   File memberDatabase = recieveFileMemberDatabase();
      
   public CashierMGMT()
   {
      showMenuCashier();
   }
   /**
   * Metoden printer liste af medlemmer under 18 år
   **/
   public void printListJuniors()
   {
   
      String line = ".";
      int count = 0;
      while(line != "")
      {
         line = readLine(memberDatabase, count);
         String[] lineItems = line.split(";");
         if(lineItems.length > 1){
            if(lineItems[10].equals("JUNIOR"))
            {
               System.out.println(line);
            }
         }
         
         count++;
      } 

   }
   /**
   *Metoden printer liste over medlemmer
   **/
   public void printSubscriptionList()
   {
      String line = ".";
      int count = 0;
      while(line != "")
      {
         line = readLine(memberDatabase, count);
         System.out.println(line);
         count++;

      }

   
   }
   /**
   *Metoden printer liste over medlemmer, som ikke har betalt
   **/
   public void printListNonPaid()
   {
      String line = ".";
      int count = 0;
      while(line != "")
      {
         line = readLine(memberDatabase, count);
         String[] lineItems = line.split(";");
         if(lineItems.length > 1){
            if(lineItems[9].equals("false"))
            {
               System.out.println(line);
            }
         }
         
         count++;
      }

   
   }
   /**
   *Metoden tager et medlemsnummer, og ændrer betalingsstatusen for dette
   @param memberNumber
   **/
   
   
   public void updatePaymentStatus(String memberNumber)
   {
      
      
      int lineNumber = getLineNumOfValue(memberDatabase, 0, memberNumber);
      if(lineNumber == -1){
       System.out.println("Line could not be found");
      }
      String line = readLine(memberDatabase, lineNumber);
     //System.out.println(line);
     String[] lineItems = line.split(";");
     //System.out.println(lineItems[0]);
      
         if(lineItems[9].equals("true"))
      {
         lineItems[9] = "false";
      }
      else
      {
         
         lineItems[9] = "true";
     }
     line = "";
     for(String item : lineItems){
      line += item + ";";
     }
     //System.out.println(line);
     updateLine(memberDatabase, lineNumber, line);
     System.out.println("Payment status updated");
      
   }
   /**
   *Metoden printer en menu, og bruger en scanner til at tage inputs og navigere brugeren rundt
   **/
   public void showMenuCashier()
   {
      boolean runMenu = true;
         while(runMenu)
         {
            int valg = 0;
            System.out.println("Cashier Menu");
            System.out.println("Choose a number");
            System.out.println("1: Print junior-list");
            System.out.println("2: Print subscribers-list");
            System.out.println("3: Print list of non paid members");
            System.out.println("4: Update payment status for a member");
            System.out.println("0: Logout");
            valg = readInt();
            
            if(valg==1)
            {
            clearConsole();
            printListJuniors();
            }
            if(valg==2)
            {
            clearConsole();
            printSubscriptionList();
            }
            if(valg==3)
            {
            clearConsole();
            printListNonPaid();
            }
            if(valg==4)
            {
            clearConsole();
            System.out.println("Type member number");
            String nr = readString();
            updatePaymentStatus(nr);
            }
            else if(valg >4)
            {
            clearConsole();
            System.out.println("Choose a number from the menu");
            }
            if(valg==0)
            {
               clearConsole();
               System.out.println("Cashier Logged out");
            runMenu = false;
            }
         }   
   }
}