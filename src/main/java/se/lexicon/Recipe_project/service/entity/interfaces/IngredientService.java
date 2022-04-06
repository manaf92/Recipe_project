package se.lexicon.Recipe_project.service.entity.interfaces;

import se.lexicon.Recipe_project.models.dto.form.IngredientFormDTO;
import se.lexicon.Recipe_project.models.dto.view.IngredientViewDTO;
import se.lexicon.Recipe_project.models.entity.Ingredient;

public interface IngredientService extends GenericServiceCRUD<IngredientViewDTO, IngredientFormDTO,Integer>{
}
