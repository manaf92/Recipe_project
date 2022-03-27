package se.lexicon.Recipe_project.models.dto.view;


import java.util.List;
import java.util.Set;

public class RecipeDTO {
    private int recipeId;
    private String  recipeName;
    private RecipeInstructionDTO recipeInstructionDTO;
    private List<RecipeIngredientDTO> recipeIngredientsDTO;
    private Set<RecipeCategoryDTO> recipeCategoriesDTO;

    public RecipeDTO(int recipeId, String recipeName, RecipeInstructionDTO recipeInstructionDTO , List<RecipeIngredientDTO> recipeIngredientsDTO, Set<RecipeCategoryDTO> recipeCategoriesDTO) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeInstructionDTO  = recipeInstructionDTO ;
        this.recipeIngredientsDTO = recipeIngredientsDTO;
        this.recipeCategoriesDTO = recipeCategoriesDTO;
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

    public RecipeInstructionDTO getRecipeInstruction() {
        return recipeInstructionDTO ;
    }

    public void setRecipeInstruction(RecipeInstructionDTO recipeInstructionDTO ) {
        this.recipeInstructionDTO  = recipeInstructionDTO ;
    }

    public List<RecipeIngredientDTO> getRecipeIngredientsDTO() {
        return recipeIngredientsDTO;
    }

    public void setRecipeIngredientsDTO(List<RecipeIngredientDTO> recipeIngredientsDTO) {
        this.recipeIngredientsDTO = recipeIngredientsDTO;
    }

    public Set<RecipeCategoryDTO> getRecipeCategoriesDTO() {
        return recipeCategoriesDTO;
    }

    public void setRecipeCategoriesDTO(Set<RecipeCategoryDTO> recipeCategoriesDTO) {
        this.recipeCategoriesDTO = recipeCategoriesDTO;
    }
}
