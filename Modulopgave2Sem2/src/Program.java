import DBUtil.DBManagement;
import KrydsordsGenerator.KrydsordsGeneratorV1;
import KrydsordsGenerator.KrydsordsGeneratorV2;
import UI.Input;
import UI.Menu;


public class Program {
    boolean running;

    Menu menu;
    DBManagement dbManagement;

    public Program(){
        running = true;
        menu = new Menu();
        dbManagement = new DBManagement();
        KrydsordsGeneratorV1 krydsordsGeneratorV1 = new KrydsordsGeneratorV1();

        while(running){
            menu.visMenu();
            switch(Input.readInt()) {
                case 1:
                    dbManagement.Filtrer();
                    break;
                case 2:
                    krydsordsGeneratorV1.countSolutions();
                    break;
                case 3:
                    dbManagement.createOrd();
                    break;

                case 4:
                    krydsordsGeneratorV1.printKrydsord();
                    break;
                case 5:
                    dbManagement.deleteOrd();
                    break;
                case 6:
                    new KrydsordsGeneratorV2();

                case 9:
                    running = false;
                    break;
            }
        }

    }

}