import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Rooms{
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
   public int getRoomNumber(){
      return this.roomNumber;
   }
   public int getSize(){
      return this.size;
   }
   public double getPrice(){
      return this.price;
   }
   public boolean getAvability(){
      return this.avability;
   }
   public boolean getClean(){
      return this.clean;
   } 
   //toString. 
   public String toString(){
      return " Room number: " + this.roomNumber + "\n Size: " + this.size + "\n Price: " + this.price + "\n Avability: " + this.avability + "\n Clean: " + this.clean;   
   }
   //Equal?
}
