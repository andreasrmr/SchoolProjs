public class Reservations{
   private int customerId;
   private int stayTime;
   private int roomStay; 
   
   public Reservations(){
      this.customerId = 0;
      this.stayTime = 0; 
      this.roomStay = 0;
   }
   public Reservations(int customerId, int stayTime, int roomStay){
      this.customerId = customerId; 
      this.stayTime = stayTime;
      this.roomStay = roomStay;
   }
   public void setCustomerId(int customerId){
      this.customerId = customerId;
   }
   public void setStayTime(int stayTime){
      this.stayTime = stayTime;
   }
   public void setRoomStay(int roomStay){
      this.roomStay = roomStay;
   }
   public int getCustomerId(){
      return this.customerId;
   }
   public int getStayTime(){
      return this.stayTime;
   }
   public int getRoomStay(){
      return this.roomStay;
   }
   
   
   public String toString(){
      return "CustomerId: " + this.customerId + " Customer stayTime: " + this.stayTime; 
   }
   

}