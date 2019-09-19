package Queries;


import Input.InputHandler;

/**
 * Klassen indeholder og opretter query til en søgning
 * **/
public class Foedselsoverskud {

    private String query;
    private String queryInfo;
    private String columnName;
    private int aarstal;
    private String koen;
    private String kommuneNavn;

    public Foedselsoverskud(){
        queryInfo = "Fødselsoverskud: ";
        columnName = "Fødselsoverskud";
        System.out.println("Soeg efter Fødselsoverskud\nAngiv Årstal: ");
        aarstal = InputHandler.readInt();
        System.out.println("Angiv Køn: ");
        koen = InputHandler.readString();
        System.out.println("Angiv KommuneNavn: ");
        kommuneNavn = InputHandler.readString();

        query = "SELECT (bevaegelser1.AntalBevaegelser - bevaegelser2.AntalBevaegelser) as FØDSELSOVERSKUD "
                + "FROM bevaegelser bevaegelser1 "
                + "CROSS JOIN bevaegelser bevaegelser2 "
                + "INNER JOIN Kommune KOM1 on Bevaegelser1.Kommune_KommuneID = KOM1.KommuneID "
                + "INNER JOIN Kommune KOM2 on bevaegelser2.Kommune_KommuneID = KOM2.KommuneID "
                + "INNER JOIN Bevaegelsesart BA1 on Bevaegelser1.Bevaegelsesart_BevaegelsesartID = BA1.BevaegelsesartID "
                + "INNER JOIN Bevaegelsesart BA2 on Bevaegelser2.Bevaegelsesart_BevaegelsesartID = BA2.BevaegelsesartID "
                + "INNER JOIN Koen KOEN1 on Bevaegelser1.Koen_KoenID = KOEN1.KoenID "
                + "INNER JOIN Koen KOEN2 on Bevaegelser2.Koen_KoenID = KOEN2.KoenID "
                + "WHERE "
                + "bevaegelser1.Aarstal_aarstalid = ? AND "
                + "bevaegelser2.Aarstal_aarstalid = ? AND "
                + "KOEN1.KoenNavn = ? AND "
                + "KOEN2.KoenNavn = ? AND "
                + "KOM1.KommuneNavn = ? AND "
                + "KOM2.KommuneNavn = ? AND "
                + "BA1.BevaegelsesartNavn = 'levendefødte' AND "
                + "BA2.BevaegelsesartNavn = 'døde'";
    }
    public String toString(){
        return query + ";" + queryInfo + ";" + columnName + ";" + aarstal + ";" + aarstal + ";" + koen + ";" + koen + ";" + kommuneNavn + ";" + kommuneNavn;
    }
}
