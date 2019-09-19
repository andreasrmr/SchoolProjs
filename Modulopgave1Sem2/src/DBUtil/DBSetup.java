package DBUtil;

/**
 * Klassen indeholder login oplysninger til databasen.
 * **/

public class DBSetup {

    private String dbUrl = "jdbc:mysql://localhost:3306/modul";
    private String username = "moduluser";
    private String password = "password";

    public DBSetup(){}

    public String getDbUrl(){
        return dbUrl;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

}