package DBUtil.Queries;

import DBUtil.DBQuery;

public class insertOrd extends DBQuery {


    public insertOrd(String ord)
    {

        super.queryType = "INSERT";
        super.columnName = "alle_ord";
        super.query = "INSERT INTO ordliste_redigeret (alle_ord) VALUES ( '" + ord + "')";
        super.execute();

    }
}