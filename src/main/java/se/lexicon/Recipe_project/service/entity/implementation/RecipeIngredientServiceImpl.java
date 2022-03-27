package se.lexicon.Recipe_project.service.entity.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.interfaces.RecipeIngredientDAO;
import se.lexicon.Recipe_project.models.dto.form.RecipeIngredientFormDTO;
import se.lexicon.Recipe_project.models.entity.RecipeIngredient;
import se.lexicon.Recipe_project.service.entity.implementation.interfaces.RecipeIngredientService;

import java.util.Collection;
@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {
    private final RecipeIngredientDAO recipeIngredientDAO;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public RecipeIngredient create(RecipeIngredientFormDTO recipeIngredientFormDTO) {
        if(recipeIngredientFormDTO == null) throw new IllegalArgumentException("Dto was null");
        RecipeIngredient recipeIngredient = new RecipeIngredient(
                null,recipeIngredientFormDTO.getAmount(),
                recipeIngredientFormDTO.getIngredient(),
                recipeIngredientFormDTO.getMeasurement());
        return recipeIngredientDAO.create(recipeIngredient);
    }

    @Override
    public Collection<RecipeIngredient> findAll() {
        return recipeIngredientDAO.findAll();
    }

    @Override
    public RecipeIngredient findById(String id) {
        return recipeIngredientDAO.findById(id);
    }

    @Override
    public RecipeIngredient update(String id, RecipeIngredientFormDTO recipeIngredientFormDTO) {
        if(id == null || recipeIngredientFormDTO == null) throw new IllegalArgumentException("Id or form was null");
        RecipeIngredient ingredient = findById(id);
        ingredient.setIngredient(recipeIngredientFormDTO.getIngredient());
        ingredient.setAmount(recipeIngredientFormDTO.getAmount());
        ingredient.setMeasurement(recipeIngredientFormDTO.getMeasurement());
        return recipeIngredientDAO.update(ingredient);
    }

    @Override
    public void delete(String id) {
        recipeIngredientDAO.delete(id);
    }
}
