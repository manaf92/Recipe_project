package se.lexicon.Recipe_project.dao.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.Recipe_project.dao.interfaces.IngredientDAO;
import se.lexicon.Recipe_project.models.entity.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class IngredientDaoRepository implements IngredientDAO {
    @PersistenceContext
    private final EntityManager entityManager;
    @Autowired
    public IngredientDaoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //CRUD
    @Override
    public Ingredient create(Ingredient ingredient) {
        if (ingredient==null) throw new IllegalArgumentException("ingredient parameter was null.");
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient  findById(Integer id) {
        return entityManager.find(Ingredient.class,id);
    }

    @Override
    public List<Ingredient> findAll() {
        return entityManager.createQuery("SELECT i from Ingredient i ", Ingredient.class)
                .getResultList();
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findById(id));

    }

    @Override
    public Optional<Ingredient> findByIngredientName(String name) {
        Ingredient ingredient= entityManager.createQuery("SELECT i FROM Ingredient i WHERE i.ingredientName =:name",Ingredient.class)
                .setParameter("name",name)
                .getSingleResult();
        return Optional.ofNullable(ingredient);
    }


}
