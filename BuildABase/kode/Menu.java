import java.io.*;
public class Menu {
    public Menu() {};

    //main menu
    public void showMainMenu() {
        clearConsole();

        String mainMenu = "----Main menu----\n";
        mainMenu += "1. Search line in file\n";
        mainMenu += "2. Create new Line in file\n";
        mainMenu += "3. Read lines from Table\n";
        mainMenu += "4. List tables info \n";
        mainMenu += "9. Exit\n";

        System.out.print(mainMenu);
        }

    //tabel menu
    public void showTableMenu(File[] databaseFilesList){
        clearConsole();
        String tableMenu = "----Choose Table To Read/Edit-----\n";
        for(int i = 0; i < databaseFilesList.length; i++){
            System.out.println(i + 1 + ". " + databaseFilesList[i].getName());
        }
        System.out.println(tableMenu);
        System.out.println(tableMenu);
    }
    //menu med columnheaders
    public void showColumnHeaderMenu(String columnHeaders){
        String[] arrColumnHeaders = columnHeaders.split("\t");
        System.out.println("Choose a column");

        for(int i = 0; i < arrColumnHeaders.length; i++){
            System.out.println(i + 1 + ". " + arrColumnHeaders[i]);
        }
    }
    public void showUpdateDeleteMenu(){
        String UDmenu = "1. Delete line\n";
        UDmenu += "2. Update line\n";
        UDmenu += "3. Exit to main menu";
        System.out.println(UDmenu);
    }

    //Clear konsol - ikke testet på MAC.
    private static void clearConsole() {
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
