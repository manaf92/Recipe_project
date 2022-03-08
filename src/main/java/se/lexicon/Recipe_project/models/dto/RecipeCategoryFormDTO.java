package se.lexicon.Recipe_project.models.dto;

public class RecipeCategoryFormDTO {
    private int categoryId;
    private String category;

    public RecipeCategoryFormDTO(int categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public RecipeCategoryFormDTO() {
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
}
