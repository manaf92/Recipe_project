package se.lexicon.Recipe_project.models.dto.form;

import se.lexicon.Recipe_project.models.entity.Measurement;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RecipeIngredientFormDTO {
    private String recipeIngredientId;

    @NotNull
    @Min(value = 1,message = "amount should be 1 or grater than 1")
    @Max(value = 1000, message = "amount should be less than 100")
    private double amount;
    private IngredientFormDTO ingredient;
    private Measurement measurement;
    private RecipeFormDTO recipe;

    public RecipeIngredientFormDTO(String recipeIngredientId, double amount, IngredientFormDTO ingredient, Measurement measurement, RecipeFormDTO recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public IngredientFormDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientFormDTO ingredient) {
        this.ingredient = ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public RecipeFormDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeFormDTO recipe) {
        this.recipe = recipe;
    }
}
