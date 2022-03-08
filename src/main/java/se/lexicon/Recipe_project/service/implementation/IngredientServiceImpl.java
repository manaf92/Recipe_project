package se.lexicon.Recipe_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.interfaces.IngredientDAO;
import se.lexicon.Recipe_project.models.dto.IngredientFormDTO;
import se.lexicon.Recipe_project.models.entity.Ingredient;
import se.lexicon.Recipe_project.service.interfaces.IngredientService;

import java.util.Collection;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientDAO ingredientDAO;

    @Autowired
    public IngredientServiceImpl(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public Ingredient create(IngredientFormDTO ingredientFormDTO) {
        return null;
    }

    @Override
    public Collection<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById(Integer integer) {
        return null;
    }

    @Override
    public Ingredient update(Integer integer, IngredientFormDTO ingredientFormDTO) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
