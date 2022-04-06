package se.lexicon.Recipe_project.models.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "recipe_ingredient_id")
    private String recipeIngredientId;
    private double amount;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="measurement")
    private Measurement measurement;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient(String recipeIngredientId, double amount, Ingredient ingredient, Measurement measurement, Recipe recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.amount = amount;
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredient() {
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && recipeIngredientId.equals(that.recipeIngredientId) && ingredient.equals(that.ingredient) && measurement == that.measurement && recipe.equals(that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientId, amount, ingredient, measurement, recipe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", amount=" + amount +
                ", ingredient=" + ingredient +
                ", measurement=" + measurement +
                '}';
    }
}
