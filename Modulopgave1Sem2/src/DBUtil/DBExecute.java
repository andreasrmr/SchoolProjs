package DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExecute {

    private PreparedStatement ps;
    private DBConnection conn;
    public DBExecute(){}
    public DBExecute(String queryToString){
        String[] queryToStringSplit = queryToString.split(";");
        String query = queryToStringSplit[0];
        String queryInfo = queryToStringSplit[1];
        String columnName = queryToStringSplit[2];

        conn = new DBConnection();

            try {
                //opret preparedstatement med Query og Connection.
                ps = conn.newConnection().prepareStatement(query);

                for(int i = 3; i < queryToStringSplit.length; i++) {
                    //indsæt variabler i query string. //index - 2 pga i starter ved 3.
                    ps.setString(i - 2, queryToStringSplit[i]);
                }

                //execute query.
                ResultSet res = ps.executeQuery();

                //udskriv resultatsettet
                System.out.println(queryInfo);
                while (res.next()) {
                    int value = res.getInt(columnName);
                    System.out.println(value);
                }
                //close connection;
                conn.closeConnection();

            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }

    }

}
