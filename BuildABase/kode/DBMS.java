import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class DBMS {

    //attributter
    boolean running = false;
    ArrayList<Table> tableList = new ArrayList<Table>();
    File[] databaseFilesList; //indeholder liste med filer i $databaseDirectory
    File[] tableInfoFilesList; //indeholder liste med navne på filer i $tableInfoDirectory
    File[] tableInfoFilesList; //indeholder liste med navne på filer i $tableInfoDirectory
    //attributter rettes eventuelt
    File databaseDirectory = new File("../Database/BuildABaseDB");
    File tableInfoDirectory = new File("../Database/TableInfo");


    //objekter oprettes
    InputHandler input = new InputHandler();
    Menu menu = new Menu();
    FileHandler fileHandler = new FileHandler();
    Table table;

    public DBMS()
    {
        //Programmet koerer
        boolean running = true;

        //Check database filer i DB Dir - Returnere True hvis en fil ikke kan laeses eller er ikke-eksisterende.
        if(fileHandler.checkDBFiles(databaseDirectory)){
            System.out.println("Der er fejl i en eller flere filer\nCheck dine filer");
            //programmet stopper
            running = false;
        }
        else {
            System.out.println("files checked - Loading program");

            //læs tableInfo dir for filer.
            tableInfoFilesList = tableInfoDirectory.listFiles(); //læs TableInfo filnavne ind i array.

            //læs databaseDir for filer
            databaseFilesList = databaseDirectory.listFiles(); //læs DB filnavne ind i array

            //Sammenligner tableInfoFilesList og databaseFilesList.
            //Hvis .INFO fil findes i tableInfoFilesList oprettes objekt herfra.
            //Hvis .INFO fil ikke findes oprettes objekt fra .TSV fil.
            try {
                for(File file : databaseFilesList){
                    boolean found = false;
                    for(File fileInfo : tableInfoFilesList){

                    //objekt generes fra .INFO fil - hvis den findes.
                        String tempName = file.getName() + ".INFO";
                        if(tempName.equals(fileInfo.getName())){
                            File FullPathFile = new File(tableInfoDirectory + "/" + file.getName() + ".INFO");
                            tableList.add(new Table(FullPathFile));
                            found = true;
                        }
                    }
                    //objekt generes fra .TSV fil.
                    if(found == false){
                        System.out.println("Objekt oprettet: " + file.getName());
                        File FullPathFile = new File(databaseDirectory + "/" + file.getName());
                        tableList.add(new Table(FullPathFile));
                    }
                }
            }catch (IOException e){
                System.out.println("Fejl: " + e);
            }
            System.out.println("Press enter to continue");
            input.readString();

        }
        while (running){
            menu.showMainMenu();
            switch (input.readInt()){

                //Søg i en fil.
                case 1:
                    System.out.println("Search in file");
                    //vis menu over database filer.
                    menu.showTableMenu(databaseFilesList);

                    //vælg en tabel.
                    table = tableList.get(input.readInt() - 1);

                    //vis en menu over kolonner
                    menu.showColumnHeaderMenu(table.columnHeaders);

                    //vælg en kolonne
                    System.out.println("what column header do you want to search in?");
                    int columnChoice = input.readInt();

                    //vælg hvad du vil søge på.
                    System.out.println("What do you want to search for?");
                    String searchValue = input.readString();

                    //find linje og set i table.
                    table.searchInFile(columnChoice, searchValue);
                    menu.showUpdateDeleteMenu();
                    switch (input.readInt()){
                        case 1: //Slet de linjer der er søgt på.
                            table.updateLines(fileHandler, input, menu, "delete");
                            break;

                        case 2: //Opdater en kolonne udfra de linjer der er fremsøgt.
                            table.updateLines(fileHandler, input, menu, "update");
                            break;
                        case 3: //exit
                            break;
                        default:
                            System.out.println("Fejl");
                            break;

                    }
                    input.readString();
                    break;

            //opret ny linje i fil
                case 2:
                    System.out.println("Create new Line - Append to file");
                    //vis menu over database filer.
                    menu.showTableMenu(databaseFilesList);
                    //vælg en tabel
                    table = tableList.get(input.readInt() - 1);
                    //opret ny linie
                    table.createNewLine(input);
                    //tryk enter for at komme til menuen.
                    input.readString();
                    break;

            //læs linjer (range)
                case 3: //read lines from table.
                    menu.showTableMenu(databaseFilesList);
                    //vælg tabel.
                    table = tableList.get(input.readInt() - 1);
                    System.out.println("Read range of rows in file");
                    //kald readTable metode.
                    table.readTable(input);
                    //tryk enter for at komme til menuen.
                    input.readString();
                    break;

            //List table info
                case 4:
                    for(Table tables : tableList){
                        System.out.println(tables.toString());
                    }
                    System.out.println("\n\n.. Press enter for menu ..");
                    input.readString();
                    break;

            //Exit
                case 9:
                    //gem tabel info når programmet lukkes.
                    for(Table table : tableList){
                        table.writeTableInfoToFile();
                    }
                    running = false;
                    break;
                default:
                    System.out.println("Tast et nummer fra menuen");
                    break;
            }
        }
    }

}





