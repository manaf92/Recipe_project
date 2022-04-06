package se.lexicon.Recipe_project.models.dto.view;

import se.lexicon.Recipe_project.models.entity.Measurement;

public class RecipeIngredientViewDTO {
    private String recipeIngredientId;
    private double amount;
    private IngredientViewDTO ingredient;
    private Measurement measurement;
    private RecipeViewDTO recipe;

    public RecipeIngredientViewDTO(String recipeIngredientId, double amount, IngredientViewDTO ingredient, Measurement measurement, RecipeViewDTO recipe) {
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

    public IngredientViewDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientViewDTO ingredient) {
        this.ingredient = ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public RecipeViewDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeViewDTO recipe) {
        this.recipe = recipe;
    }
}
