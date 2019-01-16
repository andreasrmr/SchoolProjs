class ScheduleData {
   String schedules = "";
   ScheduleItem newItem;
   
   public void addScheduleItem(String date, double hours, String location) {
      newItem = new ScheduleItem(date, hours, location);
      schedules += "\nDato: " + date + " Timer: " + hours + " Lokation: " + location ;
   }
   public void printSchedules() {
      System.out.println(schedules);
   }
}

