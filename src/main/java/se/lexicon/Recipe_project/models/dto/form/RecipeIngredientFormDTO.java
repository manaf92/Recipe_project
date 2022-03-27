package se.lexicon.Recipe_project.models.dto.form;

import se.lexicon.Recipe_project.models.entity.Ingredient;
import se.lexicon.Recipe_project.models.entity.Measurement;

public class RecipeIngredientFormDTO {
    private String recipeIngredientId;
    private double amount;
    private Ingredient ingredient;
    private Measurement measurement;

    public RecipeIngredientFormDTO(String recipeIngredientId, double amount, Ingredient ingredient, Measurement measurement) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.ingredient = ingredient;
        this.measurement = measurement;
    }

    public RecipeIngredientFormDTO() {


    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
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
}
