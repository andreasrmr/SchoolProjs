class RecipeProgram {
     public static void main(String[] args) {
      
      RecipesData recipe = new RecipesData();
      //input fra bruger
      recipe.addRecipe("Spaghetti", "1,2,3,4,5");
      recipe.addRecipe("Lasagna", "1,2,3,4,5");
      recipe.addRecipe("Pizza", "1,2,3,4,5,6");
      
      //output til bruger.
      recipe.printRecipes();
   }
}