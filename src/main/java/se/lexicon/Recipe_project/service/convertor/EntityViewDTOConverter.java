package se.lexicon.Recipe_project.service.convertor;

import se.lexicon.Recipe_project.models.dto.view.*;
import se.lexicon.Recipe_project.models.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntityViewDTOConverter {
    //ingredient
    public Ingredient DTOToIngredient(IngredientViewDTO dto){
        return new Ingredient(dto.getIngredientId(),dto.getIngredientName());
    }
    public IngredientViewDTO ingredientToDTO(Ingredient ingredient){
        return new IngredientViewDTO(ingredient.getIngredientId(),ingredient.getIngredientName());
    }

    //recipe ingredient
    public RecipeIngredient DTOToRecipeIngredient(RecipeIngredientViewDTO dto){
        return new RecipeIngredient(dto.getRecipeIngredientId(), dto.getAmount(), DTOToIngredient(dto.getIngredient()), dto.getMeasurement(),DTOToRecipe(dto.getRecipe()));
    }
    public RecipeIngredientViewDTO recipeIngredientToDTO(RecipeIngredient recipeIngredient){
        return new RecipeIngredientViewDTO(
                recipeIngredient.getRecipeIngredientId(),
                recipeIngredient.getAmount(),
                ingredientToDTO(recipeIngredient.getIngredient()),
                recipeIngredient.getMeasurement(),
                recipeToDTO(recipeIngredient.getRecipe())
        );
    }


    // recipe
    private Recipe DTOToRecipe(RecipeViewDTO dto) {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        dto.getRecipeIngredients().forEach(recipeIngredientViewDTO -> recipeIngredients.add(DTOToRecipeIngredient(recipeIngredientViewDTO)));

        Set<RecipeCategory> recipeCategories = new HashSet<>();
        dto.getRecipeCategories().forEach(recipeCategoryViewDTO -> recipeCategories.add(DTOToRecipeCategory(recipeCategoryViewDTO)));
        return new Recipe(
                dto.getRecipeId(),
                dto.getRecipeName(),
                DTOToRecipeInstruction(dto.getRecipeInstruction()),
                recipeIngredients,
                recipeCategories
        );
    }
    private RecipeViewDTO recipeToDTO(Recipe recipe) {
        List<RecipeIngredientViewDTO> recipeIngredients = new ArrayList<>();
        recipe.getRecipeIngredients().forEach(recipeIngredient -> recipeIngredients.add(recipeIngredientToDTO(recipeIngredient)));

        Set<RecipeCategoryViewDTO> recipeCategories = new HashSet<>();
        recipe.getRecipeCategories().forEach(recipeCategory -> recipeCategories.add(recipeCategoryToDTO(recipeCategory)));
        return new RecipeViewDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                recipeInstructionToDTO(recipe.getRecipeInstruction()),
                recipeIngredients,
                recipeCategories
        );
    }

    // recipe category
    private RecipeCategory DTOToRecipeCategory(RecipeCategoryViewDTO dto) {
        Set<Recipe> recipes = new HashSet<>();
        dto.getRecipes().forEach(recipe -> recipes.add(DTOToRecipe(recipe)));
        return new RecipeCategory(dto.getCategoryId(),dto.getCategory(),recipes);
    }
    private RecipeCategoryViewDTO recipeCategoryToDTO(RecipeCategory recipeCategory) {
        Set<RecipeViewDTO> recipes = new HashSet<>();
        recipeCategory.getRecipes().forEach(recipe -> recipes.add(recipeToDTO(recipe)));
        return new RecipeCategoryViewDTO(recipeCategory.getCategoryId(),recipeCategory.getCategory(),recipes);
    }

    //recipe instruction
    private RecipeInstructionViewDTO recipeInstructionToDTO(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionViewDTO(recipeInstruction.getInstructionId(),recipeInstruction.getInstructions());
    }
    private RecipeInstruction DTOToRecipeInstruction(RecipeInstructionViewDTO dto) {
        return new RecipeInstruction(dto.getInstructionId(),dto.getInstructions());
    }
}
