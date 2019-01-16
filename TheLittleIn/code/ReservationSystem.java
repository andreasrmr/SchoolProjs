import java.util.Scanner;
public class ReservationSystem {
   
   //one room, one reservation, one day
   boolean running = false;
   RoomList roomList = new RoomList(); 
   ReservationList reservationList = new ReservationList();
   
   public ReservationSystem(){
         running = true;   
            System.out.print("\033[H\033[2J");

         while (running == true){
                          
            //display start menu
            System.out.println(displayStartMenu());
         
            switch(readInt()){
               
               //Create reservation
               case 1: {
                  int roomNumber = roomList.findReadyRoom();
                  if(roomNumber != 0){
                     System.out.println("Indtast gaest navn");
                     String customerName = readString();
                     System.out.println("Indtast passport nummer");
                     int passportNumber = readInt();
                     reservationList.createReservation(customerName, passportNumber, roomNumber);
                     roomList.occupyRoom(roomNumber);
                     System.out.println("Reservation oprettet");
                  }
                  else {
                     System.out.println("Der er desværre ikke flere ledige/rene værelser tilbage\n");
                  }   
                  backToMenu();                                              
                  break;
               }
               
               //Udtjekning
               case 2: {
                  System.out.println("------- AKTIVE RESERVATIONER -------");
                  reservationList.listActiveReservations();
                  System.out.println("\nUdtjekning, indtast værelsesnummer: ");
                  int roomNumber = readInt();
                  if(reservationList.checkoutReservation(roomNumber)){
                     //tøm værelse
                     roomList.emptyRoom(roomNumber);
                     System.out.println("Værelse: " + roomNumber + " er tjekket ud");              
                     //Udskriv pris.
                     System.out.println("Prisen er: " + roomList.room[roomNumber].getPrice());                                      
                  }
                  else {
                     System.out.println("Værelset har aldrig været tjekket ind eller findes ikke");                     
                  }
                  backToMenu();
                  break;             
               }
               //List aktive reservationer.
               case 3: {
                  System.out.println("------- AKTIVE RESERVATIONER -------");
                  reservationList.listActiveReservations();
                  backToMenu();
                  break;
               }
               //List inaktiv reservationer (udtjekkede)
               case 4: {
                  System.out.println("------- INAKTIVE RESERVATIONER -------");
                  reservationList.listInactiveReservations();
                  backToMenu();
                  break;
               }
               //Udskriv værelser der ikke er optaget
               case 5: {
                  System.out.println("------- LEDIGE VÆRELSER -------");
                  roomList.printAvailRooms();
                  backToMenu();
                  break;
               }
               //udskriv værelser der er optaget
               case 6: {   
                  System.out.println("------- OPTAGEDE VÆRELSER -------");
                  roomList.printOccupiedRooms();
                  backToMenu();
                  break;
               }
               //Housekeeping kan rengøre værelser så de kan udlejes på ny
               case 7: {
                  if(roomList.printDirtyEmptyRooms()){
                     System.out.println("Indtast værelses nummer der skal rengøres");
                     if(roomList.cleanRoom(readInt())){
                        System.out.println("Værelset er sat i clean, og kan udlejes igen.");
                     }
                     else {
                        System.out.println("Værelset er allerede clean eller findes ikke");
                     }
                  }
                  else {
                     System.out.println("Der er ingen tomme værelser at rengøre");
                  }
                  backToMenu();                  
                  break;
               }
              //stop program
               case 9: {
                  running = false;
                  break;
               }
               default: {
                  System.out.println("Fejl - indtast venligst et nummer i menuen");
                  backToMenu();
                  break;               
               }
          }
      }
   }
   public String displayStartMenu(){
      String mn = "1. Create Res\n";
      mn += "2. Checkout Res\n";
      mn += "3. List Active Res\n";
      mn += "4. List Inactive Res\n";
      mn += "5. Print Available Rooms\n";
      mn += "6. Print Occupied Rooms\n";
      mn += "7. Housekeeping Section\n";
      mn += "9. Exit";
      return mn;
   }
   public int readInt() {
      Scanner scanner = new Scanner(System.in);
      try {
         return scanner.nextInt();
      } catch(Exception e) {
         System.out.println("Fejl - indtast venligst et nummer");
         return readInt();
      }
   }
   public String readString() {
      Scanner scanner = new Scanner(System.in);
      try {
         return scanner.nextLine();
      } catch(Exception e) {
         return readString();
      }
   }
   public void backToMenu(){
      System.out.println("\nPress Enter for menu..");
      readString();
      System.out.print("\033[H\033[2J");
   }
}
