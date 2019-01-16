import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TheLittleInn{
   public static void main(String[]args){
      ArrayList<Rooms>roomsArrayList = new ArrayList<Rooms>();
      ArrayList<Reservations>reservationArrayList = new ArrayList<Reservations>();
      boolean go = true;
      int number = 0;  
     
      while(go){
         String[]options = {"CreateRoom/CR", "DeleteRoom/DR", "CheckRooms/CHR", "ReserveRoom/RR", "UnreserveRoom/UR","CleanRoom/CLR"};
         System.out.println(Arrays.toString(options));
         Scanner choice = new Scanner(System.in);
         String adminChoice = choice.next();
         
         if(adminChoice.equals("CreateRoom") || adminChoice.equals("CR")){
            //System.out.print("Room number?: ");
            //int newRoomNumber = choice.nextInt();
            System.out.print("Rooms size?: "); 
            int newRoomSize = choice.nextInt();
            System.out.print("Room price?: "); 
            double newRoomPrice = choice.nextDouble();
            //number += 1;
            Rooms newRoom = new Rooms(number+1 /*newRoomNumber*/ , newRoomSize, newRoomPrice);
            roomsArrayList.add(newRoom);
            number += 1;
            System.out.println();
            //System.out.println(roomsArrayList);
            for(int i = 0; i < roomsArrayList.size(); i++){
               System.out.println(roomsArrayList.get(i));
               System.out.println();
            }        
         }
         else if(adminChoice.equals("DeleteRoom") || adminChoice.equals("DR")){
            System.out.println("Which room do you want to delete?");
            System.out.println();
            for(int i = 0; i < roomsArrayList.size(); i++){
               System.out.println(roomsArrayList.get(i));
               System.out.println();
            }
            int deleteRoom = choice.nextInt();
            for(int i = 0; i < roomsArrayList.size(); i++){
               if(deleteRoom == roomsArrayList.get(i).getRoomNumber()){
                  roomsArrayList.remove(deleteRoom-1);    
               } 
            }
         }
         else if(adminChoice.equals("CheckRoom") || adminChoice.equals("CHR")){
            for(int i = 0; i < roomsArrayList.size(); i++){
               System.out.println(roomsArrayList.get(i));
               System.out.println();
            }
         }
         else if(adminChoice.equals("ReserveRoom") || adminChoice.equals("RR")){
            System.out.println("Which room would you like to reserve? ");
               for(int i = 0; i < roomsArrayList.size(); i++){
                  System.out.println(roomsArrayList.get(i));
                  System.out.println();
               }
            int roomReserve = choice.nextInt();
               for(int i = 0; i < roomsArrayList.size(); i++){
                  if(roomReserve == roomsArrayList.get(i).getRoomNumber()){
               }
            }
            System.out.print("Write your customerId here: "); 
            int guestId = choice.nextInt();
            System.out.println("Write how many days you will be staying: ");
            int stayTime = choice.nextInt();
            Reservations newReservation = new Reservations(guestId, stayTime, roomReserve);
            //Didn't figure out how to attatch the reservation to a room.
            //Didn't figure out how to change a specific rooms avability.
            //Didn't figure out how to chage a specific rooms cleanes.
            //roomsArrayList(roomReserve).setAvability(false);
            //roomsArrayList(roomReserve).setClean(false);
         }
      }             
   }
}




   