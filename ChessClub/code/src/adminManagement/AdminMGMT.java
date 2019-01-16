package adminManagement;
import static chessSystem.InputHandler.*;

import static chessSystem.FileHandler.*;
import static chessSystem.Configurations.recieveFileUserLogins;
import static org.mindrot.jbcrypt.BCrypt.*;
/**
 * @author Andreas Rømer
 * Administation klasse til at oprette og slette brugere.
 *
 * **/
public class AdminMGMT {

    public AdminMGMT() {
        boolean running = true;
        while (running) {
            showMenuAdmin();
            switch (readInt()) {
                case 1:
                    createNewUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    printUserList();
                    break;
                case 4:
                    updateUserPassword();
                    break;
                case 9:
                    clearConsole();
                    System.out.println("Admin logged out");
                    running = false;
                    break;
            }

        }
    }
    /**
     * Metoden opretter en ny bruger.
     * @return void
     *
     * **/
    private void createNewUser(){
        System.out.println("Write username");
        String username = readString();
        //brugernavn rettes til små bogstaver.
        username = username.toLowerCase();
        System.out.println("Enter password");
        String password = readString();
        showMenuRoles();
        System.out.println("Enter role:");
        int roleChoice = readInt();
        String role = "";
        switch (roleChoice){
            case 1:
                role = "chairman";
                break;
            case 2:
                role = "cashier";
                break;
            case 3:
                role = "teamleader";
                break;
            case 4:
                role = "admin";
                break;
            case 9:
                role = "";
                break;
            default:
                System.out.println("Role not defined, create user again");
                role = "";
                break;
        }
        clearConsole();
        if(role != ""){
            //gensalt køre default med 10 log rounds - valid range 4 - 31.
            //hashpw hasher password.
            String hashedPassword = hashpw(password, gensalt());

            //bruger bliver tilføjet til userLogins filen.
            if(appendLine(recieveFileUserLogins(), username + ";" + hashedPassword + ";" + role)){
                System.out.println("User added");
            }
            else {
                System.out.println("Something went wrong");
            }
        }

    }
    /**
     * Metoden sletter en bruger.
     * @return void
     * **/
    private void deleteUser(){
        System.out.println("Enter username to delete");
        String username = readString();
        username = username.toLowerCase();
        clearConsole();
        if(username.equals("admin")){
            System.out.println("User: " + username + " can not be deleted");
        }
        else {
            //Hent linjenummeret hvor brugeren står i filen.
            int linenumber = getLineNumOfValue(recieveFileUserLogins(), 0, username);
            //Udføres hvis getLineNumOfValue ikke returnere -1.
            if(linenumber != -1){
                if(deleteLine(recieveFileUserLogins(), linenumber)){
                    System.out.println("User: " + username + " was deleted");
                }
            }
            else{
                System.out.println("User could not be found");
            }
        }

    }
    private void updateUserPassword(){
        System.out.println("What user do you want to change password for?");
        String username = readString();
        username = username.toLowerCase();
        clearConsole();

        //find linjenummeret på hvor brugernavnet står på.
        int linenumber = getLineNumOfValue(recieveFileUserLogins(), 0, username);
        if(linenumber != -1){
            System.out.println("Enter new password");
            String newPassword = readString();
            //hash newPassword
            String hashedPassword = hashpw(newPassword, gensalt());

            //indlæs brugers nuværende info. username;hashedpassword:role
            String userinfo = readLine(recieveFileUserLogins(), linenumber);
            String[] userinf = userinfo.split(";");

            //ny linje sammensættes. username;nyt hashed password;role.
            userinfo = userinf[0] + ";" + hashedPassword + ";" + userinf[2];

            //ny linje skrives til filen userLogins.
            if(updateLine(recieveFileUserLogins(), linenumber, userinfo)){
                System.out.println("User password is changed");
            }
            else {
                System.out.println("Something went wrong.");
            }

        }
        else {
            System.out.println("User could not be found");
        }

    }
    /**
     * Metoden printer brugerliste.
     * @return void
     * **/
    private void printUserList(){
        clearConsole();
        System.out.println("------------UserList-------------");
        System.out.println("Username ; Role");
        System.out.println("----------------------------------");

        //skip headers
        int lineNum = 2;
        String line;
        do{
            line = readLine(recieveFileUserLogins(), lineNum);
            if(line !=""){
                String[] lineSplit = line.split(";");
                System.out.println(lineSplit[0] + ";" + lineSplit[2]);
            }
            lineNum++;
        }while (line != "");

    }
    /**
     * Metoden viser admin menu
     * @return void
     * **/
    private void showMenuAdmin(){
        String menuAdmin = "\n1. Create new user";
        menuAdmin += "\n2. Delete user";
        menuAdmin += "\n3. Print userlist";
        menuAdmin += "\n4. Update password for user";
        menuAdmin += "\n9. Logout";
        System.out.println(menuAdmin);
    }
    /**
     * Metoden viser menu med roller - bruges til at oprette ny bruger.
     * @return void
     * **/
    private void showMenuRoles(){
        String menuRoles = "\nChoose role";
        menuRoles += "\n1. Chairman";
        menuRoles += "\n2. Cashier";
        menuRoles += "\n3. Team Leader";
        menuRoles += "\n4. Admin";
	    menuRoles += "\n9. Cancel new user";
        System.out.println(menuRoles);
    }
}

