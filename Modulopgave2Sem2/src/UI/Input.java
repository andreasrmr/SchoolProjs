package UI;

import java.util.Scanner;

public class Input {

    public static Scanner scanner = new Scanner(System.in);

    public static String readString(){
        return scanner.next();
    }

    public static int readInt() {
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}