import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataCompression {

    public DataCompression(){}

    public void compressTo(String allChars){
        String[] lineAllChars = allChars.split("\n");


        try{

            PrintWriter out = new PrintWriter("compressedFile.txt");
            out.println(allChars);
            out.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

    }

    public String assignCharsByteValue(String allChars){

        String[] charLines = allChars.split("\n");
        String allCharsAssignedValues = "";

        for(int i = 0; i < charLines.length; i++){
            allCharsAssignedValues += charLines[i] + "||" + i + "\n"; //hvis teksten indeholder || kan det blive et problem.

        }
        return allCharsAssignedValues;
    }

    public String CharScan(File file){
        String allChars = "";
        int count = 0;
        String line = "";
        try {
            Scanner scanner = new Scanner(file, "UTF-8");
            while(scanner.hasNextLine()){
                line += scanner.nextLine();
                line += "\n";
            }
            for(char ch : line.toCharArray()){
                if(!allChars.contains(String.valueOf(ch))){
                    if(String.valueOf(ch) != " "){
                        allChars += String.valueOf(ch) +"\n";
                        count++;
                    }
                }
            }

        }catch(FileNotFoundException e) {
            System.out.println(e);
        }
        //System.out.println(allChars);
        //System.out.println("Count: " + count);
        return allChars;
    }

}
