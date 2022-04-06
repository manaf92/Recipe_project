package se.lexicon.Recipe_project.models.dto.form;

import se.lexicon.Recipe_project.models.entity.Measurement;

public class RecipeIngredientFormDTO {
    private String recipeIngredientId;
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
