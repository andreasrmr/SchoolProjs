import java.util.Scanner;
//static scanner

public class InputReading
{ 
   //constructor
   public InputReading()
   {
   }
   
   public static int scanInt()
   {
      Scanner skanner = new Scanner(System.in);
      int nummer = skanner.nextInt();
      return nummer;
   }

   public static String scanString()
   {
      Scanner skanner = new Scanner(System.in);
      String tekst = skanner.nextLine();
      return tekst;
   }
}