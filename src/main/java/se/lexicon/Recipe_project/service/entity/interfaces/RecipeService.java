package se.lexicon.Recipe_project.service.entity.interfaces;

import se.lexicon.Recipe_project.models.dto.form.RecipeFormDTO;
import se.lexicon.Recipe_project.models.dto.view.RecipeViewDTO;
import se.lexicon.Recipe_project.models.entity.Recipe;

import java.util.List;

public interface RecipeService extends GenericServiceCRUD<RecipeViewDTO, RecipeFormDTO,Integer>{
    List<RecipeViewDTO> findByName(String name);
    List<RecipeViewDTO> findByIngredientName(String ingredientName);
    List<RecipeViewDTO> findByCategoryName(String categoryName);
    List<RecipeViewDTO> findByCategories(List<String> categories);

}
