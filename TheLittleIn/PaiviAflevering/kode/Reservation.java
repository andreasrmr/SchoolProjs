public class Reservation    
{
   //attributter, Customer datatype, kunde variabelnavn
   private int reservationId;
   private String date;
   private Customer kunde;
   
   //constructors
   Reservation() 
   {
      reservationId = 0;
      date = " ";
      kunde = new Customer();
   }
   Reservation(int reservationId, String date, Customer kunde)
   {
      this.reservationId = reservationId;
      this.date = date;
      this.kunde = kunde;
   }
   
   //setters
   public void setReservationId(int reservationId) 
   { 
      this.reservationId = reservationId; 
   }
   public void setDate(String date) 
   { 
      this.date = date; 
   }
   public void setKunde(Customer kunde)
   {
      this.kunde = kunde;
   }
   
   //getters
   public int getReservationId()
   { 
      return this.reservationId; 
   }
   
   public String getDate() 
   {  
      return this.date; 
   }
   public Customer getKunde()
   {
      return this.kunde;
   }
   public void opdatereKundeOplysninger(int passportNumber, String nytNavn)
   {
      this.kunde.setPassportNumber(passportNumber);
      this.kunde.setGuestName(nytNavn);
   }   

   //toString
   public String toString() 
   {
      String s = "Reservationsnummer: " + getReservationId();
      s += "\tDato: " + getDate();
      s += "\t" + this.getKunde().toString();
      return s;
   }
   //equals
   public boolean equals(Reservation res) 
   {
      if(this.getReservationId() == res.getReservationId()
         && this.getKunde().equals(res.getKunde()))
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
}