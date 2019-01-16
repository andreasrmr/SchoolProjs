public class Customer {
   int passportNumber;
   String customerName;
   
   Customer() {}
   
   Customer(int passportNumber, String customerName) {
      this.passportNumber = passportNumber;
      this.customerName = customerName;
   }
   
   public int getPassportNumber(){ return this.passportNumber; }
   public void setPassportNumber(int passportNumber) { this.passportNumber = passportNumber; }
   
   public String getCustomerName(){ return this.customerName; }
   public void setCustomerName(String customerName) { this.customerName = customerName; }
   
   public String toString(){
      return "Guestname: " + this.customerName + ", Passport Number: " + this.passportNumber;
   }
   public boolean equals(Customer cust){
      if(this.passportNumber == cust.getPassportNumber() && this.customerName == cust.getCustomerName()){
         return true;
      }
      else { 
      return false;
      }
   }
}