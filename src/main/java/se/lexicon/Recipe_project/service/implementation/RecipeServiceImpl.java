package se.lexicon.Recipe_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.interfaces.RecipeDAO;
import se.lexicon.Recipe_project.dao.interfaces.RecipeInstructionDAO;
import se.lexicon.Recipe_project.models.dto.RecipeFormDTO;
import se.lexicon.Recipe_project.models.entity.Recipe;
import se.lexicon.Recipe_project.service.interfaces.RecipeService;

import java.util.Collection;
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAO recipeDAO;

    @Autowired
    public RecipeServiceImpl(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @Override
    public Recipe create(RecipeFormDTO recipeFormDTO) {
        return null;
    }

    @Override
    public Collection<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findById(Integer integer) {
        return null;
    }

    @Override
    public Recipe update(Integer integer, RecipeFormDTO recipeFormDTO) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
