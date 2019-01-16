class RecipesData {
   String recipes = "";
   Recipe recipe;
 
   public void addRecipe(String name, String directions)
   {
      recipe = new Recipe(name, directions);     
      recipes += "\nID: "+ recipe.getID() +", \tRecipename: " + recipe.getName() + ", \tDirections: " + recipe.getDirections();
   }
   public void discardRecipe(String id) {
   
      //nemmere at lave hvis $recipes var et array.
         
   } 
   public void printRecipes() {
      System.out.println(recipes);
   }

}