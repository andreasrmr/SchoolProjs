package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klassen har ansvar for at oprette forbindelse til DB samt at lukke forbindelsen igen.
 * **/

public class DBConnection {
    Connection conn;
    private String dbUrl = "jdbc:mysql://localhost:3306/M2S2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "moduluser";
    private String password = "password";

    public DBConnection(){

    }
    public Connection newConnection(){
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void closeConnection(){
        try {
            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
