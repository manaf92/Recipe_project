package se.lexicon.Recipe_project.models.dto.view;

import java.util.Set;

public class RecipeCategoryViewDTO {
    private int categoryId;
    private String category;
    private Set<RecipeViewDTO> recipes;

    public RecipeCategoryViewDTO(int categoryId, String category, Set<RecipeViewDTO> recipes) {
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

    public Set<RecipeViewDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeViewDTO> recipes) {
        this.recipes = recipes;
    }
}
