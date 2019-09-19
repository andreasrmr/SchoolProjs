package Queries;

import Input.InputHandler;

/**
 * Klassen indeholder og opretter query til en søgning
 * **/
public class AntalBevaegelser {

    private String query;
    private String queryInfo;
    private String columnName;
    private String kommuneNavn;
    private String koen;
    private String bevaegelsesart;
    private int aarstal;

    public AntalBevaegelser(){
        queryInfo = "Antal personer, der matcher din søgning: ";
        columnName = "antalbevaegelser";
        System.out.println("Skriv år");
        aarstal = InputHandler.readInt();
        System.out.println("Skriv kommune");
        kommuneNavn = InputHandler.readString();
        System.out.println("Skriv køn");
        koen = InputHandler.readString();
        System.out.println("Skriv art");
        bevaegelsesart = InputHandler.readString();

        query = "SELECT antalbevaegelser "
                + "FROM bevaegelser INNER JOIN kommune "
                + "ON kommune_kommuneid = kommuneID "
                + "INNER JOIN koen "
                + "on koen_koenID = koenID "
                + "INNER JOIN bevaegelsesart "
                + "ON bevaegelsesart_bevaegelsesartID = bevaegelsesartID "
                + "INNER JOIN aarstal "
                + "ON aarstal_aarstalID = aarstalID "
                + "WHERE kommunenavn = ? AND koennavn = ? AND bevaegelsesartnavn = ? "
                + "AND aarstalid = ?";
    }
    public String toString(){
        return query + ";" + queryInfo + ";" + columnName + ";" + kommuneNavn + ";" + koen + ";" + bevaegelsesart + ";" + aarstal;
    }
}