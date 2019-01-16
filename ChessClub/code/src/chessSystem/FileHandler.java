package chessSystem;
import java.util.Scanner;
import java.io.*;
import static chessSystem.Configurations.recieveFileTempFile;

/**
 * @author Andreas Rømer
 * FileHandler klassens ansvar er at læse/skrive til fysiske filer på disken.
 *
 * **/

public class FileHandler {
    //Constructor
    public FileHandler(){}

    /**
     * Metoden tager et filobjekt og en linje.
     * Linjen vil tilføjet i slutningen af filen
     * @param file
     * @param line
     * @return returnere true, hvis det er godt godt - ellers false;
     * @see boolean
     *
     * **/
    public static boolean appendLine(File file, String line){
        if(checkFile(file)){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.write(line);
                bw.newLine();
                bw.flush();
                bw.close();
                System.out.println("line was added to file: " + file.toString() + "\n" + line);
            }
            catch(FileNotFoundException e){
                System.out.println(e);
                return false;
            }
            catch (IOException e){
                System.out.println(e);
                return false;
            }
        }
        else {
            System.out.println("Filecheck failed. check if file: " + file + " exists and can be read");
            return false;
        }
        return true;
    }

    /**
     * Read Line.
     * Metoden tager et filobjekt og et linje nummer og returnere linjen i filen.
     * @param file
     * @param lineNumber
     * @return Metoden returnere en String med det linje nummer der er defineret.
     * @see String
     *
     * **/
    public static String readLine(File file, int lineNumber){
        if(checkFile(file)){
            try {
                Scanner scanner = new Scanner(file, "UTF-8");
                for(int i = 1; i < lineNumber && scanner.hasNextLine(); i++){
                    scanner.nextLine();
                }
                //Hvis der er en næste linje returneres linjen.
                if(scanner.hasNextLine()){
                    return scanner.nextLine();
                }

            }catch(FileNotFoundException e) {
                System.out.println(e);
                return "";
            }
        }
        else {
            System.out.println("Filecheck failed. check if file: " + file + " exists and can be read");
        }
        System.out.println("No more lines || line could not be found");
        return "";
    }

    /**
     * Metoden tager et fil objekt, et linje nummer og den string pågældende linje skal
     * skrives til.
     * @param file
     * @param lineNumber
     * @param updateLine
     * @return Metoden returnere true eller false alt efter om det går godt eller skidt.
     * @see boolean
     * **/
    public static boolean updateLine(File file, int lineNumber, String updateLine){
        if(checkFile(file)){
            try {
                File tempFile = recieveFileTempFile();
                PrintStream output;
                Scanner scanner;
                output = new PrintStream(tempFile.toString());
                scanner = new Scanner(file, "UTF-8");

                for(int i = 1; i < lineNumber; i++){
                    output.print(scanner.nextLine() + "\n");
                }

                //hop linjen der skal opdateres over.
                scanner.nextLine();

                //Opdater linjen med ny string.
                output.print(updateLine + "\n");

                //skriv resterende linjer til tempfilen til der ikke er flere linjer.
                while(scanner.hasNextLine()){
                    output.print(scanner.nextLine() + "\n");
                }
                //luk printStream.
                output.close();

                //kopier tempFile til filen.
                copyFile(tempFile, file);

            }catch(FileNotFoundException e){
                System.out.println(e);
                return false;
            }

        }
        else {
            System.out.println("Filecheck failed. check if file: " + file + " exists and can be read");
            return false;
        }
        return true;
    }

    /**
     * Metoden deleteLine tager et filobjekt og linjenummer
     * Metoden skriver til filen tempFile, og skipper så linjen der er givet som parameter.
     * Tilsidst kopieres tempFile til db filen.
     * @param file
     * @param lineNumber
     * @return metoden retunere true eller false alt efter om det er godt gået.
     * @see boolean
     *
     * **/
    public static boolean deleteLine(File file, int lineNumber){

        //filecheck
        if(checkFile(file)){
            try {
                File tempFile = recieveFileTempFile();
                PrintStream output;
                Scanner scanner;
                output = new PrintStream(tempFile.toString());
                scanner = new Scanner(file, "UTF-8");

                //udskriv linje for linje til tempfil.
                //indtil lineNumber der skal slettes.
                for(int i = 1; i < lineNumber; i++){
                    output.print(scanner.nextLine() + "\n");
                }

                //skip line / delete linje.
                scanner.nextLine();

                //skriv resterende til der ikke er flere linjer.
                while(scanner.hasNextLine()){
                    output.print(scanner.nextLine() + "\n");
                }
                //luk printStream.
                output.close();

                //kopier tempFile til filen.
                copyFile(tempFile, file);

            }catch(FileNotFoundException e){
                System.out.println(e);
                return false;
            }
        }
        else {
        System.out.println("Filecheck failed. check if file: " + file + " exists and can be read");
        }
        return true;
    }
    /**
     * Metoden copyFile kopiere en fil fra source til destination
     * @param source
     * @param destination
     * @return Metoden retunere true eller false alt efter om det er gået godt.
     * @see boolean
     * **/
    private static boolean copyFile(File source, File destination){
        try {
            Scanner input = new Scanner(source);
            PrintStream output = new PrintStream(destination);

            while(input.hasNextLine()){
                output.println(input.nextLine());
            }
            input.close();
            output.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Fejl: " + e);
            return false;
        }
        return true;
    }
    /**
     * Metoden tager filnavn, kolonnenummer, samt en værdi og returnere linjenummer på første match.
     * Denne metode bruges til at få et linjenummer.
     * Der bør kun indtastes unikke værdier, da den returnere det første match den finder.
     *
     * Metoden returnere -1 hvis der ikke er et match.
     *
     * @param file
     * @param columnNumber
     * @param value
     * @return Metoden returnere et linjenummer(int) ved første forekomst af value. Hvis value ikke findes returneres der -1
     * @see int
     *
     * **/


    public static int getLineNumOfValue(File file, int columnNumber, String value) {
        try {

            Scanner scanner = new Scanner(file, "UTF-8");
            int linenumber = 1;

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] strArray = str.split(";");

                if (strArray[columnNumber].equals(value)) {
                    return linenumber;
                }
                linenumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        return -1;
    }
    public static boolean checkFile(File file){
        if(file.exists() && file.canRead()){
            return true;
        }
        return false;
    }
}
