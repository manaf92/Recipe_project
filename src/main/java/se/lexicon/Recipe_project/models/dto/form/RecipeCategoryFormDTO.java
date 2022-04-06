package se.lexicon.Recipe_project.models.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class RecipeCategoryFormDTO {
    private int categoryId;
    @NotBlank(message = "category can not be empty.")
    @Size(min = 2, max = 50, message = "category Needs to be between 2 and 50 character")
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