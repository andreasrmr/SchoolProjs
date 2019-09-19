package DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBQuery {

    //tilgængelige for subclasses (queries)
    protected String queryType;
    protected String query;
    protected String columnName;

    private PreparedStatement ps;
    private DBConnection conn;
    private ResultSet res;
    private List<String> resultList;

    public DBQuery() {}

    public List<String> execute() {
        resultList = new ArrayList<>();
        conn = new DBConnection();
        try {
            ps = conn.newConnection().prepareStatement(query);

            if (queryType.equals("INSERT")) {
                ps.execute(); //execute

            }
            else if (queryType.equals("SELECT")) {
                res = ps.executeQuery(); //execute

                while (res.next()) { //add results to list.
                    resultList.add(res.getString(columnName));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            //close connection;
            conn.closeConnection();
        }
        return resultList;
    }

}