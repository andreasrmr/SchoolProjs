public class Customer
{
  //attributter
  private int passportNumber;
  private String guestName;
  
  //constructors
  public Customer()
  {
   passportNumber = 0;
   guestName = " ";
  }
  public Customer(int passportNumber, String guestName)
  {
   this.passportNumber = passportNumber;
   this.guestName = guestName;
  }
  
  //setters
  public void setPassportNumber(int passportNumber)
  {
   this.passportNumber = passportNumber;
  }
  public void setGuestName(String guestName)
  {
   this.guestName = guestName;
  }
  
  //getters
  public int getPassportNumber()
  {
   return passportNumber;
  }
  public String getGuestName()
  {
   return guestName;
  }
  
  //toString
   public String toString()
   {
      return "Navn: " + getGuestName() + "\tPassport Number: " + getPassportNumber();
   }
   
   //equals
   public boolean equals(Customer cust)
   {
      if(this.passportNumber == cust.getPassportNumber() 
         && this.guestName.equals(cust.getGuestName()))
      {
         return true;
      }
      else 
      { 
         return false;
      }
   }
}