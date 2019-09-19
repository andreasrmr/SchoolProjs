package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klassen har ansvar for at oprette forbindelse til DB samt at lukke forbindelsen igen.
 * **/

public class DBConnection {
    Connection conn;
    DBSetup dbSetup;

    public DBConnection(){
        dbSetup = new DBSetup();
    }
    public Connection newConnection(){
        try{
            conn = DriverManager.getConnection(dbSetup.getDbUrl(), dbSetup.getUsername(), dbSetup.getPassword());
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
