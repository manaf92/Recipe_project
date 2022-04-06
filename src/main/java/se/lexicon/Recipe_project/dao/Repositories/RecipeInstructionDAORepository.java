package se.lexicon.Recipe_project.dao.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.Recipe_project.dao.interfaces.RecipeInstructionDAO;
import se.lexicon.Recipe_project.models.entity.RecipeInstruction;

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
    public Optional<RecipeInstruction> findById(String id) {
        return Optional.ofNullable(entityManager.find(RecipeInstruction.class,id));
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return entityManager.createQuery("SELECT ri FROM RecipeInstruction ri",RecipeInstruction.class)
                .getResultList();
    }

    @Override
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return entityManager.merge(recipeInstruction);
    }

    @Override
    public void delete(String id) {
        entityManager.remove(findById(id).get());
    }
}
