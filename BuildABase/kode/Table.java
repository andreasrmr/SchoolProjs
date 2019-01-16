import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
public class Table {

    Scanner scanner;
    //Database path (.tsv)

    //Kolonne headers
    String columnHeaders;
    //Bruges af createNewLine.
    String nextUsableTconstKey = "";
    //Tabelnavn
    String tableName;
    //Angiver hvor vores tabelinfo filer ligger.

    File filePath;
    File tableInfoPath = new File("../Database/TableInfo/");
    File databaseDirectory = new File("../Database/BuildABaseDB");
    //Angiver temp fil ligger. (ens for alle klasser)
    String tempTsv = "../Database/TableInfo/temp.tsv";
    //indeholder linjenumre med hits fra searchInFile metoden.
    ArrayList<Integer> hits = new ArrayList<Integer>();
    PrintStream output;



    //constructors
    public Table() {}

    public Table(File filePath) throws IOException, FileNotFoundException {
            //.INFO filer.

        if(filePath.getAbsolutePath().contains("TableInfo")){

            //TabelNavn udledes uden .INFO
                this.tableName = filePath.getName().replace(".INFO", "");

            //Hent data i .INFO fil.
                scanner = new Scanner(filePath, "UTF-8");
                String line = scanner.nextLine();
                String[] arrayLine = line.split(";");

                //Indlæs TconstKey fra .INFO fil.
                this.nextUsableTconstKey = arrayLine[0];

                //Indlæs columnheaders fra .INFO fil.
                this.columnHeaders = arrayLine[1];

            //peg objektet på .tsv filen.
                this.filePath = new File(arrayLine[2]);
                scanner = new Scanner(filePath, "UTF-8");

            }
            //.TSV Fil.
            else {
                this.tableName = filePath.getName();
                this.filePath = filePath;
                //columnHeaders
                scanner = new Scanner(filePath, "UTF-8");
                columnHeaders = scanner.nextLine(); //scan forste linje i fil.

                if(columnHeaders.contains("tconst")){
                    this.nextUsableTconstKey = generateTconstKey();
                }

                //skriv fil til tableInfo fil.
                writeTableInfoToFile();
            }




    }
    //getters
    public String getFilePath() {
        return this.filePath.getAbsolutePath();
    }
    public String getTableName(){
        return this.tableName;
    }
    public String getColumnHeaders() {
       return this.columnHeaders;
    }

    //ingen setters.

    //Opretter / appender ny linje til fil.
    //Den kigger på genereret primary key i filen og genere en ny med tconstIncrement metoden.
    //virker kun på tabeller hvor tconst er primary key
    public void createNewLine(InputHandler input)
        {
            try {
                scanner = new Scanner(System.in);
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
                System.out.println("Indtast info her");

                String s = "";
                String[] newLine = new String[columnHeaders.split("\t").length];
                newLine = columnHeaders.split("\t");
                newLine[0] = this.nextUsableTconstKey;

                for (int i = 1; i < newLine.length; i++) {
                    System.out.println("Column: " + newLine[i] + "\nWrite Value: ");
                    newLine[i] = input.readString();
                }
                for (String str : newLine) {
                    s += str + "\t";
                }
                bw.write(s);
                bw.newLine();
                bw.flush();
                bw.close();
                System.out.println("line was added\n" + s);

                tconstIncrement();//inkrement tconst nøglen(tæl en op)
                writeTableInfoToFile();

            }catch (IOException e){
                System.out.println("Fejl: " + e);
            }

    }

    //Metoden kan slette linjer der er angivet i arrayList hits fra searchInFile() metoden
    //Metoden kan opdatere linjerne ved  at der er valgt kolonne og værdi.
    public void updateLines(FileHandler fileHandler, InputHandler input, Menu menu, String function){

        try{
            if(hits.size() == 0){
                System.out.println("Der er ingen resultater at opdatere");
            }
            else {
                int count = 1;

                //output skrives til tempTsv fil
                output = new PrintStream(tempTsv);

                //Der scannes på TSV filenx.
                scanner = new Scanner(filePath, "UTF-8");

                //columnChoice og Value bruges kun til update.
                int columnChoice = -1;
                String value = "";
                //Tag inputs hvis det er til update.
                if(function == "update"){
                    System.out.println("What column do you want to update?");
                    menu.showColumnHeaderMenu(this.columnHeaders);
                    columnChoice = input.readInt();
                    System.out.println("Input value to update: ");
                    value = input.readString();
                }

                //Tjek om der er nogle hits fra "searchInFile" metoden.
                while(hits.size() != 0){

                    //Loop hen til første linje der skal slettes eller opdateres
                    while (count < hits.get(0)){
                        output.print(scanner.nextLine() + "\n");
                        count++;
                    }

                //Update
                    if(function == "update"){
                        int columnHeaderIndex = columnChoice - 1;

                    //opdater kolonne i linje
                        String row = scanner.nextLine();
                        String[] arrRow = row.split("\t");
                        arrRow[columnHeaderIndex] = value;
                        row = "";

                        for(String str : arrRow){
                            row += str + "\t";
                        }
                        //udskriv ny row til filen.
                        row.trim();
                        output.print(row + "\n");
                    }

                //Delete
                    else if (function == "delete"){
                        //skip linje
                        scanner.nextLine();
                    }

                    //fjern linjenummer fra ArrayList
                    hits.remove(0);
                    count++;
                }
                //skriv resterende til der ikke er flere linjer.
                while(scanner.hasNextLine()){
                    output.print(scanner.nextLine() + "\n");
                }
                output.close();

                //overskriv temp til csv.
                fileHandler.copyFile(tempTsv, this.filePath.getAbsolutePath());
                System.out.println("Lines updated/deleted");
            }
        }catch (FileNotFoundException e){
            System.out.println("Fejl: " + e);
        }

    }

