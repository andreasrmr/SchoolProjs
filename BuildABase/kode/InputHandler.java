import java.util.Scanner;
public class InputHandler {
    Scanner scanner;
    InputHandler(){
        scanner = new Scanner(System.in);
    }

    //Læser en string (returnere sig selv hvis der er er fejl)
    //Mangler - asger anbefaler at new scanner kun køres i constructor. Men så fejler programmet. Er der en scanner close et sted?
    public String readString() {
            scanner = new Scanner(System.in);
            return scanner.nextLine();
    }

    public int readInt() {
        // wait for integer input
        while(!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }
}


