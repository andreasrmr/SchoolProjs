package chairmanManagement;
import java.io.*;

import static chessSystem.FileHandler.*;
import static chessSystem.InputHandler.*;
import static chessSystem.Configurations.recieveFileMemberDatabase;

//ChairmanMGMT is where the chairman menu is printet form. 
//The chairmanMGMT is the processing part of the chairman 
public class ChairmanMGMT{
    private boolean ChairmanRunning = true;
    MMFH thisMMFH = new MMFH();
    File file = recieveFileMemberDatabase();
    Member member;
      
    //Where we call most of our functions.
    public ChairmanMGMT(){
        while(ChairmanRunning){
            startMenu();
            System.out.print("Choose one: ");
            menuChoice(ChairmanRunning);
            System.out.println();
        }
    }
    //Here we make a string which we call in the MGMT constructor.
    public void startMenu(){
        String menu = "----Menu----\n";
        menu += "1. Create member.\n";
        menu += "2. Read members.\n";
        menu += "3. Update member.\n";
        menu += "4. Delete member.\n";
        menu += "9. Exit.\n";
        System.out.println(menu);
    }
    //Here we make a string which we print if user chose to update a member.
    public void updateMemberMenu(){

        String menu = "----Member update options----\n";
        menu += "1. First name.\n";
        menu += "2. Last name.\n";
        menu += "3. Birthday.\n";
        menu += "4. CPR.\n";
        menu += "5. PhoneNumber\n";
        menu += "6. Email\n";
        menu += "9. Exit.\n";
        System.out.println(menu);
    }
    //This is where the user gets 
    public void menuChoice(boolean ChairmanRunning){
        //Input number to choose what to do.
        switch(readInt()){
            //Here we call a constructor in the Member class. 
            case 1:
                clearConsole();
                System.out.println("Creating new member.\n");
                Member newMember = new Member();
                appendLine(file, newMember.toString());
                break;
            //Here we call a method in our MMFH which is an extension of our fileHandler which then prints a list of the member in our system.
            case 2:
                clearConsole();
                System.out.println("Reading members.");
                thisMMFH.printRawDataList();
                break;
            //Here we call a method in our fileHandler which gets a member from our memberdatabase and then runs another member constructor on him. 
            case 3:
                clearConsole();
                thisMMFH.printRawDataList();
                System.out.print("Input member number to update: ");
                int membernumber = readInt();
                int linenumber = getLineNumOfValue(file, 0, Integer.toString(membernumber));
                String memberStr = readLine(file, linenumber);
                member = new Member(memberStr);
                updateMemberMenu();
                //Here we ask what the user want do change on the chosen member. 
                switch (readInt()){
                    case 1:
                        member.setFirstName();
                        break;
                    case 2:
                        member.setLastName();
                        break;
                    case 3:
                        member.setBirthDay();
                        break;
                    case 4:
                        member.setCpr();
                        break;
                    case 5:
                        member.setPhoneNumber();
                        break;
                    case 6:
                        member.setEmail();
                        break;
                    case 9:
                        System.out.println("Updating member... Stopping updating");
                        break;
                }
                updateLine(file, linenumber, member.toString());
                thisMMFH.printRawDataList();
                break;
            //Here we gets a member from our filehandler and then deletes this member what another function in our filehandler.
            case 4:
                clearConsole();
                System.out.println("Deleting member: ");
                thisMMFH.printRawDataList();
                System.out.print("Input member number to remove: ");
                membernumber = readInt();
                clearConsole();
                linenumber = getLineNumOfValue(file, 0, Integer.toString(membernumber));
                deleteLine(file, linenumber); //Delete member on that line. Tied to tempfile so far, don't know how to fix, not sure about the passString.
                thisMMFH.printRawDataList();
                break;
            case 9:
                clearConsole();
                this.ChairmanRunning = false;
                System.out.println("Chairman logged out");
                break;
        }
    }
}
