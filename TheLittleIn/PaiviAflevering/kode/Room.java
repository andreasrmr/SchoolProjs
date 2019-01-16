public class Room    
{
   //attributter
   private int roomNumber;
   private int size;
   private double price;
   private boolean clean;
   private boolean availability;

   //constructors
   Room() 
   {
      roomNumber = 0;
      size = 0;
      price = 0.0;
      clean = true;
      availability = true;  
   }

   Room(int roomNumber, int size, double price, boolean clean, boolean availability)
   {
      this.roomNumber = roomNumber;
      this.size = size;
      this.price = price;
      this.clean = clean;
      this.availability = availability;
   }
   
   //setters 
   public void setRoomNumber(int roomNumber) 
   { 
      this.roomNumber = roomNumber; 
   }
   public void setSize(int size) 
   { 
      this.size = size; 
   }
   public void setPrice(double price) 
   { 
      this.price = price; 
   }
   public void setClean(boolean clean) 
   { 
      this.clean = clean; 
   }
   public void setAvailability(boolean availability) 
   { 
   this.availability = availability; 
   }

   //getters 
   public int getRoomNumber()
   { 
      return this.roomNumber; 
   }
   public int getSize() 
   {  
      return this.size; 
   }
      public double getPrice()
   {  
      return this.price; 
   }
      public boolean getClean()
   { 
      return this.clean; 
   }
      public boolean getAvailability() 
   { 
      return this.availability; 
   }
   
   //toString
   public String toString() 
   {
      String p = "Room number: " + getRoomNumber();
      p+= "\tSize: " + getSize();
      p+= "\tPrice: " + getPrice();
      p+= "\tclean " + getClean();
      p+= "\tavailability: " + getAvailability() + "\n ";
      return p;
   }
   //equals
   public boolean equals(Room room) 
   {
      if(this.roomNumber == room.getRoomNumber())
      {
         return true;
      }
      else 
      {
         return false;
      }
   }    
}