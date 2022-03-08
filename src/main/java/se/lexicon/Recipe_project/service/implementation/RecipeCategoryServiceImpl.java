package se.lexicon.Recipe_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.interfaces.IngredientDAO;
import se.lexicon.Recipe_project.dao.interfaces.RecipeCategoryDAO;
import se.lexicon.Recipe_project.models.dto.RecipeCategoryFormDTO;
import se.lexicon.Recipe_project.models.entity.RecipeCategory;
import se.lexicon.Recipe_project.service.interfaces.RecipeCategoryService;

import java.util.Collection;
@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {
    private final RecipeCategoryDAO recipeCategoryDAO;

    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryDAO recipeCategoryDAO) {
        this.recipeCategoryDAO = recipeCategoryDAO;
    }

    @Override
    public RecipeCategory create(RecipeCategoryFormDTO recipeCategoryFormDTO) {
        return null;
    }

    @Override
    public Collection<RecipeCategory> findAll() {
        return null;
    }

    @Override
    public RecipeCategory findById(Integer integer) {
        return null;
    }

    @Override
    public RecipeCategory update(Integer integer, RecipeCategoryFormDTO recipeCategoryFormDTO) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
