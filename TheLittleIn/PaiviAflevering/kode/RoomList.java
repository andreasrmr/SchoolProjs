import java.util.Arrays;

public class RoomList
{
   //array allokerer plads til 6 værelser
   //på denne måde kan jeg styre værelserne herfra
   Room[] room = new Room[6];
   
   //pris konstanter til enkelt- og dobbeltværelse
   final double PRIS1 = 500.00;
   final double PRIS2 = 600.00; 
   
  //constructor, som tilskriver værdier til room
   public RoomList()
   {
   room[0] = new Room (1,1,PRIS1, true, true);
   room[1] = new Room (2,1,PRIS1, true,true);
   room[2] = new Room (3,1,PRIS1, true, true);  
   room[3] = new Room (4,2,PRIS2, true, true);
   room[4] = new Room (5,2,PRIS2, true, true);
   room[5] = new Room (6,2,PRIS2, true, true);
   }
   
   //Metode til at printe en liste over ledige værelser
   
   public void erLedig ()
   {
      for (int i = 0; i< room.length;i++)
      {
         if (room[i].getAvailability()&&room[i].getClean())
         {
            System.out.println("Værelset nummer " + room[i].getRoomNumber() + " for " + room[i].getSize() + " person(er)");
         }
      }
   }
   
   //metode til at printe en liste over enkeltværelser
    public void erLedigtEnkEllerDob(int k)
    {
      for (int i = 0; i< room.length;i++)
      {
         if (room[i].getAvailability()&&room[i].getClean()&&room[i].getSize()==k)
         {
            k = 1;
            System.out.println("Værelset nummer " + room[i].getRoomNumber() + " for " + room[i].getSize() + " person(er)");
         }
         else if (room[i].getAvailability()&&room[i].getClean()&&room[i].getSize()==k)
         {
            k = 2;
            System.out.println("Værelset nummer " + room[i].getRoomNumber() + " for " + room[i].getSize() + " person(er)");
         }
         else if (k != 1 && k != 2)
         {
            System.out.println("Ingen ledige værelser, vælg en anden værelsestype");
         }
      }
   }
   
   //Metode til at printe en liste over bookede værelser
   
   public void erBooket ()
   {
      for (int i = 0; i< room.length;i++)
      {
         if (!(room[i].getAvailability()&&room[i].getClean()))
         {
            System.out.println("Værelset nummer " + room[i].getRoomNumber() + " er booket.");
         }
      }
   }
   //Metode til at booke et værelse, dvs. ændre status fra ledig til booked
   
   public void bookVaerelse(int valgteVaerelse)
   {
      for (int i = 0; i < room.length; i++) 
      {
         if(room[i].getRoomNumber() == valgteVaerelse)
         {
            room[i].setAvailability(false);
         }
      }
   }
}
