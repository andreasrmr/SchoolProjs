package DBUtil.Queries;

import DBUtil.DBQuery;

import java.util.List;

public class selectOrdlisteUredigeret extends DBQuery {
    public selectOrdlisteUredigeret() {
        super.queryType = "SELECT";
        super.columnName = "alle_ord";
        super.query = "SELECT alle_ord FROM Ordliste_Uredigeret";
    }
    public List<String> execute(){
        return super.execute();
    }
}
