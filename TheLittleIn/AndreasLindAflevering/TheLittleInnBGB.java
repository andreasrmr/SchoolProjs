import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

//hashMapping ... Creation of new objects?.
//arrayLists ... The addition of new elements to an array... Somewhat. 

public class TheLittleInnBGB{
   public static void main(String[]args){
      //ArrayList[]roomsArrayList = new ArrayList();
      String[]roomOptions = {"Creat room","Delete room","Reserve room","Unreserve room","Check rooms"}; 
      Scanner choice = new Scanner(System.in);
      
      System.out.println("What do you want to do with the rooms? " + Arrays.toString(roomOptions));
      String want = choice.next();
      
      if(want.equals(roomOptions[0]) || want.equals("Create room") || want.equals("CR")){
         System.out.println("Type in the 3 required informations for the new room.");
         
         System.out.println("Room number / int");
         int newRoomNumber = choice.nextInt();
         
         System.out.println("Room size / int");
         int newRoomSize = choice.nextInt();
         
         System.out.println("Room price / double || int"); 
         double newRoomPrice = choice.nextDouble();
         
         Rooms newRoom = new Rooms(newRoomNumber, newRoomSize, newRoomPrice);  
         System.out.println(newRoom);
         
         //MAYBE: System.out.println("Want to create more rooms?");     
      }
         else if(want.equals(roomOptions[1]) || want.equals("Delete room") || want.equals("DR")){
            System.out.println("Which room do you want do delete?");
            //System.out.println(Arrays.toString(roomsArrayList);
            //int choiceDelete = choice.NextInt();
            //roomsArrayList.delete[choiceDelete];
            //MAYBE: System.out.println("Want to delete other rooms?")        
         }
            else if(want.equals(roomOptions[2]) || want.equals("Reserve room") || want.equals("RR")){
               System.out.println("Which room do you want to reserve?");
               //System.out.println(Arrays.toString(roomsArrayList)); 
               //int roomReserve = choice.nextInt();
               //Chosen Objects : roomAvability = false:
               //MAYBE: System.out.println("Do you want to reserve more rooms?"); 
            }
               else if(want.equals(roomOptions[3]) || want.equals("Unreserve room") || want.equals("UR")){
                  System.out.println("Which room do you want to unreserve?");
                  //Syste.out.println(Arrays.toString(roomsArrayList);
                  //int roomUnreserve = choice.nextInt();
                  //Object : roomAvability = true; 
                  //MAYBE: System.out.println("Do you want to unreserve more rooms?");   
               }
                  else if(want.equals(roomOptions[4]) || want.equals("Check room") || want.equals("CHR")){
                     System.out.println("Which room do you want to check?");
                     //System.out.pirntln(Arrays.toString(roomsArrayList);
                     //int roomCheck = choice.nextInt();
                     //System.out.println(Object : roomAvability);
                     //MAYBE: System.out.println("Do you want to check more rooms avability?");  
                  }
                     else{
                        System.out.println("You typed something wrong");
                        //Somekind of recall for user input.
                        //MAYBE: Make this into an while function?  
                     }
                  
   }     
}
     

class Rooms{
   private int roomNumber;
   private int size;
   private double price;
   private boolean avability;
   private boolean clean; 
   
   public Rooms(){
      this.roomNumber = 0;
      this.size = 0;
      this.price = 0.0;
      this.avability = true; 
      this.clean = true;
   }
   public Rooms(int roomNumber, int size, double price){
      this.roomNumber = roomNumber; 
      this.size = size; 
      this.price = price;
      this.avability = true;
      this.clean = true;  
   }
   //Setters.
   public void setRoomNumber(int roomNumber){
      this.roomNumber = roomNumber;
   }
   public void setSize(int size){
      this.size = size;
   } 
   public void setPrice(double price){
      this.price = price;
   } 
   public void setAvability(boolean avability){
      this.avability = avability;
   } 
   public void setClean(boolean clean){
      this.clean = clean;
   }  
   //Getters.
   public int getRoomNumber(int roomNumber){
      return this.roomNumber;
   }
   public int getSize(int size){
      return this.size;
   }
   public double getPrice(double price){
      return this.price;
   }
   public boolean getAvability(boolean avability){
      return this.avability;
   }
   public boolean getClean(boolean clean){
      return this.clean;
   } 
   //toString. 
   public String toString(){
      return " Room number: " + this.roomNumber + "\n size: " + this.size + "\n price: " + this.price + "\n avability: " + this.avability + "\n clean: " + this.clean;   
   }
}    
     
       
      
   
   
