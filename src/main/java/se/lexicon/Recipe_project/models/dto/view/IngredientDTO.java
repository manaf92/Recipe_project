package se.lexicon.Recipe_project.models.dto.view;

import javax.persistence.Column;

public class IngredientDTO {
    private int ingredientId;
    private String ingredientName;

    public IngredientDTO(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }
}
