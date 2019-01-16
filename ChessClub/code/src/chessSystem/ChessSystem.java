/**
 * @author Andreas Rømer
 * @docroot docroot?!?!
 * @version 1.0
 * @since 23/23/2003
 * **/
package chessSystem;

import teamLeaderManagement.*;
import cashierManagement.*;
import adminManagement.*;
import chairmanManagement.*;
import static chessSystem.InputHandler.*;
/**
 * @author Andreas Rømer
 * @description Systemet starter her. Bruger kan logge ind eller printe en strengthlist.
 * **/
public class ChessSystem {
    private Configurations loadConfig;
    private LoginFH loginFH;
    private ChairmanMGMT chairmanMGMT;
    private CashierMGMT cashierMGMT;
    private AdminMGMT adminMGMT;
    private TeamLeaderMGMT teamLeaderMGMT;
    private boolean running;
    /**
     * Constructor
     * **/
    public ChessSystem(){
        running = true;
        loginFH = new LoginFH();
        loadConfig = new Configurations();
        if(loadConfig.loadConfigurations()){
            System.out.println("Configurations loaded successfully..\n\n");
            running = true;
            programRun();
        }
        else {
            running = false;
            System.out.println("ERROR CONTACT SYSTEM ADMINISTRATOR");
            System.out.println(loadConfig.getFileErrorMessage() + "\n");
        }

    }

    private void programRun(){
        while (running){
            showStartMenu();
            switch (readInt()){
                case 1:
                    String role = Login();
                    switch (role){
                        case "chairman":
                            clearConsole();
                            System.out.println("welcome to Chairman Management");
                            chairmanMGMT = new ChairmanMGMT();
                            break;
                        case "cashier":
                            clearConsole();
                            System.out.println("welcome to Cashier Management");
                            cashierMGMT = new CashierMGMT();
                            break;
                        case "teamleader":
                            clearConsole();
                            System.out.println("welcome to Team Leader Management");
                            teamLeaderMGMT = new TeamLeaderMGMT();
                            break;
                        case "admin":
                            clearConsole();
                            System.out.println("Welcome to Admin Menu");
                            adminMGMT = new AdminMGMT();
                            break;
                        default:
                            clearConsole();
                            System.out.println("Wrong username / password - try again");
                            break;
                    }
                    break;
                case 2:
                    TeamLeaderFH tlFH = new TeamLeaderFH();
                    tlFH.generateStrengthList();
                    break;
                case 9:
                    System.out.println("system shut down");
                    running = false;
                    break;

            }

        }

    }
    /**
     * Metoden spørger efter brugernavn og password fra brugeren.
     * Derefter sendes oplysninger videre til loginFH klassen som verifyer.
     * @return Returnere brugerens rolle hvis den verifies- ellers returneres en tom String
     * @see String
     **/
    private String Login(){
        System.out.println("Enter username");
        String username = readString();
        System.out.println("Enter password");
        String password = readString();
        //check i databasen.
        String role = loginFH.verifyUserCredentials(username, password);
        return role;
    }
    /**
     * StartMenu' efter systemet har startet op.
     * **/
    private void showStartMenu() {
        System.out.println("--- Chess Club System ---");
        System.out.println("1. Login");
        System.out.println("2. Print Strengthlist");
        System.out.println("9. Shutdown");
    }
}
