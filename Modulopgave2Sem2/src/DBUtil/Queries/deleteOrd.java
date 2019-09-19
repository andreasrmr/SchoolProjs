package DBUtil.Queries;

import DBUtil.DBQuery;

public class deleteOrd extends DBQuery {


    public deleteOrd(String ord)
    {
        super.queryType = "INSERT";
        super.columnName = "alle_ord";
        super.query = "DELETE FROM ordliste_redigeret WHERE alle_ord = '" + ord + "'";
        super.execute();
    }
}