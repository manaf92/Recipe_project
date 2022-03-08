package se.lexicon.Recipe_project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.Recipe_project.dao.interfaces.RecipeIngredientDAO;
import se.lexicon.Recipe_project.dao.interfaces.RecipeInstructionDAO;
import se.lexicon.Recipe_project.models.dto.RecipeInstructionFormDTO;
import se.lexicon.Recipe_project.models.entity.RecipeInstruction;
import se.lexicon.Recipe_project.service.interfaces.RecipeInstructionService;

import java.util.Collection;
@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {

    private final RecipeInstructionDAO recipeInstructionDAO;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionDAO recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }
    @Override
    public RecipeInstruction create(RecipeInstructionFormDTO recipeInstructionFormDTO) {
        return null;
    }

    @Override
    public Collection<RecipeInstruction> findAll() {
        return null;
    }

    @Override
    public RecipeInstruction findById(String s) {
        return null;
    }

    @Override
    public RecipeInstruction update(String s, RecipeInstructionFormDTO recipeInstructionFormDTO) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
