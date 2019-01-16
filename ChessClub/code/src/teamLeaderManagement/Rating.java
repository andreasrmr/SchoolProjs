package teamLeaderManagement;

import static chessSystem.InputHandler.*;

/**
 * @author jonas
 *  Holding information for a rating.
 * **/

public class Rating
{

   int listID;
   int memberNumber;
   int playerRating;
   String tournamentName; 
   String tournamentDate;
/***
 * Constructor used for creating new rating
 *
 **/

   public Rating()
   {
   
      System.out.println("ListID: ");
      this.listID         = readInt();
      System.out.println("Membernumber: ");
      this.memberNumber   = readInt();
      System.out.println("Playerrating: ");
      this.playerRating   = readInt();
      System.out.println("Tournament name: ");
      this.tournamentName = readString();
      System.out.println("Tournament date: ");
      this.tournamentDate = readString();
   }

   /**
    * Constructor used for updating an existing rating
    * **/

   public Rating(String line)
   {
      String[] strArray = line.split(";");
      this.listID       = Integer.parseInt(strArray[0]);
      this.memberNumber = Integer.parseInt(strArray[1]);
      this.playerRating = Integer.parseInt(strArray[2]);
      this.tournamentName = strArray[3];
      this.tournamentDate = strArray[4];
   }

   /**
    *@return  toString method returning information about object
    *
    * **/

   public String toString()
   {
      return listID + ";" + memberNumber + ";" + playerRating + ";" + tournamentName + ";" + tournamentDate;
   }
   
   public void setListID(int listID)
   {
   this.listID = listID;
   }
   public void setMemberNumber(int memberNumber)
   {
   this.memberNumber = memberNumber;
   }
   public void setPlayerRating(int playerRating)
   {
   this.playerRating = playerRating;
   }
   public void setTournamentName(String tournamentName)
   {
   this.tournamentName = tournamentName;
   }
   public void setTournamentDate(String tournamentDate)
   {
   this.tournamentDate = tournamentDate;
   }
   
}