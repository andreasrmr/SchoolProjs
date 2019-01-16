import java.util.ArrayList;
import java.util.Arrays;

public class RunBandB
{
   
   public static void main(String[] args)
   {
      boolean running = true;
      RoomList roomList = new RoomList();
      ArrayList<Reservation> resPerDay = new ArrayList<Reservation>();

      while(running) 
      {
         System.out.print(displayStartMenu());
         int menuValg = InputReading.scanInt();

         if (menuValg == 1)
         {
            //Vi spørger, hvor mange gæster - indeholder metodekald på static metode
            System.out.println("Velkommen! Skal det være et værelse til 1 eller 2 personer?");
            
            boolean rigtigtValg = true;
            
            while (rigtigtValg==true) 
            {
               int antalGaester = InputReading.scanInt();
               
               if(antalGaester == 1 || antalGaester == 2)
                  {
                     System.out.println("Du har valgt: " + antalGaester + ". \nVi henter et ledigt værelse til dig.");
                     roomList.erLedigtEnkEllerDob(antalGaester);
                     rigtigtValg = false;
                     
                  }
               else
                  {
                     System.out.println("Vælg venligst et værelse til 1 eller 2 personer");
                     rigtigtValg = true;
                  } 
            }
            //Vælg et værelse
            System.out.println("Angiv venligst nummeret på det værelse, du vil reservere.");
            int valgteVaerelse = InputReading.scanInt();
            System.out.println("Du har valgt: " + valgteVaerelse + ". \nVi laver en reservation.");
            //Hvad er datoen?
            System.out.println("Hvad er datoen?");
            String dato = InputReading.scanString();
            //Hvad er navnet?
            System.out.println("Hvad er navnet?");
            String kundeNavn = InputReading.scanString();
            //Hvad er passnummeret?
            System.out.println("Hvad er pasnummeret?");            
            int pasnummer = InputReading.scanInt();
      
            //laver kunden
            Customer kunde1 = new Customer(pasnummer, kundeNavn);

            //laver en reservation - reservationId = værelsenummer
            resPerDay.add(new Reservation(valgteVaerelse,dato,kunde1));
      
            //laver den endelige reservation med kunde og værelse
            BookingSystem finalReservation1 = new BookingSystem(resPerDay.get(0),roomList);
            System.out.println(finalReservation1.toString()); 
            System.out.println(roomList.room[valgteVaerelse-1].toString());
   
            //ændrer det pågældende værelse til booket
            roomList.bookVaerelse(valgteVaerelse);
      
         }
         else if (menuValg == 2) 
         {
            for (int i = 0; i < resPerDay.size(); i++)
            {
               System.out.println(resPerDay.get(i).toString());
            }
         }
         else if (menuValg == 3)
         {
            roomList.erLedig();
         }
         
         else if (menuValg == 4)
         {
            roomList.erBooket();
         }   
         else if (menuValg == 5)
         {
            System.out.println("Hvad er reservationsnummer(det samme som værelsesnummeret)?");            
            int resnummer = InputReading.scanInt();
            System.out.println("Hvad er det nye navn?");
            String nytNavn = InputReading.scanString();
            System.out.println("Hvad er passportnummeret?");
            int nytPas = InputReading.scanInt();
            
            for (int i = 0; i<resPerDay.size();i++)
            {
               if (resnummer == resPerDay.get(i).getReservationId())
               {
               resPerDay.get(i).opdatereKundeOplysninger(nytPas, nytNavn);
               System.out.print("Den opdaterede reservation: ");
               System.out.println(resPerDay.get(i).toString());
               }
            }
         }        
         else if (menuValg == 6)
         {
            running = false;
         } 
      }
    }
      public static String displayStartMenu()
      {
         String menu = "\nVælg et menupunkt\n";
         menu += "1. Lav en reservation\n";
         menu += "2. Print alle reservationer\n"; 
         menu += "3. Print alle ledige værelser\n";   
         menu += "4. Print alle bookede værelser\n";      
         menu += "5. Opdatere kundeoplysninger i en reservation\n";       
         menu += "6. Luk programmet\n";
         return menu;
      }
}