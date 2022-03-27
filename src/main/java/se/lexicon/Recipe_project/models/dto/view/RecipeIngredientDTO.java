package se.lexicon.Recipe_project.models.dto.view;

import se.lexicon.Recipe_project.models.entity.Measurement;

public class RecipeIngredientDTO {
    private String recipeIngredientId;
    private double amount;
    private IngredientDTO ingredientDTO;
    private Measurement measurement;
    private RecipeDTO recipeDTO;

    public RecipeIngredientDTO(String recipeIngredientId, double amount, IngredientDTO ingredientDTO, Measurement measurement, RecipeDTO recipeDTO) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.ingredientDTO = ingredientDTO;
        this.measurement = measurement;
        this.recipeDTO = recipeDTO;
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

    public IngredientDTO getIngredientDTO() {
        return ingredientDTO;
    }

    public void setIngredientDTO(IngredientDTO ingredientDTO) {
        this.ingredientDTO = ingredientDTO;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }
}
