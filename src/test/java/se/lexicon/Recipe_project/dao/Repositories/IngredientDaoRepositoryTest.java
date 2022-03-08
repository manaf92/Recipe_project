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

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
class IngredientDaoRepositoryTest {
    @Autowired
    private IngredientDaoRepository ingredientDao;
    @Autowired
    private TestEntityManager em;

    Ingredient ingredient1;
    int id;

    @BeforeEach
    void setUp() {
        //Data Class is  in: test/java/se/lexicon/Recipe_project/dao/Data.java
        Data data = new Data(em);
        ingredient1=data.getIngredient1();
        id = ingredient1.getIngredientId();
    }
    @Test
    void create() {
        int ex = ingredientDao.findAll().size() + 1;
        ingredientDao.create(new Ingredient(0,"beef"));
        int ac = ingredientDao.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void findById() {
        int ex = id;
        Ingredient ingredient =  ingredientDao.findById(id);
        int ac = ingredient.getIngredientId();
        assertEquals(ex,ac);
    }

    @Test
    void findAll() {
        int ex = 2;
        int ac =  ingredientDao.findAll().size();
        assertEquals(ex,ac);
    }

    @Test
    void update() {
        String ex = "beef";
        Ingredient ingredient =  ingredientDao.update(new Ingredient(id,"beef"));
        String ac = ingredientDao.findById(id).getIngredientName();
        assertEquals(ex,ac);
    }

    @Test
    void delete() {
        System.out.println(id);
        ingredientDao.delete(id);
        Ingredient findingRemovedIngredient = em.find(Ingredient.class, id);
        assertNull(findingRemovedIngredient);
    }

    @Test
    void findByIngredientName() {
        int ex = id;
        int ac = ingredientDao.findByIngredientName("potato").get().getIngredientId();
        assertEquals(ex,ac);
    }
}