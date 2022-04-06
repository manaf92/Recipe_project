package se.lexicon.Recipe_project.service.convertor;

import org.springframework.stereotype.Component;
import se.lexicon.Recipe_project.models.dto.form.*;
import se.lexicon.Recipe_project.models.entity.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class EntityFormDTOConverter {
    //ingredient
    public Ingredient DTOToIngredient(IngredientFormDTO dto){
        return new Ingredient(dto.getIngredientId(),dto.getIngredientName());
    }
    public IngredientFormDTO ingredientToDTO(Ingredient ingredient){
        return new IngredientFormDTO(ingredient.getIngredientId(),ingredient.getIngredientName());
    }

    //recipe ingredient
    public RecipeIngredient DTOToRecipeIngredient(RecipeIngredientFormDTO dto){
        return new RecipeIngredient(dto.getRecipeIngredientId(), dto.getAmount(), DTOToIngredient(dto.getIngredient()), dto.getMeasurement(),DTOToRecipe(dto.getRecipe()));
    }
    public RecipeIngredientFormDTO recipeIngredientToDTO(RecipeIngredient recipeIngredient){
        return new RecipeIngredientFormDTO(recipeIngredient.getRecipeIngredientId(),recipeIngredient.getAmount(), ingredientToDTO(recipeIngredient.getIngredient()), recipeIngredient.getMeasurement(), recipeToDTO(recipeIngredient.getRecipe())
        );
    }


    // recipe
    public Recipe DTOToRecipe(RecipeFormDTO dto) {
        return new Recipe(
                dto.getRecipeId(),
                dto.getRecipeName(),
                DTOToRecipeInstruction(dto.getRecipeInstruction()),
                listOfDtoToListOfRecipeIngredient(dto.getRecipeIngredients()),
                setOfDtoToSetOfRecipeCategory(dto.getRecipeCategories())
        );
    }
    public RecipeFormDTO recipeToDTO(Recipe recipe) {
        return new RecipeFormDTO(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                recipeInstructionToDTO(recipe.getRecipeInstruction()),
                listOfRecipeIngredientToListOfDto(recipe.getRecipeIngredients()),
                setOfRecipeCategoryToSetOfDTO(recipe.getRecipeCategories())
        );
    }

    // recipe category
    public RecipeCategory DTOToRecipeCategory(RecipeCategoryFormDTO dto) {
        return new RecipeCategory(dto.getCategoryId(),dto.getCategory(),setOfDtoToSetOfRecipe(dto.getRecipes()));
    }
    public RecipeCategoryFormDTO recipeCategoryToDTO(RecipeCategory recipeCategory) {
        return new RecipeCategoryFormDTO(recipeCategory.getCategoryId(),recipeCategory.getCategory(),setOfRecipeToSetOfDto(recipeCategory.getRecipes()));
    }

    //recipe instruction
    public RecipeInstructionFormDTO recipeInstructionToDTO(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionFormDTO(recipeInstruction.getInstructionId(),recipeInstruction.getInstructions());
    }
    public RecipeInstruction DTOToRecipeInstruction(RecipeInstructionFormDTO dto) {
        return new RecipeInstruction(dto.getInstructionId(),dto.getInstructions());
    }



    // Lists and sets
    private Set<RecipeFormDTO> setOfRecipeToSetOfDto(Set<Recipe> recipes) {
        Set<RecipeFormDTO> recipeDTOS = new HashSet<>();
        recipes.forEach(recipe -> recipeDTOS.add(recipeToDTO(recipe)));
        return recipeDTOS;
    }

    private Set<Recipe> setOfDtoToSetOfRecipe(Set<RecipeFormDTO> recipeDTOS ) {
        Set<Recipe> recipes = new HashSet<>();
        recipeDTOS.forEach(recipe -> recipes.add(DTOToRecipe(recipe)));
        return recipes;
    }


    private List<RecipeIngredientFormDTO> listOfRecipeIngredientToListOfDto(List<RecipeIngredient> recipeIngredients ) {
        List<RecipeIngredientFormDTO> recipeIngredientsDTO = new ArrayList<>();
        recipeIngredients.forEach(recipeIngredient -> recipeIngredientsDTO.add(recipeIngredientToDTO(recipeIngredient)));
        return recipeIngredientsDTO;
    }

    public List<RecipeIngredient> listOfDtoToListOfRecipeIngredient(List<RecipeIngredientFormDTO> recipeIngredientsDTO  ) {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        recipeIngredientsDTO.forEach(recipeIngredient -> recipeIngredients.add(DTOToRecipeIngredient(recipeIngredient)));
        return recipeIngredients;
    }

    public Set<RecipeCategory> setOfDtoToSetOfRecipeCategory(Set<RecipeCategoryFormDTO> recipeCategoryFormDTOS  ) {
        Set<RecipeCategory> recipeCategories = new HashSet<>();
        recipeCategoryFormDTOS.forEach(recipeCategoryFormDTO -> recipeCategories.add(DTOToRecipeCategory(recipeCategoryFormDTO)));
        return recipeCategories;
    }


    private Set<RecipeCategoryFormDTO> setOfRecipeCategoryToSetOfDTO(Set<RecipeCategory> recipeCategories) {
        Set<RecipeCategoryFormDTO> recipeCategoryFormDTOS = new HashSet<>();
        recipeCategories.forEach(recipeCategory -> recipeCategoryFormDTOS.add(recipeCategoryToDTO(recipeCategory)));
        return recipeCategoryFormDTOS;
    }

}
