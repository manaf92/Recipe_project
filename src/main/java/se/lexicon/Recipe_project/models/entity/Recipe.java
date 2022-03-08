package se.lexicon.Recipe_project.models.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {
    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    @Column(name = "recipe_name")
    private String  recipeName;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients ;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
    private Set<RecipeCategory> recipeCategories;

    public Recipe(int recipeId, String recipeName, RecipeInstruction recipeInstruction) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
        this.recipeIngredients = new ArrayList<>();
        this.recipeCategories = new HashSet<>();
    }

    public Recipe() {
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void setRecipeCategories(Set<RecipeCategory> recipeCategories) {
        this.recipeCategories.addAll(recipeCategories);
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null ) throw new IllegalArgumentException("recipeIngredient was null");
        recipeIngredient.setRecipe(this);
        recipeIngredients.add(recipeIngredient);
    }
    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if (recipeIngredient == null ) throw new IllegalArgumentException("recipeIngredient was null");
        recipeIngredients.remove(recipeIngredient);
        recipeIngredient.setRecipe(null);
    }
    public Set<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId && recipeName.equals(recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
