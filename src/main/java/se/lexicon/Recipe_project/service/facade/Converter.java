package se.lexicon.Recipe_project.service.facade;


import se.lexicon.Recipe_project.models.dto.view.*;
import se.lexicon.Recipe_project.models.entity.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Converter {

    // RecipeCategory  small
    public RecipeCategoryDTO toSmallRecipeCategoryExcludingRecipe(RecipeCategory  recipeCategory) {

        return new RecipeCategoryDTO(
                recipeCategory.getCategoryId(),
                recipeCategory.getCategory(),
                null);
    }
    // RecipeCategory  full
    public RecipeCategoryDTO toFullRecipeCategory(RecipeCategory  recipeCategory) {

        HashSet<RecipeDTO> recipeDTOs = new HashSet<>();
        recipeCategory.getRecipes().forEach(recipe -> recipeDTOs.add(toSmallRecipeExcludingCategory(recipe)));
        return new RecipeCategoryDTO(
                recipeCategory.getCategoryId(),
                recipeCategory.getCategory(),
                recipeDTOs
                );
    }
    // Recipe    small
    public RecipeDTO toSmallRecipeExcludingCategory(Recipe recipe) {
        List<RecipeIngredientDTO> recipeIngredientDTOs = new ArrayList<>();
        recipe.getRecipeIngredients().forEach(recipeIngredient -> recipeIngredientDTOs.add(toSmallRecipeIngredientExcludingRecipe(recipeIngredient)));
        return new RecipeDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                toRecipeInstructionDTO(recipe.getRecipeInstruction()),
                recipeIngredientDTOs,
                null
                );
    }
    // Recipe    small
    public RecipeDTO toSmallRecipeExcludingRecipeIngredient(Recipe recipe) {
        HashSet<RecipeCategoryDTO> recipeCategoryDTOs = new HashSet<>();
        recipe.getRecipeCategories().forEach(recipeCategory -> recipeCategoryDTOs.add(toSmallRecipeCategoryExcludingRecipe(recipeCategory)));
        return new RecipeDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                toRecipeInstructionDTO(recipe.getRecipeInstruction()),
                null,
                recipeCategoryDTOs
                );
    }
    // Recipe    full
    public RecipeDTO toFullRecipeExcludingCategory(Recipe recipe) {
        List<RecipeIngredientDTO> recipeIngredientDTOs = new ArrayList<>();
        recipe.getRecipeIngredients()
                .forEach(recipeIngredient -> recipeIngredientDTOs.add(toSmallRecipeIngredientExcludingRecipe(recipeIngredient)));

        HashSet<RecipeCategoryDTO> recipeCategoryDTOs = new HashSet<>();
        recipe.getRecipeCategories()
                .forEach(recipeCategory -> recipeCategoryDTOs.add(toSmallRecipeCategoryExcludingRecipe(recipeCategory)));

        return new RecipeDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                toRecipeInstructionDTO(recipe.getRecipeInstruction()),
                recipeIngredientDTOs,
                recipeCategoryDTOs
                );
    }
    // RecipeIngredient small
    public RecipeIngredientDTO toSmallRecipeIngredientExcludingRecipe(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientDTO(
                recipeIngredient.getRecipeIngredientId(),
                recipeIngredient.getAmount(),
                toIngredientDTO(recipeIngredient.getIngredient()),
                recipeIngredient.getMeasurement(),
                null
        );
    }
    // RecipeIngredient full
    public RecipeIngredientDTO toFullRecipeIngredient(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientDTO(
                recipeIngredient.getRecipeIngredientId(),
                recipeIngredient.getAmount(),
                toIngredientDTO(recipeIngredient.getIngredient()),
                recipeIngredient.getMeasurement(),
                toSmallRecipeExcludingRecipeIngredient(recipeIngredient.getRecipe())
        );
    }
    // RecipeInstruction  full
    public RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionDTO(recipeInstruction.getInstructionId(), recipeInstruction.getInstructions());
    }
    // Ingredient  full
    private IngredientDTO toIngredientDTO(Ingredient ingredient) {
        return new IngredientDTO(ingredient.getIngredientId(),ingredient.getIngredientName());
    }


}
