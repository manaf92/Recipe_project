package se.lexicon.Recipe_project.dao.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.Recipe_project.dao.interfaces.RecipeIngredientDAO;
import se.lexicon.Recipe_project.models.entity.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RecipeIngredientDAORepository implements RecipeIngredientDAO {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public RecipeIngredientDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    public Optional<RecipeIngredient> findById(String id) {
        return Optional.ofNullable(entityManager.find(RecipeIngredient.class,id));
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return entityManager.createQuery("SELECT ri FROM RecipeIngredient ri", RecipeIngredient.class)
                .getResultList();
    }

    @Override
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return entityManager.merge(recipeIngredient);
    }

    @Override
    public void delete(String id) {
        entityManager.remove(findById(id).get());
    }
}
