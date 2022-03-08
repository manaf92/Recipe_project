package se.lexicon.Recipe_project.dao.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.Recipe_project.dao.interfaces.RecipeCategoryDAO;
import se.lexicon.Recipe_project.models.entity.RecipeCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RecipeCategoryDAORepository implements RecipeCategoryDAO {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public RecipeCategoryDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public RecipeCategory create(RecipeCategory recipeCategory) {
        entityManager.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    public RecipeCategory findById(Integer id) {
        return entityManager.find(RecipeCategory.class,id);
    }

    @Override
    public List<RecipeCategory> findAll() {
        return entityManager.createQuery("SELECT r FROM RecipeCategory r",RecipeCategory.class)
                .getResultList();
    }

    @Override
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return entityManager.merge(recipeCategory);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }
}
