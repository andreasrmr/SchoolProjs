package chessSystem;

/**
 * @author Andreas Rømer
 * Klassen configurations tager sig af statiske system variabler
 * Til implementering af nye statiske variable gøres følgende:
 * 1. Definer variablen i config filen.(eks. tempFile=dbfiles/tempFile)
 * 2. opret private static "variabel" i programmet
 * 3. lav getMetode på ovenstående..
 * 4. Indsæt i switch statement.
 *
 * Klassen sikre desuden at filer findes og kan læses.
 * * **/

import java.io.File;
import static chessSystem.FileHandler.getLineNumOfValue;
import static chessSystem.FileHandler.readLine;
import static chessSystem.FileHandler.checkFile;

public class Configurations {
        //Configuration file pointer.
        private File config = new File("dbfiles/config");
        private boolean filecheck = true;
        private String fileErrorMessage = "";

        //Environment vars.
        private static File userLogins;
        private static File tempFile;
        private static File strengthList;
        private static File memberDatabase;
        private static int memberNumber;

        //Constructor
        public Configurations(){}

        //Getters
        public String getFileErrorMessage(){return fileErrorMessage; }

        public static File getConfig(){
            File config = new File("dbfiles/config");
            return config;
        }


        public static File recieveFileUserLogins(){
            return userLogins;
        }
        public static File recieveFileTempFile(){
            return tempFile;
        }
        public static File recieveFileStrengthList(){ return strengthList; }
        public static File recieveFileMemberDatabase(){ return memberDatabase; }
        public static int recieveIntNextMemberNumber(){
            memberNumber = memberNumber + 1;
            writeMemberNumberToDisk(memberNumber);
            return memberNumber;
        }

        /**
         * Write member number to disk method
         * @param newMemberNumber
         * @return void
         * **/
        private static void writeMemberNumberToDisk(int newMemberNumber){
            File config = getConfig();
            FileHandler fh = new FileHandler();
            String memberNumber = Integer.toString(newMemberNumber);
            int lineNum = getLineNumOfValue(config,0, "memberNumber");
            System.out.println(lineNum);
            fh.updateLine(config, lineNum, "memberNumber;" + memberNumber);
        }
        /**
         * Method loads configurations from configurations file.
         * @return returnere boolean alt efter om konfigurationer loades godt eller skidt.
         **/
         public boolean loadConfigurations(){
            System.out.println("-----CONFIGURATIONS LOADING-----");
            String line = ".";
            String[] lineItems = new String[0];
            int lineNum = 1;
            while (line != ""){
                line = readLine(getConfig(), lineNum);
                System.out.println(line);
                lineItems = line.split(";");
                switch (lineItems[0]){
                    case "userLogins":
                        if(checkFile(new File(lineItems[1]))){
                            this.userLogins = new File(lineItems[1]);
                        }
                        else {
                            fileErrorMessage += "Error on File: " + lineItems[1] + "\n";
                            filecheck = false;
                        }
                        break;
                    case "tempFile":
                        if(checkFile(new File(lineItems[1]))){
                            this.tempFile = new File(lineItems[1]);
                        }
                        else {
                            fileErrorMessage += "Error on File: " + lineItems[1] + "\n";
                            filecheck = false;
                        }
                        break;
                    case "strengthList":
                        if(checkFile(new File(lineItems[1]))){
                            this.strengthList = new File(lineItems[1]);
                        }
                        else {
                            fileErrorMessage += "Error on File: " + lineItems[1] + "\n";
                            filecheck = false;
                        }
                        break;
                    case "memberDatabase":
                        if(checkFile(new File(lineItems[1]))){
                            this.memberDatabase = new File(lineItems[1]);
                        }
                        else {
                            fileErrorMessage += "Error on File: " + lineItems[1] + "\n";
                            filecheck = false;
                        }
                        break;
                    case "memberNumber":
                        this.memberNumber = Integer.parseInt(lineItems[1]);
                        break;
                    case "":
                        break;
                    default:
                        System.out.println("System kender ikke variablen: " + lineItems[0] + " som er sat i configurationen");
                        break;
                }
                lineNum++;
            }
            if(filecheck){
                return true;
            }
            return false;
        }
        /**
         * Metoden checker om en fil eksistere og kan læses.
         * Hvis der er fejl tilføjes
         * @param file
         * **/
        /*private void checkFile(File file){
            if(!(file.exists() && file.canRead())){
                this.fileErrorMessage += "Error on File: " + file.toString() + "\n";
                this.filecheck = false;
            }
        }*/

}
