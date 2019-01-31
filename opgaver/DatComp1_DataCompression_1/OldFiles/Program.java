import java.io.File;

public class Program {
    public static void main(String[] args){
        DataCompression dc = new DataCompression();
        File aliceinw = new File("AliceInWonderland.txt");
        String allChars = dc.CharScan(aliceinw);
        String allCharsAssignedValues = dc.assignCharsByteValue(allChars);
        dc.compressTo(allCharsAssignedValues);

    }
}
