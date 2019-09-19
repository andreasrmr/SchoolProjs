package Input;

import java.util.Scanner;

/**
 * Klassen har ansvaret for at tage input fra brugeren.
 * @author andreasr
 * **/
public class InputHandler {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Læs en tekststreng
     * @return Metoden returnere en String som bruger indtaster
     * @see String
     **/
    public static String readString(){
        return scanner.next();
    }
    /**
     * Læs et heltal (integer)
     * @return Metoden returnere en Integer som bruger indtaster
     * @see Integer
     * **/
    public static int readInt() {
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }
    /**
     * Læs et decimaltal (double)
     * @return Metoden returnere en double som bruger indtaster
     * @see double
     * **/
    public static double readDouble() {
        while(!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }
}