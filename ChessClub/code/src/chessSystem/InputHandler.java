package chessSystem;

import java.io.IOException;
import java.util.Scanner;
/**
 * Klassen har ansvaret for at tage input fra brugeren.
 * @author andreasr
 * **/
public class InputHandler{

    //public static class Reads {
        public static Scanner scanner = new Scanner(System.in);
        //public Reads(){
        //}
        /**
         * Læs en tekststreng
         * @return Metoden returnere en String som bruger indtaster
         * @see String
         **/
        public static String readString(){
            String str = scanner.next();
            return str;
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
        /**
         * Clear console.
         * Windows / linux / mac.
         * @return void
         * **/
        public static void clearConsole() {
            String OS = System.getProperty("os.name");
            try {
                if(OS.contains("Linux") || OS.contains("MAC")){
                    System.out.print("\033[H\033[2J");
                }
                else if (OS.contains("Windows")){
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }
                else {
                    System.out.println("Du bør ikke være nået her til; se metode: clearConsole() i Menu class.");
                }
            }catch(IOException e){
                System.out.println("Fejl: " + e);

            }catch(InterruptedException e){
                System.out.println("Fejl: " + e);
            }
        }
}