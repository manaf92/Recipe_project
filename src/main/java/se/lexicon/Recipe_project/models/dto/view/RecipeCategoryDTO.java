package se.lexicon.Recipe_project.models.dto.view;

import java.util.Set;

public class RecipeCategoryDTO {
    private int categoryId;
    private String category;
    private Set<RecipeDTO> recipesDTO;

    public RecipeCategoryDTO(int categoryId, String category, Set<RecipeDTO> recipesDTO) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipesDTO = recipesDTO;
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

    public Set<RecipeDTO> getRecipesDTO() {
        return recipesDTO;
    }

    public void setRecipesDTO(Set<RecipeDTO> recipesDTO) {
        this.recipesDTO = recipesDTO;
    }
}
