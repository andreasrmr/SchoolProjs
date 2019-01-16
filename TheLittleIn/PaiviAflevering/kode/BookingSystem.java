public class BookingSystem
{
   //attributter

   private Reservation res;
   private RoomList roomList;
   
   //constructors
   public BookingSystem()
   {
      this.res = new Reservation();
      this.roomList = new RoomList();
   }
   
   public BookingSystem(Reservation res, RoomList roomList)
   {
      this.res = res;
      this.roomList = roomList;
   } 
   //setters

   public void setRes (Reservation res)
   {
      this.res = res;
   }
   public void setRoomList (RoomList roomList)
   {
      this.roomList = roomList;
   }
   //getters

   public Reservation getRes()
   {
      return this.res;
   }
   public RoomList getRoomList()
   {
      return this.roomList;
   }
   //toString - her er roomList ikke er med, fordi den ikke har nogen String-metode
   public String toString()
   {
      return "Din reservation: " + this.getRes().toString();
   }
}