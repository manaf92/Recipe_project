package se.lexicon.Recipe_project.dao.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.Recipe_project.dao.interfaces.RecipeInstructionDAO;
import se.lexicon.Recipe_project.models.Ingredient;
import se.lexicon.Recipe_project.models.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RecipeInstructionDAORepository implements RecipeInstructionDAO {
    private final EntityManager entityManager;
    @Autowired
    public RecipeInstructionDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public RecipeInstruction create(RecipeInstruction recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    public RecipeInstruction findById(String s) {
        return null;
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return null;
    }

    @Override
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    public void delete(String id) {

    }
}
