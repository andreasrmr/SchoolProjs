class Staff {
   int staffID = 0;
   static int instancecounter = 0;
   String fullName = "";
   int phoneNumber;
   String position;
   //0 = admin
   //1 = staff
   int accessLevel;
   
   public void Staff (String fullName, int phoneNumber, String position, int accessLevel) {
      this.fullName = fullName;
      this.phoneNumber = phoneNumber;
      this.position = position;
      this.accessLevel = accessLevel;
      this.instancecounter++;
      this.staffID = instancecounter;
   }
   public String getStaffID(){
      return Integer.toString(this.staffID);
   }

}