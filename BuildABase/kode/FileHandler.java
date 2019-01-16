import java.io.*;
import java.util.Scanner;

public class FileHandler
{  
   //File directory;

    FileHandler(){}

    //metoden checker alle filer i databasePath om de kan laeses og om de eksistere.
    //koeres ved opstart af DBMS system.
    public boolean checkDBFiles(File databasePath){
        File[] fList = databasePath.listFiles(); //opret array af directory filerne.
        boolean errorFound = false;
        System.out.println("FILECHECK FOR ALL FILES IN DIR: " + databasePath + "\nChecking for; file.canRead(), file.exists()");
        for (File file : fList){
            if(file.exists() && file.canRead() && file.length() != 0) {
                System.out.println("OK FILECHECK ON: " + file.getName());
            }
            else {
                if(file.length() == 0){
                    System.out.println("FILE EMPTY: " + file.getName());
                }
                else if(!(file.exists()) && file.canRead()){
                    System.out.println("ERROR FILECHECK ON: '" + file.getName());
                }
            errorFound = true;
            }

        }
        return errorFound;
    }
    //kopiere fil fra source til dest.
    public void copyFile(String source, String destination){
        try {
            //overskriv source til fil.
            File inputfil = new File(source);
            Scanner input = new Scanner(inputfil);
            File outputfil = new File(destination);
            PrintStream output2 = new PrintStream(outputfil);

            while(input.hasNextLine()){
                output2.println(input.nextLine());
            }
            input.close();

        }
        catch (FileNotFoundException e){
            System.out.println("Fejl: " + e);
        }

    }

}