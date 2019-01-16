package chairmanManagement;

import static chessSystem.Configurations.recieveFileMemberDatabase;
import static chessSystem.FileHandler.*;
import java.io.File;

public class MMFH {
        MMFH(){}
        public void printRawDataList() {
            File file = recieveFileMemberDatabase();
            int lineNum = 1;
            String line = ".";
            while (line != ""){
                line = readLine(file, lineNum);
                System.out.println(line);
                lineNum++;
            }
        }
    }

