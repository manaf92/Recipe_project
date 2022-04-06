package se.lexicon.Recipe_project.service.facade;


import org.springframework.stereotype.Component;
import se.lexicon.Recipe_project.models.dto.view.*;
import se.lexicon.Recipe_project.models.entity.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
@Transactional
public class EntityViewConverter {

    // RecipeCategory  small
    public RecipeCategoryViewDTO toSmallRecipeCategoryExcludingRecipe(RecipeCategory  recipeCategory) {

        return new RecipeCategoryViewDTO(
                recipeCategory.getCategoryId(),
                recipeCategory.getCategory(),
                null);
    }
    // RecipeCategory  full
    public RecipeCategoryViewDTO toFullRecipeCategory(RecipeCategory  recipeCategory) {

        HashSet<RecipeViewDTO> recipeViewDTOS = new HashSet<>();
        recipeCategory.getRecipes().forEach(recipe -> recipeViewDTOS.add(toSmallRecipeExcludingCategory(recipe)));
        return new RecipeCategoryViewDTO(
                recipeCategory.getCategoryId(),
                recipeCategory.getCategory(),
                recipeViewDTOS
                );
    }


    // Recipe    small
    public RecipeViewDTO toSmallRecipeExcludingCategory(Recipe recipe) {
        List<RecipeIngredientViewDTO> recipeIngredientViewDTOS = new ArrayList<>();
        recipe.getRecipeIngredients().forEach(recipeIngredient -> recipeIngredientViewDTOS.add(toSmallRecipeIngredientExcludingRecipe(recipeIngredient)));
        return new RecipeViewDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                toRecipeInstructionDTO(recipe.getRecipeInstruction()),
                recipeIngredientViewDTOS,
                null
                );
    }
    // Recipe    small
    public RecipeViewDTO toSmallRecipeExcludingRecipeIngredient(Recipe recipe) {
        HashSet<RecipeCategoryViewDTO> recipeCategoryViewDTOS = new HashSet<>();
        recipe.getRecipeCategories().forEach(recipeCategory -> recipeCategoryViewDTOS.add(toSmallRecipeCategoryExcludingRecipe(recipeCategory)));
        return new RecipeViewDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                toRecipeInstructionDTO(recipe.getRecipeInstruction()),
                null,
                recipeCategoryViewDTOS
                );
    }
    // Recipe    full
    public RecipeViewDTO toFullRecipeExcludingCategory(Recipe recipe) {
        List<RecipeIngredientViewDTO> recipeIngredientViewDTOS = new ArrayList<>();
        recipe.getRecipeIngredients()
                .forEach(recipeIngredient -> recipeIngredientViewDTOS.add(toSmallRecipeIngredientExcludingRecipe(recipeIngredient)));

        HashSet<RecipeCategoryViewDTO> recipeCategoryViewDTOS = new HashSet<>();
        recipe.getRecipeCategories()
                .forEach(recipeCategory -> recipeCategoryViewDTOS.add(toSmallRecipeCategoryExcludingRecipe(recipeCategory)));

        return new RecipeViewDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                toRecipeInstructionDTO(recipe.getRecipeInstruction()),
                recipeIngredientViewDTOS,
                recipeCategoryViewDTOS
                );
    }

    // RecipeIngredient small
    public RecipeIngredientViewDTO toSmallRecipeIngredientExcludingRecipe(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientViewDTO(
                recipeIngredient.getRecipeIngredientId(),
                recipeIngredient.getAmount(),
                toIngredientDTO(recipeIngredient.getIngredient()),
                recipeIngredient.getMeasurement(),
                null
        );
    }
    // RecipeIngredient full
    public RecipeIngredientViewDTO toFullRecipeIngredient(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientViewDTO(
                recipeIngredient.getRecipeIngredientId(),
                recipeIngredient.getAmount(),
                toIngredientDTO(recipeIngredient.getIngredient()),
                recipeIngredient.getMeasurement(),
                toSmallRecipeExcludingRecipeIngredient(recipeIngredient.getRecipe())
        );
    }

    // RecipeInstruction  full
    public RecipeInstructionViewDTO toRecipeInstructionDTO(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionViewDTO(recipeInstruction.getInstructionId(), recipeInstruction.getInstructions());
    }
    // Ingredient  full
    public IngredientViewDTO toIngredientDTO(Ingredient ingredient) {
        return new IngredientViewDTO(ingredient.getIngredientId(),ingredient.getIngredientName());
    }


}
