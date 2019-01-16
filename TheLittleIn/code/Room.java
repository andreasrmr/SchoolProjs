public class Room {
   int roomNumber;
   int size;
   double price;
   boolean clean;
   boolean occupied;
   
   Room() {}
   
   Room(int roomNumber, double price){
      this.roomNumber = roomNumber;
      this.price = price;
      this.clean = true;
      this.occupied = false;
   }

   public int getRoomNumber(){ return this.roomNumber; }
   public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
   
   public double getPrice(){  return this.price; }
   public void setPrice(double price) { this.price = price; }
   
   public boolean getClean(){ return this.clean; }
   public void setClean(boolean clean) { this.clean = clean; }
   
   public boolean getOccupied() { return this.occupied; }
   public void setOccupied(boolean occupied) { this.occupied = occupied; }

   public String toString() {
      return "Room No: " + roomNumber + ", Price: " + price + ", Clean: " + clean + ", Occupied: " + occupied;
   }
   
   public boolean equals(Room room) {
      if(this.roomNumber == room.getRoomNumber()){
         return true;
      }
      else {
         return false;
      }
   }
}
