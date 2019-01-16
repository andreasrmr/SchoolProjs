import java.util.ArrayList;

public class ReservationList{
   ArrayList<Reservation> reservations = new ArrayList<Reservation>();
   
   public ReservationList(){}
   
   //opret reservation
   public void createReservation(String customerName, int passportNumber, int roomNumber){        
         reservations.add(new Reservation(roomNumber, customerName, passportNumber));
         }
         
   //check værelse ud.
   public boolean checkoutReservation(int roomNumber){
      for(int i = 0; i < reservations.size(); i++) {
         if(reservations.get(i).getRoomNumber() == roomNumber){
            reservations.get(i).setActiveStatus(false);
            return true;
         } 
      }
      return false;
   }
   public void listActiveReservations(){
      for (int i = 0; i < reservations.size(); i++) {     
         if(reservations.get(i).getActiveStatus()){
            System.out.println(reservations.get(i).toString());
         }
         
      }
   }
   public void listInactiveReservations(){
      for (int i = 0; i < reservations.size(); i++) {
         if(reservations.get(i).getActiveStatus() == false){
            System.out.println(reservations.get(i).toString());
         }
         
      }
   }
}
   