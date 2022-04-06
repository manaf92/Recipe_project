package se.lexicon.Recipe_project.models.dto.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class IngredientFormDTO {
    private int ingredientId;

    @NotBlank(message = "ingredientName can not be empty.")
    @Size(min = 2, max = 50, message = "Need to have between 2 and 50 letters")
    private String ingredientName;

    public IngredientFormDTO(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public IngredientFormDTO() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
