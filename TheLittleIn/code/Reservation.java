import java.util.ArrayList; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reservation {

   int reservationid = 10000;
   public static int instanceCounter = 0;
   Customer customer = new Customer();
   String dateOfBooking;
   int roomNumber;
   boolean activeStatus = true;
   DateFormat formatter = new SimpleDateFormat("dd/MM/yy");

   Reservation(){ }
   
   Reservation(int roomNumber, String customerName, int passportNumber) { 
      this.reservationid += instanceCounter;
      this.instanceCounter++;
      this.roomNumber = roomNumber;
      this.customer.setCustomerName(customerName);
      this.customer.setPassportNumber(passportNumber);
      
      Date date = Calendar.getInstance().getTime();
      this.dateOfBooking = formatter.format(date);
   }
   public int getReservationid() {return this.reservationid; }
     
   public String getDateOfBooking() {return this.dateOfBooking;}
   public void setDateOfBooking(String dateOfBooking) { this.dateOfBooking = dateOfBooking; }
   
   public int getRoomNumber() { return this.roomNumber; }
   public void setRoomNumber(int roomNumber){ this.roomNumber = roomNumber; }
   
   public void setActiveStatus(boolean isActiveStatus){ this.activeStatus = isActiveStatus; }
   public boolean getActiveStatus(){ return this.activeStatus; }
    
   public String toString() { return "Active Status: " + this.activeStatus + ", Reservation ID: " + this.reservationid + ", Room: " + this.roomNumber + ", Date: " + this.dateOfBooking + ", " + this.customer.toString(); }
   
   public boolean equals(Reservation reservation) {
      if(this.reservationid == reservation.getReservationid()){
         return true;
      }
      else {
         return false;
      }
   }  
}
