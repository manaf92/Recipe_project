package se.lexicon.Recipe_project.service.entity.interfaces;

import se.lexicon.Recipe_project.models.dto.form.RecipeIngredientFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeIngredientViewDTO;
import se.lexicon.Recipe_project.models.entity.RecipeIngredient;

public interface RecipeIngredientService extends GenericServiceCRUD<RecipeIngredientViewDTO, RecipeIngredientFormDTO,String> {
}
