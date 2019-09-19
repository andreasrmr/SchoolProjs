
import DBUtil.DBExecute;
import Input.InputHandler;
import Queries.AntalBevaegelser;
import Queries.Foedselsoverskud;
import UI.Menu;

public class Program {
    boolean running;
    DBExecute dbE;

    Menu menu;
    public Program(){
        running = true;
        menu = new Menu();
        while(running){
            menu.showStartMenu();
            switch(InputHandler.readInt()){
                case 1:
                    dbE = new DBExecute(new AntalBevaegelser().toString());
                    break;
                case 2:
                    dbE = new DBExecute(new Foedselsoverskud().toString());
                    break;
                case 9:
                    running = false;
                    break;
            }
        }
    }

}