    //metoden lægger 1 til pkk tconst.
    public void tconstIncrement(){

        char[] charArray = nextUsableTconstKey.toCharArray();
        String numberAsStr = "";
        for(int i = 2; i < charArray.length; i++){
            numberAsStr += charArray[i];
        }
        int number = Integer.parseInt(numberAsStr);
        number = number + 1;
        this.nextUsableTconstKey = "tt" + number;
    }

    //Metoden genere næste usable TconstKey.
    //Kigger altid på første kolonne.
    private String generateTconstKey()
        {
                try {
                    scanner = new Scanner(filePath, "UTF-8");
                }
                catch (FileNotFoundException e){
                    System.out.println("Fejl: " + e);
                }
        String line = "";
        int highestNumber = 0;

        //skip first line (headers)
        scanner.nextLine();

        System.out.println("Generating new key");
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] arrLine = line.split("\t");
            char[] charArray = arrLine[0].toCharArray();
            String numberAsStr = "";
            for (int i = 2; i < charArray.length; i++) {
                numberAsStr += charArray[i];
            }

            int number = Integer.parseInt(numberAsStr);
            if (number > highestNumber) {
                highestNumber = number;
            }

        }
        nextUsableTconstKey = "tt" + (highestNumber + 1);
        System.out.println("Key generated: " + nextUsableTconstKey);
        return nextUsableTconstKey;
    }

    public void searchInFile(int columnChoice, String searchValue) {
        //opret ny liste af hits.
        this.hits = new ArrayList<Integer>();

        int lineCount = 0;
        String[] lineItem = new String[0];
        String[] arrColumnHeaders = this.columnHeaders.split("\t");
        int columnHeaderIndex = columnChoice - 1;

        try {
            scanner = new Scanner(filePath, "UTF-8");
            System.out.println(this.columnHeaders+ "\n-------------------------------");
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                lineItem = str.split("\t");
                lineCount++;

                if (lineItem[columnHeaderIndex].equals(searchValue)) {
                    for (String str2 : lineItem) {
                        System.out.print(str2 + "\t");
                    }
                    //tilføj linjenummeret til arrayliste.
                    this.hits.add(lineCount);
                    System.out.println();
                }
            }
            if (this.hits.size() == 0) {
                //lineItem = new String[0];
                System.out.println("kolonne: " + arrColumnHeaders[columnHeaderIndex] + " | value: " + searchValue + " kunne ikke findes");

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        scanner.close();
        System.out.println("\nLines found: " + hits.size());
    }

    public String toString() {
        String str = "Tablename : " + this.tableName + "\n";
        str += "Column Headers: " + this.columnHeaders + "\n";
        str += "File path: " + this.filePath + "\n";
        str += "File Length: " + this.filePath.length() + "\n";
        return str;
    }

    public void writeTableInfoToFile()
    {
        try {
            //opret dir der skal skrives til.
            tableInfoPath.createNewFile();

            //klargør skriv til dest + filnavn
            PrintStream out = new PrintStream(this.tableInfoPath + "/" + tableName + ".INFO");

            //overskriv til fil
            out.println(this.nextUsableTconstKey + ";" + this.columnHeaders + ";" + this.filePath + ";");

            //luk
            out.close();

        }catch (FileNotFoundException e){
            System.out.println("Fejl: " + e);
        }
        catch (IOException e){
            System.out.println("Fejl: " + e);
        }
    }

    //læser et antal linjer i filen i en given range. (f)
    public void readTable(InputHandler input) {
        System.out.println("Write line startnumber: ");
        int startLine = input.readInt();
        System.out.println("Write line endNumber: ");
        int endLine = input.readInt();

        try {
            scanner = new Scanner(filePath, "UTF-8");
        }
        catch(FileNotFoundException e){
            System.out.println("Fejl:" + e);
        }

        System.out.println(columnHeaders.toString());
        int line = 0;
        //skip first line. (headers)
        scanner.nextLine();
        while(line < startLine){
            scanner.nextLine();
            line++;
        }
        while(line <= endLine && scanner.hasNextLine() == true){
            System.out.println(scanner.nextLine());
            line++;
        }
    }
}