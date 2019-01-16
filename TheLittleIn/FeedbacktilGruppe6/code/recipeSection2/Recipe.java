class Recipe {
   int id = 0;
   static int instancecounter = -1; 
   String name;
   String directions;
   //static String allRecipes = "";
   
   //allRecipes kan holde 30 recipes.
   static String[] allRecipes = new String[30]; 
   
   public Recipe(String name, String directions){
      this.name = name;
      this.directions = directions;
      this.instancecounter++;
      this.id = instancecounter;
      
   }
   public void setRecipe(String name, String directions){
      this.name = name;
      this.directions = directions;
      this.instancecounter++;
      this.id = instancecounter;
   }
   public void saveRecipe () { 
      allRecipes[this.id] = "\nID: "+ this.id +", \tRecipename: " + this.name + ",\tDirections: " + this.directions;   
      //allRecipes += "\nID: "+ this.id +", \tRecipename: " + this.name + ",\tDirections: " + this.directions;
   }
   public String getRecipe(int id){
      return allRecipes[id];
      //return allRecipes;
   }
   public void getAllRecipes() {
      int arrayCount = allRecipes.length;
      for (int i = 0; i <= arrayCount -1; i++){
         if(allRecipes[i] != null) {
            System.out.println(allRecipes[i]);      
         }
         
      }
      
   }
   public void updateRecipe(int id, String name, String directions) {
      this.id = id;
      this.name = name;
      this.directions = directions;
      saveRecipe();
   }
}