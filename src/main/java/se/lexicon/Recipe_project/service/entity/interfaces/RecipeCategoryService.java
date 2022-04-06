package se.lexicon.Recipe_project.service.entity.interfaces;

import se.lexicon.Recipe_project.models.dto.form.RecipeCategoryFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeCategoryViewDTO;
import se.lexicon.Recipe_project.models.entity.RecipeCategory;

public interface RecipeCategoryService extends GenericServiceCRUD<RecipeCategoryViewDTO, RecipeCategoryFormDTO,Integer>{
}
