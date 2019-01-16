package chessSystem;
/**
 * Class: LoginFH
 * Når bruger logger ind tjekkes credentials.
 * **/
import java.io.File;
import static chessSystem.Configurations.recieveFileUserLogins;
import static chessSystem.FileHandler.* ;
import static org.mindrot.jbcrypt.BCrypt.checkpw;

public class LoginFH {
    File userLogins;

    public LoginFH(){
        this.userLogins = recieveFileUserLogins();
    }

    /**
     * @param username
     * @param password
     * @return Hvis brugeren verifies returneres rollen, ellers returneres en tom string.
     * **/

    public String verifyUserCredentials(String username, String password){
        this.userLogins = recieveFileUserLogins();

        //brugernavn kan skrives med stort og småt.
        username = username.toLowerCase();

        int lineNum = getLineNumOfValue(userLogins, 0, username);
        if(lineNum != -1){
            String line = readLine(userLogins, lineNum);
            String[] lineItems = line.split(";");
            if(checkpw(password, lineItems[1])){
                return lineItems[2];
            }
        }
        return "";
    }
}
