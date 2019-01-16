class RecipeProgram {
     public static void main(String[] args) {
      Recipe recipe = new Recipe("Spaghetti", "1,2,3,4,5");
      
      recipe.saveRecipe();
      
      recipe.setRecipe("Lasagna", "5,2,3,4,5");
      recipe.saveRecipe(
      l
      
      );
      /*
      recipe.setRecipe("Pizza", "7,2,3,4,5");
      recipe.saveRecipe();
      recipe.setRecipe("Tortellini", "5,2,3,4,5");
      recipe.saveRecipe();
      recipe.setRecipe("Another one", "7,2,3,4,5");
      recipe.saveRecipe();
      recipe.setRecipe("Another Two", "5,2,3,4,5");
      recipe.saveRecipe();
      recipe.setRecipe("Another Three", "7,2,3,4,5");
      recipe.saveRecipe();
      recipe.setRecipe("Another Four", "5,2,3,4,5");
      recipe.saveRecipe();
      recipe.setRecipe("Another Five", "7,2,3,4,5");
      recipe.saveRecipe();
      */
      //System.out.println(recipe.getRecipes(3));   
      //recipe.getAllRecipes();
      System.out.println(recipe.getRecipe(0));
      System.out.println(recipe.getRecipe(1));
      recipe.updateRecipe(1, "ny ret", "nye directions");
      System.out.println(recipe.getRecipe(1));
      //recipe.getAllRecipes();
   }
}