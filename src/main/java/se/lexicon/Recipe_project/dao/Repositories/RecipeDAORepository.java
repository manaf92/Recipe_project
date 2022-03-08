package se.lexicon.Recipe_project.dao.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.Recipe_project.dao.interfaces.RecipeDAO;
import se.lexicon.Recipe_project.models.entity.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RecipeDAORepository implements RecipeDAO {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public RecipeDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Recipe> findByName(String name) {
        return entityManager.createQuery("SELECT r from Recipe r WHERE r.recipeName= :name", Recipe.class)
                .setParameter("name",name)
                .getResultList();
    }

    @Override
    public List<Recipe> findByIngredientName(String ingredientName) {
        return entityManager.createQuery(
                "SELECT r from RecipeIngredient ri JOIN ri.recipe r "+
                        " WHERE ri.ingredient.ingredientName = : ingredientName",
                        Recipe.class)
                .setParameter("ingredientName",ingredientName)
                .getResultList();
    }

    @Override
    public List<Recipe> findByCategoryName(String categoryName) {
        return entityManager.createQuery(
                        "SELECT r from RecipeCategory rc JOIN rc.recipes AS r "+
                                "WHERE rc.category = :categoryName",
                        Recipe.class)
                .setParameter("categoryName",categoryName)
                .getResultList();
    }

    @Override
    public List<Recipe> findByCategories(List<String> categories) {
        return entityManager.createQuery(
                        "SELECT r from RecipeCategory rc JOIN  rc.recipes r "+
                                "WHERE rc.category IN :categories",
                        Recipe.class)
                .setParameter("categories",categories)
                .getResultList();
    }

    //CRUD
    @Override
    public Recipe create(Recipe recipe) {
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    public Recipe findById(Integer id) {
        return entityManager.find(Recipe.class,id);
    }

    @Override
    public List<Recipe> findAll() {
        return entityManager.createQuery("SELECT r from Recipe r ", Recipe.class)
                .getResultList();
    }

    @Override
    public Recipe update(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));
    }

}
