class Recipe {
   int id = 0;
   static int instancecounter = 0; 
   String name;
   String directions;
   
   public Recipe(String name, String directions){
      this.name = name;
      this.directions = directions;
      this.instancecounter++;
      this.id = instancecounter;
   }
   public String getName() {
      return this.name;
   }
   public String getDirections() {
      return this.directions;
   }
   public String getID() {
      return Integer.toString(id);
   }

   
}