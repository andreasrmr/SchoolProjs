package DBUtil;
import DBUtil.Queries.deleteOrd;
import DBUtil.Queries.insertOrd;
import DBUtil.Queries.insertOrdlisteRedigeret;
import DBUtil.Queries.selectOrdlisteUredigeret;
import KrydsordsGenerator.Tid;
import UI.Input;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class DBManagement {

    //DBQuery dbQuery;
    Tid tid;

    public DBManagement(){
    }

    public void createOrd()
    {

        System.out.println("Indtast nyt ord");
        String ord = Input.readString();

            if(chkForAtleastOneVowel(ord) && chkFor3LetterWord(ord) && chkForUniqueLetters(ord))
               {
                   new insertOrd(ord);
                   System.out.println("Ordet er i databasen.");
               }
            else
            {

                System.out.println("Ordet overholder ikke kravene. Prøv igen");
            }
    }
    public void deleteOrd()
    {
        System.out.println("Indtast ord der skal slettes");
        String ord = Input.readString();

        if(chkForAtleastOneVowel(ord) && chkFor3LetterWord(ord) && chkForUniqueLetters(ord))
        {
            new deleteOrd(ord);
            System.out.println("Ordet er slettet");
        }
        else
        {

            System.out.println("Ordet overholder ikke kravene. Prøv igen");
        }


    }

    public void Filtrer(){
        tid = new Tid();
        tid.startTid();

        List<String> uredigeretListe = new selectOrdlisteUredigeret().execute();
        Set<String> redigeretListe = new HashSet<>();
        List<String> ordFiltreretFra = new LinkedList<>();

        for(String ord : uredigeretListe){
            ord = ord.toLowerCase(); //ord til lower case.
            ord = ord.trim(); //trim for mellemrum

            if((chkFor3LetterWord(ord)) && (chkForUniqueLetters(ord) && (chkForAtleastOneVowel(ord)))){
                redigeretListe.add(ord); //tilføj til set
            }
            else {
                ordFiltreretFra.add(ord);
            }
        }
        System.out.println("----Uredigeret Liste----");
        System.out.println("Antal ord før redigering : " + uredigeretListe.size());
        System.out.println();
        System.out.println("----Redigeret Liste----");
        System.out.println("Antal ord efter redigering: " + redigeretListe.size());
        System.out.println("Ordliste: " + redigeretListe);
        System.out.println();
        System.out.println("----Frasortede ord----");
        System.out.println("Frasortede ord: " + ordFiltreretFra);
        System.out.println();
        DBQuery dbQ = new insertOrdlisteRedigeret(redigeretListe);
        tid.slutTid();
    }

    private boolean chkForAtleastOneVowel(String ord){
        if(ord.matches(".*?[aeiouyæøå]+.*?")){
            return true;
        }
        return false;

    }
    private boolean chkFor3LetterWord(String ord){
        if(ord.matches("^[a-zæøå]{3}$")){
            return true;
        }
        return false;
    }
    private boolean chkForUniqueLetters(String ord){
        char[] charArr = ord.toCharArray();
        Set<Character> unique = new HashSet<>();
        for(char c : charArr){
            unique.add(c);
        }
        if(unique.size() == 3){
            return true;
        }
        return false;
    }
}
