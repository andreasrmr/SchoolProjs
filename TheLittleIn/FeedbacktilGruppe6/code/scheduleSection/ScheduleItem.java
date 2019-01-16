class ScheduleItem {
   String date;
   String location;
   double hours;
   
   public ScheduleItem (String date, double hours, String location) {
      this.date = date;
      this.hours = hours;
      this.location = location;
   }
   public String getDate() {
      return this.date;
   }
   public String getLocation() {
      return this.location;
   }
   public String getHours(){
      return Double.toString(this.hours);
   }
}