package DBUtil.Queries;

import DBUtil.DBQuery;

import java.util.Set;

public class insertOrdlisteRedigeret extends DBQuery {
    public insertOrdlisteRedigeret(Set<String> ordListe) {
        super.queryType = "INSERT";
        super.columnName = "alle_ord";
        
        String valuesToInsert = "";
        for(String ord : ordListe){  //klar gør values til insert statement.
            valuesToInsert += "('"+ord+"'),";
        }
        int lastIndexOfComma = valuesToInsert.lastIndexOf(","); //find index for sidste komma
        valuesToInsert = valuesToInsert.substring(0, lastIndexOfComma); //fjern sidste komma.

        super.query = "INSERT INTO ordliste_redigeret (" + columnName + ") values " + valuesToInsert;
        super.execute();
    }
}
