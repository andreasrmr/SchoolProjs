package DBUtil.Queries;

import DBUtil.DBQuery;

import java.util.List;

public class selectOrdListeRedigeret extends DBQuery {

    public selectOrdListeRedigeret() {
        super.queryType = "SELECT";
        super.columnName = "alle_ord";
        super.query = "SELECT alle_ord FROM Ordliste_Redigeret";
    }
    public List<String> execute(){
        return super.execute();
    }
}
