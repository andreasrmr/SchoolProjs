package chessSystem;

import java.time.DateTimeException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

/**
 * @author andreasr
 * klassen validere input fra bruger.
 * Klassen bruges især af Member.java klassen
 * **/

public class InputVerification {

    public enum Patterns {
        DIGITS,
        LETTERS,
        LETTERSANDDIGITS,
        PHONENUMBER,
        CPRLASTFOUR
    }
    public static boolean regexString(Patterns patterns, String str) {
        String pattern = "";
        switch (patterns) {
            case LETTERS:
                pattern = "[A-Za-z]*";
                break;
            case DIGITS:
                pattern = "\\d*";
                break;
            case LETTERSANDDIGITS:
                pattern = "[a-zA-Z\\d]*";
                break;
            case PHONENUMBER:
                pattern = "\\d{8}$";
                break;
            case CPRLASTFOUR:
                pattern = "^[\\d]{4}$";
                break;
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if (m.matches()) {
            return true;
        }
        System.out.println("Validation failed: '" + str + "' failed - Try again");
        return false;
    }

    /**
     * @author Andreas Rømer
     * Metoden tager en String i format: ddmmyyyy
     * returnere true hvis det er en valid dato.
     * True eksempel:
     * checkValidDate("28011987");
     * False eksempel:
     * checkValidDate("35011987");
     */

    public static boolean validateDate(String str){
        if(str.length() == 8){
            int day = Integer.parseInt(str.substring(0,2));
            int month = Integer.parseInt(str.substring(2, 4));
            int year = Integer.parseInt(str.substring(4, 8));
            try {
                LocalDate date = LocalDate.of(year, month, day);
                return true;
            }catch(DateTimeException e){
                System.out.println(e + " - Try again");
                return false;
            }
        }
        System.out.println("date needs to be 8 digits long - ddmmyyyy");
        return false;
    }
}
