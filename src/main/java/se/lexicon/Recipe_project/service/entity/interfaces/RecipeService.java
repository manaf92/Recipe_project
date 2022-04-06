package se.lexicon.Recipe_project.service.entity.interfaces;

import se.lexicon.Recipe_project.models.dto.form.RecipeFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeViewDTO;
import se.lexicon.Recipe_project.models.entity.Recipe;

public interface RecipeService extends GenericServiceCRUD<RecipeViewDTO, RecipeFormDTO,Integer>{
}
