public class Customers{
   private int passNumber;
   private String custName;
    
   public Customers(){
      int passNumber = 0;
      String custName = "Default";
   }
   public Customers(int passportNumber, String customerName){
      int passNumber = passportNumber;
      String custName = customerName;
   }
   public void setPassportNumber(int passportNumber){
      this.passNumber = passportNumber; 
   }
   public void setCustomerName(String customerName){
      this.custName = customerName;
   }
   public int getPassportNumber(int passportNumber){
      return this.passNumber; 
   }
   public String getCustomerName(String customerName){
      return this.custName; 
   }
   public String toString(){
      return "PassNumber: " + this.passNumber + " customerName: " + this.custName; 
   }
   //}
   //Equals?
}