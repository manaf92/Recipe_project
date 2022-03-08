package se.lexicon.Recipe_project.dao.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.Recipe_project.dao.Data;
import se.lexicon.Recipe_project.models.entity.Ingredient;
import se.lexicon.Recipe_project.models.entity.Measurement;
import se.lexicon.Recipe_project.models.entity.RecipeIngredient;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class RecipeIngredientDAORepositoryTest {

    @Autowired
    private RecipeIngredientDAORepository recipeIngredientDAORepository;
    @Autowired
    private TestEntityManager em;

    RecipeIngredient recipeIngredient1;
    String id;

    Ingredient ingredient;

    @BeforeEach
    void setUp() {
        //Data Class is  in: test/java/se/lexicon/Recipe_project/dao/Data.java
        Data data = new Data(em);
        recipeIngredient1 =data.getRecipeIngredient1();
        id = recipeIngredient1.getRecipeIngredientId();
        ingredient = data.getIngredient1();

    }
    @Test
    void create() {
        int ex = recipeIngredientDAORepository.findAll().size() + 1;
        recipeIngredientDAORepository.create(new RecipeIngredient(null,2,ingredient, Measurement.KG));
        int ac = recipeIngredientDAORepository.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void findById() {
        String ex = id;
        RecipeIngredient recipeIngredient =  recipeIngredientDAORepository.findById(id);
        String ac = recipeIngredient.getRecipeIngredientId();
        assertEquals(ex,ac);
    }

    @Test
    void findAll() {
        int ex = 2;
        int ac =  recipeIngredientDAORepository.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void update() {
        double ex = 4;
        recipeIngredientDAORepository.update(new RecipeIngredient(id,4,ingredient, Measurement.KG));
        double ac = recipeIngredientDAORepository.findById(id).getAmount();
        assertEquals(ex,ac);
    }

    @Test
    void delete() {
        System.out.println(id);
        recipeIngredientDAORepository.delete(id);
        RecipeIngredient findingRemovedIngredient = em.find(RecipeIngredient.class, id);
        assertNull(findingRemovedIngredient);
    }

}