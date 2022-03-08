package se.lexicon.Recipe_project.models.dto;


public class RecipeFormDTO {
    private int recipeId;
    private String  recipeName;

    public RecipeFormDTO(int recipeId, String recipeName) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
    }

    public RecipeFormDTO() {
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
