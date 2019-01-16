package teamLeaderManagement;

import static chessSystem.FileHandler.*;
import static chessSystem.Configurations.recieveFileStrengthList;

import java.io.*;
import java.util.*;

public class TeamLeaderFH
{
  public TeamLeaderFH()
  {}
    /**
     * @Author Andreas Rømer
     * **/
    public static void generateStrengthList(){
        File strengthList = recieveFileStrengthList();
        int lineNum = 2;
        String line = "";
        String[] arrMemberAndRating;
        ArrayList<String> listMember = new ArrayList<String>();
        ArrayList<String> listRating = new ArrayList<String>();

        //tilføj members + rating på hver deres liste.
        //Hvert index i de 2 lister høre sammen.
        do{
            line = readLine(strengthList, lineNum);
            if(line != ""){
                arrMemberAndRating = line.split(";");
                listMember.add(arrMemberAndRating[1]);
                listRating.add(arrMemberAndRating[2]);
            }
            lineNum++;
        }while (line != "");

        //Så længe der er flere medlemmer i listen køres loopet.
        while(!(listMember.isEmpty())){
            //Tag første element. (rating + member)
            String member = listMember.get(0);
            int rating = Integer.parseInt(listRating.get(0));

            //fjern første element (rating + member)
            listMember.remove(0);
            listRating.remove(0);

            //check om der er flere forekomster af et member,
            //hvis der er, tilføjes rating, og member + rating fjernes fra liste.
            while(listMember.indexOf(member) != -1){
                int index = listMember.indexOf(member);
                rating += Integer.parseInt(listRating.get(index));
                listMember.remove(index);
                listRating.remove(index);
            }
            System.out.println("Member number: " + member + " Rating: " + rating);

        }

    }

}