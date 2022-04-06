package se.lexicon.Recipe_project.models.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class RecipeFormDTO {
    private int recipeId;
    @NotBlank(message = "recipeName can not be empty.")
    @Size(min = 2, max = 50, message = "Need to have between 2 and 50 letters")
    private String  recipeName;

    private RecipeInstructionFormDTO recipeInstruction;
    private List<RecipeIngredientFormDTO> recipeIngredients ;
    private Set<RecipeCategoryFormDTO> recipeCategories;

    public RecipeFormDTO(int recipeId, String recipeName, RecipeInstructionFormDTO recipeInstruction, List<RecipeIngredientFormDTO> recipeIngredients, Set<RecipeCategoryFormDTO> recipeCategories) {
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

    public RecipeInstructionFormDTO getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstructionFormDTO recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeIngredientFormDTO> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientFormDTO> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Set<RecipeCategoryFormDTO> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(Set<RecipeCategoryFormDTO> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }
}
