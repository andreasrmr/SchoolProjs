public class RoomList{

   Room[] room = new Room[10];
     
   public RoomList(){
      //opretter 10 værelser.
     for(int i = 0; i < 10; i++){
        room[i] = new Room(i + 1, 500);
     }         
   }
   public Room[] getRoomList() { return this.room; }
      
   public void printRoomList() {
      for(int i = 0; i < room.length; i++) {
         System.out.println(room[i].toString());
      }
   }
   public void printAvailRooms(){
      for(int i = 0; i < room.length; i++) {
         if(room[i].getOccupied() == false && room[i].getClean() == true) {
            System.out.println(room[i].toString());
         }
      }
   }
   public void printOccupiedRooms(){
      for(int i = 0; i < room.length; i++) {
         if(room[i].getOccupied() == true) {
            System.out.println(room[i].toString());
         }
      }
   }
   public boolean printDirtyEmptyRooms(){
      String str = "";
      for(int i = 0; i < room.length; i++){
         if(room[i].getOccupied() == false && room[i].getClean() == false){
            str += room[i].toString();
         }
      }
      if(str == ""){
         return false;
      }
      System.out.println(str);
      return true;
   
   }
   public void occupyRoom(int roomNumber){
      for (int i = 0; i < room.length; i++) {
         if(room[i].getRoomNumber() == roomNumber){
            room[i].setOccupied(true);
            room[i].setClean(false); 
         }
      }
   }
   public void emptyRoom(int roomNumber){
      for (int i = 0; i < room.length; i++) {
         if(room[i].getRoomNumber() == roomNumber){
            room[i].setOccupied(false); 
         }
      }
   }
   public boolean cleanRoom(int roomNumber){
      for (int i = 0; i < room.length; i++) {
         if(room[i].getRoomNumber() == roomNumber){
            if(room[i].getClean() == false){
               room[i].setClean(true); 
               return true;
            }
            else {
               return false;
            }
         }
      }
      return false;
   }

   public int findReadyRoom(){
      for(int i = 0; i < room.length; i++){
         //hvis værelse er rent og ikke optaget bliver det brugt
         if(room[i].getClean() == true && room[i].getOccupied() == false){
            
            return room[i].getRoomNumber();
         }
      }
      return 0;
   }
}