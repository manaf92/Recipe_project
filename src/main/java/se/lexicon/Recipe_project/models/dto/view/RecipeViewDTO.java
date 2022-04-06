package se.lexicon.Recipe_project.models.dto.view;

import java.util.List;
import java.util.Set;

public class RecipeViewDTO {
    private int recipeId;
    private String  recipeName;
    private RecipeInstructionViewDTO recipeInstruction;
    private List<RecipeIngredientViewDTO> recipeIngredients ;
    private Set<RecipeCategoryViewDTO> recipeCategories;

    public RecipeViewDTO(int recipeId, String recipeName, RecipeInstructionViewDTO recipeInstruction, List<RecipeIngredientViewDTO> recipeIngredients, Set<RecipeCategoryViewDTO> recipeCategories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
        this.recipeIngredients = recipeIngredients;
        this.recipeCategories = recipeCategories;
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

    public RecipeInstructionViewDTO getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstructionViewDTO recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeIngredientViewDTO> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientViewDTO> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Set<RecipeCategoryViewDTO> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(Set<RecipeCategoryViewDTO> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }
}
