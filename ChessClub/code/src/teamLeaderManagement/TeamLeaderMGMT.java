package teamLeaderManagement;

import java.io.*;
import static chessSystem.InputHandler.*;
import static chessSystem.Configurations.recieveFileStrengthList;
import static chessSystem.FileHandler.*;

/***
 * @author jonas
 *
 * Contains methods responsible for managing CRUD operations
 * */

public class TeamLeaderMGMT
{

   TeamLeaderFH teamLeaderFH = new TeamLeaderFH(); 
   Rating rating;
   File strengthList = recieveFileStrengthList();

   /**
    * Runs team leader menu
    * **/
   public TeamLeaderMGMT()
   {

      showMenuTeamLeader();
   }
      /**
       * Method that creates a new rating
       * **/

   public void createNewRating()
   {
      System.out.print("Please enter ");
      rating = new Rating();
      appendLine(strengthList, rating.toString());
         
   }
   /**
    * Method that updates a existing rating
    * **/
   public void updateRating()
   {
      System.out.print("Please enter listID: ");
      String value = readString();
      int lineNumber = getLineNumOfValue(strengthList,0,value);
      String line = readLine(strengthList, lineNumber);
      rating = new Rating(line);

      System.out.println("    Choose what you want to update!" + "\n" + "0. Exit" + "\n" + "1. Membernumber" + "\n" + 
      "2. Playerrating" + "\n" + "3. Tournament name" + "\n" + "4. Tournament date");
      int choice = readInt();
      switch (choice){
         case 0:
            clearConsole();
            System.out.println("You have chosen to exit!");
            break;
         case 1:
            clearConsole();
            System.out.println("Enter new membernumber: ");
            rating.setMemberNumber(readInt());
            updateLine(strengthList, lineNumber, rating.toString());
            break;
         case 2:
             clearConsole();
               System.out.println("Enter new playerrating: ");
               rating.setPlayerRating(readInt());
               updateLine(strengthList, lineNumber, rating.toString());
               break;
         case 3:
             clearConsole();
               System.out.println("Enter new tournament name ");
               rating.setTournamentName(readString());
               updateLine(strengthList, lineNumber, rating.toString());
               break;
         case 4:
             clearConsole();
               System.out.println("Enter new tournament date");
               rating.setTournamentDate(readString());
               updateLine(strengthList, lineNumber, rating.toString());
               break;
         default:
               break;
           
      }
   }
   /**
    * Method to delete a rating
    * **/
   public void deleteRating()
   {
      // Skal rettes til, men funktion virker
      System.out.println("Enter listID");
      int value = readInt();
      int linenumber = getLineNumOfValue(strengthList, 0, Integer.toString(value));
      deleteLine(strengthList, linenumber);
      System.out.println("Line deleted!");
   }
    /**
     * Method to print raw data list
     * **/
    public void printRawDataList() {
        System.out.println("Raw data from file");
        int lineNum = 1;
        String line = ".";
        while (line != ""){
            line = readLine(strengthList, lineNum);
            System.out.println(line);
            lineNum++;
        }
    }
   /**
    *  Method for Teamleader menu
    **/
   public void showMenuTeamLeader()
   {

    boolean running;
    running = true;
    while(running){
        System.out.println("You have entered Team Leader Menu." + "\n" + "Select your choice:");
        System.out.println("0. Exit");
        System.out.println("1. Create a new rating");
        System.out.println("2. Update existing rating");
        System.out.println("3. Delete a rating");
        System.out.println("4. Print strength list");
        System.out.println("5. Print Raw Data.");
        int choice = readInt();

        switch (choice)
        {
            case 0:
                running = false;
                clearConsole();
                System.out.println("Teamleader logged out");
                break;
            case 1:
                clearConsole();
                createNewRating();
                break;
            case 2:
                clearConsole();
                updateRating();
                break;
            case 3:
                clearConsole();
                deleteRating();
                break;
            case 4:
                clearConsole();
                teamLeaderFH.generateStrengthList();
                break;
            case 5:
                clearConsole();
                printRawDataList();
                break;
        }

    }

   }
   
}