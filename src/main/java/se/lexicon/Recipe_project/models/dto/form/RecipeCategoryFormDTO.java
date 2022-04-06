package se.lexicon.Recipe_project.models.dto.form;

import java.util.Set;

public class RecipeCategoryFormDTO {
    private int categoryId;
    private String category;
    private Set<RecipeFormDTO> recipes;

    public RecipeCategoryFormDTO(int categoryId, String category, Set<RecipeFormDTO> recipes) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<RecipeFormDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeFormDTO> recipes) {
        this.recipes = recipes;
    }
}